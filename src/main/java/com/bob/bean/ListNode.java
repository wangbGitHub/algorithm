package com.bob.bean;

/**
 * @Author wangbo
 * @Date 2022/10/14 11:07
 * @Description: 简单单向链表
 * @Version 1.0
 */
public class ListNode {
	/**
	 * 值
	 */
	int val;
	/**
	 * 下一个节点
	 */
	ListNode next;

	ListNode() {
	}

	ListNode(int val) {
		this.val = val;
	}

	ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}
}
