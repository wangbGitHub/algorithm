package com.bob.bean;

/**
 * @Author wangbo
 * @Date 2022/9/22 15:01
 * @Description: 单向链表结构
 * @Version 1.0
 */
public class SingleTrackLinked {
	/**
	 * 链接符
	 */
	private final static String SYLK = "-->";

	/**
	 * 值
	 */
	private int value;

	/**
	 * 下一个值
	 */
	private SingleTrackLinked next;

	/**
	 * 构造链表
	 *
	 * @param value 值
	 * @param next  指向下个链表
	 * @return node
	 */
	public static SingleTrackLinked valueOf(int value, SingleTrackLinked next) {
		SingleTrackLinked node = new SingleTrackLinked();
		node.value = value;
		node.next = next;
		return node;
	}

	public SingleTrackLinked getNext() {
		return next;
	}

	public void setNext(SingleTrackLinked next) {
		this.next = next;
	}

	/**
	 * 打应value值
	 */
	public  void printValue() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(this.value);
		SingleTrackLinked next = this.next;
		while (next != null) {
			stringBuilder.append(SYLK);
			stringBuilder.append(next.value);
			next = next.next;
		}
		System.out.println(stringBuilder);
	}

	public void setValue(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}
}
