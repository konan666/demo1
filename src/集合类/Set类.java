package 集合类;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author ：konan
 * @date ：2020/9/9 18:18
 */
public class Set类 {
    public static void main(String[] args) {
       Set<Integer> s = new HashSet<Integer>();
//       Set<Integer> s = new TreeSet<Integer>(); 使用此函数有顺序排序

        Random r = new Random();
        while (s.size()<10){
            int index=r.nextInt(20)+1;
            s.add(index);
        }
        for(Integer i:s){
            System.out.println(i);
        }

    }
}
