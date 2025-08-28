// 1.
import java.sql.*;

// 2.
// 匯入 lib 那個Driver，但 IntelliJ 不用 Register

public class Demo {
    public static void main(String[] args) throws SQLException {
        String sql = "select name from product ";
        //可以拿去 QUERY TOOL 中看看結果來驗證

        String url = "jdbc:postgresql://localhost:5432/telusko";
        // Postgres連接透過網路 所以jdbc connect to pgsql to //localhost:5432(PORT Number)/telsuko (這是你的database名稱)
        String username = "postgres";
        String password = "0000";

        // 3.
        Connection con = DriverManager.getConnection(url , username,  password);

        // 4.
        Statement st = con.createStatement();

        //5.
        ResultSet rs = st.executeQuery(sql);
        // 因為拿到的會是一個表個包含column name 所以要再處理。

        //6.
        rs.next(); // 注意：Pointer not point to "Apple keyboard" BUT point to Column name
        String name = rs.getString(1);
        System.out.println(name);

        rs.next(); // 再往下移一個
        name = rs.getString(1);
        System.out.println(name);


        // Close connection;
        con.close();
    }
}
