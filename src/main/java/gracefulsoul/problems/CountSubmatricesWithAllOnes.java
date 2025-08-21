package gracefulsoul.problems;

public class CountSubmatricesWithAllOnes {

	// https://leetcode.com/problems/count-submatrices-with-all-ones/submissions/1743013102/
	public static void main(String[] args) {
		CountSubmatricesWithAllOnes test = new CountSubmatricesWithAllOnes();
		System.out.println(test.numSubmat(new int[][] {
			{ 1, 0, 1 },
			{ 1, 1, 0 },
			{ 1, 1, 0 }
		}));
		System.out.println(test.numSubmat(new int[][] {
			{ 0, 1, 1, 0 },
			{ 0, 1, 1, 1 },
			{ 1, 1, 1, 0 }
		}));
	}

	public int numSubmat(int[][] mat) {
		int rows = mat.length;
		int cols = mat[0].length;
		int result = 0;
		int[] height = new int[cols];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				height[j] = (mat[i][j] == 0) ? 0 : height[j] + 1;
			}
			result += this.getCounts(height);
		}
		return result;
	}

	private int getCounts(int[] height) {
		int length = height.length;
		int count = 0;
		int top = -1;
		int[] sum = new int[length];
		int[] stack = new int[length];
		for (int j = 0; j < length; j++) {
			while (top >= 0 && height[stack[top]] >= height[j]) {
				top--;
			}
			if (top == -1) {
				sum[j] = height[j] * (j + 1);
			} else {
				sum[j] = sum[stack[top]] + (height[j] * (j - stack[top]));
			}
			count += sum[j];
			stack[++top] = j;
		}
		return count;
	}

}
