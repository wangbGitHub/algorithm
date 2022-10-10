package com.bob.a20221010;

import com.bob.untils.ArrayUntil;

/**
 * @Author wangbo
 * @Date 2022/10/10 09:55
 * @Description: 柠檬水找零测试类
 * @Version 1.0
 */
public class OctTenArraySellWaterTest {

	public static void main(String[] args) {
		int[] bills = new int[]{5,5,5,10,20};
		ArrayUntil.print(bills);
		System.out.println(OctTenArraySellWater.lemonadeChange(bills));
		bills = new int[]{5,5,10,10,20};
		ArrayUntil.print(bills);
		System.out.println(OctTenArraySellWater.lemonadeChange(bills));
		bills = new int[]{5,5,10,20,5,5,5,5,5,5,5,5,5,10,5,5,20,5,20,5};
		ArrayUntil.print(bills);
		System.out.println(OctTenArraySellWater.lemonadeChange(bills));
		bills = new int[]{5,5,5,5,20,20,5,5,20,5};
		ArrayUntil.print(bills);
		System.out.println(OctTenArraySellWater.lemonadeChange(bills));
	}
}
