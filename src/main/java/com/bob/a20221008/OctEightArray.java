package main.java.com.bob.a20221008;

/**
 * @Author wangbo
 * @Date 2022/10/8 14:06
 * @Description: 寻找消失的数
 * @Version 1.0
 * <p>
 * 需求:
 * 给你一个含n个整数的数组nums,其中nums[i]在区间[1,n]内.请找出所有在[1,n]范围内但没有出现在nums中的数字,并以数组的形式返回结果
 * 示例1:
 * 输入:nums = [4,3,2,7,8,2,3,1]
 * 输出:[5,6]
 * 示例2:
 * 输入:nums = [1,1]
 * 输出:nums = [2]
 */
public class OctEightArray {

	/**
	 * 分析:
	 * 1.使用boolean[] flags接收
	 * 2.遍历nums数组,存在的数改变flags下标标记
	 * 3.遍历flags
	 *
	 * @param nums 待核查的数据
	 * @return 结果集
	 */
	public static int[] violence(int[] nums) {
		boolean[] flags = new boolean[nums.length];
		int count = 0;
		for (int i = 0; i < nums.length; i++) {
			if (flags[nums[i] - 1]) {
				continue;
			}
			count++;
			flags[nums[i] - 1] = true;
		}
		int[] deficiencyArray = new int[nums.length - count];
		if (count >= nums.length) {
			return new int[0];
		}
		int subscript = 0;
		for (int i = 0; i < flags.length; i++) {
			if (flags[i]) {
				continue;
			}
			deficiencyArray[subscript] = i + 1;
			subscript++;
		}
		return deficiencyArray;

	}
}
