package 抽象类.day01.String类;

/**
 * @author ：konan
 * @date ：2020/8/30 9:36
 */
public class StringDemo1 {
    public static void main(String[] args) {
//        String s1="hello";
//        String s2="hello";
//        String s3="HELLO";
//        System.out.println(s1.equals(s2));
//        System.out.println(s1.equals(s3));
//        //忽略大小写
//        System.out.println(s1.equalsIgnoreCase(s2));
//        System.out.println(s1.equalsIgnoreCase(s3));
        Integer i=1;
        int j=1;
        char m='1';
        System.out.println(i==j);
        System.out.println(m==j);
        Object obj1=new Object();
        Object obj2=new Object();
        //都是比较地址值
        System.out.println(obj1.equals(obj2));
        System.out.println(obj1==obj2);
        String a=new String("abc");
        String b=new String("abc");
        String c="abc";
        String d="abc";
        System.out.println(a==b);//false 是两个不同的对象
        System.out.println(a.equals(b));//true String重写了equals
        System.out.println(c==d);//true 共享同一变量

    }
}
