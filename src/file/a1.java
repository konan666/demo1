package file;

import java.io.*;

/**
 * @author ：konan
 * @date ：2020/12/4 18:19
 */
public class a1 {
    public static void main(String[] args) throws IOException {
        File f = new File("D:\\1.txt");
        InputStreamReader readf = new InputStreamReader(new FileInputStream(f),"GBK");
        BufferedReader bfReader = new BufferedReader(readf);
        String txtline =bfReader.readLine();
        String str = txtline;
        String[][] array = toArray(str);

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static String[][] toArray(String str) {
        String[] split = str.split("\t");
        String[][] array = new String[split.length][];
        for (int i = 0; i < split.length; i++) {
            array[i] = split[i].split("-");
        }
        return array;
    }
}
