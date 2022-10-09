package com.bob.a20220926;

/**
 * @Author wangbo
 * @Date 2022/9/26 11:43
 * @Description: TODO
 * @Version 1.0
 */
public class SepTwentySixFindTest {
	public static void main(String[] args) {
		int[] array = new int[]{1,2,3,6,8,10,11,23,24,25,26};
		int target = 26;
		print(SepTwentySixFind.violence(array,target));
		print(SepTwentySixFind.utilizeMap(array,target));
		print(SepTwentySixFind.binarySearch(array,target));
		print(SepTwentySixFind.pointer(array,target));

	}

	private static void print(int[] array){
		StringBuilder stringBuilder = new StringBuilder();
		for (int i= 0;i< array.length;i++){
			stringBuilder.append(array[i]).append(",");
		}
		System.out.println(stringBuilder);
	}
}
