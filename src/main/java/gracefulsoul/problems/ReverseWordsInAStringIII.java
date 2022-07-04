package gracefulsoul.problems;

public class ReverseWordsInAStringIII {

	// https://leetcode.com/submissions/detail/738136794/
	public static void main(String[] args) {
		ReverseWordsInAStringIII test = new ReverseWordsInAStringIII();
		System.out.println(test.reverseWords("Let's take LeetCode contest"));
		System.out.println(test.reverseWords("God Ding"));
	}

	public String reverseWords(String s) {
		char[] charArray = s.toCharArray();
		int start = 0;
		int end = 0;
		while (end < charArray.length) {
			if (charArray[end] == ' ') {
				this.reverse(charArray, start, end - 1);
				start = end + 1;
			}
			end++;
		}
		this.reverse(charArray, start, end - 1);
		return new String(charArray);
	}

	private void reverse(char[] charArray, int start, int end) {
		while (start < end) {
			char temp = charArray[start];
			charArray[start++] = charArray[end];
			charArray[end--] = temp;
		}
	}

}
