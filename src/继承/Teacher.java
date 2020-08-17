package 继承;

/**
 * @author ：konan
 * @date ：2020/8/16 11:35
 */
public class Teacher extends Employee {
    int num=6;
    public void pring(){
        System.out.println("name"+name);
    }
    public void show(){
        System.out.println("fu"+super.num);
        System.out.println("zi"+num);
    }
    @Override
    public void study(){
        System.out.println("好好学习111");
    }
}
