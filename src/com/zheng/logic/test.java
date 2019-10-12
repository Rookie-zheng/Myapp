package com.zheng.logic;

import java.util.ArrayList;
import java.util.List;

public class test {
	public static void main(String[] args) {
		AutoProOperation atp = new AutoProOperation(56,10);
//		List<String> list = atp.autoProNum(24,10000);
//		for (String string : list) {
//			System.out.println(string);
//		}
//		
//		String s = "3 + 4 + 5 * 5 * 2 / 2 - 1";
//		int cal = atp.cal(s);
//		System.out.println(cal);
//		List<String> autoProNumNotInt = atp.autoProNumNotInt(24, 1000);
//		for (String string : autoProNumNotInt) {
//			System.out.println(string);
//		}
		List<String> autoProNumNotInt = atp.autoProNumNotInt();
		for (String string : autoProNumNotInt) {
			System.out.println(string);
		}
		String s = "30/41 - 5 - 24/26 * 26/47 ";
		String s1 = "-1/2";
//		String changePro = atp.changePro(s1);
//		System.out.println(changePro);
		List<String> sumFraction1 = atp.resultCalMatch(autoProNumNotInt);
//		int commonMeasure = atp.commonMeasure(Math.abs(Integer.parseInt(sumFraction.split("/")[0])), Integer.parseInt(sumFraction.split("/")[1]));
//		sumFraction = Integer.parseInt(sumFraction.split("/")[0]) / commonMeasure + "/" + Integer.parseInt(sumFraction.split("/")[1]) / commonMeasure;
//		List<String> list = new ArrayList<String>();
//		list.add(s);
//		List<String> sumFraction = ((AutoProOperation) atp).resultCalMatch(sumFraction1);
//		List<String> changeAutoPro1 = atp.changeAutoPro1(list);
		for (String string : sumFraction1) {
			System.out.println(string);
		}
//		System.out.println(commonMeasure);
//		System.out.println();
//		for (String string : sumFraction) {
//			System.out.println(string);
//		}
//		System.out.println(sumFraction);
		
//		System.out.println();
//		for (String string : sumFraction1) {
//			System.out.println(string);
//		}
//		System.out.println(sumFraction);
	}
	
	
}
