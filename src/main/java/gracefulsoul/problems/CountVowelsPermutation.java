package gracefulsoul.problems;

public class CountVowelsPermutation {

	// https://leetcode.com/problems/count-vowels-permutation/submissions/1489504737/
	public static void main(String[] args) {
		CountVowelsPermutation test = new CountVowelsPermutation();
		System.out.println(test.countVowelPermutation(1));
		System.out.println(test.countVowelPermutation(2));
		System.out.println(test.countVowelPermutation(5));
	}

	private static final int MOD = 1000000007;

	public int countVowelPermutation(int n) {
		long a = 1;
		long e = 1;
		long i = 1;
		long o = 1;
		long u = 1;
		for (int j = 1; j < n; j++) {
			long nextA = e;
			long nextE = (a + i) % MOD;
			long nextI = (a + e + o + u) % MOD;
			long nextO = (i + u) % MOD;
			long nextU = a;
			a = nextA;
			e = nextE;
			i = nextI;
			o = nextO;
			u = nextU;
		}
		return (int) ((a + e + i + o + u) % MOD);
	}

}
