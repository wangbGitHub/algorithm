package main.java.com.bob.untils;

import java.util.List;

/**
 * @Author wangbo
 * @Date 2022/10/8 14:44
 * @Description: 数组工具类
 * @Version 1.0
 */
public class ArrayUntil {

	/**
	 * 打印数组里面元素
	 *
	 * @param array 数组
	 */
	public static void print(int[] array) {
		StringBuilder stringBuilder = new StringBuilder();
		for (int i = 0; i < array.length; i++) {
			stringBuilder.append(array[i]);
			if (i < array.length - 1) {
				stringBuilder.append(",");
			}
		}
		System.out.println(stringBuilder);
	}

	/**
	 * 打印数组里面元素
	 *
	 * @param array 数组
	 */
	public static void print(List array) {
		StringBuilder stringBuilder = new StringBuilder();
		for (int i = 0; i < array.size(); i++) {
			stringBuilder.append(array.get(i));
			if (i < array.size() - 1) {
				stringBuilder.append(",");
			}
		}
		System.out.println(stringBuilder);
	}
}
