package gracefulsoul.problems;

public class KthSymbolInGrammar {

	// https://leetcode.com/problems/k-th-symbol-in-grammar/submissions/864042701/
	public static void main(String[] args) {
		KthSymbolInGrammar test = new KthSymbolInGrammar();
		System.out.println(test.kthGrammar(1, 1));
		System.out.println(test.kthGrammar(2, 1));
		System.out.println(test.kthGrammar(2, 2));
	}

	public int kthGrammar(int n, int k) {
		if (n == 1) {
			return 0;
		} else if (k % 2 == 0) {
			return 1 - this.kthGrammar(n - 1, k / 2);
		} else {
			return this.kthGrammar(n - 1, (k + 1) / 2);
		}
	}

}
