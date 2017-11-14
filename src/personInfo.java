package Model;

/**
 * 
 * 用户类
 * @param name 姓名
 * @param department 学院
 * @param classrm 班级
 *
 */
public class personInfo {

	private String name;//姓名
	private String department;//学院
	private String classrm;//班级
	
	public personInfo(String name,String department,String classrm){
		setName(name);
		setDepartment(department);
		setClassrm(classrm);
	}
	
	//重写的构造方法
	public personInfo(String in) {
		String[] data = in.split(",");
		
		this.name = data[0];
		this.department = data[1];
		this.classrm = data[2];
	}
	
	/*getters*/
	public String getName() {
		return name;
	}
	
	public String getDepartment( ) {
		return department;
	}
	
	public String getClassrm() {
		return classrm;
	}
	
	/*setters*/
	public void setName(String aName) {
		this.name = aName;
	}
	
	public void setDepartment(String aDepartment) {
		this.department = aDepartment;
	}
	
	public void setClassrm(String aClassrm) {
		this.classrm = aClassrm;
	}
	
	/**
	 * 
	 * @return String
	 */
	//转化为字符串方便输出
	public String output() {
		String s = "姓名：" + name + "\n" + "院系：" + department + "\n" + "班级：" + classrm + "\n";
		
		return s;
	}
	
}
