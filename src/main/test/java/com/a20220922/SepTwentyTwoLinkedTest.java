package main.test.java.com.a20220922;

import main.java.com.bob.a20220922.SepTwentyTwoLinked;
import main.java.com.bob.bean.SingleTrackLinked;

/**
 * @Author wangbo
 * @Date 2022/9/22 15:53
 * @Description: 单链表反转测试类
 * @Version 1.0
 */
public class SepTwentyTwoLinkedTest {

	public static void main(String[] args) {
		SingleTrackLinked node = getSingleTrackLinked( 10000);
		node.printValue();
		long iterationDate = System.currentTimeMillis();
		SepTwentyTwoLinked.iteration(node).printValue();
		System.out.println("迭代耗时:" + (System.currentTimeMillis() - iterationDate));
		node = getSingleTrackLinked( 10000);
		long recursionDate = System.currentTimeMillis();
		SepTwentyTwoLinked.recursion(node).printValue();
		System.out.println("递归耗时:" + (System.currentTimeMillis() - recursionDate));
	}

	private static SingleTrackLinked getSingleTrackLinked(SingleTrackLinked node, int n, int count) {
		count++;
		if (count > n) {
			return node;
		}
		node = SingleTrackLinked.valueOf(count, node);
		return getSingleTrackLinked(node, n, count);
	}

	private static SingleTrackLinked getSingleTrackLinked(int n) {
		SingleTrackLinked node = null;
		int count = 1;
		while (count <= n){
			node = SingleTrackLinked.valueOf(count,node);
			count ++;
		}
		return node;
	}
}
