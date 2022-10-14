package com.bob.a20221014;

import com.bob.bean.SingleTrackLinked;

/**
 * @Author wangbo
 * @Date 2022/10/14 10:01
 * @Description: 链表合并
 * @Version 1.0
 */
public class OctFourteenLinkedTest {

	public static void main(String[] args) {
		SingleTrackLinked node1 = SingleTrackLinked.valueOf(1,
				SingleTrackLinked.valueOf(2,
						SingleTrackLinked.valueOf(4, null
												)));
		SingleTrackLinked node2 = SingleTrackLinked.valueOf(1,
				SingleTrackLinked.valueOf(3,
						SingleTrackLinked.valueOf(4, null
						)));
		node1.printValue();
		node2.printValue();
		SingleTrackLinked linked = OctFourteenLinked.recursion(node1, node2);
		linked.printValue();
	}
}
