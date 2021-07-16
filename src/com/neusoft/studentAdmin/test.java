package com.neusoft.studentAdmin;

/**
 * @author ：konan
 * @date ：2021/1/24 20:32
 */
public class test extends tet{
    private int user;
    private  String name;
    public void sys(){
        name="456";
        user=2;
        System.out.println("name:"+this.name+"user:"+this.user);
        System.out.println("name:"+super.name+"user:"+super.user);
    }

    public static void main(String[] args) {
        test test = new test();
        test.sys();

    }

}
