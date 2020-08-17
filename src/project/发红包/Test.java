package project.发红包;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author ：konan
 * @date ：2020/8/16 13:18
 */
public class Test {
    public static void main(String[] args) {
        Manager manager=new Manager("群主",200);
        Member one=new Member("成员A",0);
        Member two=new Member("成员B",0);
        Member three=new Member("成员C",0);
        manager.show();
        one.show();
        two.show();
        three.show();
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入发红包的金额");
        int outmoney=scanner.nextInt();
        System.out.println("请输入发几个红包");
        int count=scanner.nextInt();
        ArrayList<Integer> restList=manager.send(outmoney,count);
        one.recive(restList);
        two.recive(restList);
        three.recive(restList);
        manager.show();
        one.show();
        two.show();
        three.show();

    }
}
