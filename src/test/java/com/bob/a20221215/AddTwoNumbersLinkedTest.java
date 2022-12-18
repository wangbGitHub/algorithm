package com.bob.a20221215;

import com.bob.bean.ListNode;

/**
 * @Author wangbo
 * @Date 2022/12/15 10:32
 * @Description: 两数相加
 * @Version 1.0
 */
public class AddTwoNumbersLinkedTest {
	public static void main(String[] args) {
		ListNode listNode_1 = new ListNode(2,new ListNode(4,new ListNode(3)));
		ListNode listNode_2 = new ListNode(5,new ListNode(6,new ListNode(8,new ListNode(9,new ListNode(9,new ListNode(9))))));
		listNode_1.printValue();
		listNode_2.printValue();
		AddTwoNumbersLinked addTwoNumbersLinked = new AddTwoNumbersLinked();
		ListNode listNode = addTwoNumbersLinked.addTwoNumbers(listNode_1, listNode_2);
		listNode.printValue();
	}
}
