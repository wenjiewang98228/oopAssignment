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
	 * �������ڲ��Ը����ֹ��ܵ�test��
	 * @param args
	 * @throws InterruptedException
	 * 
	 */
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		List<personInfo> persons = readInPersonList();
		
		List<actInfo> acts = readInActList();
		
	    List<teamInfo> teams = readInTeamList();

	    //������Ƭ�ֲ�
	    printPhoto(teams);
	    
	    //�����в������ݼ��һ��ʱ��˳�����
	    long time = System.currentTimeMillis();
	    
	    //������������б�
	    while(System.currentTimeMillis() - time <= 300);
	    printTeamNameList(teams);
	    System.out.println("");
	    
	    //���Դ�ӡ��б�
	    while(System.currentTimeMillis() - time <= 600);
	    printActNameList(acts);
	    System.out.println("");
	    
	    //����������ϸ��Ϣ
	    while(System.currentTimeMillis() - time <= 900);
	    System.out.println("���������");
	    printTeamInfo(teams,persons,"��ѧ��");
	    
	    while(System.currentTimeMillis() - time <= 1200);
	    System.out.println("���������");
	    printTeamInfo(teams,persons,"������");
	    
	    //�������ϸ��Ϣ
	    while(System.currentTimeMillis() - time <= 1500);
	    System.out.println("���������");
	    printActInfo(acts,"��������");
	    
	    while(System.currentTimeMillis() - time <= 1800);
	    System.out.println("���������");
	    printActInfo(acts,"��ͷ�������");
	    
	    //����ĳʱ��֮ǰ�Ļ
	    while(System.currentTimeMillis() - time <= 2100);
	    System.out.println("2016.1.1ǰ�Ļ�У�");
	    searchBeforeTime(acts,"2016.1.1");
	    
	    //����ĳʱ��֮��Ļ
	    while(System.currentTimeMillis() - time <= 2400);
	    System.out.println("2016.5.1��Ļ�У�");
	    searchAfterTime(acts,"2016.5.1");
	    
	    //��������ɸѡ�
	    while(System.currentTimeMillis() - time <= 2700);
	    System.out.println("�������������Ļ�У�");
	    searchActByTeam(acts,"������");
	    System.out.println("\n");
	    
	    while(System.currentTimeMillis() - time <= 3000);
	    System.out.println("����Э���������Ļ�У�");
	    searchActByTeam(acts,"����Э��");
	    System.out.println("\n");
	    
	    //���ݿ�չ����������Ž�������
	    while(System.currentTimeMillis() - time <= 3300);
	    sortByTimes(teams);
	    System.out.println("\n");
	    
	    //���ݻ��ģ�������������Ž�������
	    while(System.currentTimeMillis() - time <= 3600);
	    sortByPersons(teams);
	    System.out.println("\n");
	    
	    //��Ϣ���ܣ��޸ı�ע��
	    while(System.currentTimeMillis() - time <= 3900);
	    editInfo(acts, "����ѧ","��ʦ������Linda");
	    
	    while(System.currentTimeMillis() - time <= 4200);
	    editInfo(acts,"��ͷ�������","���ݶӣ�У�����");
	}
	
	/**
	 * 
	 * @return List<personInfo>
	 */
	public static List<personInfo> readInPersonList() {
		List<personInfo> persons = new ArrayList<personInfo>();
		
		/*�������ݣ�������洢*/
		/*�û���Ķ��룬����¼�����洢�����������Ը�ֵ*/
		List<String> personList = fileOperation.importCsv(new File("�û���.csv"));
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
		
		/*�������ݣ�������洢*/
		/*���ű�Ķ��룬����¼�����洢�����������Ը�ֵ*/
		List<String> teamList = fileOperation.importCsv(new File("���ű�.csv"));
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
		
		/*�������ݣ�������洢*/
		/*���Ķ��룬����¼�����洢�����������Ը�ֵ*/
		List<String> actList = fileOperation.importCsv(new File("���.csv"));
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
	/*��Ƭ�ֲ�������������ĸ���򲢷�����Ƭ����*/
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
        				System.out.print(list.get(i)+ "  " + "��Ƭ" + photos[k] + "  " + "\n");
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
	/*��ʾ�����б�*/
	public static void printTeamNameList(List<teamInfo> teams) {
		System.out.println("�����б����£�");
		for(int i = 0; i < teams.size(); i++) {
			System.out.print(teams.get(i).getName() + "  ");
		}
		System.out.println("");
	}
	
	/**
	 * 
	 * @param acts
	 */
	/*��ʾ��б�*/
	public static void printActNameList(List<actInfo> acts) {
		System.out.println("��б����£�");
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
	/*����������ϸ��Ϣ������������Ϣ����������Ϣ�Լ��ٰ���Ļ�б�*/
	public static void printTeamInfo(List<teamInfo> teams,List<personInfo> persons,String key) {
		for(int i = 0; i < teams.size(); i++) {
			if(teams.get(i).getName().equals(key)) {
				System.out.println(teams.get(i).output());
				System.out.println("��������Ϣ���£�");
				for(int j = 0; j < persons.size(); j++) {
					if(persons.get(j).getName().equals(teams.get(i).getPerson())) {
						System.out.println(persons.get(j).output());
						break;
					}
				}
				System.out.println("��ػ�б�");
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
	/*�������ϸ��Ϣ*/
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
	/*����ʱ����������֮ǰ*/
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
	/*����ʱ����������֮��*/
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
	/*��������ɸѡ�*/
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
	/*���ݿ�չ����������Ž�������*/
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
		System.out.println("�����������б�Ϊ��");
		for(i = 0; i < t.length; i++) {
			System.out.print(t[i] + "  ");
		}
	}
	
	/**
	 * 
	 * @param teams
	 */
	/*���ݻ��ģ����������������*/
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
		System.out.println("�����������б�Ϊ��");
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
	/*��Ϣ���ܣ��޸ı�ע��*/
	public static void editInfo(List<actInfo> acts,String actName,String addInfo) {
		for(int i = 0; i < acts.size(); i++) {
			if(acts.get(i).getName().equals(actName)) {
				acts.get(i).setIntro(addInfo);
				System.out.println(acts.get(i).output() + "\n");
			}
		}
		File  f = new File("���.csv");
		List<String> s = new ArrayList<String>();
		for(int i = 0; i < acts.size(); i++) {
			s.add(acts.get(i).writeOut());
		}
		fileOperation.exportCsv(f, s);
	}
	
}

