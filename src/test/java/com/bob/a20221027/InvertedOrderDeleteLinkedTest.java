package com.bob.a20221027;

import com.bob.bean.ListNode;

/**
 * @Author wangbo
 * @Date 2022/10/27 11:43
 * @Description: TODO
 * @Version 1.0
 */
public class InvertedOrderDeleteLinkedTest {

	public static void main(String[] args) {
		ListNode listNode = new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4,new ListNode(5)))));
		ListNode kthFromEnd = InvertedOrderDeleteLinked.getKthFromEnd(listNode, 2);
		kthFromEnd.printValue();


	}
}
