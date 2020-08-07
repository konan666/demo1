package test;

import jdbc.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DeptDaoImpl implements DeptDao {
    @Override
    public List<Dept> finall() {
        Connection conn=null;
        PreparedStatement pstm=null;
        ResultSet rs=null;
        List list=new ArrayList();
        String sql="select * from dept";
        try{
            conn= JDBCUtil.getConnection();
            pstm=conn.prepareStatement(sql);
            rs=pstm.executeQuery();
            while(rs.next()){
                Dept d=new Dept();
                int deptno=rs.getInt(1);
                String name=rs.getString(2);
                String loc=rs.getString(3);
                d.setDeptno(deptno);
                d.setDname(name);
                d.setLoc(loc);
                list.add(d);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public int sava(Dept dept) {
        Connection conn=null;
        PreparedStatement pstm=null;
        ResultSet rs=null;
        int sum=0;
        List list=new ArrayList();
        String sql="insert into dept(dname,loc)values(?,?)";
        try{
            conn=JDBCUtil.getConnection();
            pstm=conn.prepareStatement(sql);
            pstm.setString(1,dept.getDname());
            pstm.setString(2,dept.getLoc());
            sum=pstm.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sum;
    }

    @Override
    public int remove(int id) {
        Connection conn=null;
        PreparedStatement pstm=null;
        ResultSet rs=null;
        int sum=0;
        List list=new ArrayList();
        String sql="delete from dept where deptno=?";
        try{
            conn=JDBCUtil.getConnection();
            pstm=conn.prepareStatement(sql);
            pstm.setInt(1,id);
            sum=pstm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sum;
    }

    @Override
    public int update(Dept dept) throws SQLException {
        Connection conn=null;
        PreparedStatement pstm=null;
        ResultSet rs=null;
        int sum=0;
        conn.setAutoCommit(false);
        List list=new ArrayList();
        String sql="update dept set dname=?,loc=? where deptno=?";

        try{
            conn=JDBCUtil.getConnection();
            pstm=conn.prepareStatement(sql);
            pstm.setString(1,dept.getDname());
            pstm.setString(2,dept.getLoc());
            pstm.setInt(3,dept.getDeptno());
            sum=pstm.executeUpdate();
           
        } catch (SQLException e) {

            e.printStackTrace();
        }
        return sum;
    }
}
