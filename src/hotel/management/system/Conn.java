//
//package hotel.management.system;
//import java.sql.*;
//
//public class Conn {
//    Connection c;
//    Statement s;
//    Conn(){
//        try{
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelmanagementsystem", "root", "rishabhchauhan242003");
//            s = c.createStatement();
//        }
//        catch(Exception e){
//        e.printStackTrace();
//    }
//    }
//}
package hotel.management.system;
import java.sql.*;

public class Conn implements AutoCloseable {
    Connection c;
    Statement s;

    public Conn() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelmanagementsystem", "root", "rishabhchauhan242003");
            s = c.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void close() throws SQLException {
        if (s != null) {
            s.close(); // Close the statement
        }
        if (c != null) {
            c.close(); // Close the connection
        }
    }
}
