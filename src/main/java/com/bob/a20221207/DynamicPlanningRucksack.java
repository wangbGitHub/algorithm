package com.bob.a20221207;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author wangbo
 * @Date 2022/12/7 10:25
 * @Description: 动态规划
 * @Version 1.0
 * <p>
 * 🎒问题
 */
public class DynamicPlanningRucksack {

	/**
	 * 处理过程中需要的二维数组的元素定义
	 */
	private static class ArrayElement {
		/**
		 * 计算后的数组元素值
		 */
		private int value;
		/**
		 * 哪些物品的值组成了当前数组元素
		 */
		private Set<Element> elements;

		public ArrayElement(int value, Element element) {
			this.value = value;
			this.elements = new HashSet<>();
			this.elements.add(element);
		}

		public ArrayElement(int value, Set<Element> elements) {
			this.value = value;
			this.elements = elements;
		}

		@Override
		public String toString() {
			return "BagElement{" +
					"value=" + value +
					", elements=" + elements +
					'}';
		}
	}

	/**
	 * 放入背包的物品
	 */
	private static class Element {
		/**
		 * 名称
		 */
		private final String name;
		/**
		 * 价值
		 */
		private final int value;
		/**
		 * 物品的需要卡槽
		 */
		private final int cost;

		public Element(String name, int cost, int value) {
			this.name = name;
			this.value = value;
			this.cost = cost;
		}

		@Override
		public String toString() {
			return "Element{" +
					"name='" + name + '\'' +
					", value=" + value +
					", cost=" + cost +
					'}';
		}
	}

	public void putBag(Element[] goods, int bagSize) {
		ArrayElement[][] calcArray = new ArrayElement[goods.length][bagSize];
		for (int i = 0; i < goods.length; i++) {
			for (int j = 0; j < bagSize; j++) {
				Element element = goods[i];
				if (i == 0) {
					calcArray[i][j] = new ArrayElement(element.value, element);
				} else {
					ArrayElement arrayElement = calcArray[i - 1][j];
					if (bagSize < element.cost) {
						calcArray[i][j] = new ArrayElement(arrayElement.value,arrayElement.elements);
					} else if (bagSize == element.cost) {
						if (arrayElement.value < element.value) {
							calcArray[i][j] = new ArrayElement(element.value, element);
						}else {
							calcArray[i][j] = new ArrayElement(arrayElement.value,arrayElement.elements);
						}
					} else {
						ArrayElement arrayElement1 = calcArray[i][j - 1];
						


					}
				}
			}

		}

	}


//	/**
//	 * @param size  背包大小
//	 * @param goods 可选商品列表  下角标为占领的格数
//	 * @return
//	 */
//	public static int[] dynamicPlanning(int size, int[] goods) {
//		int[] ints = new int[size];
//		boolean[] booleans = new boolean[goods.length + 1];
//		int minIndex = -1;
//		for (int i = 0; i < goods.length; i++) {
//			if (goods[i] > 0) {
//				minIndex = i + 1;
//				break;
//			}
//		}
//		if (minIndex == -1) {
//			return null;
//		}
//
//		for (int i = 0; i < size; i++) {
//			ints[i] = minIndex;
//		}
//		int max = goods[minIndex - 1];
//		booleans[minIndex] = true;
//		for (int i = 0; i < size; i++) {
//			if (i < goods.length && !booleans[i]) {
//				if (goods[i] > max) {
//
//				}
//			}
//		}
//		return ints;
//	}
}
