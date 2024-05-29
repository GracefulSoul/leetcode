package gracefulsoul.problems;

public class NumberOfStepsToReduceANumberInBinaryRepresentationToOne {

	// https://leetcode.com/problems/number-of-steps-to-reduce-a-number-in-binary-representation-to-one/submissions/1271263583/
	public static void main(String[] args) {
		NumberOfStepsToReduceANumberInBinaryRepresentationToOne test = new NumberOfStepsToReduceANumberInBinaryRepresentationToOne();
		System.out.println(test.numSteps("1101"));
		System.out.println(test.numSteps("10"));
		System.out.println(test.numSteps("1"));
	}

	public int numSteps(String s) {
		int result = 0;
		int carry = 0;
		for (int i = s.length() - 1; i > 0; i--) {
			result++;
			if (s.charAt(i) - '0' + carry == 1) {
				carry = 1;
				result++;
			}
		}
		return result + carry;
	}

}
