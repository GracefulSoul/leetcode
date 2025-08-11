package gracefulsoul.problems;

import java.util.ArrayList;
import java.util.List;

import gracefulsoul.util.PrintUtil;

public class RangeProductQueriesOfPowers {

	// https://leetcode.com/problems/range-product-queries-of-powers/submissions/1731082104/
	public static void main(String[] args) {
		RangeProductQueriesOfPowers test = new RangeProductQueriesOfPowers();
		PrintUtil.print(test.productQueries(15, new int[][] {
			{ 0, 1 },
			{ 2, 2 },
			{ 0, 3 }
		}));
		PrintUtil.print(test.productQueries(2, new int[][] {
			{ 0, 0 }
		}));
	}

	public int[] productQueries(int n, int[][] queries) {
		int length = queries.length;
		int mod = 1000000007;
		List<Integer> powers = new ArrayList<>();
		while (n > 0) {
			int lowBit = n & -n;
			powers.add(lowBit);
			n ^= lowBit;
		}
		int size = powers.size();
		int[][] table = new int[size][size];
		for (int i = 0; i < size; i++) {
			table[i][i] = powers.get(i);
			for (int j = i + 1; j < size; j++) {
				table[i][j] = (int) (((long) table[i][j - 1] * powers.get(j)) % mod);
			}
		}
		int[] result = new int[length];
		for (int i = 0; i < length; i++) {
			int[] curr = queries[i];
			result[i] = table[curr[0]][curr[1]];
		}
		return result;
	}

}
