package gracefulsoul.problems;

public class UsingARobotToPrintTheLexicographicallySmallestString {

	// https://leetcode.com/problems/using-a-robot-to-print-the-lexicographically-smallest-string/submissions/1655308965/
	public static void main(String[] args) {
		UsingARobotToPrintTheLexicographicallySmallestString test = new UsingARobotToPrintTheLexicographicallySmallestString();
		System.out.println(test.robotWithString("zza"));
		System.out.println(test.robotWithString("bac"));
		System.out.println(test.robotWithString("bdda"));
	}

	public String robotWithString(String s) {
		int[] counts = new int[26];
		int i = 0;
		StringBuilder psb = new StringBuilder();
		StringBuilder tsb = new StringBuilder();
		for (char c : s.toCharArray()) {
			counts[c - 'a']++;
		}
		while (i < 26 && counts[i] == 0) {
			i++;
		}
		for (char c : s.toCharArray()) {
			int index = c - 'a';
			if (index == i) {
				psb.append(c);
				counts[index]--;
				if (counts[index] == 0) {
					while (i < 26 && counts[i] == 0) {
						i++;
					}
					for (int length = tsb.length(); i < 26 && 0 < length && tsb.charAt(length - 1) <= i + 'a'; length = tsb.length()) {
						psb.append(tsb.charAt(length - 1));
						tsb.deleteCharAt(length - 1);
					}
				}
			} else {
				tsb.append(c);
				counts[index]--;
			}
		}
		tsb.reverse();
		psb.append(tsb);
		return psb.toString();
	}

}
