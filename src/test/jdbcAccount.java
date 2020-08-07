package test;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class jdbcAccount {
    public static void main(String[] args) throws Exception {
        List<account> acc=new jdbcAccount().findAll();
        System.out.println(acc);
    }
    public List<account> findAll()throws Exception {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        ArrayList<account> acc = null;
        Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/java9", "root", "123456");
        try {
            String sql = "select * from account";
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            acc = new ArrayList<>();
            while (rs.next()) {
                account a = new account();
                int id = rs.getInt(1);
                String name = rs.getString(2);
                int bal = rs.getInt(3);
                a.setId(id);
                a.setName(name);
                a.setBalance(bal);

                acc.add(a);
            }
        } catch (ClassCastException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (stmt != null) {
                try {
                    stmt.close();
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

return acc;
    }}
