package gracefulsoul.object.tree.mod;

import java.util.Arrays;

public class SegmentTree {

	private int size;
	private int mod;
	private Info[] tree;

	public SegmentTree(int[] nums, int k) {
		this.mod = k;
		this.size = 1;
		while (this.size < nums.length) {
			this.size <<= 1;
		}
		int length = size * 2;
		this.tree = new Info[length];
		for (int i = 0; i < length; i++) {
			this.tree[i] = new Info(k);
		}
		for (int i = 0; i < nums.length; i++) {
			int val = nums[i] % k;
			this.tree[this.size + i].ways[val] = 1;
			this.tree[size + i].whole = val;
		}
		for (int i = this.size - 1; i > 0; i--) {
			this.tree[i] = this.combine(this.tree[i << 1], this.tree[i << 1 | 1]);
		}
	}

	public void update(int index, int value) {
		int position = this.size + index;
		int val = value % this.mod;
		Arrays.fill(this.tree[position].ways, 0);
		this.tree[position].ways[val] = 1;
		this.tree[position].whole = val;
		position >>= 1;
		while (position > 0) {
			this.tree[position] = this.combine(this.tree[position << 1], this.tree[position << 1 | 1]);
			position >>= 1;
		}
	}

	public Info query(int left, int right) {
		Info leftPart = new Info(this.mod);
		Info rightPart = new Info(this.mod);
		left += this.size;
		right += this.size;
		while (left < right) {
			if ((left & 1) != 0) {
				leftPart = this.combine(leftPart, tree[left]);
				left++;
			}
			if ((right & 1) != 0) {
				right--;
				rightPart = this.combine(tree[right], rightPart);
			}
			left >>= 1;
			right >>= 1;
		}
		return this.combine(leftPart, rightPart);
	}

	private Info combine(Info left, Info right) {
		Info merge = new Info(this.mod);
		for (int i = 0; i < this.mod; i++) {
			merge.ways[i] = left.ways[i];
		}
		for (int i = 0; i < this.mod; i++) {
			if (right.ways[i] == 0) {
				continue;
			}
			merge.ways[(left.whole * i) % this.mod] += right.ways[i];
		}
		merge.whole = (left.whole * right.whole) % this.mod;
		return merge;
	}

	public class Info {
		private int[] ways;
		private int whole;

		public Info(int k) {
			this.ways = new int[k];
			this.whole = 1;
		}

		public int[] getWays() {
			return this.ways;
		}
	}

}
