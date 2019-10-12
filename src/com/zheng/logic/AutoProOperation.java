package com.zheng.logic;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Stack;

import javax.print.StreamPrintService;

public class AutoProOperation {
	public int maxValue = 0;
	public int n = 0;

	public AutoProOperation(int maxValue, int n) {
		this.maxValue = maxValue;
		this.n = n;
	}

	public AutoProOperation() {
		// TODO Auto-generated constructor stub
	}

	public List<String> autoProNumNotInt() {
		// 4的含义：由于输入的运算符不超过 3 个，所以数最多 4 个
		final int notChangeNum = 4;
		List<String> list = new ArrayList<>();
		Random rd = new Random();
		int num1 = 0;
		int num2 = 0;
		String num1Str = "";
		String num2Str = "";
		String numerator = "";
		String denominator = "";
		for (int j = 0; j < n; j++) {
			int random1 = 0;
			int random2 = 0;
			String temp = "";
			random1 = rd.nextInt(15);
			random2 = rd.nextInt(4);
			if (random1 == 1) {
				temp = "(" + " ";
			}
			if (random2 == 1) {
				int input1 = rd.nextInt(maxValue - 1) + 1;
				numerator = rd.nextInt(input1) + "";
				denominator = input1 + "";
				num1Str = numerator + "/" + denominator;
				temp = temp + num1Str + " ";
			} else {
				num1 = rd.nextInt(maxValue);
				temp = temp + num1 + " ";
			}

			int count = 0;

			String temp1 = "";
			int out = rd.nextInt(notChangeNum - 1) + 1;
			int right = 0;
			if (out == 1) {
				right = out;
			} else {
				right = rd.nextInt(out) + 1;
			}
			while (count < out) {

				int markNum = rd.nextInt(3);
				// 获取运算符, 4 表示有 4 个运算符
				int countNum = rd.nextInt(4);
				String getOpe = getOperator(countNum);

				if (markNum == 0) {
					int input = rd.nextInt(maxValue - 1) + 1;
					numerator = rd.nextInt(input) + "";
					denominator = input + "";
					num2Str = numerator + "/" + denominator;
					if (Integer.parseInt(numerator) == 0 && getOpe.equals("/")) {
						continue;
					}
					temp1 = temp;
					temp = temp + getOpe + " " + num2Str + " ";
				} else {
					num2 = rd.nextInt(maxValue);
					if (getOpe == "/" && num2 == 0) {
						continue;
					}
					temp1 = temp;
					temp = temp + getOpe + " " + num2 + " ";
				}
				if (count == right - 1 && random1 == 1) {
					temp = temp + ")" + " ";
				}
				count++;
			}
			temp = temp.trim();
			list.add(temp);
		}
		return list;
	}

	// 运算表达式转换成 分数形式
	public List<String> changeAutoPro() {
		List<String> result = autoProNumNotInt();
		for (String str : result) {
			String[] strSplit = str.split(" ");
			for (int j = 0; j < strSplit.length; j++) {
				if (!isOper(strSplit[j]) && !strSplit[j].equals("(") && !strSplit[j].equals(")")
						&& !strSplit[j].contains("/")) {
					if (Integer.parseInt(strSplit[j]) != 0) {
						strSplit[j] = Integer.parseInt(strSplit[j]) * Integer.parseInt(strSplit[j]) + "/"
								+ Integer.parseInt(strSplit[j]);
					}
				}
			}
			result.add(str);
		}
		return result;
	}

	public List<String> changeAutoPro1(List<String> result) {
		String newStr = "";
		List<String> result1 = new ArrayList<>();
		for (String str : result) {
			String[] strSplit = str.split(" ");
			for (int j = 0; j < strSplit.length; j++) {
				if (!isOper(strSplit[j]) && !strSplit[j].equals("(") && !strSplit[j].equals(")")
						&& !strSplit[j].contains("/")) {
					if (Integer.parseInt(strSplit[j]) != 0) {
						strSplit[j] = Integer.parseInt(strSplit[j]) * Integer.parseInt(strSplit[j]) + "/"
								+ Integer.parseInt(strSplit[j]);
					}
				}
				newStr = newStr + strSplit[j] + " ";
			}
			result1.add(newStr);
		}
		return result1;
	}

	public List<String> resultCalMatch(List<String> autoProNumNotInt) {
		List<String> result = new ArrayList<>();
		for (String str : autoProNumNotInt) {
			String resultCalNotInt = resultCalNotInt(str);
			if (resultCalNotInt.contains("-")) {
				int num1 = Math.abs(Integer.parseInt(resultCalNotInt.split("/")[0]));
				int num2 = Integer.parseInt(resultCalNotInt.split("/")[1]);
				int res = commonMeasure(num1, num2);
				resultCalNotInt = "-" + num1 / res + "/" + num2 / res;
				resultCalNotInt = changePro(resultCalNotInt);
			} else {
				if (resultCalNotInt.equals("0")) {
					resultCalNotInt = 0 + "";
				} else {
					int num1 = Math.abs(Integer.parseInt(resultCalNotInt.split("/")[0]));
					int num2 = Integer.parseInt(resultCalNotInt.split("/")[1]);
					int res = commonMeasure(num1, num2);
					resultCalNotInt = num1 / res + "/" + num2 / res;
					resultCalNotInt = changePro(resultCalNotInt);
				}

			}
			result.add(resultCalNotInt);
		}
		return result;
	}

	// 分数变成要求的样式
	public String changePro(String str) {
		if (str.equals("0") || str.equals("0/0")) {
			return "0";
		}
		String[] strSplit = str.split("/");
		int num1 = Math.abs(Integer.parseInt(strSplit[0]));
		int num2 = Math.abs(Integer.parseInt(strSplit[1]));
		int a = num1 / num2;
		int b = num1 % num2;
		if (str.contains("-")) {
			if (a != 0) {
				if(b == 0) {
					return "-" + a;
				}
				return "-" + a + "`" + b + "/" + num2;
			}
		} else {
			if (a != 0) {
				if(b == 0) {
					return a + "";
				}
				return a + "`" + b + "/" + num2;
			}
		}
		return str;
	}

	// 返回结果
	public String resultCalNotInt(String str) {
		Stack<String> operStack = new Stack<String>();
		Stack<String> numStack = new Stack<String>();
		List<String> list = new ArrayList<>();
		list.add(str);
		list = changeAutoPro1(list);
		str = list.get(0);
		String[] strSplit = str.split(" ");
		String num1 = "";
		String num2 = "";
		String oper = "";
		String oper1 = "";
		String numStr = "";
		String result = "";
		for (int i = 0; i < strSplit.length; i++) {
			if (strSplit[i].equals(")")) {
				List<String> newList = new ArrayList<>();
				numStr = operStack.peek();
				while (!numStr.equals("(")) {
					num1 = numStack.pop();
					if (num1.equals("0")) {
						continue;
					}
					num2 = numStack.pop();

					oper = operStack.pop();
					oper1 = oper;
					while (priority(operStack.peek()) > priority(oper)) {
						numStr = numStack.pop();
						result = sumFraction(numStr, num2, oper1);
						numStack.push(result);
						if (!operStack.isEmpty() && priority(operStack.peek()) > priority(oper)
								&& !operStack.peek().equals("(")) {
							oper1 = operStack.pop();
						}
					}
					numStr = operStack.peek();
					result = sumFraction(num2, num1, oper);
					numStack.push(result);
				}
				numStack.pop();
				numStack.push(result);
				operStack.pop();
			} else {
				if (strSplit[i].equals("(")) {
					operStack.push(strSplit[i]);
				} else {
					if (isOper(strSplit[i])) {
						if (!operStack.isEmpty()) {
							if (priority(strSplit[i]) <= priority(operStack.peek())) {
								while (priority(strSplit[i]) <= priority(operStack.peek())) {
									num1 = numStack.pop();
									num2 = numStack.pop();
									oper = operStack.pop();
									result = sumFraction(num2, num1, oper);
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
			}
		}
		int size = operStack.size();
		for (int k = 0; k < size; k++) {
			if (operStack.isEmpty()) {
				break;
			}
			num1 = numStack.pop();
			num2 = numStack.pop();
			oper = operStack.pop();
			result = sumFraction(num2, num1, oper);
			numStack.push(result);
		}
		return result;
	}

	/**
	 * 
	 * @param a
	 *            分子
	 * @param b
	 *            分母
	 * @return 返回真分数的最大公约数
	 */
	public int commonMeasure(int a, int b) {
		int res = 1;
		for (int i = 1; i <= a; i++) {
			if (a % i == 0 && b % i == 0) {
				res = i;
			}
		}
		return res;
	}

	/**
	 * 
	 * @param a
	 *            分子
	 * @param b
	 *            分母
	 * @return 返回一个要求的分数表达式 1'3/4
	 */
	public String changeMeasure(int a, int b) {
		int moreNum = a / b;
		int remainderNum = a % b;
		String result = "";
		if (moreNum > 0) {
			result = moreNum + "'" + remainderNum + "/" + b;
		} else {
			result = a + "/" + b;
		}
		return result;
	}

	/**
	 * @param fraction1
	 *            左边真分数
	 * @param fraction2
	 *            右边真分数
	 * @param proStr
	 *            符号
	 * @return 返回结果，没有化简
	 */
	public String sumFraction(String fraction1, String fraction2, String proStr) {
		int fra12 = 0;
		int fra22 = 0;
		if (fraction1.equals("0")) {
			fra12 = 0;
		} else {
			fra12 = Integer.parseInt(fraction1.split("/")[1]);
		}
		if (fraction2.equals("0")) {
			fra22 = 0;
		} else {
			fra22 = Integer.parseInt(fraction2.split("/")[1]);
		}
		int fra11 = Integer.parseInt(fraction1.split("/")[0]);
		int fra21 = Integer.parseInt(fraction2.split("/")[0]);
		int numerator = 0;
		int denominator = 0;
		int res = 1;
		String result = "";
		switch (proStr) {
		case "+":
			if (fraction1.equals("0") && !fraction2.equals("0")) {
				result = fraction2;
			} else if (!fraction1.equals("0") && fraction2.equals("0")) {
				result = fraction1;
			} else {
				numerator = fra11 * fra22 + fra12 * fra21;
				denominator = fra12 * fra22;
				res = commonMeasure(numerator, denominator);
				numerator = numerator / res;
				denominator = denominator / res;
				result = numerator + "/" + denominator;
			}

			break;
		case "-":
			if (fraction2.equals("0")) {
				result = fraction1;
			} else {
				numerator = fra11 * fra22 - fra12 * fra21;
				denominator = fra12 * fra22;
				res = commonMeasure(numerator, denominator);
				numerator = numerator / res;
				denominator = denominator / res;
				result = numerator + "/" + denominator;
			}

			break;
		case "*":

			if (fraction1.equals("0") || fraction2.equals("0")) {
				result = 0 + "";
			} else {
				numerator = fra11 * fra21;
				denominator = fra12 * fra22;
				res = commonMeasure(numerator, denominator);
				numerator = numerator / res;
				denominator = denominator / res;
				result = numerator + "/" + denominator;
			}

			break;
		case "/":
			if (fraction1.equals("0")) {
				result = 0 + "";
			} else {
				numerator = fra11 * fra22;
				denominator = fra12 * fra21;
				numerator = numerator / res;
				denominator = denominator / res;
				result = numerator + "/" + denominator;
				break;
			}

		}
		return result;
	}

	// 判断是不是一个运算符
	public boolean isOper(String val) {
		return val.equals("+") || val.equals("-") || val.equals("*") || val.equals("/");

	}

	// 判断运算符优先级
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
}
