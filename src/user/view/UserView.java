package user.view;

import user.user;

import java.sql.SQLException;
import java.util.List;

/**
 * @author ：konan
 * @date ：2020/8/27 9:07
 */
public interface UserView {
    public List<user> cx() throws SQLException;
    public int sc(user user) throws SQLException;
    public int cr(user user) throws SQLException;
    public int gx(user user) throws SQLException;
}
