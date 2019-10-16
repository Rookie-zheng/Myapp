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
		System.out.println("������������ʽ�����ֵ��");
		int maxValue = sc.nextInt();
		System.out.println("������������ʽ��������");
		int n = sc.nextInt();
		long startTime = System.currentTimeMillis();
		AutoProOperation apo = new AutoProOperation(maxValue,n);
		List<String> autoProNum = apo.autoProNumNotInt();
		List<String> resultNum = apo.resultCalMatch(autoProNum);
		// ��������ʽд�� Exercises.txt �ļ�
		sf.storeExTxt(autoProNum);
		sf.storeAnTxt(resultNum);
		long endTime = System.currentTimeMillis();
		long time = endTime - startTime;
		System.out.println("������Ŀ�ʹ���Ҫʱ�䣺" + time);
		try {
			System.out.println("��ȷ���Ƿ��Ѿ�������Ŀ�������밴  enter ��");
			System.in.read();
			sg.storeGradeTxt();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

