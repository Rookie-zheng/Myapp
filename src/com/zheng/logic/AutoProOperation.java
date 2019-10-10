package com.zheng.logic;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Stack;

public class AutoProOperation {

	/**
	 * @param maxValue
	 *            ������ʽ���������ֵ
	 * @param n
	 *            ͳ��һ���ж�����������ʽ
	 * @return ����������ʽ�ļ��ϣ�ÿһ�����ַ�����ʾ
	 * 
	 */

	public List<String> autoProNum(int maxValue, int n) {
		// 4�ĺ��壺�������������������� 3 ������������� 4 ��
		final int notChangeNum = 4;
		List<String> list = new ArrayList<>();
		Random rd = new Random();
		int num1 = 0;
		int num2 = 0;

		for (int j = 0; j < n; j++) {
			num1 = rd.nextInt(maxValue);
			// ����Ԫ������Ľ��
			int num = num1;
			int count = 0;
			String temp = num1 + " ";
			String temp1 = "";
			int out = rd.nextInt(notChangeNum - 1) + 1;
			while (count < out) {
				num2 = rd.nextInt(maxValue);
				// ��ȡ�����, 4 ��ʾ�� 4 �������
				int countNum = rd.nextInt(4);
				String getOpe = getOperator(countNum);
				if (getOpe == "/" && num2 == 0) {
					continue;
				}
				temp1 = temp;
				temp = temp + getOpe + " " + num2 + " ";

				count++;
				// ���� temp �Ľ��
				int cal = cal(temp);
//				if (cal > 0) {
//					System.out.println(temp);
//					System.out.println(cal);
//				}
				if (cal < 0) {
					temp = temp1;
					count--;
				}
			}
			list.add(temp);
		}
		return list;
	}

	// ��ȡ��ȷ�Ĵ�
	public List<String> resultCal(List<String> autoProNum){
		List<String> result = new ArrayList<>();
		for (int i = 0; i < autoProNum.size(); i++) {
			int cal = cal(autoProNum.get(i));
			result.add(cal + "");
		}
		return result;
		
	}
	
	/**
	 * 
	 * @param str
	 *            ����� ������ʽ
	 * @return ���ظ�������ʽ���
	 */
	public int cal(String str) {

		Stack<String> operStack = new Stack<String>();
		Stack<String> numStack = new Stack<String>();
		String[] strSplit = str.split(" ");
		int num1 = 0;
		int num2 = 0;
		int result = 0;
		String oper = "";
		for (int i = 0; i < strSplit.length; i++) {
			if (isOper(strSplit[i])) {
				if (!operStack.empty()) {
					if (priority(strSplit[i]) <= priority(operStack.peek())) {
						while (priority(strSplit[i]) <= priority(operStack.peek())) {
							num1 = Integer.parseInt(numStack.pop());
							num2 = Integer.parseInt(numStack.pop());
							oper = operStack.pop();
							result = cal(num1, num2, oper);
							numStack.push(result + "");
							if (operStack.isEmpty()) {
								break;
							}
						}
						operStack.push(strSplit[i]);
					} else {
						operStack.push(strSplit[i]);
					}
				} else {
					operStack.push(strSplit[i]);
				}
			} else {
				numStack.push(strSplit[i]);
			}

		}
		while (true) {
			if (operStack.isEmpty()) {
				break;
			}
			num1 = Integer.parseInt(numStack.pop());
			num2 = Integer.parseInt(numStack.pop());
			oper = operStack.pop();
			result = cal(num1, num2, oper);
			numStack.push(result + "");
		}
		int res = Integer.parseInt(numStack.pop());
		return res;

	}

	// �ж��ǲ���һ�������
	public boolean isOper(String val) {
		return val.equals("+") || val.equals("-") || val.equals("*") || val.equals("/");

	}

	public String getOperator(int num) {
		if (num == 0) {
			return "+";
		} else if (num == 1) {
			return "-";
		} else if (num == 2) {
			return "*";
		} else {
			return "/";
		}
	}

	// ���㷽��
	public int cal(int num1, int num2, String oper) {
		int res = 0; // res ���ڴ�ż���Ľ��
		switch (oper) {
		case "+":
			res = num1 + num2;
			break;
		case "-":
			res = num2 - num1;// ע��˳��
			break;
		case "*":
			res = num1 * num2;
			break;
		case "/":
			res = num2 / num1;
			break;
		default:
			break;
		}
		return res;
	}

	public int priority(String oper) {
		if (oper.equals("*") || oper.equals("/")) {
			return 2;
		}
		if (oper.equals("+") || oper.equals("-")) {
			return 1;
		} else {
			return 0;
		}
	}
}
