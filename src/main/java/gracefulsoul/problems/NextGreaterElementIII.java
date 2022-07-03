package gracefulsoul.problems;

import java.util.Arrays;

public class NextGreaterElementIII {

	// https://leetcode.com/submissions/detail/737179036/
	public static void main(String[] args) {
		NextGreaterElementIII test = new NextGreaterElementIII();
		System.out.println(test.nextGreaterElement(12));
		System.out.println(test.nextGreaterElement(21));
	}

	public int nextGreaterElement(int n) {
		String str = String.valueOf(n);
		char[] charArray = str.toCharArray();
		int index = 0;
		int i;
		for (i = charArray.length - 2; i >= 0; i--) {
			if (charArray[i] < charArray[i + 1]) {
				index = i;
				break;
			}
		}
		if (i < 0) {
			return -1;
		}
		int smallest = 0;
		for (int j = index + 1; j < charArray.length; j++) {
			if ((j == charArray.length - 1 && charArray[j] > charArray[index]) || (charArray[j] > charArray[index] && charArray[index] >= charArray[j + 1])) {
				smallest = j;
				break;
			}
		}
		this.swap(charArray, index, smallest);
		Arrays.sort(charArray, index + 1, charArray.length);
		long val = Long.parseLong(new String(charArray));
		return (val <= Integer.MAX_VALUE) ? (int) val : -1;
	}

	private void swap(char[] charArray, int left, int right) {
		char temp = charArray[left];
		charArray[left] = charArray[right];
		charArray[right] = temp;
	}

}
