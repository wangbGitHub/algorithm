package com.bob.a20221208;

/**
 * @Author wangbo
 * @Date 2022/12/8 09:57
 * @Description: 最大序列数组
 * @Version 1.0
 * <p>
 * 输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
 * 要求时间复杂度为O(n)。
 * 示例1:
 * 输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * 提示：
 * 1 <= arr.length <= 10^5
 * -100 <= arr[i] <= 100
 */
public class ArrayMaxContinuous {
	/**
	 * 动态规划获取最大连续数组
	 *
	 * @param nums
	 * @return
	 */
	public static int maxSubArray(int[] nums) {
		if (nums == null) {
			return 0;
		}
		if (nums.length == 1) {
			return nums[0];
		}
		int max = Integer.MIN_VALUE;
		int max_1 = Integer.MIN_VALUE;
		boolean isContinuous = true;
		for (int i = 0; i < nums.length; i++) {
			int num = nums[i];
			if (num > max && max < 0) {
				max = num;
				// 第二次遗漏的地方
				isContinuous = true;
				continue;
			}
			if (isContinuous) {
				if (max + num >= max) {
					max = max + num;
					continue;
				}
				max_1 = max + num;
				isContinuous = false;
			} else {
				if (max_1 < 0) {
					if (num >= max_1) {
						max_1 = num;
						// 第一次依赖的地方
						if (max_1 >= max) {
							max = max_1;
						}
					}
				} else {
					max_1 = max_1 + num;
					if (max_1 >= max) {
						max = max_1;
						isContinuous = true;
					}
				}
			}
		}
		return max;
	}
}
