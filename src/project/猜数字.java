package project;

import java.util.Random;
import java.util.Scanner;

/**
 * @author ：konan
 * @date ：2020/8/14 17:57
 */
public class 猜数字 {
    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        Random r=new Random();
        int num=r.nextInt(100)+1;
        System.out.println(num);
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
