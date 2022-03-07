package gracefulsoul.problems;

public class TrappingRainWaterII {

	// https://leetcode.com/submissions/detail/654980565/
	public static void main(String[] args) {
		TrappingRainWaterII test = new TrappingRainWaterII();
		System.out.println(test.trapRainWater(new int[][] {
			{ 1, 4, 3, 1, 3, 2 },
			{ 3, 2, 1, 3, 2, 4 },
			{ 2, 3, 3, 2, 3, 1 }
		}));
		System.out.println(test.trapRainWater(new int[][] {
			{ 3, 3, 3, 3, 3 },
			{ 3, 2, 2, 2, 3 },
			{ 3, 2, 1, 2, 3 },
			{ 3, 2, 2, 2, 3 },
			{ 3, 3, 3, 3, 3 }
		}));
	}

	public int trapRainWater(int[][] heightMap) {
		int row = heightMap.length;
		int col = heightMap[0].length;
		int[][] volume = new int[row][col];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				volume[i][j] = heightMap[i][j];
			}
		}
		boolean update = true;
		boolean init = true;
		while (update) {
			update = false;
			for (int i = 1; i < row - 1; i++) {
				for (int j = 1; j < col - 1; j++) {
					int val = Math.max(heightMap[i][j], Math.min(volume[i - 1][j], volume[i][j - 1]));
					if (init || val < volume[i][j]) {
						volume[i][j] = val;
						update = true;
					}
				}
			}
			init = false;
			for (int i = row - 2; i >= 1; i--) {
				for (int j = col - 2; j >= 1; j--) {
					int val = Math.max(heightMap[i][j], Math.min(volume[i + 1][j], volume[i][j + 1]));
					if (val < volume[i][j]) {
						volume[i][j] = val;
						update = true;
					}
				}
			}
		}
		int sum = 0;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (volume[i][j] - heightMap[i][j] > 0) {
					sum += volume[i][j] - heightMap[i][j];
				}
			}
		}
		return sum;
	}

}
