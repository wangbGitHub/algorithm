package com.bob.a20221206;

/**
 * @Author wangbo
 * @Date 2022/12/6 11:15
 * @Description: 字符串相加
 * @Version 1.0
 * <p>
 * 给定两个字符串形式的非负整数num1 和num2，计算它们的和并同样以字符串形式返回。
 * 你不能使用任何內建的用于处理大整数的库（比如 BigInteger），也不能直接将输入的字符串转换为整数形式。
 * 示例 1：
 * 输入：num1 = "11", num2 = "123"
 * 输出："134"
 * 示例 2：
 * 输入：num1 = "456", num2 = "77"
 * 输出："533"
 * 示例 3：
 * 输入：num1 = "0", num2 = "0"
 * 输出："0"
 */
public class StringAdd {

	public static String stringAdd(String num1, String num2) {
		if (num1 == null || num1.length() < 1) {
			return num2;
		}
		if (num2 == null || num2.length() < 1) {
			return num1;
		}
		int max = num1.length() > num2.length() ? num1.length() : num2.length();
		int[] chars = new int[max + 1];
		int intoOne = 0;
		for (int i = 1; i <= max; i++) {
			int var1 = 0;
			if (num1.length() - i >= 0) {
				var1 = num1.charAt(num1.length() - i) - '0';
			}
			int var2 = 0;
			if (num2.length() - i >= 0) {
				var2 = num2.charAt(num2.length() - i) - '0';
			}
			int sum = var1 + var2 + intoOne;
			chars[i - 1] = sum % 10;
			intoOne = sum / 10;
		}
		chars[max] = intoOne;
		StringBuilder stringBuilder = new StringBuilder();
		for (int i = 0; i < chars.length; i++) {
			if (i == 0 && chars[max - i] == 0) {
				continue;
			}
			stringBuilder.append(chars[max - i]);
		}
		return stringBuilder.toString();

	}
}
