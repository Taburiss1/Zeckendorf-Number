package test;

import java.util.ArrayList;
import java.util.Scanner;

public class GetZNum {

	public static void main(String[] args) {

		while (true) {
			System.out.println("请输入一个正整数D ，范围为(1 < D < 10^10)：或者输入q结束！\n");
			Scanner inp = new Scanner(System.in);
			String str = inp.next();
			if (str.equals("q")) {
				break;
			}
			int value = Integer.MAX_VALUE;
			Long tmp = Long.parseLong(str);
			if (tmp <= 1 || tmp >= Math.pow(10, 10)) {
				System.out.println("输入数字不合理，请重新输入！\n");
				continue;
			}
			if (tmp > value) {
				/**
				 * 超长数字暂时没处理
				 */

			} else {
				int tmp1 = Integer.parseInt(str);
				System.out.println("结果为：" + getResult(tmp1));
			}
		}
	}

	private static String getTmpResult(int[] result) {
		String resultStr = "";
		int jLen = result[0] + 1;
		int[] tmpInt = new int[jLen];
		for (int i = 0; i < result.length; i++) {
			tmpInt[result[i]] = 1;
		}
		for (int i = jLen - 1; i > 1; i--) {
			resultStr += tmpInt[i];
		}
		return resultStr;
	}

	private static String getResult(int tmp) {
		int[] result = new int[100];
		int[] all100 = getFArray(tmp);
		int oldR = -1;
		int endInt = 0;
		for (int i = 0; i < 100; i++) {
			int tmpR = all100.length;
			result[i] = tmpR;
			if (oldR - tmpR == 1) {
				result[i] = oldR + 1;
			}
			oldR = tmpR;
			int fibNum = fib(result[i]);
			int half = tmp - fibNum;
			if (half == 0) {
				endInt = i + 1;
				break;
			} else {
				tmp = half;
				all100 = getFArray(tmp);
			}
		}
		int[] returnA = new int[endInt];
		System.arraycopy(result, 0, returnA, 0, endInt);
		return getTmpResult(returnA);
	}


	private static int[] getFArray(int t) {
		int[] fa = new int[100];
		int endInt = 0;
		for (int i = 0; i < 100; i++) {
			fa[i] = fib(i + 1);
			if (fa[i] > t) {
				endInt = i;
				break;
			}
		}
		int[] returnA = new int[endInt];
		System.arraycopy(fa, 0, returnA, 0, endInt);
		return returnA;
	}

	private static int fib(int n) {
		if (n == 1 || n == 2)
			return 1;
		else
			return fib(n - 1) + fib(n - 2);
	}
}
