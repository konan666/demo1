package project;

public class 乘法口诀表 {
    public static void main(String[] args){
        for(int i=1;i<=9;i++){
            for(int x=1;x<=i;x++){
                int sum=i*x;
                System.out.print(x+"*"+i+"="+sum+" ");
            }
            System.out.println();
        }





    }
}
