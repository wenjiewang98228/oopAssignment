package Model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class fileOperation {

	/**
	 * 
	 * ÎÄ¼þ¶ÁÐ´Àà
	 * @param file
	 * @param dataList
	 * @return true/false
	 */
	public static boolean exportCsv(File file, List<String> dataList){
        boolean isSuccess = false;
		
		FileOutputStream out = null;
		OutputStreamWriter osw = null;
		BufferedWriter bw = null;
		
		try {
			out = new FileOutputStream(file);
			osw = new OutputStreamWriter(out,"GBK");
			bw = new BufferedWriter(osw);
			
			if(dataList != null && !dataList.isEmpty()){
				for(String data : dataList) {
					bw.append(data).append("\r\n");
				}
			}
			isSuccess = true;
		}
		catch(Exception e){
			isSuccess = false;
		}
		finally {
			if(bw != null) {
				try {
					bw.close();
					bw = null;
				}
				catch(IOException e){
					e.printStackTrace();
				}
			}
			if(osw != null) {
				try {
					osw.close();
					osw = null;
				}
				catch(IOException e) {
					e.printStackTrace();
				}
			}
			if(out != null) {
				try {
					out.close();
					out = null;
				}
				catch(IOException e) {
					e.printStackTrace();
				}
			}
			}
		return isSuccess;
		}
		
	   /**
	    * 
	    * @param file
	    * @return true/false
	    */
		public static List<String> importCsv(File file){
			List<String> dataList = new ArrayList<String>();
			
			BufferedReader br = null;
			
			try {
				br = new BufferedReader(new InputStreamReader(new FileInputStream(file),"GBK"));
				
				String line = "";
				
				while((line = br.readLine()) != null) {
					dataList.add(line);
				}
			}
			catch(Exception e){
			}
			finally {
				if(br != null) {
					try {
						br.close();
						br = null;
					}
					catch(Exception e) {
						e.printStackTrace();
					}
				}
			}
		return dataList;	
		}
}
