package project;

import java.util.Arrays;

public class 自动遍历实例 {
    public static void main(String[] args){
        //Arrays自动遍历数组
        int a[]={11,22,33,44};
        System.out.println(Arrays.toString(a));

     //增强型for循环
        for(int i:a){
           System.out.println(i);
        }
     //找出数组最大数
        int max=a[0];
        for (int i=1;i<a.length;i++){
            if(a[i]>max){
                max=a[i];
            }
        }
        System.out.println(max);
    }
}
