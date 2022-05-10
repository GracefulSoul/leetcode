package gracefulsoul.problems;

public class SmallestGoodBase {

	// https://leetcode.com/submissions/detail/696535539/
	public static void main(String[] args) {
		SmallestGoodBase test = new SmallestGoodBase();
		System.out.println(test.smallestGoodBase("13"));
		System.out.println(test.smallestGoodBase("4681"));
		System.out.println(test.smallestGoodBase("1000000000000000000"));
	}

	public String smallestGoodBase(String n) {
		long num = 0;
		for (char c : n.toCharArray()) {
			num = (num * 10) + (c - '0');
		}
		for (int idx = 60; idx >= 2; idx--) {
			long left = 2;
			long right = (long) Math.pow(num + 1, 1.0 / (idx - 1));
			while (left <= right) {
				long mid = left + (right - left) / 2;
				long result = 0;
				long base = 1;
				for (int j = 0; j < idx; j++) {
					result += base;
					base *= mid;
				}
				if (result == num) {
					return Long.toString(mid);
				} else if (result < num) {
					left = mid + 1;
				} else {
					right = mid - 1;
				}
			}
		}
		return String.valueOf(num - 1);
	}

}
