package 集合类;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * @author ：konan
 * @date ：2020/9/9 18:14
 */
public class Collection类 {
    public static void main(String[] args) {
        Collection<String> c = new ArrayList<String>();
        c.add("123");
        c.add("456");
        Iterator<String> z = c.iterator();
//
        while (z.hasNext()){
            System.out.println(z.next());
        }

    }
}
