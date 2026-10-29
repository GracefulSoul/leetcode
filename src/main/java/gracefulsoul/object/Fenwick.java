package gracefulsoul.object;

public class Fenwick {

	int n;
	int[] bit;

	public Fenwick(int n) {
		this.n = n;
		this.bit = new int[n + 1];
	}

	public void add(int i, int val) {
		for (i++; i <= n; i += i & -i) {
			this.bit[i] ^= val;
		}
	}

	public int sum(int i) {
		int r = 0;
		for (i++; i > 0; i -= i & -i) {
			r ^= bit[i];
		}
		return r;
	}
}
