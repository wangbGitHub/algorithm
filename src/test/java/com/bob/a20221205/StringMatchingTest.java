package com.bob.a20221205;

/**
 * @Author wangbo
 * @Date 2022/12/5 10:48
 * @Description: 字符串匹配算法
 * @Version 1.0
 */
public class StringMatchingTest {

	public static void main(String[] args) {

		char a = 2;
		char b = 9;
		System.out.println(a+b);
		System.out.println((a+b) / 10);

		String source = "BBC ABCDAB ABCDABCDABDE";
		String target = "ABCDABD";
		System.out.println(StringMatching.bf(source,target));
		System.out.println(StringMatching.bm(source,target));

	}
}
