package jdbc.studentAdmin.dao.impl;
import jdbc.studentAdmin.dao.*;
import  jdbc.studentAdmin.dao.daomain.*;
import jdbc.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class studentDaoImpl implements studentDao {
    @Override
    public List<Student> findAll() throws SQLException {
        Connection conn=null;
        conn=JDBCUtil.getConnection();
        PreparedStatement pstm=null;
        ResultSet rs=null;
        List sss =new ArrayList();
        String sql="select * from studentmanage";
        try {
            pstm = conn.prepareStatement(sql);
            rs=pstm.executeQuery();
            while (rs.next()){
            Student stu=new Student();
            stu.setId(rs.getInt(1));
            stu.setName(rs.getString(2));
            stu.setGender(rs.getString(3));
            stu.setScore(rs.getInt(4));
            stu.setAddr(rs.getString(5));
            stu.setTel(rs.getString(6));
            sss.add(stu);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(pstm,conn);

        }

        return sss;
    }

    @Override
    public int save(Student student) throws SQLException {
        Connection conn=null;
        conn=JDBCUtil.getConnection();
        PreparedStatement pstm=null;
        ResultSet rs=null;
        int sum=0;
        String sql="insert into studentmanage (name,gender,score,addr,tel)values(?,?,?,?,?)";
        try {
               pstm = conn.prepareStatement(sql);
               pstm.setString(1,student.getName());
               pstm.setString(2,student.getGender());
               pstm.setInt(3,student.getScore());
               pstm.setString(4,student.getAddr());
               pstm.setString(5,student.getTel());
               sum=pstm.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(pstm,conn);

        }

        return sum;
    }


    @Override
    public int remove(Integer id) throws SQLException {
        Connection conn=null;
        conn=JDBCUtil.getConnection();
        PreparedStatement pstm=null;
        ResultSet rs=null;
        int sum=0;
        String sql = "delete from studentmanage where id=?";
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1,id);
            sum=pstm.executeUpdate();

        }catch (SQLException e) {
            e.printStackTrace();
        }
        return sum;
    }

    @Override
    public int update(Student student) throws SQLException {
        Connection conn=null;
        conn=JDBCUtil.getConnection();
        PreparedStatement pstm=null;
        ResultSet rs=null;
        int sum=0;
        String sql="update studentmanage set score =? where id=? ";
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1,student.getScore());
            pstm.setInt(2,student.getId());
            sum=pstm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(pstm,conn);

        }

        return sum;
    }
    }

