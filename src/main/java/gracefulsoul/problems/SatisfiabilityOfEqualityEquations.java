package gracefulsoul.problems;

public class SatisfiabilityOfEqualityEquations {

	// https://leetcode.com/problems/satisfiability-of-equality-equations/submissions/1042893429/
	public static void main(String[] args) {
		SatisfiabilityOfEqualityEquations test = new SatisfiabilityOfEqualityEquations();
		System.out.println(test.equationsPossible(new String[] { "a==b", "b!=a" }));
		System.out.println(test.equationsPossible(new String[] { "b==a", "a==b" }));
	}

	public boolean equationsPossible(String[] equations) {
		int[] parent = new int[26];
		for (int i = 0; i < 26; i++) {
			parent[i] = i;
		}
		for (String equation : equations) {
			if (equation.charAt(1) == '=') {
				parent[this.find(parent, equation.charAt(0) - 'a')] = this.find(parent, equation.charAt(3) - 'a');
			}
		}
		for (String equation : equations) {
			if (equation.charAt(1) == '!' && this.find(parent, equation.charAt(0) - 'a') == this.find(parent, equation.charAt(3) - 'a')) {
				return false;
			}
		}
		return true;
	}

	private int find(int[] parent, int i) {
		if (parent[i] == i) {
			return i;
		} else {
			return parent[i] = find(parent, parent[i]);
		}
	}

}
