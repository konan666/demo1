package 面向对象;

/**
 * @author ：konan
 * @date ：2020/8/14 18:16
 */
public class Student {
    private String name;
    private int age;

    public Student(String name,int age){
        this.name=name;
        this.age=age;
    }
    public Student(){

    }
   public String getName(){
       return name;
   }
   public void setName(String name){
       this.name=name;
   }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void study(){
        System.out.println("正在学习");
    }
    public void eat(){
        System.out.println("正在学习");
    }
}
