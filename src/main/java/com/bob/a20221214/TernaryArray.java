package com.bob.a20221214;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author wangbo
 * @Date 2022/12/14 11:29
 * @Description: 三数之和
 * @Version 1.0
 * @link https://leetcode.cn/problems/3sum/
 * <p>
 * 需求
 * 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请
 * 你返回所有和为 0 且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组
 * 示例 1：
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 * 解释：
 * nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0 。
 * nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0 。
 * nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0 。
 * 不同的三元组是 [-1,0,1] 和 [-1,-1,2] 。
 * 注意，输出的顺序和三元组的顺序并不重要。
 * 示例 2：
 * 输入：nums = [0,1,1]
 * 输出：[]
 * 解释：唯一可能的三元组和不为 0 。
 * 示例 3：
 * 输入：nums = [0,0,0]
 * 输出：[[0,0,0]]
 * 解释：唯一可能的三元组和为 0 。
 */
public class TernaryArray {

	public static List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> list = new ArrayList<>();
		if (nums.length < 2) {
			return list;

		}
		Arrays.sort(nums);
		for (int i = 0; i < nums.length - 2; i++) {
			int first = nums[i];
			if (first > 0) {
				break;
			}
			int head = i + 1;
			int tail = nums.length - 1;
			while (head < tail) {
				int headValue = nums[head];
				int tailValue = nums[tail];
				if (first + headValue + tailValue == 0) {
					List<Integer> nodes = new ArrayList<>();
					nodes.add(first);
					nodes.add(headValue);
					nodes.add(tailValue);
					list.add(nodes);
					// TODO 去重未做出来
					// 去重
					while (head + 1 <= tail && nums[head] == nums[head + 1]) {
						head++;
					}
					while (head + 1 <= tail && nums[tail] == nums[tail - 1]) {
						tail--;
					}
					head++;
					tail--;

				} else {
					if (first + headValue + tailValue > 0) {
						tail--;
					} else {
						head++;
					}
				}
			}
			// TODO 去重未做出来
			while (i + 1 < nums.length && nums[i + 1] == nums[i]) {
				i++;
			}
		}
		return list;
	}
}
