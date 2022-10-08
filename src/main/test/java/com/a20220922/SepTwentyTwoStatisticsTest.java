package main.test.java.com.a20220922;

import main.java.com.bob.a20220922.SepTwentyTwoStatistics;

/**
 * @Author wangbo
 * @Date 2022/9/22 16:52
 * @Description: TODO
 * @Version 1.0
 */
public class SepTwentyTwoStatisticsTest {

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		System.out.println(SepTwentyTwoStatistics.violence(555555));
		long end = System.currentTimeMillis();
		System.out.println("暴力算法耗时:"+(end - start) );
		System.out.println(SepTwentyTwoStatistics.erichsen(555555));
		System.out.println("埃氏筛选耗时:"+(System.currentTimeMillis() - end) );

	}
}
