package com.bob.a20221205;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author wangbo
 * @Date 2022/12/5 10:40
 * @Description: 字符串匹配
 * @Version 1.0
 * <p>
 * 在一个字符串中寻找另一字符串
 */
public class StringMatching {

	/**
	 * 匹配字符串 暴力破解
	 *
	 * @param source 源
	 * @param target 目标
	 * @return 匹配成功 true 匹配失败 false
	 */
	public static boolean bf(String source, String target) {
		if (!checkout(source, target)) {
			return false;
		}
		int index = 0;
		for (int i = 0; i < source.toCharArray().length; i++) {
			boolean isCharAlike = source.toCharArray()[i] == target.toCharArray()[index];
			if (isCharAlike && index == target.toCharArray().length - 1) {
				return true;
			}
			if (isCharAlike) {
				index++;
			}
			if (!isCharAlike && source.toCharArray()[i] == target.toCharArray()[0]) {
				index = 1;
			}
		}
		return false;
	}

	/**
	 * 对于每一次失败的匹配尝试，算法都能够使用这些信息来排除尽可能多的无法匹配的位置。
	 *
	 * @param source 源
	 * @param target 目标
	 * @return 匹配成功 true 匹配失败 false
	 */
	public static boolean bm(String source, String target) {
		if (!checkout(source, target)) {
			return false;
		}
		Map<Character, Integer> map = getTaggetMap(target);
		char[] sourceChars = source.toCharArray();
		char[] targetChars = target.toCharArray();
		for (int i = targetChars.length - 1; i < sourceChars.length; i++) {
			if (targetChars[targetChars.length - 1] != sourceChars[i]) {
				Integer index = map.get(sourceChars[i]);
				if (index == null) {
					i = i + targetChars.length;
					continue;
				}
				i = i + targetChars.length - index;
				continue;
			}
			boolean isCharAlike = true;
			son:
			for (int j = targetChars.length - 1; j >= 0; j--) {
				if (targetChars[j] != sourceChars[i - (targetChars.length - 1 - j)]) {
					isCharAlike = false;
					break son;
				}
			}
			if (isCharAlike) {
				return true;
			}
		}
		return false;
	}

	private static Map<Character, Integer> getTaggetMap(String target) {
		char[] chars = target.toCharArray();
		Map<Character, Integer> map = new HashMap<>(16);
		for (int i = 0; i < chars.length; i++) {
			map.put(chars[chars.length - i - 1], chars.length - i - 1);
		}
		return map;
	}

	private static boolean checkout(String source, String target) {
		if (source == null || target == null) {
			return false;
		}
		char[] sourceChars = source.toCharArray();
		char[] targetChars = target.toCharArray();
		if (sourceChars.length < targetChars.length) {
			return false;
		}
		return true;
	}
}
