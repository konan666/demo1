package 面向对象;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author ：konan
 * @date ：2020/8/16 10:29
 */
public class student数组 {
    public static void main(String[] args) {
        Student[] student=new Student[3];
        Student s1=new Student("123",4);
        Student s2=new Student("456",4);
        Student s3=new Student("789",4);
        student[0]=s1;
        student[1]=s2;
        student[2]=s3;
//        for (int i = 0; i < student.length; i++) {
//            Student s= student[i];
//            System.out.println(s.getAge());
//        }
        ArrayList<Student> list = new ArrayList<>();
        Student s=new Student();
        s.setName("123");
        s.setName("123");
        s.setName("123");
        s.setName("123");
        list.add(s);
        for(Student i:list){
            System.out.println(i);
        }

    }
}
