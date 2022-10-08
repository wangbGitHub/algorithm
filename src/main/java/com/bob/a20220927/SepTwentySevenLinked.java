package main.java.com.bob.a20220927;

import main.java.com.bob.bean.SingleTrackLinked;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author wangbo
 * @Date 2022/9/27 10:56
 * @Description: 环形链表
 * @Version 1.0
 */
public class SepTwentySevenLinked {

	/**
	 * 直接使用java的Set集合进行去重
	 *
	 * @param node 待判断节点
	 * @return false 非环型链表 true 环型链表
	 */
	public static boolean iteration(SingleTrackLinked node) {
		if (node == null) {
			return false;
		}
		Set<SingleTrackLinked> set = new HashSet<>();
		set.add(node);
		while (node.getNext() != null) {
			SingleTrackLinked next = node.getNext();
			if (!set.add(next)) {
				return true;
			}
			node = next;
		}
		return false;
	}

	/**
	 *
	 * @param node
	 * @return
	 */
	public static boolean pointer(SingleTrackLinked node){
		if (node == null || node.getNext()== null){
			return false;
		}
		SingleTrackLinked head = node;
		SingleTrackLinked tail = node.getNext();
		while (head != tail ){
			if (tail == null || tail.getNext()== null){
				return false;
			}
			head = head.getNext();
			tail = tail.getNext().getNext();
		}
		return true;
	}
}
