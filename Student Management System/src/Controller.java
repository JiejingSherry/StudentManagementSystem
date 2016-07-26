import java.util.ArrayList;
import java.util.List;
public class Controller {
	private static Controller controller = null;
	private List<Student> stus = new ArrayList<Student>();
	
	private Controller(){
	}
    
	public static synchronized Controller getInstance(){
		if (controller == null){
			controller = new Controller();
		}
		return controller;
	}
	
	public void add(Student stu){
		if (!stus.contains(stu)){
			stus.add(stu);
		}
	}
	public void deleteBySno(String sno) {
        if (sno == null || "".equals(sno)) {
            return;
        }
        for (int i = 0; i < stus.size(); i++) {
            Student stu = stus.get(i);
            if (stu.getSno().equals(sno)) {
                stus.remove(i);
            }
        }
    }

    public void update(Student stu) {
        if (stu == null) {
            return;
        }
        for (int i = 0; i < stus.size(); i++) {
            Student student = stus.get(i);
            if (stu.getSno().equals(student.getSno())) {
                student.setAge(stu.getAge());
                student.setChinese(stu.getChinese());
                student.setEnglish(stu.getEnglish());
                student.setMath(stu.getMath());
                student.setName(stu.getName());
            }
        }
    }

    public Student queryBySno(String sno) {
        Student result = null;
        for (int i = 0; i < stus.size(); i++) {
            Student stu = stus.get(i);
            if (stu.getSno().equals(sno)) {
                result = stu;
                break;
            }
        }
        return result;
    }
	
}
