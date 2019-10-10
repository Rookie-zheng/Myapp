package com.zheng.logic;

import java.util.List;

public class test {
	public static void main(String[] args) {
		AutoProOperation atp = new AutoProOperation();
		List<String> list = atp.autoProNum(24,10000);
		for (String string : list) {
			System.out.println(string);
		}
//		
//		String s = "3 + 4 + 5 * 5 * 2 / 2 - 1";
//		int cal = atp.cal(s);
//		System.out.println(cal);
	}
	
	
}
