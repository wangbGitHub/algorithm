package com.bob.a20221010;

import com.bob.untils.ArrayUntil;

/**
 * @Author wangbo
 * @Date 2022/10/10 11:41
 * @Description: 三角形的最大周长
 * @Version 1.0
 */
public class OctTenArrayTriangleTest {

	public static void main(String[] args) {
		int[] nums = new int[]{2,1,2};
		ArrayUntil.print(nums);
		System.out.println(OctTenArrayTriangle.optimalRecursion(nums,0,nums.length-1));
		System.out.println(OctTenArrayTriangle.optimalDp(nums));
		ArrayUntil.print(nums);
		nums = new int[]{1,2,1};
		System.out.println(OctTenArrayTriangle.optimalRecursion(nums,0,nums.length-1));
		System.out.println(OctTenArrayTriangle.optimalDp(nums));
		nums = new int[]{1,2,2,4,18,8};
		ArrayUntil.print(nums);
		System.out.println(OctTenArrayTriangle.optimalRecursion(nums,0,nums.length-1));
		System.out.println(OctTenArrayTriangle.optimalDp(nums));
		nums = new int[]{1,2,2,2,4,18,8};
		ArrayUntil.print(nums);
		System.out.println(OctTenArrayTriangle.optimalRecursion(nums,0,nums.length-1));
		System.out.println(OctTenArrayTriangle.optimalDp(nums));
	}
}
