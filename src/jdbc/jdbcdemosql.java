package jdbc;

import jdbc.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class jdbcdemosql {
    public static void main(String[] args)throws SQLException{
        Connection conn=null;
        conn= JDBCUtil.getConnection();
        conn.setAutoCommit(false);
        PreparedStatement pstmt=null;
        PreparedStatement pstmt2=null;
        ResultSet rs=null;
        String sql="update account set balance = balance - ? where id = ?";
        String sql1="update account set balance = balance + ? where id = ?";
        try{
         pstmt=conn.prepareStatement(sql);
         pstmt2=conn.prepareStatement(sql1);
         pstmt.setInt(1,10);
         pstmt.setInt(2,1);
         pstmt2.setInt(1,300);
         pstmt2.setInt(2,2);
         int a=pstmt.executeUpdate();
         int b=pstmt2.executeUpdate();
         System.out.println(a+""+b);
         conn.commit();
        } catch (SQLException e) {
            try{
                if(conn!=null){
                    conn.rollback();
                }
            }catch (SQLException e1){
                e1.printStackTrace();
            }
            e.printStackTrace();
        }finally {
            JDBCUtil.close(pstmt,conn);
            JDBCUtil.close(pstmt2,conn);
        }


    }
}
