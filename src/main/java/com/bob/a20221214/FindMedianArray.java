package com.bob.a20221214;

/**
 * @Author wangbo
 * @Date 2022/12/16 10:31
 * @Description: 寻找两个正序数组的中位数
 * @Version 1.0
 * @link https://leetcode.cn/problems/median-of-two-sorted-arrays/description/
 * <p>
 * 需求:
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 * 算法的时间复杂度应该为 O(log (m+n)) 。
 * 示例 1：
 * 输入：nums1 = [1,3], nums2 = [2]
 * 输出：2.00000
 * 解释：合并数组 = [1,2,3] ，中位数 2
 * 示例 2：
 * 输入：nums1 = [1,2], nums2 = [3,4]
 * 输出：2.50000
 * 解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
 * 提示：
 * nums1.length == m
 * nums2.length == n
 * 0 <= m <= 1000
 * 0 <= n <= 1000
 * 1 <= m + n <= 2000
 * -106 <= nums1[i], nums2[i] <= 106
 */
public class FindMedianArray {

	/**
	 * 暂时没有相对O(log (m+n)) 想到是O(n)
	 * 分析如下:
	 * 1.若 nums1 = [1,2], nums2 = [3,4] 可以直接判断数组个数,计算出下角标数据直接返回
	 * 2.若存在包含,需要开辟一个int[nums1.length + nums2.length] 将元素放进去,最后空间复杂O(n),时间复杂度O(n)
	 *
	 * @param nums1 第一个数据源
	 * @param nums2 第二个数据源
	 * @return 结果集
	 */
	public static double findMedianSortedArraysMe(int[] nums1, int[] nums2) {
		if (nums1.length == 0 && nums2.length == 0) {
			return 0.0;
		}
		if (nums1.length == 0 || nums2.length == 0) {
			int remainder = (nums1.length + nums2.length) & 1;
			int count = (nums1.length + nums2.length) / 2;
			int[] nums;
			if (nums1.length == 0) {
				nums = nums2;
			} else {
				nums = nums1;
			}
			if (remainder == 1) {
				return nums[count];
			} else {
				return ((double) nums[count - 1] + (double) nums[count]) / 2;
			}
		}
		if (nums1[nums1.length - 1] <= nums2[0] || nums2[nums2.length - 1] <= nums1[0]) {
			return noOpenUpSpace(nums1, nums2);
		} else {
			return openUpSpace(nums1, nums2);
		}
	}

	private static double openUpSpace(int[] nums1, int[] nums2) {
		int[] nums = new int[nums1.length + nums2.length];

		int i = 0;
		int j = 0;
		int k = 0;
		while (nums1.length > i || nums2.length > j) {
			if (i >= nums1.length) {
				nums[k] = nums2[j];
				j++;
			} else if (j >= nums2.length) {
				nums[k] = nums1[i];
				i++;
			} else if (nums1[i] >= nums2[j]) {
				nums[k] = nums2[j];
				j++;
			} else {
				nums[k] = nums1[i];
				i++;
			}
			k++;
		}
		int remainder = (nums1.length + nums2.length) & 1;
		int count = (nums1.length + nums2.length) / 2;
		if (remainder == 1) {
			return nums[count];
		} else {
			return ((double) nums[count - 1] + (double) nums[count]) / 2;
		}
	}

	private static double noOpenUpSpace(int[] nums1, int[] nums2) {
		int remainder = (nums1.length + nums2.length) & 1;
		int count = (nums1.length + nums2.length) / 2;
		int[] head;
		int[] tail;
		if (nums1[nums1.length - 1] <= nums2[0]) {
			head = nums1;
			tail = nums2;
		} else {
			head = nums2;
			tail = nums1;
		}
		if (remainder == 1) {
			if (head.length > count) {
				return head[count];
			}
			return tail[count - head.length];
		} else {
			if (head.length > count) {
				return ((double) head[count - 1] + (double) head[count]) / 2;
			} else if (head.length == count) {
				return ((double) head[count - 1] + (double) tail[0]) / 2;
			} else {
				return ((double) tail[count - head.length - 1] + (double) tail[count - head.length]) / 2;
			}
		}
	}






	/**
	 * TODO 需要好好思考一下
	 * 别人较好的方案
	 * 时间复杂度O(log(m+n))
	 *
	 * @param nums1
	 * @param nums2
	 * @return
	 */
	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int m = nums1.length, n = nums2.length;
		/*将奇数个数和偶数个数情况统一处理
		 * 奇数个数: left==right
		 * 偶数个数: left==right+1 */
		int left = (m + n + 1) / 2;
		int right = (m + n + 2) / 2;
		return (getkth(nums1, 0, nums2, 0, left)
				+ getkth(nums1, 0, nums2, 0, right)) / 2.0;
	}

	public static double getkth(int[] nums1, int nums1Start, int[] nums2, int nums2Start, int k) {
		/*有任何一个数组空了，直接返回结果*/
		if (nums1Start > nums1.length - 1) {
			return nums2[nums2Start + k - 1];
		}
		if (nums2Start > nums2.length - 1) {
			return nums1[nums1Start + k - 1];
		}
		/*找第1小的数字，所以只需判断两个数组中第一个数字哪个小就可以了*/
		if (k == 1) {
			return Math.min(nums1[nums1Start], nums2[nums2Start]);
		}

		// 获得两个数组中第k/2个元素的值
		int num1Mid = Integer.MAX_VALUE, num2Mid = Integer.MAX_VALUE;
		if (nums1Start + k / 2 - 1 < nums1.length) {
			num1Mid = nums1[nums1Start + k / 2 - 1];
		}
		if (nums2Start + k / 2 - 1 < nums2.length) {
			num2Mid = nums2[nums2Start + k / 2 - 1];
		}

		// 比较两值的大小，然后以递归的形式继续更小数组的处理
		if (num1Mid < num2Mid) {
			// num1Mid更小，排除num1[]中小于等于num1Mid的部分
			return getkth(nums1, nums1Start + k / 2,
					nums2, nums2Start, k - k / 2);
		} else {
			// num2Mid更小，排除num2[]中小于等于num2Mid的部分
			return getkth(nums1, nums1Start, nums2,
					nums2Start + k / 2, k - k / 2);
		}
	}
}
