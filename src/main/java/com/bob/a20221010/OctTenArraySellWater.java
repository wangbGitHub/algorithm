package com.bob.a20221010;

/**
 * @Author wangbo
 * @Date 2022/10/10 09:45
 * @Description: 柠檬水找零
 * @Version 1.0
 * <p>
 * 需求:
 * 在柠檬水摊上，每一杯柠檬水的售价为 5 美元。顾客排队购买你的产品，（按账单 bills 支付的顺序）一次购买一杯。
 * 每位顾客只买一杯柠檬水，然后向你付 5 美元、10 美元或 20 美元。你必须给每个顾客正确找零，也就是说净交易是每位顾客向你支付 5 美元。
 * 注意，一开始你手头没有任何零钱。
 * 给你一个整数数组 bills ，其中 bills[i] 是第 i 位顾客付的账。如果你能给每位顾客正确找零，返回 true ，否则返回 false 。
 * 示例 1：
 * 输入：bills = [5,5,5,10,20]
 * 输出：true
 * 解释：
 * 前 3 位顾客那里，我们按顺序收取 3 张 5 美元的钞票。
 * 第 4 位顾客那里，我们收取一张 10 美元的钞票，并返还 5 美元。
 * 第 5 位顾客那里，我们找还一张 10 美元的钞票和一张 5 美元的钞票。
 * 由于所有客户都得到了正确的找零，所以我们输出 true。
 * 示例 2：
 * 输入：bills = [5,5,10,10,20]
 * 输出：false
 * 解释：
 * 前 2 位顾客那里，我们按顺序收取 2 张 5 美元的钞票。
 * 对于接下来的 2 位顾客，我们收取一张 10 美元的钞票，然后返还 5 美元。
 * 对于最后一位顾客，我们无法退回 15 美元，因为我们现在只有两张 10 美元的钞票。
 * 由于不是每位顾客都得到了正确的找零，所以答案是 false。
 * <p>
 * 提示：
 * 1 <= bills.length <= 10^5
 * bills[i]不是5就是10或是20
 */
public class OctTenArraySellWater {

	/**
	 * 方法:贪心算法
	 * 分析:
	 * 1.定义两个值, 一个值记录当前5元面值microBill,一个记录当前10元面值middleBill
	 * 2.遍历数组
	 * ①遇到5元,microBill+1
	 * ②遇到10元,microBill-1,middleBill+1,但microBill-1 < 0 时  不能找零
	 * ③遇到20元,
	 * microBill-1,middleBill-1,
	 * ⑴microBill > 0 &&  middleBill < 0,microBill-3
	 * ⑵microBill < 0 ||  middleBill < 0,不能找零
	 *
	 * @param bills 钱数组
	 * @return 结果集
	 */
	public static boolean lemonadeChange(int[] bills) {
		if (bills == null || bills.length < 1) {
			return true;
		}
		int microBill = 0;
		int middleBill = 0;
		for (int i = 0; i < bills.length; i++) {
			if (bills[i] == 5) {
				microBill++;
				continue;
			}
			if (bills[i] == 10) {
				--microBill;
				if (microBill < 0) {
					return false;
				}
				middleBill++;
				continue;
			}
			if (bills[i] != 20) {
				return false;
			}
			--microBill;
			--middleBill;
			if (middleBill < 0 && microBill > 0){
				microBill = microBill -2;
				++middleBill;
			}
			if (microBill < 0 || middleBill < 0) {
				return false;
			}
		}
		return true;
	}
}
