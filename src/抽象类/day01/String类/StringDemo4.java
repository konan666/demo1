package 抽象类.day01.String类;

import java.util.Arrays;

/**
 * @author ：konan
 * @date ：2020/8/30 10:10
 */
public class StringDemo4 {
    public static void main(String[] args) {
        String s="123456789@qq.com";
        String[] st=s.split("@");
        System.out.println(Arrays.toString(st));
    }
}
