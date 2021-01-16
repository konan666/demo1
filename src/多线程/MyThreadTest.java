package 多线程;

/**
 * @author ：konan
 * @date ：2020/9/13 9:09
 */
public class MyThreadTest {
    public static void main(String[] args) {
        MyThread my1 = new MyThread();
        MyThread my2 = new MyThread();
//        my1.run();
//        my2.run();
        //run相当于直接方法调用
        my1.start();
        my2.start();
        //start 启动线程，由jvm调用里面的run方法
    }
}
