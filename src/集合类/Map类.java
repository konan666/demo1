package 集合类;

import java.util.Collection;
import java.util.HashMap;

/**
 * @author ：konan
 * @date ：2020/9/9 18:32
 */
public class Map类 {
    public static void main(String[] args) {
        HashMap<String ,String > map = new HashMap<String ,String>();
        map.put("123","456");
        map.put("23","456");
        map.put("12","456");
        map.put("3","456");
        Collection<String > value=map.keySet();
        for(String i:value){
            System.out.println(i);
        }
    }
}
