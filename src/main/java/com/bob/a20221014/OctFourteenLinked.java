package com.bob.a20221014;

import com.bob.bean.SingleTrackLinked;

/**
 * @Author wangbo
 * @Date 2022/10/14 09:36
 * @Description: 链表合并
 * @Version 1.0
 * <p>
 * 需求:
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 */
public class OctFourteenLinked {

	/**
	 * 方法:迭代
	 *
	 * @param list1 链表1
	 * @param list2 链表2
	 * @return 结果集
	 */
	public static SingleTrackLinked mergeTwoLists(SingleTrackLinked list1, SingleTrackLinked list2) {
		// l1=  [1,2,4], l2 = [1,3,4]
		SingleTrackLinked linked = new SingleTrackLinked();

		if (list1 == null) {
			linked = list2;
			return linked;
		}
		if (list2 == null) {
			linked = list1;
			return linked;
		}
		if (list1.getValue() <= list2.getValue()) {
			linked.setValue(list1.getValue());
			list1 = list1.getNext();
		} else {
			linked.setValue(list2.getValue());
			list2 = list2.getNext();
		}
		SingleTrackLinked atPresent = linked;
		SingleTrackLinked next = null;
		while (list1 != null || list2 != null) {
			if (list1 == null) {
				next = list2;
				atPresent.setNext(next);
				break;
			}
			if (list2 == null) {
				next = list1;
				atPresent.setNext(next);
				break;
			}
			next = new SingleTrackLinked();
			if (list1.getValue() <= list2.getValue()) {
				next.setValue(list1.getValue());
				atPresent.setNext(next);
				list1 = list1.getNext();
			} else {
				next.setValue(list2.getValue());
				atPresent.setNext(next);
				list2 = list2.getNext();
			}
			atPresent = atPresent.getNext();
			next = null;
		}
		return linked;
	}

	// ------------------ 以上直接写，以下看了题解出来的 ----

	/**
	 * 方法:递归
	 *
	 * @param list1 链表1
	 * @param list2 链表2
	 * @return 结果集
	 */
	public static SingleTrackLinked recursion(SingleTrackLinked list1, SingleTrackLinked list2) {
		if (list1 == null) {
			return list2;
		}
		if (list2 == null) {
			return list1;
		}
		SingleTrackLinked linked;
		if (list1.getValue() <= list2.getValue()) {
			linked = list1;
			linked.setNext(recursion(list1.getNext(), list2));
		} else {
			linked = list2;
			linked.setNext(recursion(list1, list2.getNext()));
		}
		return linked;
	}


	/**
	 * 方法:迭代
	 *
	 * @param list1 链表1
	 * @param list2 链表2
	 * @return 结果集
	 */
	public static SingleTrackLinked iteration(SingleTrackLinked list1, SingleTrackLinked list2) {
		SingleTrackLinked linked = SingleTrackLinked.valueOf(-1, null);
		SingleTrackLinked atPresent = linked;
		while (list1 != null && list2 != null) {
			if (list1.getValue() <= list2.getValue()) {
				atPresent = list1;
				list1 = list1.getNext();
			} else {
				atPresent = list2;
				list2 = list2.getNext();
			}
		}
		atPresent.setNext(list1 == null ? list2 : list1);
		return linked;
	}

}
