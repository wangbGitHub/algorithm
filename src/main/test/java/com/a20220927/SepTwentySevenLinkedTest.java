package main.test.java.com.a20220927;

import main.java.com.bob.a20220927.SepTwentySevenLinked;
import main.java.com.bob.bean.SingleTrackLinked;

/**
 * @Author wangbo
 * @Date 2022/9/27 15:24
 * @Description: TODO
 * @Version 1.0
 */
public class SepTwentySevenLinkedTest {

	public static void main(String[] args) {
		SingleTrackLinked singleTrackLinked = SingleTrackLinked.valueOf(2, null);
		SingleTrackLinked zero = SingleTrackLinked.valueOf(1, SingleTrackLinked.valueOf(0, singleTrackLinked));
		SingleTrackLinked node = SingleTrackLinked.valueOf(5, SingleTrackLinked.valueOf(4, SingleTrackLinked.valueOf(3, zero)));
		singleTrackLinked.setNext(zero);
		System.out.println(SepTwentySevenLinked.iteration(node));
		System.out.println(SepTwentySevenLinked.pointer(node));


		SingleTrackLinked node1 = SingleTrackLinked.valueOf(5,
				SingleTrackLinked.valueOf(4,
						SingleTrackLinked.valueOf(3,
								SingleTrackLinked.valueOf(2,
										SingleTrackLinked.valueOf(1,
												SingleTrackLinked.valueOf(0, null
												))))));
		System.out.println(SepTwentySevenLinked.iteration(node1));
		System.out.println(SepTwentySevenLinked.pointer(node1));



	}
}
