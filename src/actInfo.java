package Model;

import java.util.ArrayList;

/**
 * 
 * 活动类
 * @param name 活动名称
 * @param time 开始时间
 * @param location 活动地点
 * @param host 主办社团（可多个）
 * @param intro 备注
 * @param slogan 宣传标语
 *
 */
public class actInfo {

	private String name;
	private String time;
	private String location;
	private ArrayList<String> host = new ArrayList<String>();
	private String intro = "";
	private String slogan;
	
	public actInfo(String name,String time,String location,ArrayList<String> host,String slogan,
			String intro){
		setName(name);
		setTime(time);
		setLocation(location);
		setHost(host);
		setSlogan(slogan);
		this.intro = intro;

	}
	
	/*构造方法的重写*/
	public actInfo(String in) {
		String[] data = in.split(",");
		
		this.name = data[0];
		this.time = data[1];
		this.location = data[2];
		//主办方与teamInfo类相关，需要特殊方法,data[3]
		//先将主办方的社团名存入数组
		String[] tNames = data[3].split("、");
		//通过DataBase类的方法完成
		for(String t : tNames) {
			host.add(t);
		}

		this.slogan = data[4];
		this.intro = data[5];
	}
	
	/*getters*/
	public String getName() {
		return name;
	}
	
	public String getTime() {
		return time;
	}
	
	public String getLocation() {
		return location;
	}
	
	public ArrayList<String> getHost() {
		return host;
	}
	
	public String getIntro() {
		return intro;
	}

	
	public String getSlogan() {
		return slogan;
	}
	
	/*setters*/
	public void setName(String aName) {
		this.name = aName;
	}
	
	public void setTime(String aTime) {
		this.time = aTime;
	}
	
	public void setLocation(String aLocation) {
		this.location = aLocation;
	}
	
	public void setHost(ArrayList<String> aHost) {
		this.host = aHost;
	}
	
	public void setIntro(String aIntro) {
		this.intro = aIntro;
	}

	public void setSlogan(String aSlogan) {
		this.slogan = aSlogan;
	}
	
	/*方法*/
	/*将读取的字符串与相应属性对应*/
/*	public void set(String input) {
		String[] data = input.split(",");
		
		name = data[0];
		time = data[1];
		location = data[2];
		
		String[] tNames = data[3].split("、");
		for(String t : tNames) {
			host.add(t);
		}
		
		slogan = data[4];
		intro = data[5];

	}*/
	
	/**
	 * 
	 * @return String
	 */
	/*输出格式*/
	public String output() {
		String output = "活动名称：" + name + "\n" + "活动时间："  + time + "\n" + "活动地点：" 
						+ location + "\n" + "主办社团：";
		
		for(int i = 0; i < host.size()-1; i++) {
			output += (host.get(i) + "、");
		}
		output += (host.get(host.size()-1) + "\n" + "宣传标语：");
		
		output = output + slogan + "\n" +  "备注：" + intro + "\n" ;
		
		return output;
	}

	/**
	 * 
	 * @return String
	 */
	/*修改文件格式*/
	public String writeOut() {
		String writeOut = name + "," + time + "," + location + ",";
		
		for(int i = 0; i < host.size()-1; i++) {
			writeOut += (host.get(i) + "、");
		}
		
		writeOut += host.get(host.size()-1) + ",";
		
		writeOut += slogan + "," + intro + ",";
		
		return writeOut;
	}
}
