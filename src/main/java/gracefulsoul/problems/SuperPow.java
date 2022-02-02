package gracefulsoul.problems;

public class SuperPow {

	// https://leetcode.com/submissions/detail/632794105/
	public static void main(String[] args) {
		SuperPow test = new SuperPow();
		System.out.println(test.superPow(2, new int[] { 3 }));
		System.out.println(test.superPow(2, new int[] { 1, 0 }));
		System.out.println(test.superPow(1, new int[] { 4, 3, 3, 8, 5, 2 }));
	}

	public int superPow(int a, int[] b) {
		int mod = 1337;
		if (a % mod == 0) {
			return 0;
		}
		a %= mod;
		int[] next = new int[mod];
		int count = 0;
		int num = a;
		while (next[num] == 0) {
			next[num] = num * a % mod;
			num = next[num];
			count++;
		}
		int m = 0;
		for (int i = 0; i < b.length; i++) {
			m = (m * 10 + b[i]) % count;
		}
		while (--m > 0) {
			a = next[a];
		}
		return a;
	}

}
