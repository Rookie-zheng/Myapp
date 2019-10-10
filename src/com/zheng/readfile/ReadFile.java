package com.zheng.readfile;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class ReadFile {
	
	// 读取 Answers.txt 中的文件内容
	public List<String> readAnswersFile() throws Exception{
		List<String> getConten = new ArrayList<String>();
		File file = new File("Answers.txt");
		if(!file.exists()) {
			System.out.println("文件不存在");
			return new ArrayList<String>();
		}
		InputStreamReader read = null;
		try {
			read = new InputStreamReader(new FileInputStream(file),"utf-8");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BufferedReader bufferedReader = new BufferedReader(read);
		String lineTxt = null;
		while((lineTxt = bufferedReader.readLine()) != null) {
			getConten.add(lineTxt);
		}
		read.close();
		return getConten;
	}
	
}
