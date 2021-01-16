package project;

/**
 * @author ：konan
 * @date ：2020/8/17 18:23
 */
public class String字符转换 {
    public static void main(String[] args) {
//        String s1 = "hello";
//        String s2 = "hello";
//        String s3 = "HELLO";
//        //将此 String 与另一个 String 比较
//        System.out.println(s1.equals(s2));// true
//        System.out.println(s1.equals(s3));// false
//        // 将此 String 与另一个 String 比较，不考虑大小写。
//        System.out.println(s1.equalsIgnoreCase(s2)); // true
//        System.out.println(s1.equalsIgnoreCase(s3)); // true
        String s = "helloworld";
// 获取字符串的长度
        System.out.println(s.length());
        System.out.println("++++++++++++++++++++++++++");
// 将指定的字符串连接到该字符串的末尾
        String s2 = s.concat("**haha");
        System.out.println(s2);
        System.out.println("++++++++++++++++++++++++++");
// 获取指定索引的字符
        System.out.println(s.charAt(0));
        System.out.println(s.charAt(1));
        System.out.println("++++++++++++++++++++++++++");
// 返回目标第一次出现的索引, 没有返回-1
        System.out.println(s.indexOf("l"));
        System.out.println(s.indexOf("owo"));
        System.out.println(s.indexOf("a"));
        System.out.println("++++++++++++++++++++++++++");
// 从start开始 截取字符串到字符串结尾的值
        System.out.println(s.substring(0));
        System.out.println(s.substring(5));
        System.out.println("++++++++++++++++++++++++++");
// 从start开始到end结束的截取， 左闭右开
        System.out.println(s.substring(0, s.length()));
        System.out.println(s.substring(3, 8)); // lowor

    }
}
