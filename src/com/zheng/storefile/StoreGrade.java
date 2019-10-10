package com.zheng.storefile;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import com.zheng.logic.AutoProOperation;

public class StoreGrade {

	// 统计答案中的对错数量统计 
	public void storeGradeTxt(List<String> correctConten, List<String> wrongConten) throws Exception {
		List<String> listEX = new ArrayList<String>();
		listEX = readEXFile("Exercises.txt");
		List<String> listGrade = new ArrayList<>();
		listGrade = readEXFile("Answers.txt");
		List<String> resulAntNum = new ArrayList<>();
		
		String filePath = "Grade.txt";
		FileWriter fwriter = null;
		String correctStr = null;
		String wrongStr = null;
		try {
			fwriter = new FileWriter(filePath, true);
			AutoProOperation apo = new AutoProOperation();
			resulAntNum.addAll(apo.resultCal(listEX));
			for (int i = 0; i < listEX.size(); i++) {
				if(listEX.get(i).equals(resulAntNum.get(i))) {
					correctConten.add(i + "");
				}else if(!listEX.get(i).equals(resulAntNum.get(i))) {
					wrongConten.add(i + "");
				}
			}
			correctStr = "Correct: " + correctConten.size() + 1 + "[";
			wrongStr = "Wrong: " + wrongConten.size() + 1 + "[";
			for(int j = 0; j < correctConten.size(); j++) {
				if(j != correctConten.size() - 1) {
					correctStr = correctStr + correctConten.get(j) + ",";
				} else {
					correctStr = correctStr + correctStr + "]";
				}
			}
			
			for(int j = 0; j < wrongConten.size(); j++) {
				if(j != wrongConten.size() - 1) {
					wrongStr = wrongStr + wrongConten.get(j) + ",";
				} else {
					wrongStr = wrongStr + wrongConten.get(j) + "]";
				}
			}
			fwriter.write(correctStr);
			fwriter.write(wrongStr);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fwriter.flush();
				fwriter.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	// 读取 Answers.txt 中的文件内容
	public List<String> readEXFile(String str) throws Exception {
		List<String> getConten = new ArrayList<String>();
		File file = new File(str);
		if (!file.exists()) {
			System.out.println("文件不存在");
			return new ArrayList<String>();
		}
		InputStreamReader read = null;
		try {
			read = new InputStreamReader(new FileInputStream(file), "utf-8");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BufferedReader bufferedReader = new BufferedReader(read);
		String lineTxt = null;
		while ((lineTxt = bufferedReader.readLine()) != null) {
			getConten.add(lineTxt);
		}
		read.close();
		return getConten;
	}
}
