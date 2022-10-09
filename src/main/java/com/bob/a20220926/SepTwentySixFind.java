package com.bob.a20220926;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author wangbo
 * @Date 2022/9/26 10:15
 * @Description: 暴力、利用map特性、二分查找、双指针
 * @Version 1.0
 */
public class SepTwentySixFind {

	/**
	 * 需求:给定一个升序排列的整数数组 numbers ，从数组中找出两个数满足相加之和等于目标数 target 。
	 * 假设每个输入只对应唯一的答案，而且不可以重复使用相同的元素。
	 * 返回两数的下标值，以数组形式返回
	 *
	 */

	/**
	 * 暴力算法
	 * 分析: 使用双层for循环直接查找
	 *
	 * @param array  待分析的数据集合
	 * @param target 目标数据
	 * @return 结果集
	 */
	public static int[] violence(int[] array, int target) {
		if (array == null || array.length < 2) {
			return new int[]{-1, -1};
		}
		for (int i = 0; i < array.length; i++) {
			// 这里之所以不从1开始是由于之前已遍历过，无需再进行遍历
			for (int j = i + 1; j < array.length; j++) {
				if (array[i] + array[j] == target) {
					return new int[]{i, j};
				}
			}
		}
		return new int[]{-1, -1};
	}

	/**
	 * 利用map特性
	 * 分析: 使用map容器存储,通过一次遍历,将值放到map中,以及满足条件就输出
	 *
	 * @param array  待分析的数据集合
	 * @param target 目标数据
	 * @return 结果集
	 */
	public static int[] utilizeMap(int[] array, int target) {
		if (array == null || array.length < 2) {
			return new int[]{-1, -1};
		}
		Map<Integer, Integer> map = new HashMap<>(16);
		for (int i = 0; i < array.length; i++) {
			map.put(array[i], i);
			if (map.get(target - array[i]) != null) {
				return new int[]{i, map.get(target - array[i])};
			}
		}
		return new int[]{-1, -1};
	}

	/**
	 * 分析:利用原始条件"升序排列"特点,默尔头元素,二分查找尾元素
	 *
	 * @param array  待分析的数据集合
	 * @param target 目标数据
	 * @return 结果集
	 */
	public static int[] binarySearch(int[] array, int target) {
		if (array == null || array.length < 2) {
			return new int[0];
		}
		for (int i = 0; i < array.length; ++i) {
			int low = i, high = array.length - 1;
			while (low <= high) {
				int mid = (high - low) / 2 + low;
				if (array[mid] == target - array[i]) {
					return new int[]{i, mid};
				} else if (array[mid] > target - array[i]) {
					high = mid - 1;
				} else {
					low = mid + 1;
				}
			}
		}
		return new int[]{-1, -1};
	}


	/**
	 * 分析:使用双指针
	 *
	 * @param array  待分析的数据集合
	 * @param target 目标数据
	 * @return
	 */
	public static int[] pointer(int[] array, int target) {
		if (array == null || array.length < 2) {
			return new int[0];
		}
		int low = 0, high = array.length - 1;
		while (low < high) {
			int sum = array[low] + array[high];
			if (sum == target) {
				return new int[]{low + 1, high + 1};
			} else if (sum < target) {
				++low;
			} else {
				--high;
			}
		}
		return new int[]{-1, -1};
	}

}
