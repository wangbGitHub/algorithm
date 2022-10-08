package main.test.java.com.a20221008;

import main.java.com.bob.a20221008.OctEightArray;
import main.java.com.bob.untils.ArrayUntil;

/**
 * @Author wangbo
 * @Date 2022/10/8 14:32
 * @Description: 寻找消失的数
 * @Version 1.0
 */
public class OctEightArrayTest {

	public static void main(String[] args) {
		int[] nums = new int[]{4, 3, 2, 7, 8, 2, 3, 1};
		ArrayUntil.print(OctEightArray.violence(nums));
		ArrayUntil.print(OctEightArray.mark(nums));
	}



}
