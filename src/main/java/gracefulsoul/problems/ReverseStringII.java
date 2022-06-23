package gracefulsoul.problems;

public class ReverseStringII {

	// https://leetcode.com/submissions/detail/729193034/
	public static void main(String[] args) {
		ReverseStringII test = new ReverseStringII();
		System.out.println(test.reverseStr("abcdefg", 2));
		System.out.println(test.reverseStr("abcd", 2));
	}

	public String reverseStr(String s, int k) {
		char[] array = s.toCharArray();
		int length = array.length;
		int i = 0;
		while (i < length) {
			int j = Math.min(i + k - 1, length - 1);
			this.swap(array, i, j);
			i += 2 * k;
		}
		return new String(array);
	}

	private void swap(char[] array, int left, int right) {
		while (left < right) {
			char temp = array[left];
			array[left++] = array[right];
			array[right--] = temp;
		}
	}

}
