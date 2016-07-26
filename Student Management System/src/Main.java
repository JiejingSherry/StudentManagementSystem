import java.util.Scanner;
import java.applet.*;
public class Main {

    public static void main(String[] args) {
        Controller con = Controller.getInstance();
        init();
        Scanner scanner = new Scanner(System.in);
        int index = scanner.nextInt();
        while (true) {
            switch (index) {
            case (0):
                scanner.close();
                System.out.println("Thanks.");
                System.exit(0);
                break;
            case (1):
                System.out.println("********************************");
                System.out.println("请输入学生信息:");
                System.out.println("姓名,学号,年龄,语文,数学,英语");
                String stuInfo = scanner.next();
                if ("".equals(stuInfo) || stuInfo == null
                        || !stuInfo.matches("^[\\w]+[,][\\d]+[,][\\d]+[,][\\d]+[,][\\d]+[,][\\d]+$")) {
                    if ("over".equals(stuInfo)) {
                        break;
                    }
                    System.out.println("Result:Error,input again");
                    System.out.println("********************************");
                }
                con.add(initStuInfo(stuInfo));
                System.out.println("Result：add successful");
                System.out.println("********************************");
                break;
            case (2):
                System.out.println("********************************");
                System.out.println("Input Student Number:");
                String sno = scanner.next();
                con.deleteBySno(sno);
                break;
            case (3):
                System.out.println("********************************");
                System.out.println("Update stu info:");
                System.out.println("Name,Student ID,age,Level,Math,English");
                String stuInfo1 = scanner.next();
                if ("".equals(stuInfo1) || stuInfo1 == null
                        || !stuInfo1.matches("^[\\w]+[,][\\d]+[,][\\d]+[,][\\d]+[,][\\d]+[,][\\d]+$")) {
                    if ("over".equals(stuInfo1)) {
                        break;
                    }
                    System.out.println("Result:Error,input again");
                    System.out.println("********************************");
                }
                con.update(initStuInfo(stuInfo1));
                System.out.println("Result：Successful");
                System.out.println("********************************");
                break;
            case (4):
                System.out.println("********************************");
                System.out.println("Input：Student Info:");
                String sno1 = scanner.next();
                Student stu = con.queryBySno(sno1);
                if (stu != null) {
                    System.out.println("Name|Student ID|age|Level|Math|English");
                    System.out.println(stu.getName() + "|" + stu.getSno() + "|" + stu.getAge() + "|" + stu.getMath()
                            + "|" + stu.getEnglish() + "|" + stu.getChinese());
                } else {
                    System.out.println("no exist.");
                }
                break;
            default:
                break;
            }
            System.out.println();
            init();
            index = scanner.nextInt();
        }

    }

    private static void init() {
        System.out.println("************************");
        System.out.println("*   1.Add    StuInfo                  *");
        System.out.println("*   2.Delete StuInfo                  *");
        System.out.println("*   3.Update StuInfo                  *");
        System.out.println("*   4.DisplayStuInfo                  *");
        System.out.println("*   0.Exit                            *");
        System.out.println("************************");
    }

    // 输入学生信息
    private static Student initStuInfo(String inputStr) {
        Student student = new Student();
        if (inputStr.length() <= 0) {
            System.out.println("student's infomation is null.");
            return null;
        }
        String[] infos = inputStr.split(",");
        student.setName(infos[0]);
        student.setSno(infos[1]);
        student.setAge(Integer.parseInt(infos[2]));
        student.setChinese(Integer.parseInt(infos[3]));
        student.setMath(Integer.parseInt(infos[4]));
        student.setEnglish(Integer.parseInt(infos[5]));
        return student;
    }
}