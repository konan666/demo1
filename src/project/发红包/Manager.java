package project.发红包;

import java.util.ArrayList;

/**
 * @author ：konan
 * @date ：2020/8/16 13:13
 */
public class Manager extends User {
    public Manager(String name, int money) {
        super(name, money);
    }
    public ArrayList<Integer> send(int leftmoney, int ccount){
        ArrayList<Integer> restList=new ArrayList<>();
        int money=super.getMoney();
        if(leftmoney>money){
            System.out.println("余额不足");
        }
        super.setMoney(money-leftmoney);
        //每个人发的钱
        int avg=leftmoney/ccount;
        //除不开余出来的钱
        int mon=leftmoney%ccount;
        for (int i = 0; i < ccount; i++) {
             restList.add(avg);
        }
        int last=avg+mon;
        restList.add(last);
        return restList;
    }

}
