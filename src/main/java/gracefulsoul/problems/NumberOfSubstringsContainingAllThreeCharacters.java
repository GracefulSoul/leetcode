package gracefulsoul.problems;

public class NumberOfSubstringsContainingAllThreeCharacters {

	// https://leetcode.com/problems/number-of-substrings-containing-all-three-characters/submissions/1570090687/
	public static void main(String[] args) {
		NumberOfSubstringsContainingAllThreeCharacters test = new NumberOfSubstringsContainingAllThreeCharacters();
		System.out.println(test.numberOfSubstrings("abcabc"));
		System.out.println(test.numberOfSubstrings("aaacb"));
		System.out.println(test.numberOfSubstrings("abc"));
	}

	public int numberOfSubstrings(String s) {
		char[] charArray = s.toCharArray();
		int length = charArray.length;
		int[] lastIndex = new int[] { -1, -1, -1 };
		int result = 0;
		for (int i = 0; i < length; i++) {
			lastIndex[charArray[i] - 'a'] = i;
			result += 1 + Math.min(lastIndex[0], Math.min(lastIndex[1], lastIndex[2]));
		}
		return result;
	}

}
