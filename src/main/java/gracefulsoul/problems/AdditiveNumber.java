package gracefulsoul.problems;

public class AdditiveNumber {

	// https://leetcode.com/submissions/detail/603377076/
	public static void main(String[] args) {
		AdditiveNumber test = new AdditiveNumber();
		System.out.println(test.isAdditiveNumber("112358"));
		System.out.println(test.isAdditiveNumber("199100199"));
	}

	public boolean isAdditiveNumber(String num) {
		return this.recursive(num, -1, -1, 0, 0);
	}

	private boolean recursive(String num, long pre, long cur, int idx, int cnt) {
		int length = num.length();
		if (idx == length) {
			if (cur != -1 && pre != -1 && cnt > 2) {
				return true;
			} else {
				return false;
			}
		}
		long n = 0;
		for (int i = idx; i < length; i++) {
			n = n * 10 + (num.charAt(i) - '0');
			if (cur != -1 && pre != -1) {
				if (n == cur + pre) {
					if (this.recursive(num, cur, n, i + 1, cnt + 1)) {
						return true;
					}
				} else if (n > cur + pre) {
					return false;
				}
			}
			if (pre == -1) {
				if (this.recursive(num, n, cur, i + 1, cnt + 1)) {
					return true;
				}
			} else if (cur == -1) {
				if (this.recursive(num, pre, n, i + 1, cnt + 1)) {
					return true;
				}
			}
			if (n == 0) {
				break;
			}
		}
		return false;
	}

}
