package jdbc;

public class ttt {
    private int value;
    private String face;

    public ttt(int value, String face) {
        this.value = value;
        this.face = face;
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
 public void showall(){
        System.out.println(value+face);
 }


    public static void main(String[] args){
        int a=1;
        String b="2";
        ttt t=new ttt(a,b);
        t.showall();



    }
}
