package com.bob.a20221026;

import com.bob.bean.ListNode;

/**
 * @Author wangbo
 * @Date 2022/10/26 10:47
 * @Description: 回文链表测试类
 * @Version 1.0
 */
public class PalindromeLinkedTest {
	public static void main(String[] args) {
		ListNode listNode = new ListNode(1,new ListNode(2,new ListNode(2,new ListNode(1))));
		System.out.println(PalindromeLinked.isPalindrome(listNode));
		listNode = new ListNode(1,new ListNode(2,new ListNode(2,new ListNode(1))));
		System.out.println(PalindromeLinked.isPalindromeHash(listNode));


	}
}
