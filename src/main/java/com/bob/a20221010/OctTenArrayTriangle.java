package com.bob.a20221010;

/**
 * @Author wangbo
 * @Date 2022/10/10 11:16
 * @Description: 三角形的最大周长
 * @Version 1.0
 * <p>
 * 需求:
 * 三角形的最大周长
 * 给定由一些正数（代表长度）组成的数组 nums ，返回 由其中三个长度组成的、面积不为零的三角形的最大周长 。如果不能形成任何面积不为零的三角形，返回 0。
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

	public static int largestPerimeter(int[] nums) {
		if (nums == null || nums.length < 3) {
			return 0;
		}
		int big = 0;
		int middle = 0;
		int micro = 0;
		for (int i = 0; i < nums.length; i++) {
			if (i == 0) {
				big = nums[i];
				continue;
			}
			if (i == 1) {
				middle = Math.min(big, nums[i]);
				big = Math.max(big, nums[i]);
				continue;
			}
			if (nums[i] >= big) {
				micro = middle;
				middle = big;
				big = nums[i];
				continue;
			}
			if (nums[i] >= middle) {
				micro = middle;
				middle = nums[i];
				continue;
			}
			if (nums[i] >= micro) {
				micro = nums[i];
			}
		}
		if (checkTriangle(big,middle,micro)){
			return  big + middle + micro;
		}
		boolean isFinish = true;
		while (!checkTriangle(big,middle,micro) && isFinish){
			big = middle;
			middle = micro;
			int max = 0;
			boolean isBig = false;
			boolean isMiddle = false;
			for (int i = 0; i < nums.length; i++) {
				if (middle == nums[i] && !isMiddle){
					isMiddle = true;
					continue;
				}
				if (middle == nums[i] && big != middle && isMiddle ){
					max = nums[i];
					break;
				}
				if (big == nums[i] && big == middle && isMiddle && !isBig){
					isBig = true;
					continue;
				}
				if (middle == nums[i] && big == middle && isMiddle &&  isBig){
					max = nums[i];
					break;
				}
				if (micro > nums[i] && nums[i] > max){
					max = nums[i];
					continue;
				}
			}
			if (max == 0){
				isFinish = false;
			}
			micro = max;
		}
		if (!checkTriangle(big,middle,micro)){
			return 0;
		}
		return big + middle + micro;
	}

	private static boolean checkTriangle(int big, int middle, int micro) {
		return big - micro < middle && micro + middle > big;
	}
}
