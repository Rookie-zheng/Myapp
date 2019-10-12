package com.zheng.storefile;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class StoreFile {

	// 运算表达式写入 Exercises.txt 文件中
	public void storeExTxt(List<String> conten) {
		File file = new File("Exercises.txt");
		if(!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		String filePath = "Exercises.txt";
		FileWriter fwriter = null;
		try {
			fwriter = new FileWriter(filePath);
			for (int i = 0; i < conten.size(); i++) {
				fwriter.write("第 " + (i + 1) +" 题 :" + conten.get(i)+ " = " + "\r\n");
			}
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
	
	public void storeAnTxt(List<String> conten) {
		String filePath = "Answers.txt";
		File file = new File("Answers.txt");
		if(!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		FileWriter fwriter = null;
		try {
			fwriter = new FileWriter(filePath);
			for (int i = 0; i < conten.size(); i++) {
				fwriter.write("第 " + (i + 1) +" 题答案是  : " + conten.get(i)+ "\r\n");
			}
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
}
