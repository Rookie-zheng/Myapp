package com.zheng.logic;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AutoProOperation {
	
	
	
	
	
	public List<String> autoProNum(){
		Random rd = new Random();
		int num1 = 0;
		int num2 = 0;
		for(int i = 0; i < 10; i++) {
			num1 = rd.nextInt();
			num2 = rd.nextInt();
			
		}
		return new ArrayList<String>();
	}
	
}
