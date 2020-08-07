package jdbc;

import jdbc.util.JDBCUtil;

import java.sql.*;
import java.util.Scanner;

public class jdbclogin {
    public static void main(String[] args) throws SQLException {
        Scanner scanner=new Scanner(System.in);
        System.out.println("input name");
        String username=scanner.nextLine();
        System.out.println("input password");
        String password=scanner.nextLine();
        int sum = new jdbclogin().login(username, password);
        if (sum!=0){
            System.out.println("登录成功！");
        }else {
            System.out.println("用户名或密码错误");
        }
    }
    public int login(String username, String password) throws SQLException {
        if(username==null||password==null){
            return 0;
        }
        Connection conn= JDBCUtil.getConnection();
        int sum=0;
        Statement stmt=null;
        ResultSet rs=null;
        PreparedStatement pstm=null;
        String sql="select id from user where username=? and PASSWORD=?";
        try{
            pstm=conn.prepareStatement(sql);
            pstm.setString(1,username);
            pstm.setString(2,password);
            rs=pstm.executeQuery();
            if(rs.next()){
                sum=rs.getInt(1);
            }

        }catch (SQLException e) {
            e.printStackTrace();
        }
        return sum;
    }
}
