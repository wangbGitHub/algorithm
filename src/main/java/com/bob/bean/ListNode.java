package com.bob.bean;

/**
 * @Author wangbo
 * @Date 2022/10/14 11:07
 * @Description: 简单单向链表
 * @Version 1.0
 */
public class ListNode {
	private final static String SYLK = "-->";

	/**
	 * 值
	 */
	public int val;
	/**
	 * 下一个节点
	 */
	public ListNode next;

	public ListNode() {
	}

	public ListNode(int val) {
		this.val = val;
	}

	public ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}

	public  void printValue() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(this.val);
		ListNode next = this.next;
		while (next != null) {
			stringBuilder.append(SYLK);
			stringBuilder.append(next.val);
			next = next.next;
		}
		System.out.println(stringBuilder);
	}
}
