package 抽象类.day01.String类;

import java.util.Scanner;

/**
 * @author ：konan
 * @date ：2020/8/30 10:13
 */
public class StringAi {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String str;
        while(true){
            str=scanner.next();
            str=str.replace("吗","");
            str=str.replace("?","!");
            System.out.println(str);



        }
    }
}
