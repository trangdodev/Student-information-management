package studentma;

import Lookup.Course;
import Lookup.Scores;
import Lookup.StudentInfo;
import Rating.Student;
import Common.Response_Scores;
import Common.Response_Rating;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import static Common.Constants.PORT;
import java.sql.Date;
import java.text.DecimalFormat;
import java.util.List;

public class Handle_Server {

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server đã sẵn sàng");

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client đã kết nối đến server");
                ClientHandler clientHandler = new ClientHandler(clientSocket);
                new Thread(clientHandler).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class ClientHandler implements Runnable {

    private Socket clientSocket;
    private ObjectOutputStream oos;
    private ObjectInputStream ois;

    public ClientHandler(Socket clientSocket) {
        // Kiểm tra xem clientSocket có giá trị không phải là null trước khi sử dụng
        if (clientSocket != null) {
            this.clientSocket = clientSocket;
            try {
                oos = new ObjectOutputStream(clientSocket.getOutputStream());
                ois = new ObjectInputStream(clientSocket.getInputStream());
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            // Xử lý trường hợp clientSocket là null
            System.out.println("ClientSocket is null. Cannot proceed with the operation.");
        }
    }

    @Override
    public void run() {
        try {
            while (true) {
                if (clientSocket.isClosed() || !clientSocket.isConnected()) {
                    System.out.println("Kết nối bị đóng hoặc không hoạt động. Kết thúc luồng xử lý.");
                    break;
                }
                Object valueSended =null;

                Object receivedObject = ois.readObject();
                if (receivedObject instanceof RequestSendToServer) {
                    RequestSendToServer requestSendToServer = (RequestSendToServer) receivedObject;
                                    System.out.println(requestSendToServer.getType());

                    StudentInfo studentInfo = null;
                    Scores scores = null;
                    int tongTinChi = 0;
                    double cgpa = 0;
                    double gpa = 0;
                    switch (requestSendToServer.getType()) {
                        case "navigate": {
                            valueSended = processRequest((String) requestSendToServer.getValue());
                            break;
                        }
                        case "CGPARequest": {
                            String mSSV = (String) requestSendToServer.getValue();
                            studentInfo = getStudentInfo(mSSV);
                            scores = getScores(mSSV);
                            cgpa = calculateCGPA(scores.getCourses(), mSSV);
                            break;
                        }
                        case "GPARequest": {
                            String mSSV = (String) requestSendToServer.getValue();
                            studentInfo = getStudentInfo(mSSV);
                            scores = getScores(mSSV);
                            gpa = calculateGPA(scores.getCourses(), mSSV);
                            break;
                        }
                        case "TongTinChiRequest": {
                            String mSSV = (String) requestSendToServer.getValue();
                            tongTinChi = sumTinChi(mSSV);
                            break;
                        }
                        case "lookUpScore": {
                            String mSSV = (String) requestSendToServer.getValue();
                            studentInfo = getStudentInfo(mSSV);  
                            scores = getScores(mSSV);
                            tongTinChi = sumTinChi(mSSV);
                            cgpa = calculateCGPA(scores.getCourses(), mSSV);
                            gpa = calculateGPA(scores.getCourses(), mSSV);
                            tongTinChi = sumTinChi(mSSV);
                            valueSended = new Response_Scores(requestSendToServer.getType(),studentInfo,scores,tongTinChi,cgpa,gpa);
                            break;
                        }
                        case "thongtinRequest": {
                                String mSSV = (String) requestSendToServer.getValue();
                                boolean studentExists = kiemTraSinhVienTrongCSDL(mSSV);
                                System.out.println("Giá trị của studentExists: " + studentExists);
                                break;
                            }
                            case "XepHangSinhVienTheoNganhHoc": {
                                RequestSendToServer_Rating requestSendToServerRating = (RequestSendToServer_Rating) requestSendToServer.getValue();

                                String nganh = requestSendToServerRating.nganh;
                                String hangMuc = requestSendToServerRating.hangMuc;
                                ArrayList<Student> sinhVienList = xepHangSinhVienTheoMonHoc(nganh, hangMuc);
                                valueSended=sinhVienList;
                                sendSinhVienListToClient(sinhVienList);
                                break;
                            }
                    }
                    Response_Rating responseRating = new Response_Rating(requestSendToServer.getType(),  valueSended);
                        oos.writeObject(responseRating);
                        oos.flush();
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            closeConnections();
        }
    }

    private void closeConnections() {
        try {
            if (oos != null) {
                oos.close();
            }
            if (ois != null) {
                ois.close();
            }
            if (clientSocket != null && !clientSocket.isClosed()) {
                clientSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private StudentInfo getStudentInfo(String mSSV) {
        StudentInfo studentInfo = null;
        try (Connection connection = DriverManager.getConnection("jdbc:sqlserver://localhost:8081;Database=qlsv;user=sa;password=123456");
             PreparedStatement pstmt = connection.prepareStatement("SELECT HoTen, Ngaysinh, NoiSinh, Phai, Lop, Nganh FROM SinhVien WHERE MSSV = ?")) {

            pstmt.setString(1, mSSV);
            ResultSet resultSet = pstmt.executeQuery();
            
            String hoTen = null, lop = null, noiSinh = null, nganh = null, phai = null;
            Date ngaySinh = null;
            
            while (resultSet.next()) {
                hoTen = resultSet.getString("HoTen");
                lop = resultSet.getString("Lop");
                phai = resultSet.getString("Phai");
                noiSinh = resultSet.getString("NoiSinh");
                nganh = resultSet.getString("Nganh");
                ngaySinh = resultSet.getDate("NgaySinh");
            }
            
            if (mSSV != null) {
                    studentInfo = new StudentInfo(hoTen, noiSinh, ngaySinh, phai, nganh, lop);
            }
        } catch (SQLException e) {}
        
        return studentInfo;
    }
    private void sendSinhVienListToClient(ArrayList<Student> sinhVienList) {
        try {
            oos.writeObject(sinhVienList);
            System.out.println("sended");
            oos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void sendObjectToClient(Object object) {
        try {
            oos.writeObject(object);
            oos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String processRequest(String request) {
        if ("ThongTinRequest".equals(request)) {
            boolean studentExists = kiemTraSinhVienTrongCSDL(request);
            return String.valueOf(studentExists);
        } else {
            return "PhanHoiKhac";
        }
    }

    private boolean kiemTraSinhVienTrongCSDL(String mSSV) {
        boolean studentExists = false;
        try (Connection connection = DriverManager.getConnection("jdbc:sqlserver://localhost:8081;Database=qlsv;user=trang;password=123456")) {
            // Sử dụng PreparedStatement để tránh các lỗ hổng bảo mật SQL Injection
            String query = "SELECT COUNT(*) FROM SinhVien WHERE MSSV = ?";
            try (PreparedStatement pstmt = connection.prepareStatement(query)) {
                pstmt.setString(1, mSSV);
                ResultSet resultSet = pstmt.executeQuery();

                // Nếu có bất kỳ dòng dữ liệu nào được trả về, sinh viên tồn tại
                if (resultSet.next()) {
                    int count = resultSet.getInt(1);
                    studentExists = (count > 0);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Xử lý lỗi nếu cần thiết
        }
        return studentExists;
    }

    private ArrayList<Student> xepHangSinhVienTheoMonHoc(String nganh, String hangMuc) {

        ArrayList<Student> sinhVienList = new ArrayList<>();

        // Thực hiện truy vấn đến cơ sở dữ liệu để lấy danh sách sinh viên được xếp hạng
        try (Connection connection = DriverManager.getConnection("jdbc:sqlserver://localhost:8081;Database=qlsv;user=trang;password=123456")) {
            // Sử dụng PreparedStatement để tránh các lỗ hổng bảo mật SQL Injection
            String query = "SELECT S.MSSV, S.HoTen, S.DiemTB_H4 "
                    + "FROM dbo.SinhVien S "
                    + "WHERE S.Nganh = ? "
                    + "ORDER BY S.DiemTB_H4 DESC"; // Sắp xếp theo điểm trung bình hệ 4 giảm dần

            try (PreparedStatement pstmt = connection.prepareStatement(query)) {
                pstmt.setString(1, nganh);
                ResultSet resultSet = pstmt.executeQuery();

                // Duyệt qua kết quả truy vấn và thêm vào danh sách sinh viên và cập nhật bảng XepHang
                while (resultSet.next()) {
                    String mssv = resultSet.getString("MSSV");
                    String hoTen = resultSet.getString("HoTen");
                    float diemTB_H4 = resultSet.getFloat("DiemTB_H4");

                    // Thêm sinh viên vào danh sách
                    Student sinhVien = new Student(mssv, hoTen, diemTB_H4);
                    sinhVienList.add(sinhVien);
                    String mergeQuery = "MERGE INTO XepHang AS target "
                            + "USING (VALUES (?, ?, ?, ?)) AS source (MSSV, Nganh, HoTen, DiemTBChung) "
                            + "ON target.MSSV = source.MSSV AND target.Nganh = source.Nganh "
                            + "WHEN MATCHED THEN "
                            + "UPDATE SET target.DiemTBChung = source.DiemTBChung, target.HoTen = source.HoTen "
                            + "WHEN NOT MATCHED THEN "
                            + "INSERT (MSSV, Nganh, HoTen, DiemTBChung) VALUES (source.MSSV, source.Nganh, source.HoTen, source.DiemTBChung);";

                    try (PreparedStatement mergeStmt = connection.prepareStatement(mergeQuery)) {
                        mergeStmt.setString(1, mssv);
                        mergeStmt.setString(2, nganh);
                        mergeStmt.setString(3, hoTen);
                        mergeStmt.setFloat(4, diemTB_H4);
                        mergeStmt.executeUpdate();
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }

        return sinhVienList;
    }

    private Scores getScores(String mSSV) {
        Scores scores = null;
        try (Connection connection = DriverManager.getConnection("jdbc:sqlserver://localhost:8081;Database=qlsv;user=trang;password=123456");
                PreparedStatement pstmt = connection.prepareStatement("SELECT TenMon, Diem FROM Diem WHERE MSSV = ?")) {

            pstmt.setString(1, mSSV);
            ResultSet resultSet = pstmt.executeQuery();

            List<Course> courses = new ArrayList<>();

            while (resultSet.next()) {
                String monHoc = resultSet.getString("TenMon");
                double diem = resultSet.getDouble("Diem");
                courses.add(new Course(monHoc, diem));
                //System.out.println("Môn:" + monHoc + "Điểm:" + diem);
            }
            if (mSSV != null) {
                scores = new Scores(courses);
            }
        } catch (SQLException e) {
        }

        return scores;
    }

    public int sumTinChi(String mSSV) {
        int tongTinChi = 0;
        try (Connection connection = DriverManager.getConnection("jdbc:sqlserver://localhost:8081;Database=qlsv;user=trang;password=123456")) {
            String query = "SELECT SUM(MonHoc.TinChi) AS TongTinChi "
                    + "FROM Diem "
                    + "INNER JOIN MonHoc ON Diem.MaMon = MonHoc.MaMon "
                    + "WHERE Diem.MSSV = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, mSSV);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        tongTinChi = resultSet.getInt("TongTinChi");
                    }
                }
            }
            String updateQuery = "UPDATE SinhVien SET SoTinChiTichLuy = ? WHERE MSSV = ?";
            try (PreparedStatement updateStatement = connection.prepareStatement(updateQuery)) {
                updateStatement.setInt(1, tongTinChi);
                updateStatement.setString(2, mSSV);
                updateStatement.executeUpdate();
            }
        } catch (SQLException e) {
        }
        return tongTinChi;
    }

    private double calculateCGPA(List<Course> courses, String mSSV) {
        int totalCredits = 0;
        double cgpa = 0;
        double totalGradePoints = 0;
        DecimalFormat decimalFormat = new DecimalFormat("#.##");

        try (Connection connection = DriverManager.getConnection("jdbc:sqlserver://localhost:8081;Database=qlsv;user=trang;password=123456")) {
            for (Course course : courses) {
                String query = "SELECT Diem, MonHoc.TinChi FROM Diem "
                        + "INNER JOIN MonHoc ON Diem.MaMon = MonHoc.MaMon "
                        + "WHERE Diem.MSSV = ? AND Diem.TenMon = ?";
                try (PreparedStatement statement = connection.prepareStatement(query)) {
                    statement.setString(1, mSSV);
                    statement.setString(2, course.getCourseName());
                    try (ResultSet resultSet = statement.executeQuery()) {
                        if (resultSet.next()) {
                            double diem = resultSet.getDouble("Diem");
                            int tinChi = resultSet.getInt("TinChi");
                            totalCredits += tinChi;
                            totalGradePoints += diem * tinChi;
                        }
                    }
                }
            }
            if (totalCredits != 0) {
                cgpa = Double.parseDouble(decimalFormat.format(totalGradePoints / totalCredits));
            }
            String updateQuery = "UPDATE SinhVien SET DiemTB_H10 = ? WHERE MSSV = ?";
            try (PreparedStatement updateStatement = connection.prepareStatement(updateQuery)) {
                updateStatement.setDouble(1, cgpa);
                updateStatement.setString(2, mSSV);
                updateStatement.executeUpdate();
            }
        } catch (SQLException e) {}
       
        return cgpa;
    }

    private double calculateGPA(List<Course> courses, String mSSV) {
        int totalCredits = 0;
        double totalGradePoints = 0;
        double gpa = 0;
        DecimalFormat decimalFormat = new DecimalFormat("#.##");

        try (Connection connection = DriverManager.getConnection("jdbc:sqlserver://localhost:8081;Database=qlsv;user=trang;password=123456")) {
            for (Course course : courses) {
                String query = "SELECT Diem, MonHoc.TinChi FROM Diem " +
                               "INNER JOIN MonHoc ON Diem.MaMon = MonHoc.MaMon " +
                               "WHERE Diem.MSSV = ? AND Diem.TenMon = ?";
                try (PreparedStatement statement = connection.prepareStatement(query)) {
                    statement.setString(1, mSSV);
                    statement.setString(2, course.getCourseName());
                    try (ResultSet resultSet = statement.executeQuery()) {
                        if (resultSet.next()) {
                            double diemH4 = convertToH4(course.getGrade());
                            int tinChi = resultSet.getInt("TinChi");
                            totalCredits += tinChi;
                            totalGradePoints += diemH4 * tinChi; 
                        }
                    }
                }
            }
            if (totalCredits != 0) {
                gpa = Double.parseDouble(decimalFormat.format(totalGradePoints / totalCredits));
            }
            String updateQuery = "UPDATE SinhVien SET DiemTB_H4 = ? WHERE MSSV = ?";
            try (PreparedStatement updateStatement = connection.prepareStatement(updateQuery)) {
                updateStatement.setDouble(1, gpa);
                updateStatement.setString(2, mSSV);
                updateStatement.executeUpdate();
            }
        } catch (SQLException e) {}
        return gpa;
    }

    public static double convertToH4(double diemH10) {
        if (diemH10 >= 8.5 && diemH10 <= 10) {
            return 4.0;
        } else if (diemH10 >= 7.8 && diemH10 < 8.5) {
            return 3.5;
        } else if (diemH10 >= 7.0 && diemH10 < 7.8) {
            return 3.0;
        } else if (diemH10 >= 6.3 && diemH10 < 7.0) {
            return 2.5;
        } else if (diemH10 >= 5.5 && diemH10 < 6.3) {
            return 2.0;
        } else if (diemH10 >= 4.8 && diemH10 < 5.5) {
            return 1.5;
        } else if (diemH10 >= 4.0 && diemH10 < 4.8) {
            return 1.0;
        } else if (diemH10 >= 3.0 && diemH10 < 4.0) {
            return 0.5;
        } else {
            return 0.0;
        }
    }

    public int countTotalCourses(List<Course> courses, String mSSV) {
        int totalCourses = courses.size();

        try (Connection connection = DriverManager.getConnection("jdbc:sqlserver://localhost:8081;Database=qlsv;user=trang;password=123456")) {
            String updateQuery = "UPDATE SinhVien SET TongSoMonHocDaHoc = ? WHERE MSSV = ?";
            try (PreparedStatement updateStatement = connection.prepareStatement(updateQuery)) {
                updateStatement.setInt(1, totalCourses);
                updateStatement.setString(2, mSSV);
                updateStatement.executeUpdate();
            }
        } catch (Exception e) {}
        return totalCourses;
    }

}
