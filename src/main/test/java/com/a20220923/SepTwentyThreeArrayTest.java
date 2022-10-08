package main.test.java.com.a20220923;

import main.java.com.bob.a20220923.SepTwentyThreeArray;

/**
 * @Author wangbo
 * @Date 2022/9/23 14:59
 * @Description: TODO
 * @Version 1.0
 */
public class SepTwentyThreeArrayTest {

	public static void main(String[] args) {
		int[] array = {1,-1,-1,1,3,4,4,4,-4,-4,-4,1,1,1};

		System.out.println(SepTwentyThreeArray.findCentre(array));
	}
}
