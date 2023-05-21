package gracefulsoul.problems;

public class LongPressedName {

	// https://leetcode.com/problems/long-pressed-name/submissions/954291370/
	public static void main(String[] args) {
		LongPressedName test = new LongPressedName();
		System.out.println(test.isLongPressedName("alex", "aaleex"));
		System.out.println(test.isLongPressedName("saeed", "ssaaedd"));
	}

	public boolean isLongPressedName(String name, String typed) {
		int i = 0;
		int j = 0;
		while (j < typed.length()) {
			if (i < name.length() && name.charAt(i) == typed.charAt(j)) {
				i++;
			} else if (j == 0 || typed.charAt(j) != typed.charAt(j - 1)) {
				return false;
			}
			j++;
		}
		return i == name.length();
	}

}
