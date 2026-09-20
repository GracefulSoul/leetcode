package gracefulsoul.problems;

public class ReverseDegreeOfAString {

	// https://leetcode.com/problems/reverse-degree-of-a-string/submissions/2147546716/
	public static void main(String[] args) {
		ReverseDegreeOfAString test = new ReverseDegreeOfAString();
		System.out.println(test.reverseDegree("abc"));
		System.out.println(test.reverseDegree("zaza"));
	}

	public int reverseDegree(String s) {
		int sum = 0;
		for (int i = 0; i < s.length(); i++) {
			sum += (26 - (s.charAt(i) - 'a')) * (i + 1);
		}
		return sum;
	}

}
