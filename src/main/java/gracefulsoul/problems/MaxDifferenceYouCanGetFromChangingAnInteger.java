package gracefulsoul.problems;

public class MaxDifferenceYouCanGetFromChangingAnInteger {

	// https://leetcode.com/problems/max-difference-you-can-get-from-changing-an-integer/submissions/1664324379/
	public static void main(String[] args) {
		MaxDifferenceYouCanGetFromChangingAnInteger test = new MaxDifferenceYouCanGetFromChangingAnInteger();
		System.out.println(test.maxDiff(555));
		System.out.println(test.maxDiff(8));
	}

	public int maxDiff(int num) {
		String str = Integer.toString(num);
		char[] charArray = str.toCharArray();
		String max = str;
		String min = str;
		for (char c : charArray) {
			if (c != '9') {
				max = str.replace(c, '9');
				break;
			}
		}
		if (str.charAt(0) != '1') {
			return Integer.parseInt(max) - Integer.parseInt(str.replace(charArray[0], '1'));
		}
		for (int i = 1; i < str.length(); i++) {
			if (charArray[i] != '0' && charArray[i] != '1') {
				min = str.replace(charArray[i], '0');
				break;
			}
		}
		return Integer.parseInt(max) - Integer.parseInt(min);
	}

}
