package test;

import java.sql.*;

public class jdbc {
    public static void main(String[] args)throws Exception{
        Connection conn=null;
        Statement stmt=null;
        ResultSet rs=null;
        Class.forName("com.mysql.jdbc.Driver");
        conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/java9","root","123456");
        try{
            String sql="select * from account";
            stmt=conn.createStatement();
            rs=stmt.executeQuery(sql);
            while(rs.next()){
                int id=rs.getInt(1);
                String name=rs.getString(2);
                int bal=rs.getInt(3);
                System.out.println(id+name+bal);
            }
        }catch(ClassCastException e){
            e.printStackTrace();
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            if(conn!=null){
                try{
                conn.close();
            }catch(SQLException e){
                e.printStackTrace();
            }
            }
            if(stmt!=null){
                try{
                    stmt.close();
                }catch(SQLException e){
                    e.printStackTrace();
                }
            }
            if(rs!=null){
                try{
                    rs.close();
                }catch(SQLException e){
                    e.printStackTrace();
                }
            }
        }



    }
}
