package project.发红包;

import java.util.ArrayList;
import java.util.Random;

/**
 * @author ：konan
 * @date ：2020/8/16 13:13
 */
public class Member extends User {
    public Member(String name, int money) {
        super(name, money);

    }
    public void recive(ArrayList<Integer> list){
        Random random = new Random();
        int index=random.nextInt(list.size());
        Integer removeMoney=list.remove(index);
        int leftmoney=super.getMoney();
        int updatemoney=leftmoney+removeMoney;
        super.setMoney(updatemoney);

    }
}
