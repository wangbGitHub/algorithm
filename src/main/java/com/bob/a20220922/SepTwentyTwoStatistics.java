package com.bob.a20220922;

/**
 * @Author wangbo
 * @Date 2022/9/22 11:48
 * @Description: 统计算法
 * @Version 1.0
 */
public class SepTwentyTwoStatistics {
	/**
	 * 统计n以内素数个数 0和1 除外
	 */

	/**
	 * 暴力算法
	 *
	 * @param n 待计算的数据
	 * @return 结果集
	 */
	public static int violence(int n) {
		int count = 0;
		if (n < 2) {
			return count;
		}
		for (int i = 2; i <= n; i++) {
			if (isPrime(i)) {
				count++;
			}
		}
		return count;
	}

	/**
	 * 判断当前数是否是素数
	 *
	 * @param i 被判断的数
	 * @return
	 */
	private static boolean isPrime(int i) {
		boolean isPrime = true;
		for (int j = 2; j < i && isPrime; j++) {
			if (i % j == 0) {
				isPrime = false;
			}
		}
		return isPrime;
	}

	/**
	 * 埃氏筛选
	 * <p>
	 * 2*2 = 4
	 * 2*3 = 6   3*2 = 6	4*2 = 8
	 * 2*4 = 8   3*3 = 9    4*3 = 12
	 * 2*5 = 10  3*4 = 12   4*4 = 16
	 * 2*6 = 12  3*5 = 15   4*5 = 20
	 * ...		 ...        ...
	 *
	 * @param n 待计算的数据
	 * @return 结果集
	 */
	public static int erichsen(int n) {
		int count = 0;
		if (n < 2) {
			return count;
		}
		boolean[] isPrimes = new boolean[n + 1];
		for (int i = 2; i <= n; i++) {
			if (!isPrimes[i]) {
				count++;
				for (int j = i * i; j < n && j > 0; j += i) {
					isPrimes[j] = true;
				}
				continue;
			}
		}
		return count;
	}

}
