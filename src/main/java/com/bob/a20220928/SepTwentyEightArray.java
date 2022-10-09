package com.bob.a20220928;

/**
 * @Author wangbo
 * @Date 2022/9/28 10:21
 * @Description: 数组合并
 * @Version 1.0
 * @link https://www.processon.com/view/link/6333cdd5e0b34d3300839ae2
 * <p>
 * 需求:两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。假设 nums1 的空间大小等于 m + n，这样它就
 * 有足够的空间保存来自 nums2 的元素。
 */
public class SepTwentyEightArray {

	/**
	 * 方法:双指针
	 * 分析:
	 * 因为是两个有序数组,使用前序遍历, 通过两个指针记录,且创建一个新的数组存储新的元素
	 *
	 * @param nums1 大空间数组
	 * @param nums2 小空间数组
	 * @return 结果集
	 */
	public static int[] pointer(int[] nums1, int[] nums2) {
		int[] array = new int[nums1.length];
		int pointer1 = 0;
		int pointer2 = 0;
		for (int i = 0; i < nums1.length; i++) {
			if (pointer2 > nums2.length-1) {
				array[i] = nums1[pointer1++];
				continue;
			}
			if (pointer1  > nums1.length - nums2.length-1) {
				array[i] = nums2[pointer2++];
				continue;
			}
			array[i] = nums1[pointer1] < nums2[pointer2] ? nums1[pointer1++] : nums2[pointer2++];
		}
		return array;
	}


	/**
	 * 方法:双指针
	 * 分析:
	 * 因为是两个有序数组,使用后序遍历, 通过两个指针记录
	 *
	 * @param nums1 大空间数组
	 * @param nums2 小空间数组
	 * @return 结果集
	 */
	public static int[] pointer2(int[] nums1, int[] nums2) {
		int pointer1 = nums1.length - nums2.length -1;
		int pointer2 = nums2.length -1;
		for (int i = nums1.length-1; i >= 0; i--) {
			if (pointer2 < 0){
				nums1[i] = nums1[pointer1--];
				continue;
			}
			if (pointer1 < 0){
				nums1[i] = nums2[pointer2--];
				continue;
			}
			nums1[i] = nums1[pointer1] > nums2[pointer2] ? nums1[pointer1--] : nums2[pointer2--];
		}
		return nums1;
	}


}
