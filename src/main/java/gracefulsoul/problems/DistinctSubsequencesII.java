package gracefulsoul.problems;

public class DistinctSubsequencesII {

	// https://leetcode.com/problems/distinct-subsequences-ii/submissions/985208040/
	public static void main(String[] args) {
		DistinctSubsequencesII test = new DistinctSubsequencesII();
		System.out.println(test.distinctSubseqII("abc"));
		System.out.println(test.distinctSubseqII("aba"));
		System.out.println(test.distinctSubseqII("aaa"));
	}

	public int distinctSubseqII(String s) {
		int sum = 0;
		int[] count = new int[26];
		int mod = 1000000007;
		for (char c : s.toCharArray()) {
			int index = c - 'a';
			int curr = (sum + 1 - count[index] + mod) % mod;
			sum = (sum + curr) % mod;
			count[index] = (count[index] + curr) % mod;
		}
		return sum;
	}

}
