package task9;
import java.sql.*;
public class AtomicTransaction {
    public static void main(String[] args) {
        try(
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookstore?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC", "root","");
                Statement stmt = conn.createStatement();
        ){
            conn.setAutoCommit(false);

            ResultSet rset = stmt.executeQuery(" select bookID, qty from book where bookID in (2001, 2002)");
            System.out.println("Before update: ");
            while (rset.next()){
                System.out.println(rset.getInt("bookID")+ ", " + rset.getInt("qty"));
            }
            conn.commit();

            stmt.executeUpdate("update book set qty = qty + 1 where bookID = 2001");
            stmt.executeUpdate("update book set qty = qty + 1 where bookID = 2002");
            conn.commit();

            rset = stmt.executeQuery("select bookID, qty from book where bookID in (2001, 2002)");
            System.out.println("After update: ");
            while (rset.next()){
                System.out.println(rset.getInt("bookID")+", "+rset.getInt("qty"));
            }
            conn.commit();

            stmt.executeUpdate("update book set qty = qty - 99 where bookID = 2001");
            stmt.executeUpdate("update book set qty = qty - 99 where bookID = 2002");
            conn.rollback();

            rset = stmt.executeQuery("select bookID, qty from book where bookID in (2001, 2002)");
            System.out.println("After update and rollback");
            while (rset.next()){
                System.out.println(rset.getInt("bookID") + ", "+rset.getInt("qty"));
            }
            conn.commit();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
