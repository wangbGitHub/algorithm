package com.bob.a20220922;

/**
 * @Author wangbo
 * @Date 2022/9/22 18:42
 * @Description: 双指针算法
 * @Version 1.0
 */
public class SepTwentyTwoArray {
	/**
	 * 删除排序数组中的重复项
	 * 一个有序数组nums,原地删除重复出现的元素，使每一个元素只出现一次，返回删除后数组的新长度
	 * 不能使用额外的数组空构建，必须在原地修改输入数组并在使用O(1)额外空间的条件下完成
	 * 例：[0，1，2，2，3，3，4]
	 * 输出：5
	 */
	public static int pointer(int[] array) {
		if (array == null) {
			return 0;
		}
		int head = 0;
		int count = 1;
		for (int down = 1; down < array.length; down++) {
			if (array[head] != array[down]) {
				count++;
				head = down;
			}
		}
		return count;
	}
}
