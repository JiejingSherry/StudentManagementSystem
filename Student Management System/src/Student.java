public class Student{
	private String name;
	private int age;
	private String sno;
	private int math;
	private int chinese;
    private int english;

    public int getTotal(){
		return (math+chinese+english);
    }
    
    public int getAvg(){
    	return getTotal()/3;
    }
    
    public String getName(){
    	return name;
    }
    
    public void setName(String name){
    	this.name = name;
    }
    
    public int getAge(){
    	return age;
    }
    
    public void setAge(int age){
    	this.age = age;
    }
    
    public String getSno(){
    	return sno;
    }
    
    public void setSno(String sno){
    	this.sno = sno;
    }
    
    public int getMath(){
    	return math;
    }
    
    public void setMath(int math){
    	this.math = math;
    }

    public int getChinese() {
        return chinese;
    }

    public void setChinese(int chinese) {
        this.chinese = chinese;
    }

    public int getEnglish() {
        return english;
    }

    public void setEnglish(int english) {
        this.english = english;
    }

}


