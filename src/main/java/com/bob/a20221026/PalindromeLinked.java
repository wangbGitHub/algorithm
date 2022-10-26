package com.bob.a20221026;

import com.bob.bean.ListNode;

/**
 * @Author wangbo
 * @Date 2022/10/26 10:16
 * @Description: 回文链表
 * @Version 1.0
 * <p>
 * 需求:
 * 给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true；否则，返回 false 。
 * 示例 1：
 * 输入：head = [1,2,2,1]
 * 输出：true
 * 示例 2：
 * 输入：head = [1,2]
 * 输出：false
 * 提示：
 * 链表中节点数目在范围[1, 10^5] 内
 * 0 <= Node.val <= 9
 * 进阶：你能否用O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 */
public class PalindromeLinked {

	/**
	 * 分析:
	 * 1.获取正序结果集
	 * 2.获取倒序结果集
	 * 3.比较结果集
	 * 看着空间复杂度O(1),但stringBuilder本质是char[]
	 * 时间复杂度O(n),空间复杂度O(n)
	 *
	 * @param head 头节点
	 * @return 结果集
	 */
	public static boolean isPalindrome(ListNode head) {
		if (head == null || head.next == null) {
			return true;
		}
		// 前序遍历将值拼接成字符串
		String positiveSequence = traversal(head);
		ListNode up = head;
		ListNode next = head.next;
		up.next = null;
		while (next != null) {
			ListNode temp = next.next;
			next.next = up;
			up = next;
			next = temp;
		}
		String invertedOrder = traversal(up);
		return positiveSequence.equals(invertedOrder);
	}

	/**
	 * 遍历结果集
	 *
	 * @param head
	 * @return
	 */
	private static String traversal(ListNode head) {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(head.val);
		ListNode next = head.next;
		while (next != null) {
			stringBuilder.append(next.val);
			next = next.next;
		}
		return stringBuilder.toString();
	}


	/**
	 * 分析:
	 * hash算法
	 * 回文数反转之后不变，一个正向计算哈希值，一个反向计算哈希值，比较反转之前和反转之后的哈希值是否相等
	 *
	 * @param head 头节点
	 * @return 结果集
	 */
	public static boolean isPalindromeHash(ListNode head) {
		ListNode t = head;
		int base = 11, mod = 1000000007;
		int left = 0, right = 0, mul = 1;
		while (t != null) {
			left = (int) (((long) left * base + t.val) % mod);
			right = (int) ((right + (long) mul * t.val) % mod);
			mul = (int) ((long) mul * base % mod);
			t = t.next;
		}
		return left == right;
	}

	/**
	 * 分析:
	 * 快慢指针
	 *
	 * @param head
	 * @return
	 */
	public boolean isPalindromePointer(ListNode head) {
		if (head == null) {
			return true;
		}

		// 找到前半部分链表的尾节点并反转后半部分链表
		ListNode firstHalfEnd = endOfFirstHalf(head);
		ListNode secondHalfStart = reverseList(firstHalfEnd.next);

		// 判断是否回文
		ListNode p1 = head;
		ListNode p2 = secondHalfStart;
		boolean result = true;
		while (result && p2 != null) {
			if (p1.val != p2.val) {
				result = false;
			}
			p1 = p1.next;
			p2 = p2.next;
		}

		// 还原链表并返回结果
		firstHalfEnd.next = reverseList(secondHalfStart);
		return result;
	}

	private ListNode reverseList(ListNode head) {
		ListNode prev = null;
		ListNode curr = head;
		while (curr != null) {
			ListNode nextTemp = curr.next;
			curr.next = prev;
			prev = curr;
			curr = nextTemp;
		}
		return prev;
	}

	private ListNode endOfFirstHalf(ListNode head) {
		ListNode fast = head;
		ListNode slow = head;
		while (fast.next != null && fast.next.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		return slow;
	}
}
