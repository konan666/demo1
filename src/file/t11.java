package file;

import java.io.*;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.*;

/**
 * @author ：konan
 * @date ：2020/12/4 17:38
 */
public class t11 {
    public static void main(String[] args) throws IOException, ClassNotFoundException , SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/java9","root","123456");
        String sql="insert into num(count,xavg,yavg,zavg,xfc,yfc,zfc,xavg1,yavg1,zavg1,xfc1,yfc1,zfc1) values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement pstm=connection.prepareStatement(sql);
        long starTime=System.currentTimeMillis();
        List<String> firstColList = new ArrayList<String>();
        List<String> secondColList = new ArrayList<String>();
        List<String> sColList = new ArrayList<String>();
        List<String> firstColList1 = new ArrayList<String>();
        List<String> secondColList1 = new ArrayList<String>();
        List<String> sColList1 = new ArrayList<String>();
        try {
            File f = new File("D:\\2.txt");
            File f1 = new File("D:\\3.txt");
            InputStreamReader readf = new InputStreamReader(new FileInputStream(f), "GBK");
            InputStreamReader readf1 = new InputStreamReader(new FileInputStream(f1), "GBK");
            BufferedReader bfReader = new BufferedReader(readf);
            BufferedReader bfReader1 = new BufferedReader(readf1);
            String txtline = null;
            String txtline1 = null;
            while ((txtline = bfReader.readLine()) != null) {
                txtline1=bfReader1.readLine();
                String[] read = txtline.trim().split("\t");
                String[] read1 = txtline1.trim().split("\t");
                firstColList.add(read[0]);
                secondColList.add(read[1]);
                sColList.add(read[2]);
                firstColList1.add(read1[0]);
                secondColList1.add(read1[1]);
                sColList1.add(read1[2]);
            }
            bfReader.close();
            bfReader1.close();
        } catch (Exception e) {
            System.out.println("读取文件内容出错");
            e.printStackTrace();
        }

        String[] outArray = new String[firstColList.size()];
        String[] outArray2 = new String[secondColList.size()];
        String[] outArray3 = new String[sColList.size()];
        String[] outArray1 = new String[firstColList1.size()];
        String[] outArray21 = new String[secondColList1.size()];
        String[] outArray31 = new String[sColList1.size()];
        /**
         * 将集合里面的数据存到数组里
         */
        for (int i = 0; i < firstColList.size(); i++) {
            outArray[i] = firstColList.get(i);
            outArray2[i] = secondColList.get(i);
            outArray3[i] = sColList.get(i);
            outArray1[i] = firstColList1.get(i);
            outArray21[i] = secondColList1.get(i);
            outArray31[i] = sColList1.get(i);

        }
        /**
         * 遍历数组，将第一位的小数点替换成0及去掉收尾空格
         */
        for (int x = 0; x < firstColList.size(); x++) {
            int count = outArray[x].indexOf(".");
            outArray2[x] = outArray2[x].trim();
            outArray3[x] = outArray3[x].trim();
            int count2 = outArray2[x].indexOf(".");
            int count3 = outArray3[x].indexOf(".");
            if (count == 0) {
                outArray[x] = outArray[x].trim().replaceFirst("\\.", "0.");
            }
            if (count2 == 0) {
                outArray2[x] = outArray2[x].trim().replaceFirst("\\.", "0.");
            }
            if (count3 == 0) {
                outArray3[x] = outArray3[x].trim().replaceFirst("\\.", "0.");
            }
            int count1 = outArray1[x].indexOf(".");
            outArray21[x] = outArray21[x].trim();
            outArray31[x] = outArray31[x].trim();
            int count21 = outArray21[x].indexOf(".");
            int count31 = outArray31[x].indexOf(".");
            if (count1 == 0) {
                outArray1[x] = outArray1[x].trim().replaceFirst("\\.", "0.");
            }
            if (count21 == 0) {
                outArray21[x] = outArray21[x].trim().replaceFirst("\\.", "0.");
            }
            if (count31 == 0) {
                outArray31[x] = outArray31[x].trim().replaceFirst("\\.", "0.");
            }
        }
        /**
         * 遍历数组查找首位负号 第二位为.
         */
        for (int y = 0; y < firstColList.size(); y++) {
            int count = outArray[y].indexOf("-");
            int coun = outArray[y].indexOf(".");
            int count2 = outArray2[y].indexOf("-");
            int coun2 = outArray2[y].indexOf(".");
            int count3 = outArray3[y].indexOf("-");
            int coun3 = outArray3[y].indexOf(".");
            if (count == 0 && coun == 1) {
                StringBuilder stringBuilder = new StringBuilder(outArray[y]);
                stringBuilder.insert(1, "0");
                outArray[y] = stringBuilder.toString();
            }
            if (count2 == 0 && coun2 == 1) {
                StringBuilder stringBuilder = new StringBuilder(outArray2[y]);
                stringBuilder.insert(1, "0");
                outArray2[y] = stringBuilder.toString();
            }
            if (count3 == 0 && coun3 == 1) {
                StringBuilder stringBuilder = new StringBuilder(outArray3[y]);
                stringBuilder.insert(1, "0");
                outArray3[y] = stringBuilder.toString();
            }
            int count1 = outArray1[y].indexOf("-");
            int coun1 = outArray1[y].indexOf(".");
            int count21 = outArray21[y].indexOf("-");
            int coun21 = outArray21[y].indexOf(".");
            int count31 = outArray31[y].indexOf("-");
            int coun31 = outArray31[y].indexOf(".");
            if (count1 == 0 && coun1 == 1) {
                StringBuilder stringBuilder = new StringBuilder(outArray1[y]);
                stringBuilder.insert(1, "0");
                outArray1[y] = stringBuilder.toString();
            }
            if (count21 == 0 && coun21 == 1) {
                StringBuilder stringBuilder = new StringBuilder(outArray21[y]);
                stringBuilder.insert(1, "0");
                outArray21[y] = stringBuilder.toString();
            }
            if (count31 == 0 && coun31 == 1) {
                StringBuilder stringBuilder = new StringBuilder(outArray31[y]);
                stringBuilder.insert(1, "0");
                outArray31[y] = stringBuilder.toString();
            }
        }

        Double s1 = 0.0;/** x的平均值*/
        Double s2 = 0.0;/** y的平均值*/
        Double s3 = 0.0;/** z的平均值*/
        Double f1 = 0.0;/** x的方差*/
        Double f2 = 0.0;/** y的方差*/
        Double f3 = 0.0;/** z的方差*/
        Double s11 = 0.0;/** x的平均值*/
        Double s21 = 0.0;/** y的平均值*/
        Double s31 = 0.0;/** z的平均值*/
        Double f11 = 0.0;/** x的方差*/
        Double f21 = 0.0;/** y的方差*/
        Double f31 = 0.0;/** z的方差*/
        int sum = 5000;/** 循环的初值*/

        a:
        while (true) {
            for (int j = 1; ; j++) {
                int i = sum * (j - 1);
                for (; i < sum * j; i++) {
                    int count1 = outArray[i].indexOf("E-02");
                    int count11 = outArray[i].indexOf("E-03");
                    int count12 = outArray[i].indexOf("E-4");
                    int count2 = outArray2[i].indexOf("E-02");
                    int count22 = outArray2[i].indexOf("E-03");
                    int count3 = outArray3[i].indexOf("E-02");
                    int count33 = outArray3[i].indexOf("E-03");
                    if (count1 == 8 || count11 == 8||count12==8) {
                        BigDecimal bd1 = new BigDecimal(outArray[i]);
                        outArray[i] = String.valueOf(bd1);
                    }
                    if (count2 == 8 || count22 == 8) {
                        BigDecimal bd2 = new BigDecimal(outArray2[i]);
                        outArray2[i] = String.valueOf(bd2);
                    }
                    if (count3 == 8 || count33 == 8) {
                        BigDecimal bd3 = new BigDecimal(outArray3[i]);
                        outArray3[i] = String.valueOf(bd3);
                    }
                    int count10 = outArray1[i].indexOf("E-02");
                    int count111 = outArray1[i].indexOf("E-03");
                    int count121 = outArray1[i].indexOf("E-4");
                    int count21 = outArray21[i].indexOf("E-02");
                    int count221 = outArray21[i].indexOf("E-03");
                    int count31 = outArray31[i].indexOf("E-02");
                    int count331 = outArray31[i].indexOf("E-03");
                    if (count10 == 8 || count111 == 8||count121==8) {
                        BigDecimal bd1 = new BigDecimal(outArray1[i]);
                        outArray1[i] = String.valueOf(bd1);
                    }
                    if (count21 == 8 || count221 == 8) {
                        BigDecimal bd2 = new BigDecimal(outArray21[i]);
                        outArray21[i] = String.valueOf(bd2);
                    }
                    if (count31 == 8 || count331 == 8) {
                        BigDecimal bd3 = new BigDecimal(outArray31[i]);
                        outArray31[i] = String.valueOf(bd3);
                    }
                    s1 += Double.parseDouble(outArray[i]);
                    s2 += Double.parseDouble(outArray2[i]);
                    s3 += Double.parseDouble(outArray3[i]);
                    f1 += (Double.parseDouble(outArray[i]) - s1) * (Double.parseDouble(outArray[i]) - s1);
                    f2 += (Double.parseDouble(outArray2[i]) - s2) * (Double.parseDouble(outArray2[i]) - s2);
                    f3 += (Double.parseDouble(outArray3[i]) - s3) * (Double.parseDouble(outArray3[i]) - s3);
                    s11 += Double.parseDouble(outArray1[i]);
                    s21 += Double.parseDouble(outArray21[i]);
                    s31 += Double.parseDouble(outArray31[i]);
                    f11 += (Double.parseDouble(outArray1[i]) - s11) * (Double.parseDouble(outArray1[i]) - s11);
                    f21 += (Double.parseDouble(outArray21[i]) - s21) * (Double.parseDouble(outArray21[i]) - s21);
                    f31 += (Double.parseDouble(outArray31[i]) - s31) * (Double.parseDouble(outArray31[i]) - s31);
                    if (i == (firstColList.size() - 1)) {
                        break a;
                    }
                }
                pstm.setInt(1,i);
                pstm.setDouble(2,s1/i);
                pstm.setDouble(3,s2/i);
                pstm.setDouble(4,s3/i);
                pstm.setDouble(5,f1/i);
                pstm.setDouble(6,f2/i);
                pstm.setDouble(7,f3/i);
                pstm.setDouble(8,s11/i);
                pstm.setDouble(9,s21/i);
                pstm.setDouble(10,s31/i);
                pstm.setDouble(11,f11/i);
                pstm.setDouble(12,f21/i);
                pstm.setDouble(13,f31/i);
                pstm.executeUpdate();
                System.out.println();
                BigDecimal ss1 = new BigDecimal(s1 / i);
                System.out.println("第" + i + "循环");
                System.out.println("x平均值为" + ss1);
                System.out.println("x方差为" + f1 / i);
                BigDecimal ss = new BigDecimal(s2 / i);
                System.out.println("y平均值为" + ss);
                System.out.println("y方差为" + f2 / i);
                BigDecimal ss3 = new BigDecimal(s3 / i);
                System.out.println("z平均值为" + ss3);
                System.out.println("z方差为" + f3 / i);
            }
        }
        long endTime=System.currentTimeMillis();
        long Time=endTime-starTime;
        Double s=Time/1000.0;
        System.out.println("程序执行时间为："+s+"s");
    }}

