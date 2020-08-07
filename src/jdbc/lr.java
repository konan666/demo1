package jdbc;

import java.util.Arrays;

public class lr {
    public static void main(String[] args) {
        int num = 0;
        card[] car = new card[52];

        for (int i = 0; i < 13; i++) {
            for (int j = 0; j < 4; j++) {

                switch (j) {
                    case 0:
                        car[num] = new card((i + 1), "红桃");
                        break;
                    case 1:
                        car[num] = new card((i + 1), "方片");
                        break;
                    case 2:
                        car[num] = new card((i + 1), "黑桃");
                        break;
                    case 3:
                        car[num] = new card((i + 1), "梅花");
                        break;
                }
                num++;

            }

        }
//for(card cm:car){
//    System.out.println(cm);
//
//}
        System.out.println(Arrays.toString(car));
        }



 static class card{
    private int value;
    private String face;

     public card(int value, String face){
         this.value=value;
         this.face=face;

     }
     public int getValue() {
         return value;
     }

     public void setValue(int value) {
         this.value = value;
     }

     public String getFace() {
         return face;
     }

     public void setFace(String face) {
         this.face = face;
     }

     @Override
     public String toString() {
         return  value + face ;
     }



}}