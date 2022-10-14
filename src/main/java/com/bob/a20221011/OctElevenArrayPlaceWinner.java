package com.bob.a20221011;

/**
 * @Author wangbo
 * @Date 2022/10/11 09:32
 * @Description: 预测赢家
 * @Version 1.0
 * <p>
 * 需求:
 * 玩家 1 和玩家 2 轮流进行自己的回合，玩家 1 先手。开始时，两个玩家的初始分值都是 0 。每一回合，玩家从数组的任意一端取一个数字
 * （即，nums[0] 或 nums[nums.length - 1]），取到的数字将会从数组中移除（数组长度减 1 ）。玩家选中的数字将会加到他的得分上。当数组中没有剩余数字可取时，游戏结束。
 * 如果玩家 1 能成为赢家，返回 true 。如果两个玩家得分相等，同样认为玩家 1 是游戏的赢家，也返回 true 。你可以假设每个玩家的玩法都会使他的分数最大化。
 * 示例 1：
 * 输入：nums = [1,5,2]
 * 输出：false
 * 解释：一开始，玩家 1 可以从 1 和 2 中进行选择。
 * 如果他选择 2（或者 1 ），那么玩家 2 可以从 1（或者 2 ）和 5 中进行选择。如果玩家 2 选择了 5 ，那么玩家 1 则只剩下 1（或者 2 ）可选。
 * 所以，玩家 1 的最终分数为 1 + 2 = 3，而玩家 2 为 5 。
 * 因此，玩家 1 永远不会成为赢家，返回 false 。
 * 示例 2：
 * 输入：nums = [1,5,233,7]
 * 输出：true
 * 解释：玩家 1 一开始选择 1 。然后玩家 2 必须从 5 和 7 中进行选择。无论玩家 2 选择了哪个，玩家 1 都可以选择 233 。
 * 最终，玩家 1（234 分）比玩家 2（12 分）获得更多的分数，所以返回 true，表示玩家 1 可以成为赢家。
 * 提示：
 * 1 <= nums.length <= 2^0
 * 0 <= nums[i] <= 10^7
 */
public class OctElevenArrayPlaceWinner {

	/**
	 * @param nums
	 * @return
	 */
	public static boolean PredictTheWinner(int[] nums) {
		if (nums == null || nums.length < 2) {
			return true;
		}
		int pre = 0;
		int tail = nums.length - 1;
		int sumA = 0;
		int sumB = 0;
		boolean isA = true;
		while (pre != tail) {
			boolean isPre = true;
			if (tail - pre < 3) {
				isPre = nums[pre] > nums[tail];

			} else {
				isPre = isPre(nums[pre], nums[pre + 1], nums[tail - 1], nums[tail]);
			}
			if (isA) {
				sumA = sumA + (isPre ? nums[pre] : nums[tail]);
			} else {
				sumB = sumB + (isPre ? nums[pre] : nums[tail]);
			}
			if (isPre) {
				++pre;
			} else {
				--tail;
			}
			if (pre == tail) {
				if (!isA) {
					sumA = sumA + nums[pre];
				} else {
					sumB = sumB + nums[pre];
				}
			}
			isA = !isA;
		}
		return sumA >= sumB;
	}

	private static boolean isPre(int var1, int var2, int var3, int var4) {
		if (var1 + var3 >= var1 + var2 && var1 + var3 >= var1 + var4 && var1 + var3 >= var2 + var4) {
			return true;
		}

		if (var2 + var4 > var4 + var1 && var2 + var4 > var4 + var3 && var2 + var4 > var2 + var3  ){
			return false;
		}

		return var1 >= var4;

	}
}
