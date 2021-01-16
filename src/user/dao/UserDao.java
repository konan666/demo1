package user.dao;

import user.user;

import java.sql.SQLException;
import java.util.List;

/**
 * @author ：konan
 * @date ：2020/8/27 7:50
 */
public interface UserDao {
    public List<user> finall() throws SQLException;
    public int insert(user user) throws SQLException;
    public int update(user user) throws SQLException;
    public int delete(user user) throws SQLException;
}
