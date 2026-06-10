package gracefulsoul.object.table.sparse;

public class SparseTable {

	private int[][] min;
	private int[][] max;

	public SparseTable(int[] num) {
		int length = num.length;
		int bitWidth = 32 - Integer.numberOfLeadingZeros(length);
		this.min = new int[bitWidth][length];
		this.max = new int[bitWidth][length];

		for (int i = 0; i < length; i++) {
			this.min[0][i] = this.max[0][i] = num[i];
		}
		for (int i = 1; i < bitWidth; i++) {
			for (int j = 0; j + (1 << i) <= length; j++) {
				this.min[i][j] = Math.min(this.min[i - 1][j], this.min[i - 1][j + (1 << (i - 1))]);
				this.max[i][j] = Math.max(this.max[i - 1][j], this.max[i - 1][j + (1 << (i - 1))]);
			}
		}
	}

	public int query(int left, int right) {
		int k = 31 - Integer.numberOfLeadingZeros(right - left);
		return Math.max(this.max[k][left], this.max[k][right - (1 << k)])
				- Math.min(this.min[k][left], this.min[k][right - (1 << k)]);
	}

}
