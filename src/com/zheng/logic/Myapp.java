package com.zheng.logic;

import java.util.List;
import java.util.Scanner;

import com.zheng.readfile.ReadFile;
import com.zheng.storefile.StoreFile;
import com.zheng.storefile.StoreGrade;

public class Myapp {

	public static void main(String[] args) {
		
		ReadFile rf = new ReadFile();
		StoreFile sf = new StoreFile();
		StoreGrade sg = new StoreGrade();
		
		System.out.println();
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入运算表达式的最大值：");
		int maxValue = sc.nextInt();
		System.out.println("请输入运算表达式的条数：");
		int n = sc.nextInt();
		AutoProOperation apo = new AutoProOperation(maxValue,n);
		List<String> autoProNum = apo.autoProNumNotInt();
		List<String> resultNum = apo.resultCalMatch(autoProNum);
		// 将运算表达式写入 Exercises.txt 文件
		sf.storeExTxt(autoProNum);
		sf.storeAnTxt(resultNum);
		try {
			System.out.println("请确认是否已经答完题目，打完请enter键");
			System.in.read();
			sg.storeGradeTxt();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

