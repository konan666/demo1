package project;

import java.util.ArrayList;
import java.util.Random;

/**
 * @author ：konan
 * @date ：2020/8/16 11:22
 */
public class list筛选偶数 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 20; i++) {
            list.add(random.nextInt(1000)+1);
        }
        System.out.println(list);
        ArrayList<Integer> arraylist=getlist(list);
        System.out.println(arraylist);
    }
    public static ArrayList<Integer> getlist(ArrayList<Integer> list){
        ArrayList<Integer> outnumber = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            Integer number=list.get(i);
            if(number%2==0){
               outnumber.add(list.get(i));
            }
        }


        return outnumber;
    }
}
