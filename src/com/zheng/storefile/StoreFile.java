package com.zheng.storefile;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class StoreFile {

	// 运算表达式写入 Exercises.txt 文件中
	public void storeExTxt(List<String> conten) {
		String filePath = "Exercises.txt";
		FileWriter fwriter = null;
		try {
			fwriter = new FileWriter(filePath, true);
			for (int i = 0; i < conten.size(); i++) {
				fwriter.write(conten.get(i));
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
