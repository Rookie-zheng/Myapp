package com.zheng.logic;

public class test {
	public static void main(String[] args) {
		String s = "( 2 / 1 / 5 ) + 3";
		AutoProOperation apo = new AutoProOperation();
		String resultCalNotInt = apo.resultCalNotInt(s);
		System.out.println(resultCalNotInt);
	}
}
