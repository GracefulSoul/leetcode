package gracefulsoul.problems;

public class RemoveKDigits {

	// https://leetcode.com/submissions/detail/651625905/
	public static void main(String[] args) {
		RemoveKDigits test = new RemoveKDigits();
		System.out.println(test.removeKdigits("1432219", 3));
		System.out.println(test.removeKdigits("10200", 1));
		System.out.println(test.removeKdigits("10", 2));
	}

	public String removeKdigits(String num, int k) {
		char[] numCharArray = num.toCharArray();
		int index = this.findIndex(numCharArray, k);
		int start = 0;
		while (index > start && numCharArray[start] == '0') {
			start++;
		}
		return start == index ? "0" : new String(numCharArray, start, index - start);
	}

	private int findIndex(char[] numCharArray, int k) {
		int index = 0;
		for (int idx = 0; idx < numCharArray.length; idx++) {
			if (index > 0 && k > 0 && numCharArray[idx] < numCharArray[index - 1]) {
				index--;
				k--;
				idx--;
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
