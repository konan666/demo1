package 抽象类.day01.String类;

/**
 * @author ：konan
 * @date ：2020/8/30 10:03
 */
public class StringDemo3 {
    public static void main(String[] args) {
        String s="helloworld";
        //转换为字符组
        char[] chars = s.toCharArray();
        for (int i = 0; i <chars.length ; i++) {
            System.out.println(chars[i]);

        }
        //转换为字节数组
        byte[] bytes=s.getBytes();
        for (int i = 0; i <bytes.length ; i++) {
            System.out.println(bytes[i]);
        }
        //替换
        s=s.replace("h","H");
        System.out.println(s);
        s=s.replace("w","W");
        System.out.println(s);

    }
}
