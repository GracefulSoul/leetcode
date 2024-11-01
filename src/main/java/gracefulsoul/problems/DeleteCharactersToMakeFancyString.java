package gracefulsoul.problems;

public class DeleteCharactersToMakeFancyString {

	// https://leetcode.com/problems/delete-characters-to-make-fancy-string/submissions/1439745394/
	public static void main(String[] args) {
		DeleteCharactersToMakeFancyString test = new DeleteCharactersToMakeFancyString();
		System.out.println(test.makeFancyString("leeetcode"));
		System.out.println(test.makeFancyString("aaabaaaa"));
		System.out.println(test.makeFancyString("aab"));
	}

	public String makeFancyString(String s) {
		char[] charArray = s.toCharArray();
		StringBuilder sb = new StringBuilder();
		int count = 1;
		for (int i = 0; i < charArray.length; i++) {
			if (0 < i && charArray[i - 1] == charArray[i]) {
				count++;
			} else {
				count = 1;
			}
			if (count < 3) {
				sb.append(charArray[i]);
			}
		}
		return sb.toString();
	}

}
