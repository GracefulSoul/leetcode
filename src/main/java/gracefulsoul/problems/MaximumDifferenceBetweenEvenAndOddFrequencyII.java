package gracefulsoul.problems;

import java.util.Arrays;

public class MaximumDifferenceBetweenEvenAndOddFrequencyII {

	// https://leetcode.com/problems/maximum-difference-between-even-and-odd-frequency-ii/submissions/1660777176/
	public static void main(String[] args) {
		MaximumDifferenceBetweenEvenAndOddFrequencyII test = new MaximumDifferenceBetweenEvenAndOddFrequencyII();
		System.out.println(test.maxDifference("12233", 4));
		System.out.println(test.maxDifference("1122211", 3));
		System.out.println(test.maxDifference("110", 3));
	}

	public int maxDifference(String s, int k) {
        int n = s.length();
        //[0, i]中某个数字的出现次数
        int[][] preSum = new int[n+1][5];
        for (int i = 0; i < s.length(); ++i) {
            for (int j = 0; j <= 4; ++j) {
                preSum[i+1][j] = preSum[i][j];
            }
            preSum[i+1][s.charAt(i)-'0'] = preSum[i][s.charAt(i)-'0'] + 1;
        }
        int max = Integer.MIN_VALUE;
        for (int a = 0; a <= 4; ++a) {
            for (int b = 0; b <= 4; ++b) {
                if (a == b) {
                    continue;
                }
                int left = 0, right = 0;
                int[][] min = new int[][]{{Integer.MAX_VALUE/2, Integer.MAX_VALUE/2}, {Integer.MAX_VALUE/2, Integer.MAX_VALUE/2}};
                while(right < n) {
                    while(right - left + 1 >= k && preSum[right+1][a] > preSum[left][a] && preSum[right+1][b] > preSum[left][b]) {
                            int p = preSum[left][a] & 1;
                            int q = preSum[left][b] & 1;
                            min[p][q] = Math.min(min[p][q], preSum[left][a] - preSum[left][b]);
                            ++left;
                    }
                    int x = preSum[right+1][a] & 1 ^ 1;
                    int y = preSum[right+1][b] & 1;
                    max = Math.max(max, preSum[right+1][a] - preSum[right+1][b] - min[x][y]);
                    ++right;
                }
            }
        }
        return max;
	}

}
