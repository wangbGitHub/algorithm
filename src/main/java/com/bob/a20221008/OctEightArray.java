package com.bob.a20221008;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author wangbo
 * @Date 2022/10/8 14:06
 * @Description: 寻找消失的数
 * @Version 1.0
 * <p>
 * 需求:
 * 给你一个含n个整数的数组nums,其中nums[i]在区间[1,n]内.请找出所有在[1,n]范围内但没有出现在nums中的数字,并以数组的形式返回结果
 * 示例1:
 * 输入:nums = [4,3,2,7,8,2,3,1]
 * 输出:[5,6]
 * 示例2:
 * 输入:nums = [1,1]
 * 输出:nums = [2]
 */
public class OctEightArray {

	/**
	 * 分析:
	 * 1.使用boolean[] flags接收
	 * 2.遍历nums数组,存在的数改变flags下标标记
	 * 3.遍历flags
	 *
	 * @param nums 待核查的数据
	 * @return 结果集
	 */
	public static int[] violence(int[] nums) {
		boolean[] flags = new boolean[nums.length];
		int count = 0;
		for (int i = 0; i < nums.length; i++) {
			if (flags[nums[i] - 1]) {
				continue;
			}
			count++;
			flags[nums[i] - 1] = true;
		}
		int[] deficiencyArray = new int[nums.length - count];
		if (count >= nums.length) {
			return new int[0];
		}
		int subscript = 0;
		for (int i = 0; i < flags.length; i++) {
			if (flags[i]) {
				continue;
			}
			deficiencyArray[subscript] = i + 1;
			subscript++;
		}
		return deficiencyArray;
	}

	/**
	 * 分析:
	 * 1.遍历数组中对数据,存在时，当前位置数据变为负数
	 * 2.获取数据>0的数据
	 *
	 * @param nums 待核查的数据
	 * @return 结果集
	 * @link https://www.processon.com/view/link/634189f45653bb6a7b50cbc5
	 */
	public static List<Integer> mark(int[] nums) {
		List<Integer> deficiencyArray = new ArrayList<>();

		// 遍历数组中对数据,存在时，当前位置数据变为负数
		for (int i = 0; i < nums.length; i++) {
			int subscript = Math.abs(nums[i]) - 1;
			if(subscript < 0){
				subscript = Math.abs(subscript);
			}
			if (nums[subscript] < 0){
				continue;
			}
			nums[subscript] = -nums[subscript];
		}

		// 获取数据>0的数据
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] > 0) {
				deficiencyArray.add(i + 1);
			}
		}
		return deficiencyArray;
	}
}
