package com.bob.a20221010;

/**
 * @Author wangbo
 * @Date 2022/10/10 11:16
 * @Description: 三角形的最大周长
 * @Version 1.0
 * <p>
 * 需求:
 * 三角形的最大周长
 * 给定由一些正数（代表长度）组成的数组 nums，返回 由其中三个长度组成的、面积不为零的三角形的最大周长。如果不能形成任何面积不为零的三角形，返回	0。
 * 示例 1：
 * 输入：nums = [2,1,2]
 * 输出：5
 * 示例 2：
 * 输入：nums = [1,2,1]
 * 输出：0
 * 提示：
 * 3 <= nums.length <= 10^4
 * 1 <= nums[i] <= 10^6
 */
public class OctTenArrayTriangle {

	/**
	 * @param nums
	 * @param left
	 * @param right
	 * @return
	 */
	public static int optimalRecursion(int[] nums, int left, int right) {
		if (right == left) {
			return nums[left];
		}
		int leftOptimal = nums[left] - optimalRecursion(nums, left + 1, right);
		int rightOptimal = nums[right] - optimalRecursion(nums, left, right - 1);
		return Math.max(leftOptimal, rightOptimal);
	}


	public static boolean optimalDp(int[] nums) {
		if (nums == null || nums.length == 1) {
			return true;
		}
		int[][] container = new int[nums.length][nums.length];
		for (int i = 0; i < nums.length; i++) {
			container[i][i] = nums[i];
		}
		for (int i = nums.length - 2; i >= 0; i--) {
			for (int j = i + 1; j < nums.length; j++) {
				container[i][j] = Math.max(nums[i] - container[i + 1][j], nums[j] - container[i][j - 1]);
			}
		}
		return container[0][nums.length - 1] >= 0;
	}


}
