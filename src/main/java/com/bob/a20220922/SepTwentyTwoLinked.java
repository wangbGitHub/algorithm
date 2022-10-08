package main.java.com.bob.a20220922;

import main.java.com.bob.bean.SingleTrackLinked;

/**
 * @Author wangbo
 * @Date 2022/9/22 11:48
 * @Description: 单链表反转
 * @link 思维导图 https://www.processon.com/view/link/632c217a7d9c081f94e5e829
 * @Version 1.0
 */
public class SepTwentyTwoLinked {
	/**
	 * 需求:
	 * 		输入:1-->2-->3-->4-->5
	 * 		输出:5-->4-->3-->2-->1
	 */

	/**
	 * 迭代实现链表反转
	 *
	 * @param node 待反转数据
	 * @return 结果集
	 */
	public static SingleTrackLinked iteration(SingleTrackLinked node) {
		SingleTrackLinked next = node.getNext();
		if (next == null) {
			return node;
		}
		SingleTrackLinked up = node;
		up.setNext(null);
		while (next != null) {
			SingleTrackLinked temp = next.getNext();
			next.setNext(up);
			up = next;
			next = temp;
		}
		return up;
	}

	/**
	 * 递归实现链表反转
	 *
	 * @param node 待反转数据
	 * @return 结果集
	 */
	public static SingleTrackLinked recursion(SingleTrackLinked node) {
		SingleTrackLinked next = node.getNext();
		if (next == null) {
			return node;
		}
		node.setNext(null);
		return doRecursion(node, next);
	}

	private static SingleTrackLinked doRecursion(SingleTrackLinked up, SingleTrackLinked node) {
		if (node == null || up == null) {
			return up;
		}
		SingleTrackLinked temp = node.getNext();
		node.setNext(up);
		return doRecursion(node, temp);
	}


}
