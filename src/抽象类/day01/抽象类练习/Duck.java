package 抽象类.day01.抽象类练习;

/**
 * @author ：konan
 * @date ：2020/8/30 8:59
 */
public class Duck extends Poultry {
    public Duck() {
    }

    public Duck(String name, String symptom, int age, String illness) {
        super(name, symptom, age, illness);
    }

    @Override
    public void showSymptom() {
        System.out.println("症状为："+getSymptom());
    }
}
