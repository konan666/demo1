package 面向对象;

/**
 * @author ：konan
 * @date ：2020/8/14 18:17
 */
public class TestStudent {
    public static void main(String[] args) {
        Student student=new Student("123",1);
        System.out.println(student.getAge());
        System.out.println(student.getName());
        student.eat();
        student.study();


    }

}
