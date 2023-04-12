package gracefulsoul.problems;

import java.util.Arrays;

public class OrderlyQueue {

	// https://leetcode.com/problems/orderly-queue/submissions/932461441/
	public static void main(String[] args) {
		OrderlyQueue test = new OrderlyQueue();
		System.out.println(test.orderlyQueue("cba", 1));
		System.out.println(test.orderlyQueue("baaca", 3));
	}

	public String orderlyQueue(String s, int k) {
		if (k > 1) {
			char[] charArray = s.toCharArray();
			Arrays.sort(charArray);
			return new String(charArray);
		} else {
			String result = s;
			for (int i = 1; i < s.length(); i++) {
				String temp = s.substring(i) + s.substring(0, i);
				if (result.compareTo(temp) > 0) {
					result = temp;
				}
			}
			return result;
		}
	}

}
