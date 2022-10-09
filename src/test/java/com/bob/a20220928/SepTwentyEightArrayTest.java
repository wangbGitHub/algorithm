package com.bob.a20220928;

import com.bob.untils.ArrayUntil;

/**
 * @Author wangbo
 * @Date 2022/9/28 11:25
 * @Description: 数组合并
 * @Version 1.0
 */
public class SepTwentyEightArrayTest {

	public static void main(String[] args) {
		int[] nums1 = {1, 3, 5, 7, 9, 0, 0, 0, 0};
		int[] nums2 = {2, 4, 6, 8};
		ArrayUntil.print(SepTwentyEightArray.pointer(nums1, nums2));
		ArrayUntil.print(SepTwentyEightArray.pointer2(nums1, nums2));


		int[] nums3 = {1, 2, 3, 4, 5, 0, 0, 0, 0};
		int[] nums4 = {6, 7, 8, 9};
		ArrayUntil.print(SepTwentyEightArray.pointer(nums3, nums4));
		ArrayUntil.print(SepTwentyEightArray.pointer2(nums3, nums4));

		int[] nums5 = {5, 6, 7, 8, 9, 0, 0, 0, 0};
		int[] nums6 = {1, 2, 3, 4};
		ArrayUntil.print(SepTwentyEightArray.pointer(nums5, nums6));
		ArrayUntil.print(SepTwentyEightArray.pointer2(nums5, nums6));

	}

}
