package com.bob.a20220926;

/**
 * @Author wangbo
 * @Date 2022/9/26 15:11
 * @Description: TODO
 * @Version 1.0
 */
public class FibonacciSequenceTest {

	public static void main(String[] args) {
		System.out.println(FibonacciSequence.recursion(11));
		System.out.println(FibonacciSequence.recursionOptimize(11));
		System.out.println(FibonacciSequence.pointer(11));
	}
}
