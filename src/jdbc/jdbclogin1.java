package jdbc;

import jdbc.util.JDBCUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class jdbclogin1 {
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        System.out.println("input name");
        String username=scanner.nextLine();
        System.out.println("input password");
        String password=scanner.nextLine();
        boolean flag=new jdbclogin1().login(username,password);
        if(flag){
            System.out.println("success");
        }else{
            System.out.println("error");
        }
    }
    public boolean login(String username,String password){
        if (username==null||password==null){
            return false;
        }
        Connection conn=null;
        Statement stmt=null;
        ResultSet rs=null;
        boolean flag = false;
        try{
            conn= JDBCUtil.getConnection();
            String sql="select * from user where username='"+username+"' and PASSWORD='"+password+"'";
            stmt=conn.createStatement();
            rs=stmt.executeQuery(sql);
            while (rs.next()){
              flag=true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
              return flag;
    }
}
