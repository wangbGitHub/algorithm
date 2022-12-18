package com.bob.a20221215;

import com.bob.bean.ListNode;

/**
 * @Author wangbo
 * @Date 2022/12/15 09:59
 * @Description: 两数相加
 * @Version 1.0
 * @link https://leetcode.cn/problems/add-two-numbers/
 * <p>
 * 给你两个非空的链表，表示两个非负的整数。它们每位数字都是按照逆序的方式存储的，并且每个节点只能存储一位数字。
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * 示例 1：
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]
 * 解释：342 + 465 = 807.
 * 示例 2：
 * 输入：l1 = [0], l2 = [0]
 * 输出：[0]
 * 示例 3：
 * 输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * 输出：[8,9,9,9,0,0,0,1]
 * <p>
 * 提示：
 * 每个链表中的节点数在范围 [1, 100] 内
 * 0 <= Node.val <= 9
 * 题目数据保证列表表示的数字不含前导零
 */
public class AddTwoNumbersLinked {

	/**
	 * 自己写的版本
	 *
	 * @param l1 node 1
	 * @param l2 node 2
	 * @return 结果集
	 */
	public ListNode addTwoNumbersMi(ListNode l1, ListNode l2) {
		ListNode node = new ListNode();
		ListNode listNode = null;
		if (l1 == null) {
			return l2;
		}
		if (l2 == null) {
			return l1;
		}
		int carry = 0;
		while ((l1 != null && l1.val >= 0) || (l2 != null && l2.val >= 0)) {
			int var1 = 0;
			int var2 = 0;
			if (l1 != null) {
				var1 = l1.val;
				l1 = l1.next;
			}
			if (l2 != null) {
				var2 = l2.val;
				l2 = l2.next;
			}
			int var = (var1 + var2 + carry) % 10;
			carry = (var1 + var2 + carry) / 10;
			if (listNode == null) {
				listNode = new ListNode(var);
				node = listNode;
			} else {
				listNode.next = new ListNode(var);
				listNode = listNode.next;
			}
			if ((l1 == null && l2 != null) || (l1 != null && l2 == null)) {
				if (l1 == null) {
					listNode.next = recursion(l2, carry);
				}
				if (l2 == null) {
					listNode.next = recursion(l1, carry);
				}
				l2 = null;
				l1 = null;
				carry = 0;
			}
		}
		if (carry > 0) {
			listNode.next = new ListNode(carry);
		}
		return node;
	}

	/**
	 * 一个链表长与一个链表短的情况
	 *
	 * @param source 数据源
	 * @param carry  上次遗留的进位
	 * @return 结果集
	 */
	public ListNode recursion(ListNode source, int carry) {
		ListNode listNode = new ListNode();
		ListNode target = null;
		while (source != null) {
			int var = (source.val + carry) % 10;
			carry = (source.val + carry) / 10;
			if (target == null) {
				target = new ListNode(var);
				listNode = target;
			} else {
				target.next = new ListNode(var);
				target = target.next;
			}
			if (carry == 0) {
				target.next = source.next;
				break;
			}
			source = source.next;

		}
		if (carry > 0) {
			target.next = new ListNode(carry);
		}
		return listNode;
	}

	/**
	 * 参考别人的
	 *
	 * @param l1
	 * @param l2
	 * @return
	 */
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode head = null, tail = null;
		int carry = 0;
		while (l1 != null || l2 != null) {
			int n1 = l1 != null ? l1.val : 0;
			int n2 = l2 != null ? l2.val : 0;
			int sum = n1 + n2 + carry;
			if (head == null) {
				head = tail = new ListNode(sum % 10);
			} else {
				tail.next = new ListNode(sum % 10);
				tail = tail.next;
			}
			carry = sum / 10;
			if (l1 != null) {
				l1 = l1.next;
			}
			if (l2 != null) {
				l2 = l2.next;
			}
		}
		if (carry > 0) {
			tail.next = new ListNode(carry);
		}
		return head;
	}


}
