package gracefulsoul.problems;

public class ShortestAndLexicographicallySmallestBeautifulString {

	// https://leetcode.com/problems/shortest-and-lexicographically-smallest-beautiful-string/submissions/2120720530/
	public static void main(String[] args) {
		ShortestAndLexicographicallySmallestBeautifulString test = new ShortestAndLexicographicallySmallestBeautifulString();
		System.out.println(test.shortestBeautifulSubstring("100011001", 3));
		System.out.println(test.shortestBeautifulSubstring("1011", 2));
		System.out.println(test.shortestBeautifulSubstring("000", 1));
		System.out.println(test.shortestBeautifulSubstring("100011001", 3));
	}

	public String shortestBeautifulSubstring(String s, int k) {
		char[] charArray = s.toCharArray();
		int[] positions = new int[] { -1, -1 };
		int index = 0;
		int count = 0;
		for (int i = 0; i < charArray.length; i++) {
			count += charArray[i] - '0';
			if (count < k) {
				continue;
			}
			while (index < i && charArray[index] == '0') {
				count -= charArray[index] - '0';
				index++;
			}
			if (positions[0] == -1 || positions[0] - positions[1] + 1 > i - index + 1) {
				positions[0] = i;
				positions[1] = index;
			} else if (positions[0] - positions[1] + 1 == i - index + 1
					&& 0 < s.substring(positions[1], positions[0] + 1).compareTo(s.substring(index, i + 1))) {
				positions[0] = i;
				positions[1] = index;
			}
			while (index < i && count == k) {
				count -= charArray[index] - '0';
				index++;
			}
		}
		return positions[0] != -1 ? s.substring(positions[1], positions[0] + 1) : "";
	}

}
