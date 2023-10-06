import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBAccess {
    private Connection con;
    private Statement stmt;

    public DBAccess() {
        try {
            MyConnection myCon = new MyConnection();
            con = myCon.getConnection();
            stmt = con.createStatement();
        } catch (SQLException e) {}
    }

    public int Update(String str) {
        try {
            int i = stmt.executeUpdate(str);
            return i;
        } catch (SQLException e) {
            return -1;
        }
    }

    public ResultSet Query(String str) {
        try {
            ResultSet rs = stmt.executeQuery(str);
            return rs;
        } catch (SQLException e) {
            return null;
        }
    }

    public Connection getConnection() {
        return con;
    }
}

