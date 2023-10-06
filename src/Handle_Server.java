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

public class Handle_Server {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(9999)) {
            System.out.println("Server đã sẵn sàng");

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client đã kết nối đến server");
                ClientHandler clientHandler = new ClientHandler(clientSocket);
                new Thread(clientHandler).start();
            }
        } catch (IOException e) {}
    }
}

class ClientHandler implements Runnable {
    private Socket clientSocket;
    private ObjectOutputStream oos;
    private ObjectInputStream ois;

    public ClientHandler(Socket clientSocket) {
        this.clientSocket = clientSocket;
        try {
            oos = new ObjectOutputStream(clientSocket.getOutputStream());
            ois = new ObjectInputStream(clientSocket.getInputStream());
        } catch (IOException e) {}
    }

    @Override
    public void run() {
        try {
            while (true) {
                String mSSV = (String) ois.readObject();
                String hoTen = getStudentName(mSSV);
                oos.writeObject(hoTen);
                System.out.println("Lấy dữ liệu thành công từ Database");
                oos.flush();
            }
        } catch (IOException e) {
            System.out.println("Client đã ngắt kết nối");
        } catch (ClassNotFoundException e) {
        } finally {
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
            } catch (IOException e) {}
        }
    }

    private String getStudentName(String mSSV) {
        String hoTen = null;
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/qlsv?user=root&password=");
             PreparedStatement pstmt = connection.prepareStatement("SELECT ho_ten FROM sinhvien WHERE ma_sinh_vien = ?")) {

            pstmt.setString(1, mSSV);
            ResultSet resultSet = pstmt.executeQuery();

            if (resultSet.next()) {
                hoTen = resultSet.getString("ho_ten");
            }
        } catch (SQLException e) {}
        return hoTen;
    }
}
