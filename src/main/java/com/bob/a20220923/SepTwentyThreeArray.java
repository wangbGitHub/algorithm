package main.java.com.bob.a20220923;

/**
 * @Author wangbo
 * @Date 2022/9/23 14:16
 * @Description: 双指针算法
 * @Version 1.0
 */
public class SepTwentyThreeArray {
	/**
	 * 需求:给定一个整数数组nums， 请编写一个能够返回数组“中心下标” 的方法
	 * 中心下标是数组的一个下标，其左侧所有元素相加的和等于右侧所有元素相加的和。如果数组不存在中心下标，返回-1。如果数组有多个中心下标，应该返回最靠近左边的那一个。
	 * 注意：中心下标可能出现在数组的两端。
	 */

	/**
	 * 双指针算法
	 *
	 * @param array 待查找的数据集
	 * @return 结果集
	 */
	public static int findCentre(int[] array) {
		int sub = -1;
		if (array == null || array.length < 2) {
			return sub;
		}
		int sum = 0;
		for (int i = 0; i < array.length; i++) {
			sum += array[i];
		}
		int frontSum = 0;
		for (int i = 0; i < array.length; i++) {
			frontSum += array[i];
			sum -= array[i];
			if (frontSum == sum) {
				return i;
			}
		}
		return sub;
	}
}
