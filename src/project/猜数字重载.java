package project;

import java.util.Random;
import java.util.Scanner;

/**
 * @author ：konan
 * @date ：2020/8/14 18:07
 */
public class 猜数字重载 {
    public static void main(String[] args) {
        System.out.println("请输入最大范围的数");
        int getnum=new Scanner(System.in).nextInt();
        getNUM(getnum);

    }
    public static void getNUM(int nu){
        Scanner scanner =new Scanner(System.in);
        Random r=new Random();
        int num=r.nextInt(nu)+1;
        int getnum=0;

        while (true){
            System.out.println("请输入");
            getnum=scanner.nextInt();
            if(getnum>num){
                System.out.println("猜的大了");
            }else if(getnum<num){
                System.out.println("猜的小了");
            }else{
                System.out.println("恭喜您猜对了");
                break;
            }

        }

    }
}
