package jdbc.studentAdmin.dao.daomain;

public class Student {
    private int id;
    private String name;
    private String gender;
    private int score;
    private String addr;
    private String  tel;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    @Override
    public String toString() {
        return "" +
                "学生ID：" + id +
                "  学生姓名：" + name  +
                "  学生：" + gender +
                "  学生成绩：" + score +
                "  学生地址：" + addr +
                "  学生手机号：" + tel
                ;
    }
}
