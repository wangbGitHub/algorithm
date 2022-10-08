package main.java.com.bob.a20220923;

/**
 * @Author wangbo
 * @Date 2022/9/23 14:16
 * @Description: 二分、牛顿迭代
 * @Version 1.0
 */
public class SepTwentyThreeStatistics {
	/**
	 * 需求:在不使用 sqrt(x） 函数的情况下，得到x的平方根的整数部分
	 */

	/**
	 * 二分法  12  这里有问题 i*i 容易大于 > Integer.MAX_VALUE 一旦大于 计算就会出现问题
	 * 1  12  -- (1+(12-1))/2  6 * 6 = 36 != 12
	 * 1  6  12 --> (1+(6-1))/2  3 * 3 = 9
	 * 3  6   (3+(6-1))/2      4 * 4 = 16
	 * ∵ 12-9 < 16-12  ∴ 3
	 *
	 * @param n 待获取的数据
	 * @return 结果集
	 */
	public static int dichotomy(int n) {
		if (n < 1) {
			return -1;
		}
		return dichotomy(1, n, n);
	}

	private static int dichotomy(int head, int tail, int n) {
		int middle = (tail - 1 + head) / 2;
		if (head == middle) {
			return head;
		}
		// i*i  > Integer.MAX_VALUE 这里查找有问题
		int product = middle * middle;
		if (n == product) {
			return middle;
		}
		boolean isLeft = n - product < 0;
		head = isLeft ? head : middle;
		tail = isLeft ? middle : tail;
		return dichotomy(head, tail, n);
	}

	/**
	 * 牛顿迭代 12
	 * 假设平方根是 i ，则 i 和 x/i 必然都是x的因子，而 x/i 必然等于 i ，推导出 i + x / i = 2 * i，得出 i = (i +x / i) / 2
	 *
	 * @param n 待获取的数据
	 * @return 结果集
	 */
	public static int newtonIteration(double i ,int n) {
		double a = (i + n/i)/2;
		if (a == i){
			return (int) a;
		}
		return newtonIteration(a,n);
	}
}
