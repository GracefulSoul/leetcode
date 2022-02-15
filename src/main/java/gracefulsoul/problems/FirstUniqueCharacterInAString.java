package gracefulsoul.problems;

public class FirstUniqueCharacterInAString {

	// https://leetcode.com/submissions/detail/641761345/
	public static void main(String[] args) {
		FirstUniqueCharacterInAString test = new FirstUniqueCharacterInAString();
		System.out.println(test.firstUniqChar("leetcode"));
		System.out.println(test.firstUniqChar("loveleetcode"));
		System.out.println(test.firstUniqChar("aabb"));
	}

	public int firstUniqChar(String s) {
		int index = Integer.MAX_VALUE;
		for (char c = 'a'; c <= 'z'; c++) {
			int first = s.indexOf(c);
			if (first != -1 && first == s.lastIndexOf(c)) {
				index = Math.min(index, first);
			}
		}
		return index == Integer.MAX_VALUE ? -1 : index;
	}

}
