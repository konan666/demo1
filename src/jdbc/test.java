package jdbc;

import java.util.Arrays;

public class test {

    public static void main(String[] args){
        String[] b={"1","2","3","4","5","6","7","8","9","10","J","Q","K"};
        String[] c={"红桃","方片","黑桃","梅花"};
        String[] a={};
        for (int i = 0; i <=12; i++) {
            for (int j = 0; j <=3; j++) {
                String d=b[i]+c[j];
//                a[i]=d;
                System.out.print(d+" ");
            }
System.out.println();
        }




    }
}
