package sachsto;

import java.sql.*;

public class testMoreJDBC {

    public static void main(String[]args){
        try(
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sachsto","root","");
            Statement stmt = conn.createStatement();
        ){
            //Before Changes
            conn.setAutoCommit(false);// vo hieu hoa tinh nang tu dong commit
            ResultSet rset = stmt.executeQuery("select bookId, price from book where bookId in (1,2)");
            System.out.println("Before update");
            while(rset.next()){
                System.out.println(rset.getInt("bookId") + "," + rset.getInt("price"));
            }
            conn.commit(); //commit select
            stmt.executeUpdate("update book set price = price + 1 where  bookId = 1");
            stmt.executeUpdate("update book set price = price + 2 where  bookId  = 2");
            conn.commit(); //commit Updates

            rset = stmt.executeQuery("select bookId, price from book where bookId in (1,2) ");
            System.out.println("after updates and commit");
            while (rset.next()){
                System.out.println(rset.getInt("bookId")+ "," + rset.getInt("price"));
            }
            conn.commit(); // commit select

            //Thực hiện 2 câu lệnh Update bằng executeUpdate()
            stmt.executeUpdate("update book set price = price - 2 where bookId = 1");
            stmt.executeUpdate("update  book set price = price - 3 where bookId = 2");
            conn.rollback(); //Bỏ tất cả các thay đổi kể từ lần commit cuối cùng

            rset = stmt.executeQuery("select bookId, price from book where bookid in (1,2)");
            System.out.println("After Update and roll back");
            while(rset.next()){
                System.out.println(rset.getInt("bookId")+","+rset.getInt("price"));
            }
            conn.commit();

        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
