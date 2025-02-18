package gracefulsoul.problems;

public class ConstructSmallestNumberFromDIString {

	// https://leetcode.com/problems/construct-smallest-number-from-di-string/submissions/1547243168/
	public static void main(String[] args) {
		ConstructSmallestNumberFromDIString test = new ConstructSmallestNumberFromDIString();
		System.out.println(test.smallestNumber("IIIDIDDD"));
		System.out.println(test.smallestNumber("DDD"));
	}

	public String smallestNumber(String pattern) {
		StringBuilder sb = new StringBuilder();
		int length = pattern.length();
		int[] stack = new int[length + 1];
		int index = 0;
		for (int i = 0; i <= length; i++) {
			stack[index++] = i + 1;
			if (i == length || pattern.charAt(i) == 'I') {
				while (index > 0) {
					sb.append(stack[--index]);
				}
			}
		}
		return sb.toString();
	}

}
