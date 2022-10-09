package com.bob.a20221009;

import com.bob.untils.ArrayUntil;

/**
 * @Author wangbo
 * @Date 2022/10/9 14:36
 * @Description: OctNineArray测试类
 * @Version 1.0
 */
public class OctNineArrayTest {

	public static void main(String[] args) {
		int[] nums = new int[]{100, 4, 200, 1, 3, 2};
		ArrayUntil.print(nums);
		System.out.println(OctNineArray.sortFind(nums));
		nums = new int[]{100, 4, 200, 1, 3, 2};
		ArrayUntil.print(nums);
		System.out.println(OctNineArray.hash(nums));

		nums = new int[]{100, 4, 200, 1, 6, 2};
		System.out.println(OctNineArray.sortFind(nums));

		nums = new int[]{100, 4, 200, 1, 6, 2};
		ArrayUntil.print(nums);
		System.out.println(OctNineArray.hash(nums));
		nums = new int[]{0,3,7,2,5,8,4,6,0,1};
		System.out.println(OctNineArray.sortFind(nums));

		nums = new int[]{0,3,7,2,5,8,4,6,0,1};
		ArrayUntil.print(nums);
		System.out.println(OctNineArray.hash(nums));
	}
}
