package com.neusoft.day11.InnerClassDemo2;

/**
 * @author Eric Lee
 * @date 2020/7/25 11:14
 */
public class InnerDemo {
    public static void main(String[] args) {

        /**
         * 等号左边：是多态赋值， （抽象类）接口类型引用指向子类对象
         * 等号右边：是匿名内部类， 定义并创建该接口的子类对象
         */

        FlyAble f  =  new FlyAble() {
            @Override
            public void fly() {
                System.out.println("嗷嗷飞");
            }
        };
        System.out.println(f);

        showFly(f);

    }

    public static void showFly(FlyAble flyAble){
        flyAble.fly();
    }

}
