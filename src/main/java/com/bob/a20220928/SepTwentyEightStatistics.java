package main.java.com.bob.a20220928;

/**
 * @Author wangbo
 * @Date 2022/9/28 13:54
 * @Description: 查找对应的数据
 * @Version 1.0
 * @link https://www.processon.com/view/link/6333e4d10e3e740798f9fada
 * <p>
 * <p>
 * 需求:给一个整数数组，找出平均数最大且长度为 k 的下标连续的子数组，并输出该最大平均数。
 */
public class SepTwentyEightStatistics {

	/**
	 * 方法:双指针
	 * 分析: 取前k，
	 * n = 1  head = 0 ,tail = k
	 * n = 2 head = 1, tail = k+1
	 *
	 * @param array 数据源
	 * @param k     几个一组
	 * @return
	 */
	public static double pointer(int[] array, int k) {
		if (array.length < k) {
			return -1;
		}
		int sum = 0;
		for (int i = 0; i < k; i++) {
			sum += array[i];
		}
		int head = 0;
		int max = 0;
		for (int tail = k; tail < array.length; tail++) {
			sum = sum - array[head++] + array[tail];
			max = Math.max(sum, max);
		}
		return 1.0 * max / 4;
	}
}
