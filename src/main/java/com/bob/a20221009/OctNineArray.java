package com.bob.a20221009;

import com.bob.untils.ArrayUntil;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author wangbo
 * @Date 2022/10/9 14:23
 * @Description: 寻找找出数字连续的最长序列
 * @Version 1.0
 * <p>
 * 需求:
 * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 * 示例 1：
 * 输入：nums = [100,4,200,1,3,2]
 * 输出：4
 * 解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
 * 示例 2：
 * 输入：nums = [0,3,7,2,5,8,4,6,0,1]
 * 输出：9
 * 提示：
 * 0 <= nums.length <= 10^4
 * -10^9 <= nums[i] <= 10^9
 * 进阶：可以设计并实现时间复杂度为O(n) 的解决方案吗？
 */
public class OctNineArray {

	/**
	 * 分析:
	 * 1.先排序
	 * 2.再通过比较
	 *
	 * @param nums 待分析的数组
	 * @return 结果集
	 */
	public static int sortFind(int[] nums) {
		if (nums == null) {
			return 0;
		}
		if (nums.length == 1) {
			return 1;
		}
		ArrayUntil.heapSort(nums);
		int max = 0;
		int count = 0;
		for (int i = 0; i < nums.length; i++) {
			if (i == 0) {
				count++;
				continue;
			}
			if (Math.abs(nums[i] - nums[i - 1]) == 1) {
				count++;
			}
			if (Math.abs(nums[i] - nums[i - 1]) > 1) {
				count = 1;
			}
			max = Math.max(max, count);
		}
		return max;
	}

	/**
	 * 方法: 哈希
	 * 分析:
	 * 	1.先排序
	 *
	 * @param nums
	 * @return
	 */
	public static int hash(int[] nums) {
		if (nums == null) {
			return 0;
		}
		Set<Integer> set = new HashSet<>(nums.length);
		for (int i = 0; i < nums.length; i++) {
			set.add(nums[i]);
		}
		int currentStreak = 0;
		int max = 0;
		for (Integer num : set) {
			boolean isBefore = set.contains(num - 1);
			if (isBefore) {
				continue;
			}
			boolean isAfter = set.contains(num + 1);
			currentStreak = 1;
			max = Math.max(max, 1);
			if (!isAfter) {
				continue;
			}
			while (set.contains(++num)) {
				currentStreak++;
			}
			max = Math.max(max, currentStreak);
		}
		return max;
	}


}
