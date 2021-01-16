package 抽象类.day01.String类;

/**
 * @author ：konan
 * @date ：2020/8/30 9:32
 */
public class demo1 {
    public static void main(String[] args) {
        String str="abc";
        str+="d";
        System.out.println(str);
        char[] str2={'a','b','c'};
        System.out.println(str2);
        byte bytes[]={1,2,3,4};
        String s = new String(bytes);
        System.out.println(s);

    }
}
