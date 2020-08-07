package jdbc.studentAdmin.dao;
import  jdbc.studentAdmin.dao.daomain.*;
import jdbc.studentAdmin.dao.impl.studentDaoImpl;

import java.sql.SQLException;
import java.util.List;

public interface studentDao {

    public List<Student> findAll() throws SQLException;

    //  保存某个学生
    public int save(Student student) throws SQLException ;

    //  删除某个学生
    public int remove(Integer id) throws SQLException;

    //  修改某个学生
    public  int update(Student student) throws SQLException ;
}
