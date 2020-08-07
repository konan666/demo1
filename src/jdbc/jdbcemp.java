package jdbc;
import jdbc.Emp;
import jdbc.util.JDBCUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class jdbcemp {
    public static void main(String[] args) throws Exception {
//

//        List<Emp> all =new jdbcemp().findAll();
//        System.out.println(all);
        List<Emp> alll =new jdbcemp().findAllUseJDBCUtil();
        System.out.println(alll);
    }
    public List<Emp> findAll()throws Exception{
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/java9","root","123456");
        Statement stmt=null;
        ResultSet rs=null;
        ArrayList<Emp> list = null;
        try{
          stmt=conn.createStatement();
          String sql="select * from emp";
          rs=stmt.executeQuery(sql);
            list = new ArrayList<>();

            while (rs.next()) {
                Emp emp = new Emp();
                int id=rs.getInt(1);
                String name=rs.getString(2);
                String job = rs.getString(3);
                int mgr=rs.getInt(4);
                Date hiredate=rs.getDate(5);
                int sal=rs.getInt(6);
                int comm=rs.getInt(7);
                int dept =rs.getInt(8);
                emp.setEmpno(id);
                emp.setEname(name);
                emp.setJob(job);
                emp.setMgr(mgr);
                emp.setHiredate(hiredate);
                emp.setSal(sal);
                emp.setComm(comm);
                emp.setDeptno(dept);
                list.add(emp);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }catch(ClassCastException e){
            e.printStackTrace();
        } finally {
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
        return list;
    }
    public List<Emp> findAllUseJDBCUtil()throws Exception{
        Statement stmt=null;
        ResultSet rs=null;
        ArrayList<Emp> list = null;
        Connection conn=null;
        try {
            conn = JDBCUtil.getConnection();
            String sql = "select * from emp";
            stmt=conn.createStatement();
            rs = stmt.executeQuery(sql);
            list = new ArrayList<>();

            while (rs.next()) {
                Emp emp = new Emp();
                int id = rs.getInt(1);
                String name = rs.getString(2);
                String job = rs.getString(3);
                int mgr = rs.getInt(4);
                Date hiredate = rs.getDate(5);
                int sal = rs.getInt(6);
                int comm = rs.getInt(7);
                int dept = rs.getInt(8);
                emp.setEmpno(id);
                emp.setEname(name);
                emp.setJob(job);
                emp.setMgr(mgr);
                emp.setHiredate(hiredate);
                emp.setSal(sal);
                emp.setComm(comm);
                emp.setDeptno(dept);
                list.add(emp);
            }
        }catch(SQLException e){
                e.printStackTrace();
        }


        return list;
    }
}
