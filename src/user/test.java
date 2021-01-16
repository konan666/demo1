package user;

import user.view.UserView;
import user.view.impl.UserViewImpl;

import java.sql.SQLException;
import java.util.List;

/**
 * @author ：konan
 * @date ：2020/8/27 9:13
 */
public class test {
    public static void main(String[] args) throws SQLException {
        UserView v=new UserViewImpl();
        /*user u=new user();
        List<user> list=v.cx();
        for(user i:list){
            System.out.println(i);
        }*/
        user u=new user();
        u.setId(3);
//        u.setUsername("66");
//        u.setPassword("666");
        int sum=v.sc(u);
        System.out.println(sum);



    }
}
