package com.bob.a20221213;

/**
 * @Author wangbo
 * @Date 2022/12/13 16:24
 * @Description: 卖股票
 * @Version 1.0
 * <p>
 * 需求
 * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
 * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
 * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
 * 示例 1：
 * 输入：[7,1,5,3,6,4]
 * 输出：5
 * 解释：在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 * 注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
 * 示例 2：
 * 输入：prices = [7,6,4,3,1]
 * 输出：0
 * 解释：在这种情况下, 没有交易完成, 所以最大利润为 0。
 *
 * 进阶:
 * https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-ii/description/
 * https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-iii/description/
 */
public class StockPrices {


	/**
	 * 通过动态规划思想
	 * 分析:
	 * 1.创建一个二维数组 dp[i][0] 不持股利润  d[i][1] 持股的利润
	 * 2.推到出 dp[i][0] = max(dp[i-1][0],dp[i-1][1] +prices[i])
	 * dp[i][1] = max(dp[i-1][1],-prices[i])
	 *
	 * @param prices
	 * @return
	 */
	public static int dp(int[] prices) {
		int[][] map = new int[prices.length][2];
		for (int i = 0; i < prices.length; i++) {
			if (i == 0) {
				map[i][0] = 0;
				map[i][1] = -7;
				continue;
			}
			int buyProfit = map[i - 1][0];
			int noHoldProfit = map[i - 1][1];
			map[i][0] = Math.max(buyProfit, noHoldProfit + prices[i]);
			map[i][1] = Math.max(noHoldProfit, -prices[i]);
		}
		return Math.max(map[prices.length - 1][0], map[prices.length - 1][1]);
	}

	/**
	 * 使用线性思维解决问题
	 * @param prices
	 * @return
	 */
	public static int linear(int[] prices) {
		int minPrices = 0;
		int maxPrices = Integer.MIN_VALUE;
		for (int i = 0; i < prices.length; i++) {
			if (i == 0){
				minPrices = prices[0];
				continue;
			}
			minPrices = Math.min(minPrices,prices[i]);
			maxPrices = Math.max(prices[i]-minPrices,maxPrices);
		}
		return  Math.max(0,maxPrices);
	}


}
