package com.bob.a20220923;

import java.util.Arrays;

/**
 * @Author wangbo
 * @Date 2022/9/23 16:19
 * @Description: 线性扫描
 * @Version 1.0
 */
public class SepTwentyThreeLinearScanning {
	/**
	 * 需求:一个整型数组 nums ，在数组中找出由三个数字组成的最大乘积，并输出这个乘积。乘积不会越界如果数组中全是非负数，
	 * 则排序后最大的三个数相乘即为最大乘积；如果全是非正数，则最大的三个数相乘同样也为最大乘积。如果数组中有正数有负数，则最大乘积既可能是三个最大正数的乘积，也可能是两个最小负数（即绝对值最大）与最大正数的乘积。
	 * 分别求出三个最大正数的乘积，以及两个最小负数与最大正数的乘积，二者之间的最大值即为所求答案。
	 * <p>
	 * 思路
	 * 不存在正数与负数混合的  取三个最大数 max1、max2、max3
	 * 存在正数与负数混合的    取最大数 与两个最小数 min1、min2、max1
	 * ==>  max1 * max2 * max3  > min1 * min2 * max1 ? max1 * max2 * max3 : min1 * min2 * max1
	 */

	/**
	 * 使用先排序之后再取值比较
	 *
	 * @param array 待分析数组
	 * @return 结果集
	 */
	public static int sort(int[] array) {
		Arrays.sort(array);
		return Math.max(array[array.length - 1] *
						array[array.length - 2] *
						array[array.length - 3],
				array[0] *
						array[1] *
						array[array.length - 1]);
	}

	/**
	 * 使用线性扫描 直接达到目的
	 *
	 * @param array 待分析数组
	 * @return 结果集
	 */
	public static int linearScanning(int[] array) {
		int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE;
		int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
		for (int i = 0; i < array.length; i++) {
			int temp = array[i];
			if (max1 < temp) {
				max2 = max1;
				max3 = max2;
				max1 = temp;
			} else if (max2 < temp) {
				max3 = max2;
				max2 = temp;
			} else if (max3 < temp) {
				max3 = temp;
			}

			if (min1 > temp) {
				min2 = min1;
				min1 = temp;
			} else if (min2 > temp) {
				min2 = temp;

			}
		}
		return Math.max(max1 * max2 * max3, max1 * min1 * min2);
	}

}
