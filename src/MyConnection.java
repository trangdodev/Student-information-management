
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

    public class MyConnection {
    public Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String URL = "jdbc:mysql://localhost/qlsv?user=root&password=";
            Connection con = DriverManager.getConnection(URL);
            return con;
        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString(), "Loi", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
    
}
