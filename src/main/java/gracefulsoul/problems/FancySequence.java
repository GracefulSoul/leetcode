package gracefulsoul.problems;

import java.util.ArrayList;
import java.util.List;

public class FancySequence {

	// https://leetcode.com/problems/fancy-sequence/submissions/1948877994/
	public static void main(String[] args) {
		Fancy fancy = new Fancy();
		fancy.append(2);						// fancy sequence: [2]
		fancy.addAll(3);						// fancy sequence: [2+3] -> [5]
		fancy.append(7);						// fancy sequence: [5, 7]
		fancy.multAll(2);						// fancy sequence: [5*2, 7*2] -> [10, 14]
		System.out.println(fancy.getIndex(0));	// return 10
		fancy.addAll(3);						// fancy sequence: [10+3, 14+3] -> [13, 17]
		fancy.append(10);						// fancy sequence: [13, 17, 10]
		fancy.multAll(2);						// fancy sequence: [13*2, 17*2, 10*2] -> [26, 34, 20]
		System.out.println(fancy.getIndex(0));	// return 26
		System.out.println(fancy.getIndex(1));	// return 34
		System.out.println(fancy.getIndex(2));	// return 20
	}

}

class Fancy {

	private static final int MOD = 1000000007;
	private List<Long> list;
	private long multiply;
	private long increment;

	public Fancy() {
		this.list = new ArrayList<>();
		this.multiply = 1;
		this.increment = 0;
	}

	public void append(int val) {
		long x = (val - this.increment + MOD) % MOD;
		this.list.add((x * pow(this.multiply, MOD - 2, MOD)) % MOD);
	}

	public void addAll(int inc) {
		this.increment = (this.increment + inc) % MOD;
	}

	public void multAll(int m) {
		this.multiply = (this.multiply * m) % MOD;
		this.increment = (this.increment * m) % MOD;
	}

	public int getIndex(int idx) {
		if (idx >= this.list.size()) {
			return -1;
		} else {
			return (int) (((this.multiply * this.list.get(idx)) + this.increment) % MOD);
		}
	}

	private long pow(long x, long y, long mod) {
		long result = 1;
		x %= mod;
		while (y > 0) {
			if (y % 2 == 1) {
				result = (result * x) % mod;
			}
			y = y / 2;
			x = (x * x) % mod;
		}
		return result;
	}

}

/**
 * Your Fancy object will be instantiated and called as such:
 * Fancy obj = new Fancy();
 * obj.append(val);
 * obj.addAll(inc);
 * obj.multAll(m);
 * int param_4 = obj.getIndex(idx);
 */