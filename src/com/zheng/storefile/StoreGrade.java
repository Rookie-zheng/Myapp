package com.zheng.storefile;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.zheng.readfile.ReadFile;

public class StoreGrade {

	// 统计答案中的对错数量统计 
	public void storeGradeTxt() throws Exception {
		ReadFile rf = new ReadFile();
		List<String> correctConten = new ArrayList<>();
		List<String> wrongConten = new ArrayList<>();
		List<String> listEX = new ArrayList<String>();
		listEX = rf.readInputAn();
		List<String> listGrade = new ArrayList<>();
		listGrade = rf.readCorrectAn();
		
		String filePath = "Grade.txt";
		FileWriter fwriter = null;
		String correctStr = null;
		String wrongStr = null;
		try {
			fwriter = new FileWriter(filePath);
			for (int i = 0; i < listGrade.size(); i++) {
				if((listGrade.get(i)).equals(listEX.get(i))) {
					correctConten.add(i + 1 + "");
				}else if(!listGrade.get(i).equals(listEX.get(i))) {
					wrongConten.add(i + 1 + "");
				}
			}
			correctStr = "Correct: " + correctConten.size() + "[";
			wrongStr = "Wrong: " + wrongConten.size() + "[";
			if(correctConten.size() == 0) {
				correctStr = correctStr + "]";
			}
			if(wrongConten.size() == 0) {
				wrongStr = wrongStr + "]";
			}
			for(int j = 0; j < correctConten.size(); j++) {
				if(j != correctConten.size() - 1) {
					correctStr = correctStr + correctConten.get(j) + ",";
				} else {
					correctStr = correctStr + correctConten.get(j) + "]";
				}
			}
			
			for(int j = 0; j < wrongConten.size(); j++) {
				if(j != wrongConten.size() - 1) {
					wrongStr = wrongStr + wrongConten.get(j) + ",";
				} else {
					wrongStr = wrongStr + wrongConten.get(j) + "]";
				}
			}
			fwriter.write(correctStr + "\r\n");
			fwriter.write(wrongStr);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fwriter.flush();
				fwriter.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
