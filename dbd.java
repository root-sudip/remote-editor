import java.sql.Connection;
import java.sql.DriverManager;
 
class dbd{
 
    private static final String url = "jdbc:mysql://localhost";
 
    private static final String user = "root";
 
    private static final String password = "sudipdas";
 
    public static void main(String args[]) {
        try {
            Connection con = DriverManager.getConnection(url, user, password);
            System.out.println("Success");
 
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}