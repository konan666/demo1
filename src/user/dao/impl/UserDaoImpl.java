package user.dao.impl;

import jdbc.util.JDBCUtil;
import user.dao.UserDao;
import user.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ：konan
 * @date ：2020/8/27 7:54
 */
public class UserDaoImpl implements UserDao {
    Connection conn=null;
    PreparedStatement pstm=null;
    ResultSet rs=null;
    @Override
    public List<user> finall() throws SQLException {
        conn= JDBCUtil.getConnection();
        String sql="select * from user";
        List list= new ArrayList();
        try{
            pstm=conn.prepareStatement(sql);
            rs=pstm.executeQuery();
            while(rs.next()){

                user us=new user();
                us.setId(rs.getInt(1));
                us.setUsername(rs.getString(2));
                us.setPassword(rs.getString(3));
                list.add(us);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.close(rs,pstm,conn);
        }
        return list;
    }

    public int delete(user user) throws SQLException {
        conn=JDBCUtil.getConnection();
        String sql="delete from user where id=?";
        int sum=0;
        try{
            pstm=conn.prepareStatement(sql);
            pstm.setInt(1,user.getId());
            sum=pstm.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }finally {
            JDBCUtil.close(null,pstm,conn);
        }
        return sum;
    }

    @Override
    public int update(user user) throws SQLException{
        conn=JDBCUtil.getConnection();
        String sql="update user set username=?,password=? where id=?";
        int sum=0;
        try {
            pstm=conn.prepareStatement(sql);
            pstm.setString(1,user.getUsername());
            pstm.setString(2,user.getPassword());
            pstm.setInt(3,user.getId());
            sum=pstm.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            JDBCUtil.close(null,pstm,conn);
        }
        return sum;
    }

    @Override
    public int insert(user user) throws SQLException {
        conn=JDBCUtil.getConnection();
        String sql="insert into user(username,password)values(?,?)";
        int sum=0;
        try {
            pstm=conn.prepareStatement(sql);
            pstm.setString(1,user.getUsername());
            pstm.setString(2,user.getPassword());
            sum=pstm.executeUpdate();

        }catch (SQLException e){
            e.printStackTrace();}
        finally {
            JDBCUtil.close(null,pstm,conn);
        }
        return sum;
    }
}
