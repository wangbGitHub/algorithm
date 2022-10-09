package com.bob.bean;

/**
 * @Author wangbo
 * @Date 2022/10/8 15:01
 * @Description: 普通二叉数
 * @Version 1.0
 */
public class BinaryTree {
	private int val;
	private BinaryTree left;
	private BinaryTree right;

	public BinaryTree() {
	}

	public BinaryTree(int val) {
		this.val = val;
	}

	public BinaryTree(int val, BinaryTree left, BinaryTree right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}

	public int getVal() {
		return val;
	}

	public void setVal(int val) {
		this.val = val;
	}

	public BinaryTree getLeft() {
		return left;
	}

	public void setLeft(BinaryTree left) {
		this.left = left;
	}

	public BinaryTree getRight() {
		return right;
	}

	public void setRight(BinaryTree right) {
		this.right = right;
	}
}
