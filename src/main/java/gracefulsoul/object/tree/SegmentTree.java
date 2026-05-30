package gracefulsoul.object.tree;

public class SegmentTree {

	private int size;
	private int[] tree;

	public SegmentTree(int n) {
		this.size = 1;
		while (this.size < n) {
			this.size *= 2;
		}
		this.tree = new int[this.size * 2];
	}

	public void update(int index, int val) {
		int position = index + this.size;
		this.tree[position] = val;
		position /= 2;

		while (position > 0) {
			this.tree[position] = Math.max(this.tree[position * 2], this.tree[position * 2 + 1]);
			position /= 2;
		}
	}

	public int query(int i, int j) {
		int result = 0;
		int left = i + this.size;
		int right = j + this.size;
		while (left <= right) {
			if (left % 2 == 1) {
				result = Math.max(result, this.tree[left]);
				left++;
			}
			if (right % 2 == 0) {
				result = Math.max(result, this.tree[right]);
				right--;
			}
			left /= 2;
			right /= 2;
		}
		return result;
	}

}