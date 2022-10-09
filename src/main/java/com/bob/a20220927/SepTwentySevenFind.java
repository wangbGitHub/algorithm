package com.bob.a20220927;

/**
 * @Author wangbo
 * @Date 2022/9/27 10:57
 * @Description: 排列硬币
 * @Version 1.0
 * <p>
 * 需求:总共有 n 枚硬币，将它们摆成一个阶梯形状，第 k 行就必须正好有 k 枚硬币。
 * 给定一个数字 n，找出可形成完整阶梯行的总行数。n 是一个非负整数，并且在32位有符号整型的范围内
 */
public class SepTwentySevenFind {

	/**
	 * 方式:迭代方式
	 * 分析: 1 2 3 4 5 6 7 ....
	 *
	 * @param n 个数
	 * @return 结果集
	 */
	public static int iteration(int n) {
		if (n < 1) {
			return -1;
		}
		for (int i = 0; i <= n; i++) {
			n = n - i;
			if (n <= i) {
				return i;
			}
		}
		return -1;
	}


	/**
	 * 方式:二分查找
	 * 分析: 1 2 3 4 5 6 7 .... n
	 * (k+1)k/2 = n
	 *
	 * @param n 总数
	 * @return 结果集
	 */
	public static int binarySearch(int n) {
		if (n < 1) {
			return -1;
		}
		int front = 1;
		int back = n;
		while (front < back) {
			int middle = (back - 1 + front) / 2 + front;
			int temp = (middle + 1) * middle / 2;
			if (temp == n) {
				return middle;
			}
			if (temp < n) {
				front = middle;
			}
			if (temp > middle) {
				back = middle;
			}
		}
		return front;
	}


	/**
	 * 牛顿迭代
	 * 假设平方根是 i ，则 i 和 x/i 必然都是x的因子，而 x/i 必然等于 i ，推导出 i + x / i = 2 * i，得出 i = (i +x / i) / 2
	 * 分析: 1 2 3 4 5 6 7 ....   ==>  恰巧:(1+k)k/2 = n  ==> 2n = k+k*k ==> k = √(2n-k)
	 *
	 * @param n 待获取的数据
	 * @return 结果集
	 */
	public static int newtonIteration(double i, int n) {
		double a = (i + (2 * n - i) / i) / 2;
		if (a == i) {
			return (int) a;
		}
		return newtonIteration(a, n);
	}
}
