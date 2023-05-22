package gracefulsoul.problems;

public class FlipStringToMonotoneIncreasing {

	// https://leetcode.com/problems/flip-string-to-monotone-increasing/submissions/955015620/
	public static void main(String[] args) {
		FlipStringToMonotoneIncreasing test = new FlipStringToMonotoneIncreasing();
		System.out.println(test.minFlipsMonoIncr("00110"));
		System.out.println(test.minFlipsMonoIncr("010110"));
		System.out.println(test.minFlipsMonoIncr("00011000"));
	}

	public int minFlipsMonoIncr(String s) {
		int flip0 = 0;
		int flip1 = 0;
		for (char c : s.toCharArray()) {
			int num = c - '0';
			flip0 += num;
			flip1 = Math.min(flip0, flip1 + 1 - num);
		}
		return flip1;
	}

}
