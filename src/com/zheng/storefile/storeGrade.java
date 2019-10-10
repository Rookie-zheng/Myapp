package com.zheng.storefile;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class storeGrade {

	
	// 统计答案中的对错数量统计 （还没完结）
	public void storeGradeTxt(List<String> correctConten, List<String> wrongConten) {
		String filePath = "Grade.txt";
		FileWriter fwriter = null;
		try {
			fwriter = new FileWriter(filePath, true);
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
