package main.test.java.com.a20220923;

import main.java.com.bob.a20220923.SepTwentyThreeLinearScanning;

/**
 * @Author wangbo
 * @Date 2022/9/23 16:43
 * @Description: 线性扫描
 * @Version 1.0
 */
public class SepTwentyThreeLinearScanningTest {
	public static void main(String[] args) {
		int[] array = {1, 2, 43, 2, -2, -2323, 3, 12, 4, 3, 23423, 4, 2334, 222, 3};
		long sort = System.currentTimeMillis();
		System.out.println(SepTwentyThreeLinearScanning.sort(array));
		System.out.println("排序时间:" + (System.currentTimeMillis() - sort));
		long linearScanning = System.currentTimeMillis();
		System.out.println(SepTwentyThreeLinearScanning.linearScanning(array));
		System.out.println("线性扫描:" + (System.currentTimeMillis() - linearScanning));
	}


}
