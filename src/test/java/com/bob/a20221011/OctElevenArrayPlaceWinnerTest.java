package com.bob.a20221011;

import com.bob.a20221010.OctTenArraySellWater;
import com.bob.untils.ArrayUntil;

/**
 * @Author wangbo
 * @Date 2022/10/11 09:53
 * @Description: TODO
 * @Version 1.0
 */
public class OctElevenArrayPlaceWinnerTest {

	public static void main(String[] args) {
		int[] nums = new int[]{5,5,5,10,20};
		ArrayUntil.print(nums);
		System.out.println(OctElevenArrayPlaceWinner.PredictTheWinner(nums));
		nums = new int[]{1,2,8,4};
		ArrayUntil.print(nums);
		System.out.println(OctElevenArrayPlaceWinner.PredictTheWinner(nums));
		nums = new int[]{2,2,4,8,4};
		ArrayUntil.print(nums);
		System.out.println(OctElevenArrayPlaceWinner.PredictTheWinner(nums));
		nums = new int[]{1,5,233,7};
		ArrayUntil.print(nums);
		System.out.println(OctElevenArrayPlaceWinner.PredictTheWinner(nums));
		nums = new int[]{1,1,567,1,1,99};
		ArrayUntil.print(nums);
		System.out.println(OctElevenArrayPlaceWinner.PredictTheWinner(nums));

	}
}
