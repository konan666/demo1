package 抽象类.day01.抽象类练习;

/**
 * @author ：konan
 * @date ：2020/8/30 9:07
 */
public class test {
    public static void main(String[] args) {
        Duck duck = new Duck();
        duck.setName("鸭子");
        duck.setAge(2);
        duck.setIllness("感冒");
        duck.setSymptom("发烧");
        duck.showMsg();
        duck.showSymptom();

    }
}
