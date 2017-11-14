package Controller;

import java.io.File;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.Timer;

import Model.actInfo;
import Model.fileOperation;
import Model.personInfo;
import Model.teamInfo;

public class test {

	/**
	 * 
	 * 这是用于测试各部分功能的test类
	 * @param args
	 * @throws InterruptedException
	 * 
	 */
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		List<personInfo> persons = readInPersonList();
		
		List<actInfo> acts = readInActList();
		
	    List<teamInfo> teams = readInTeamList();

	    //测试照片轮播
	    printPhoto(teams);
	    
	    //让所有测试内容间隔一段时间顺序输出
	    long time = System.currentTimeMillis();
	    
	    //测试输出社团列表
	    while(System.currentTimeMillis() - time <= 300);
	    printTeamNameList(teams);
	    System.out.println("");
	    
	    //测试打印活动列表
	    while(System.currentTimeMillis() - time <= 600);
	    printActNameList(acts);
	    System.out.println("");
	    
	    //搜索社团详细信息
	    while(System.currentTimeMillis() - time <= 900);
	    System.out.println("搜索结果：");
	    printTeamInfo(teams,persons,"文学社");
	    
	    while(System.currentTimeMillis() - time <= 1200);
	    System.out.println("搜索结果：");
	    printTeamInfo(teams,persons,"动漫社");
	    
	    //搜索活动详细信息
	    while(System.currentTimeMillis() - time <= 1500);
	    System.out.println("搜索结果：");
	    printActInfo(acts,"星座书上");
	    
	    while(System.currentTimeMillis() - time <= 1800);
	    System.out.println("搜索结果：");
	    printActInfo(acts,"街头篮球表演");
	    
	    //搜索某时间之前的活动
	    while(System.currentTimeMillis() - time <= 2100);
	    System.out.println("2016.1.1前的活动有：");
	    searchBeforeTime(acts,"2016.1.1");
	    
	    //搜索某时间之后的活动
	    while(System.currentTimeMillis() - time <= 2400);
	    System.out.println("2016.5.1后的活动有：");
	    searchAfterTime(acts,"2016.5.1");
	    
	    //根据社团筛选活动
	    while(System.currentTimeMillis() - time <= 2700);
	    System.out.println("街舞社参与主办的活动有：");
	    searchActByTeam(acts,"街舞社");
	    System.out.println("\n");
	    
	    while(System.currentTimeMillis() - time <= 3000);
	    System.out.println("音乐协会参与主办的活动有：");
	    searchActByTeam(acts,"音乐协会");
	    System.out.println("\n");
	    
	    //根据开展活动次数对社团进行排序
	    while(System.currentTimeMillis() - time <= 3300);
	    sortByTimes(teams);
	    System.out.println("\n");
	    
	    //根据活动规模（人数）对社团进行排序
	    while(System.currentTimeMillis() - time <= 3600);
	    sortByPersons(teams);
	    System.out.println("\n");
	    
	    //信息汇总（修改备注）
	    while(System.currentTimeMillis() - time <= 3900);
	    editInfo(acts, "鬼步教学","教师：陈玉，Linda");
	    
	    while(System.currentTimeMillis() - time <= 4200);
	    editInfo(acts,"街头篮球表演","表演队：校篮球队");
	}
	
	/**
	 * 
	 * @return List<personInfo>
	 */
	public static List<personInfo> readInPersonList() {
		List<personInfo> persons = new ArrayList<personInfo>();
		
		/*读入数据，并分类存储*/
		/*用户表的读入，将记录分条存储，并将各属性赋值*/
		List<String> personList = fileOperation.importCsv(new File("用户表.csv"));
		for(int i = 2; i < personList.size(); i++) {
			persons.add(new personInfo(personList.get(i)));
		}
		
		return persons;
			
	}
	
	/**
	 * 
	 * @return List<teamInfo>
	 */
	public static List<teamInfo> readInTeamList() {
	    List<teamInfo> teams = new ArrayList<teamInfo>();
		
		/*读入数据，并分类存储*/
		/*社团表的读入，将记录分条存储，并将各属性赋值*/
		List<String> teamList = fileOperation.importCsv(new File("社团表.csv"));
		for(int i = 2; i < teamList.size(); i++) {
			teams.add(new teamInfo(teamList.get(i)));
		}
			
		return teams;
	}
	
	/**
	 * 
	 * @return List<actInfo>
	 */
	public static List<actInfo> readInActList() {
		List<actInfo> acts = new ArrayList<actInfo>();
		
		/*读入数据，并分类存储*/
		/*活动表的读入，将记录分条存储，并将各属性赋值*/
		List<String> actList = fileOperation.importCsv(new File("活动表.csv"));
		for(int i = 0; i < actList.size(); i++) {
			acts.add(new actInfo(actList.get(i)));
		}
			
		return acts;
	}
	
	/**
	 * 
	 * @param teams
	 * @return List<String>
	 * @throws InterruptedException
	 */
	/*照片轮播——社团首字母排序并返回照片数组*/
	public static List<String> printPhoto(List<teamInfo> teams) throws InterruptedException {
		String[] photoList;
		
		Comparator<Object> com=Collator.getInstance(java.util.Locale.CHINA);
		
		String[] names = new String[10];
		
		for(int i = 0; i < teams.size(); i++) {
			names[i] = teams.get(i).getName();
		}
		
		List<String> list = Arrays.asList(names);  
        Collections.sort(list, com); 
        
        List<String> teamPhoto = new ArrayList<String>();
        
        for(int i = 0; i < list.size(); i++) {
        	for(int j = 0; j < teams.size(); j++) {
        		if(teams.get(j).getName().equals(list.get(i))) {
        			String photo = teams.get(j).choosePhoto();
        			String[] photos = photo.split("/");
        			
        			long start = System.currentTimeMillis();
        			
        			for(int k = 0; k < photos.length;k++) {
        				while(System.currentTimeMillis() - start <= 200*(k+1));
        				System.out.print(list.get(i)+ "  " + "照片" + photos[k] + "  " + "\n");
        			teamPhoto.add(photos[k]);
        			}
        		}
        	}
        }     
        
        return teamPhoto;
	}
	
	/**
	 * 
	 * @param teams
	 */
	/*显示社团列表*/
	public static void printTeamNameList(List<teamInfo> teams) {
		System.out.println("社团列表如下：");
		for(int i = 0; i < teams.size(); i++) {
			System.out.print(teams.get(i).getName() + "  ");
		}
		System.out.println("");
	}
	
	/**
	 * 
	 * @param acts
	 */
	/*显示活动列表*/
	public static void printActNameList(List<actInfo> acts) {
		System.out.println("活动列表如下：");
		for(int i = 0; i < acts.size(); i++) {
			System.out.print(acts.get(i).getName() + "  ");
		}
		System.out.println("");
	}
	
	/**
	 * 
	 * @param teams
	 * @param persons
	 * @param key
	 */
	/*搜索社团详细信息，包括社团信息、负责人信息以及举办过的活动列表*/
	public static void printTeamInfo(List<teamInfo> teams,List<personInfo> persons,String key) {
		for(int i = 0; i < teams.size(); i++) {
			if(teams.get(i).getName().equals(key)) {
				System.out.println(teams.get(i).output());
				System.out.println("负责人信息如下：");
				for(int j = 0; j < persons.size(); j++) {
					if(persons.get(j).getName().equals(teams.get(i).getPerson())) {
						System.out.println(persons.get(j).output());
						break;
					}
				}
				System.out.println("相关活动列表：");
				for(String s : teams.get(i).getActList()) {
					System.out.print(s + "  " + "\n");
				}
			}
		}
	}
	
	/**
	 * 
	 * @param acts
	 * @param key
	 */
	/*搜索活动详细信息*/
	public static void printActInfo(List<actInfo> acts,String key) {
		for(int i = 0; i < acts.size(); i++) {
			if(acts.get(i).getName().equals(key)) {
				System.out.println(acts.get(i).output());
			}
		}
	}
	
	/**
	 * 
	 * @param acts
	 * @param key
	 */
	/*按照时间搜索——之前*/
	public static void searchBeforeTime(List<actInfo> acts,String key) {
		for(int i = 0; i < acts.size(); i++) {
			if(acts.get(i).getTime().compareTo(key) == -1) {
				System.out.println(acts.get(i).output());
			}
		}
	}
	
	/**
	 * 
	 * @param acts
	 * @param key
	 */
	/*按照时间搜索——之后*/
	public static void searchAfterTime(List<actInfo> acts,String key) {
		for(int i = 0; i < acts.size(); i++) {
			if(acts.get(i).getTime().compareTo(key) == 1) {
				System.out.println(acts.get(i).output());
			}
		}
	}
	
	/**
	 * 
	 * @param acts
	 * @param key
	 */
	/*按照社团筛选活动*/
	public static void searchActByTeam(List<actInfo> acts,String key) {
		for(int i = 0; i < acts.size(); i++) {
			for(int j = 0; j < acts.get(i).getHost().size(); j++)
			if(acts.get(i).getHost().get(j).equals(key)) {
				System.out.print(acts.get(i).getName() + "  ");
			}
		}
	}
	
	/**
	 * 
	 * @param teams
	 */
	/*根据开展活动次数对社团进行排序*/
	public static void sortByTimes(List<teamInfo> teams) {
		String t[] = new String[10];
		int i,j;
		for(i = 0; i < teams.size(); i++) {
			t[i] = teams.get(i).getName();
		}
		String tmp = "";
		for(i = 1; i < teams.size(); i++) {
			tmp = t[i];
			for(j  = i; j>0 && (teams.get(j-1).getActList().size() <= teams.get(i).getActList().size());j--) {
				t[j] = t[j-1];
			}
			t[j] = tmp;
		}
		System.out.println("排序后的社团列表为：");
		for(i = 0; i < t.length; i++) {
			System.out.print(t[i] + "  ");
		}
	}
	
	/**
	 * 
	 * @param teams
	 */
	/*根据活动规模（人数）进行排序*/
	public static void sortByPersons(List<teamInfo> teams) {
		String t[] = new String[10];
		int i,j;
		for(i = 0; i < teams.size(); i++) {
			t[i] = teams.get(i).getName();
		}
		String tmp = "";
		for(i = 1; i < teams.size(); i++) {
			tmp = t[i];
			for(j  = i; j>0 && (teams.get(j-1).getPersonList().length <= teams.get(i).getPersonList().length);j--) {
				t[j] = t[j-1];
			}
			t[j] = tmp;
		}
		System.out.println("排序后的社团列表为：");
		for(i = 0; i < t.length; i++) {
			System.out.print(t[i] + "  ");
		}
	}
	
	/**
	 * 
	 * @param acts
	 * @param actName
	 * @param addInfo
	 */
	/*信息汇总（修改备注）*/
	public static void editInfo(List<actInfo> acts,String actName,String addInfo) {
		for(int i = 0; i < acts.size(); i++) {
			if(acts.get(i).getName().equals(actName)) {
				acts.get(i).setIntro(addInfo);
				System.out.println(acts.get(i).output() + "\n");
			}
		}
		File  f = new File("活动表.csv");
		List<String> s = new ArrayList<String>();
		for(int i = 0; i < acts.size(); i++) {
			s.add(acts.get(i).writeOut());
		}
		fileOperation.exportCsv(f, s);
	}
	
}

