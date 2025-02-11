package gracefulsoul.problems;

public class RemoveAllOccurrencesOfASubstring {

	// https://leetcode.com/problems/remove-all-occurrences-of-a-substring/submissions/1539137683/
	public static void main(String[] args) {
		RemoveAllOccurrencesOfASubstring test = new RemoveAllOccurrencesOfASubstring();
		System.out.println(test.removeOccurrences("daabcbaabcbc", "abc"));
		System.out.println(test.removeOccurrences("axxxxyyyyb", "xy"));
	}

	public String removeOccurrences(String s, String part) {
		char[] sCharArray = s.toCharArray();
		char[] partCharArray = part.toCharArray();
		char[] resultStack = new char[sCharArray.length];
		int size = 0;
		int partLength = partCharArray.length;
		char targetEndChar = partCharArray[partLength - 1];
		for (char c : sCharArray) {
			resultStack[size++] = c;
			if (c == targetEndChar && size >= partLength) {
				int i = size - 1;
				int j = partLength - 1;
				while (j >= 0 && resultStack[i] == partCharArray[j]) {
					i--;
					j--;
				}
				if (j < 0) {
					size = i + 1;
				}
			}
		}
		return new String(resultStack, 0, size);
	}

}
