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

public class Handle_Server implements AutoCloseable {
    private Connection connection;
    private PreparedStatement pstmt;
    
    public Handle_Server() throws SQLException {
        connection = DriverManager.getConnection("jdbc:mysql://localhost/qlsv?user=root&password=");
        String query = "SELECT ho_ten FROM sinhvien WHERE ma_sinh_vien = ?";
        pstmt = connection.prepareStatement(query);
    }
    
    public String getStudentName(String mSSV) throws SQLException {
        pstmt.setString(1, mSSV);
        ResultSet rset = pstmt.executeQuery();
        if (rset.next()) {
            return rset.getString("ho_ten");
        } else {
            return null;
        } 
    }
    public Connection getConnection() {
        return connection;
    }

    @Override
    public void close() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }
    
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(9999);
        System.out.println("Server đã sẵn sàng");
        
        try (
             Handle_Server dbConnectionWrapper = new Handle_Server()) {

            while (true) {
                try (Socket client = server.accept();
                     ObjectInputStream ois = new ObjectInputStream(client.getInputStream());
                     ObjectOutputStream oos = new ObjectOutputStream(client.getOutputStream())) {

                    String mSSV = (String) ois.readObject();
                    String hoTen = dbConnectionWrapper.getStudentName(mSSV);

                    if (mSSV != null) {
                        oos.writeObject(hoTen);
                    }
                } catch (Exception e) {}
            }  
        } catch (SQLException e) {}
    }      
}
    
