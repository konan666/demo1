package 多线程;

/**
 * @author ：konan
 * @date ：2020/9/13 9:08
 */
public class MyThread extends Thread {
    @Override
    public void run(){
        for (int i=0;i<100;i++){
            System.out.println(i);
        }
    }
}
