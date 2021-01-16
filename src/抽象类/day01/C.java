package 抽象类.day01;

/**
 * @author ：konan
 * @date ：2020/8/30 8:47
 */
public class C extends B{
    int numc = 30;
    @Override
    public void showB() {
        System.out.println("numb"+numb);
    }

    @Override
    public void showA() {
        System.out.println("numa"+numa);
    }
    public void showC(){
        System.out.println("numc"+numc);
    }
}
