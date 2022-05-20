package sachsto;
import java.sql.*;
import java.util.*;
public class testpreparedStatement {
    public static void main (String[] args){
        try(
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sachsto","root","");
                PreparedStatement pstmt = conn.prepareStatement("insert into category values (?,?)");
                PreparedStatement pstmtSelect = conn.prepareStatement("select * from category")
                ){
            pstmt.setInt(1,9);
            pstmt.setString(2,"sao lai la hoang");
            int rowInserted = pstmt.executeUpdate();
            System.out.println(rowInserted + "row affected.");

            ResultSet rset = pstmtSelect.executeQuery();
            while(rset.next()){
                System.out.println(rset.getInt("CatID")+","
                + rset.getString("category"));
            }
        }catch (SQLException ex){
            ex.printStackTrace();
        }
    }
}
