package gracefulsoul.problems;

public class RansomNote {

	// https://leetcode.com/submissions/detail/638973923/
	public static void main(String[] args) {
		RansomNote test = new RansomNote();
		System.out.println(test.canConstruct("a", "b"));
		System.out.println(test.canConstruct("aa", "ab"));
		System.out.println(test.canConstruct("aa", "aab"));
	}

	public boolean canConstruct(String ransomNote, String magazine) {
		int[] count = new int[26];
		for (char ransomNoteChar : ransomNote.toCharArray()) {
			int num = ransomNoteChar - 'a';
			int preIndex = count[num];
			int index = magazine.indexOf(ransomNoteChar, preIndex);
			if (index == -1) {
				return false;
			}
			count[num] = index + 1;
		}
		return true;
	}

}
