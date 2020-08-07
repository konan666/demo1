package jdbc.studentAdmin;

import jdbc.studentAdmin.dao.daomain.Student;
import jdbc.studentAdmin.dao.impl.studentDaoImpl;
import jdbc.studentAdmin.dao.studentDao;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class a {
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        studentDaoImpl studentDao = new studentDaoImpl();
        System.out.println("-------- 欢迎登录low版学生管理系统---------");
        System.out.println("请输入要进入的系统");
        System.out.println("1.学生列表");
        System.out.println("2.插入学生");
        System.out.println("3.修改成绩");
        System.out.println("4.删除学生");
        int input = scanner.nextInt();
        if (input == 1) {

            List<Student> list = studentDao.findAll();
            System.out.println("------------------------学生列表------------------------");
            for (Student s : list) {
                System.out.println(s);
            }
        }
        if (input == 2) {
            System.out.println("----------插入学生------------------------");
            Student stu = new Student();
            Scanner scanner3=new Scanner(System.in);
            System.out.println("请输入学生姓名");
            String name=scanner3.nextLine();
            System.out.println("请输入学生");
            String gender=scanner3.nextLine();
            System.out.println("请输入学生地址");
            String addr=scanner3.nextLine();
            System.out.println("请输入学生手机号");
            String tel=scanner3.nextLine();
            System.out.println("请输入学生成绩");
            int score=scanner3.nextInt();
            stu.setName(name);
            stu.setGender(gender);
            stu.setScore(score);
            stu.setAddr(addr);
            stu.setTel(tel);

            if (studentDao.save(stu) != 0) {
                System.out.println("success");
            } else {
                System.out.println("error");
            }
        }
            if (input == 3) {
                System.out.println("----------修改成绩------------------------");
                List<Student> list = studentDao.findAll();
                System.out.println("------------------------学生列表------------------------");
                for (Student s : list) {
                    System.out.println(s);
                }
                Scanner scanner1 = new Scanner(System.in);
                System.out.println("请输入要修改的学生ID");
                int is = scanner1.nextInt();
                System.out.println("请输入要修改的学生成绩");
                int score = scanner1.nextInt();
                Student st = new Student();
                st.setScore(score);
                st.setId(is);
                if (studentDao.update(st) != 0) {
                    System.out.println("success");
                } else {
                    System.out.println("error");
                }
            }
            if(input== 4){
                System.out.println("----------删除学生------------------------");
                List<Student> list = studentDao.findAll();
                System.out.println("------------------------学生列表------------------------");
                for (Student s : list) {
                    System.out.println(s);
                }
                Scanner scanner2 = new Scanner(System.in);
                System.out.println("请输入要删除的学生ID");
                int id = scanner2.nextInt();
                if (studentDao.remove(id) != 0) {
                    System.out.println("success");
                } else {
                    System.out.println("error");
                }





            }





    }}



