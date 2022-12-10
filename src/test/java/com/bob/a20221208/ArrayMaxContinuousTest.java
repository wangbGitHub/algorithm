package com.bob.a20221208;

/**
 * @Author wangbo
 * @Date 2022/12/8 10:29
 * @Description: ArrayMaxContinuous测试类
 * @Version 1.0
 */
public class ArrayMaxContinuousTest {

	public static void main(String[] args) {
		int[] nums = {-1,-2,-2,-2,3,2,-2,0};
		System.out.println(ArrayMaxContinuous.maxSubArray(nums));
	}
}
