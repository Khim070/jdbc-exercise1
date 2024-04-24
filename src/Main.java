import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        Connection con;
        //String createTable = "CREATE TABLE tbEmployee(emp_id int, emp_last_name varchar(50), emp_first_name varchar(50), emp_email varchar(50), emp_phone varchar(15))";
        String insertValue = "INSERT INTO tbEmployee(emp_id,emp_last_name,emp_first_name,emp_email,emp_phone) VALUES(?,?,?,?,?)";
        try{
            con = DriverManager.getConnection("jdbc:mysql://localhost:3307/testDB","root","");
            Statement stmt = con.createStatement();

            PreparedStatement pstmt = con.prepareStatement(insertValue);
            pstmt.setInt(1,3);
            pstmt.setString(2,"LEANG");
            pstmt.setString(3,"Vorleak");
            pstmt.setString(4,"vorleakl60@gmail.com");
            pstmt.setString(5,"010202821");
            pstmt.executeUpdate();
            //stmt.executeUpdate(insertValue);
            //stmt.execute(createTable);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
}