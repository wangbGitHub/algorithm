package com.bob.a20221027;

import com.bob.bean.ListNode;

/**
 * @Author wangbo
 * @Date 2022/10/27 11:24
 * @Description: 链表中倒数第k个节点
 * @Version 1.0
 * <p>
 * 需求:
 * 输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。
 * 例如，一个链表有 6 个节点，从头节点开始，它们的值依次是 1、2、3、4、5、6。这个链表的倒数第 3 个节点是值为 4 的节点。
 * 示例：
 * 给定一个链表: 1->2->3->4->5, 和 k = 2.
 * 返回链表 4->5.
 */
public class InvertedOrderDeleteLinked {

	/**
	 * @param head
	 * @param k
	 * @return
	 */
	public static  ListNode getKthFromEnd(ListNode head, int k) {
		if (head == null || k < 1) {
			return null;
		}
		int length = 0;
		ListNode listNode = head.next;
		while (listNode != null) {
			length++;
			listNode = listNode.next;
		}
		if (k >= length) {
			return null;
		}
		listNode = head;
		int count = 0;
		while (listNode != null){
			if (length - count == k-1){
				head = listNode;
				break;
			}
			count++;
			listNode = listNode.next;
		}
		return head;
	}
}
