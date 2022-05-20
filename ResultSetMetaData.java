package sachsto;
import java.sql.*;
import java.util.*;

public class ResultSetMetaData {
    public static void main(String[]args)throws SQLException{{
        try(
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sachsto","root","");
                Statement stmt = conn.createStatement();
                ){
            // thực hiện truy vấn và trả về kết quả
            ResultSet rset = stmt.executeQuery("select  * from book");
            //lấy bộ kêt quả của metaData
            java.sql.ResultSetMetaData rsetMD =  rset.getMetaData();
            //lấy só lượng cột từ MetaData
            int numColumns = rsetMD.getColumnCount();
            //in ra tên - cột từ cột 1
            for (int i = 1; i<=numColumns;++i){
                System.out.printf("%-20s", rsetMD.getColumnName(i));
            }
            System.out.println();
            //tra ve kieu du lieu cua bang
            for (int i = 1; i<= numColumns; i++){
                System.out.printf("%20s","("+rsetMD.getColumnName(i) +")");
            }
            System.out.println();
            //in nội dung bảng ở tất cả các hàng
            while (rset.next()){
                for (int i=1; i<= numColumns;++i){
                    System.out.printf("%-20s",rset.getString(i));
                }
                System.out.println();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}}
