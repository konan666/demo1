package user.view.impl;

import user.dao.UserDao;
import user.dao.impl.UserDaoImpl;
import user.user;
import user.view.UserView;

import java.sql.SQLException;
import java.util.List;

/**
 * @author ：konan
 * @date ：2020/8/27 9:09
 */
public class UserViewImpl implements UserView {
    UserDao dao=new UserDaoImpl();
    @Override
    public List<user> cx() throws SQLException {
        List<user> list=dao.finall();
        return list;
    }

    @Override
    public int sc(user user) throws SQLException {
        int sum=dao.delete(user);
        return sum;
    }

    @Override
    public int cr(user user) throws SQLException {
        int sum=dao.insert(user);
        return sum;
    }

    @Override
    public int gx(user user) throws SQLException {
        int sum=dao.update(user);
        return sum;
    }
}
