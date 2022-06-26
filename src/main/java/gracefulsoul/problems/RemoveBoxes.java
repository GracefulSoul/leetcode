package gracefulsoul.problems;

public class RemoveBoxes {

	// https://leetcode.com/submissions/detail/731541603/
	public static void main(String[] args) {
		RemoveBoxes test = new RemoveBoxes();
		System.out.println(test.removeBoxes(new int[] { 1, 3, 2, 2, 2, 3, 4, 3, 1 }));
		System.out.println(test.removeBoxes(new int[] { 1, 1, 1 }));
		System.out.println(test.removeBoxes(new int[] { 1 }));
	}

	public int removeBoxes(int[] boxes) {
		int length = boxes.length;
		return this.recursive(boxes, new int[length][length][length], 0, length - 1, 0);
	}

	private int recursive(int[] boxes, int[][][] dp, int start, int end, int index) {
		if (start > end) {
			return 0;
		}
		if (dp[start][end][index] > 0) {
			return dp[start][end][index];
		}
		int last = start;
		while (last + 1 <= end && boxes[start] == boxes[last + 1]) {
			last++;
		}
		int pre = index + last - start;
		int temp = (pre + 1) * (pre + 1) + this.recursive(boxes, dp, last + 1, end, 0);
		for (int i = last + 2; i <= end; i++) {
			if (boxes[start] == boxes[i] && boxes[i - 1] != boxes[start]) {
				temp = Math.max(this.recursive(boxes, dp, last + 1, i - 1, 0) + this.recursive(boxes, dp, i, end, pre + 1), temp);
			}
		}
		dp[start][end][index] = temp;
		return temp;
	}

}
