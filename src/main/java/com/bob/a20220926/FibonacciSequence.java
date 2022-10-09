package com.bob.a20220926;

/**
 * @Author wangbo
 * @Date 2022/9/26 14:34
 * @Description: 递归
 * @Version 1.0
 * <p>
 * 求取斐波那契数列第N位的值。
 * 斐波那契数列：每一位的值等于他前两位数字之和。前两位固定 0，1,1,2,3,5,8...
 */
public class FibonacciSequence {

	/**
	 * 方法:递归
	 * 分析: f(n) = f(n-1)+f(n-2)
	 *
	 * @param seat 第几个
	 * @return 结果集
	 */
	public static int recursion(int seat) {
		if (seat == 1) {
			return 0;
		}
		if (seat == 2) {
			return 1;
		}
		return recursion(seat - 1) + recursion(seat - 2);
	}

	/**
	 * 方法:递归
	 * 分析: f(n) = f(n-1)+f(n-2) 分析如图所属示 TODO 待补图
	 *
	 * @param seat 第几个
	 * @return 结果集
	 */
	public static int recursionOptimize(int seat) {
		int[] array = new int[seat];
		return recursion(seat, array);
	}

	private static int recursion(int seat, int[] array) {
		if (seat == 1) {
			return 0;
		}
		if (seat == 2) {
			return 1;
		}
		if (array[seat - 1] == 0) {
			array[seat - 1] = recursion(seat - 1, array) + recursion(seat - 2, array);
		}
		return array[seat - 1];
	}

	/**
	 * 方法:双指针方式
	 * 分析: 0,1,1,2,3,5,8,13,21,34,55 分析如图所属示 TODO 待补充图
	 *
	 * @param seat 第几个
	 * @return 结果集
	 */
	public static int pointer(int seat) {
		int sum = 0;
		int head = 0;
		int tail = 1;
		if (seat == 1) {
			return head;
		}
		if (seat == 2) {
			return tail;
		}
		for (int i = 3; i <= seat; i++) {
			sum = head + tail;
			head = tail;
			tail = sum;
		}
		return sum;
	}

}
