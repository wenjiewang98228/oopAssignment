package Model;

import java.util.ArrayList;
import java.util.Random;

/**
 * 
 * 社团类
 * @param name 社团名称
 * @param time 创立时间
 * @param person 负责人
 * @param tel 电话号码
 * @param email 邮箱
 * @param intro 简介
 * @param photo 照片
 * @param personList 社团人员表
 * @param actList 社团活动表
 *
 */
public class teamInfo {

	private String name;
	private String time;
	private String person;
	private String tel;
	private String email;
	private String intro;
	private String[] photo = new String[10];
	private String[] personList;
	private ArrayList<String> actList = new ArrayList<String>();
	
	public teamInfo(String name,String time,String person,String tel,String email,
					String intro,String photo[],String[] personList,
					ArrayList<String> actList){
		setName(name);
		setTime(time);
		setPerson(person);
		setTel(tel);
		setEmail(email);
		setIntro(intro);
		setPhoto(photo);
		setPersonList(personList);
		setActList(actList);
	}
	
	//构造方法的重写
	public teamInfo(String in) {
		
		String[] data = in.split(",");
		
		this.name = data[0];
		this.time = data[1];
		
		//负责人与personInfo类相关，需要特殊方法,data[2]
		this.person = data[2];
		
		this.tel = data[3];
		this.email = data[4];
		//社团成员是一个字符串数组
		//将所有社团成员所在的截出的数组存储起来
		String s = data[5];
		//将数组分开存储到personList相对应的位置
		personList = s.split("、");
		
		//将所有社团成员所在的截出的数组存储起来
		String[] aNames = data[6].split("、");
		//将数组分开存储到personList相对应的位置
		for(String a : aNames) {
			actList.add(a);
			}
				
		this.intro = data[7];
		
	}
	
	//之后再实例化actInfo类
	/*public void setActivities(String in) {
		String[] data = in.split(",");
		
		String[] aNames = data[6].split("、");
		
		for(String a : aNames) {
			actList.add(DB.connectTeamWithAct(a));
		}
	}*/
	
	/*getters*/
	public String getName() {
		return name;
	}
	
	public String getTime() {
		return time;
	}
	
	public String getPerson() {
		return person;
	}
	
	public String getTel() {
		return tel;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getIntro() {
		return intro;
	}
	
	public String[] getPhoto(){
		return photo;
	}
	
	public String[] getPersonList(){
		return personList;
	}
	
	public ArrayList<String> getActList(){
		return actList;
	}
	
	/*setters*/
	public void setName(String aName) {
		this.name = aName;
	}
	
	public void setTime(String aTime) {
		this.time = aTime;
	}
	
	public void setPerson(String aPerson) {
		this.person = aPerson;
	}
	
	public void setTel(String aTel) {
		this.tel = aTel;
	}
	
	public void setEmail(String aEmail) {
		this.email = aEmail;
	}
	
	public void setIntro(String aIntro) {
		this.intro = aIntro;
	}
	
	public void setPhoto(String[] photo) {
		this.photo = photo;
	}
	
	public void  setPersonList(String[] personList) {
		this.personList = personList;
	}
	
	public void setActList(ArrayList<String> actList) {
		this.actList = actList;
	}
	
	/*方法*/
	/*将读取的字符串与相应属性对应*/
/*	public void set(String input) {
		String[] data = input.split(",");
		
		name = data[0];
		time = data[1];
		//person = data[2];
		//负责人对应personInfo类，需要特殊的方法处理
		person = data[2];
		
		tel = data[3];
		email = data[4];
		//社团成员对应字符串数组，先设定一个字符串存储所有人的名字
		String personlist = data[5];
		//再存入相应数组
		personList = personlist.split("、");
		//活动对应actInfo类，需要特殊的方法处理,data[6]
		String[] aNames = data[6].split("、");
		//将数组分开存储到personList相对应的位置
		for(String a : aNames) {
			actList.add(a);
			}
		
		intro = data[7];
	}*/
	
	/**
	 * 
	 * @return String
	 */
	/*输出格式*/
	public String output() {
		String output = "姓名：" + name + "\n" + "成立时间：" + time + "\n" + "负责人：" + person + "\n" 
						+ "手机号码：" + tel + "\n" + "邮箱：" + email + "\n" + "成员列表：";
		
		for(int i = 0; i < personList.length-1; i++) {
			output += personList[i] + "、";
		}
		output += personList[personList.length-1] + "\n" + "活动列表：";
		
		for(int i = 0; i < actList.size()-1; i++) {
			output += actList.get(i) + "、";
		}
		output += actList.get(actList.size()-1) + "\n";
		
		output += "简介：" + intro + "\n";
		
		return output;
	}

	/**
	 * 
	 * @return String
	 */
	/*随机选出两张照片*/
	public String choosePhoto() {
		int i,j;
		
		i = new Random().nextInt(10) +1;
		j = new Random().nextInt(10) +1;
		
		String s = i + "/" + j;
		
		return s;
	}
	
	
}
