package sachsto;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
public class TestRollingBack {
    public static void main(String[]args) throws SQLException{
        try (
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sachsto","root","");
            Statement stmt = conn.createStatement();
        ){
            try{
                conn.setAutoCommit(false);
                //Thực hiện 2 câu lệnh insert
                stmt.executeUpdate("insert into category values (112,'Lý luận') ");
                // làm cho khóa ngoại bị trùng lặp gây ra một SQLException
                stmt.executeUpdate("insert  into category values (112,'Lý luận') ");
//                conn.commit();//thực hiện thay đổi khi và chỉ khi câu lệnh đúng và thực hiện thành công

            }catch (SQLException ex){
                System.out.println("--Rolling back changes --");
                conn.rollback();
                ex.printStackTrace();
            }
        }
    }
}
