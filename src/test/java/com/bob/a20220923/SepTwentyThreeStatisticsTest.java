package com.bob.a20220923;

/**
 * @Author wangbo
 * @Date 2022/9/23 15:31
 * @Description: TODO
 * @Version 1.0
 */
public class SepTwentyThreeStatisticsTest {

	public static void main(String[] args) {
		int n = 10000000;
		System.out.println(Math.sqrt(n));
		System.out.println(SepTwentyThreeStatistics.dichotomy(n));
		System.out.println(SepTwentyThreeStatistics.newtonIteration(1.0,n));
	}
}
