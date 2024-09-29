package gracefulsoul.problems;

public class UglyNumberIII {

	// https://leetcode.com/problems/ugly-number-iii/submissions/1405516926/
	public static void main(String[] args) {
		UglyNumberIII test = new UglyNumberIII();
		System.out.println(test.nthUglyNumber(3, 2, 3, 5));
		System.out.println(test.nthUglyNumber(4, 2, 3, 4));
		System.out.println(test.nthUglyNumber(5, 2, 11, 13));
	}

	public int nthUglyNumber(int n, int a, int b, int c) {
		int left = 0;
		int right = (int) 2e9;
		int result = 0;
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (this.getCount(mid, a, b, c) >= n) {
				result = mid;
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return result;
	}

	private int getCount(long num, long a, long b, long c) {
		long bc = this.getLcm(b, c);
		return (int) ((num / a) + (num / b) + (num / c)
				- (num / this.getLcm(a, b)) - (num / bc)- (num / this.getLcm(a, c))
				+ (num / (this.getLcm(a, bc))));
	}

	private long getGcd(long m, long n) {
		if (n == 0) {
			return m;
		} else {
			return this.getGcd(n, m % n);
		}
	}

	private long getLcm(long a, long b) {
		return a * b / this.getGcd(a, b);
	}

}
