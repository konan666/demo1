package jdbc;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.sql.*;

public class jdbc {
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        ResultSet rs=null;
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/java9", "root", "123456");
        String sql = "update account set balance=balance+100 where name=789";
        String sql1 = "insert into account value(null,'789',123)";
        String sql2 = "delete from account where name=789";
        String sql3="select * from account";
        Statement stmt = conn.createStatement();
        try {

            int count = stmt.executeUpdate(sql);
            int count1 = stmt.executeUpdate(sql1);
            int count2 = stmt.executeUpdate(sql2);
            rs=stmt.executeQuery(sql3);
            while(rs.next()){
                int id=rs.getInt(1);
                String name=rs.getString(2);
                int bal=rs.getInt(3);
                System.out.println(id+"  "+name+"  "+bal);
            }
            if (count1 > 0) {
                System.out.println("插入成功");
            } else {
                System.out.println("error");
            }
            if (count2 > 0) {
                System.out.println("删除成功");
            } else {
                System.out.println("error");
            }

            System.out.println(count);
        } catch (ClassCastException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 释放资源

            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        }
    }}
