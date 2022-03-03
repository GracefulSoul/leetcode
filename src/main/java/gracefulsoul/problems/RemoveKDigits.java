package gracefulsoul.problems;

public class RemoveKDigits {

	// https://leetcode.com/submissions/detail/651635861/
	public static void main(String[] args) {
		RemoveKDigits test = new RemoveKDigits();
		System.out.println(test.removeKdigits("1432219", 3));
//		System.out.println(test.removeKdigits("10200", 1));
//		System.out.println(test.removeKdigits("10", 2));
	}

	public String removeKdigits(String num, int k) {
		char[] numCharArray = num.toCharArray();
		int start = 0;
		int end = 0;
		for (int idx = 0; idx < numCharArray.length; idx++) {
			if (end > 0 && k > 0 && numCharArray[end - 1] > numCharArray[idx]) {
				k--;
				idx--;
				end--;
			} else {
				numCharArray[end++] = numCharArray[idx];
			}
		}
		if (k > 0) {
			end -= k;
		}
		while (end > start && numCharArray[start] == '0') {
			start++;
		}
		return start == end ? "0" : new String(numCharArray, start, end - start);
	}

}
