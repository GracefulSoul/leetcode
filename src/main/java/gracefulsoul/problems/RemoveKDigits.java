package gracefulsoul.problems;

public class RemoveKDigits {

	// https://leetcode.com/submissions/detail/651629059/
	public static void main(String[] args) {
		RemoveKDigits test = new RemoveKDigits();
		System.out.println(test.removeKdigits("1432219", 3));
		System.out.println(test.removeKdigits("10200", 1));
		System.out.println(test.removeKdigits("10", 2));
	}

	public String removeKdigits(String num, int k) {
		char[] numCharArray = num.toCharArray();
		int start = 0;
		int end = this.findEndIndex(numCharArray, k);
		while (end > start && numCharArray[start] == '0') {
			start++;
		}
		return start == end ? "0" : new String(numCharArray, start, end - start);
	}

	private int findEndIndex(char[] numCharArray, int k) {
		int index = 0;
		for (int idx = 0; idx < numCharArray.length; idx++) {
			if (index > 0 && k > 0 && numCharArray[index - 1] > numCharArray[idx]) {
				k--;
				idx--;
				index--;
			} else {
				numCharArray[index++] = numCharArray[idx];
			}
		}
		if (k > 0) {
			index -= k;
		}
		return index;
	}

}
