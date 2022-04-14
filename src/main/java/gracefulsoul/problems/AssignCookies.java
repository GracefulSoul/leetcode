package gracefulsoul.problems;

import java.util.Arrays;

public class AssignCookies {

	// https://leetcode.com/submissions/detail/679974327/
	public static void main(String[] args) {
		AssignCookies test = new AssignCookies();
		System.out.println(test.findContentChildren(new int[] { 1, 2, 3 }, new int[] { 1, 1 }));
		System.out.println(test.findContentChildren(new int[] { 1, 2 }, new int[] { 1, 2, 3 }));
	}

	public int findContentChildren(int[] g, int[] s) {
		Arrays.sort(g);
		Arrays.sort(s);
		int i = 0;
		for (int j = 0; i < g.length && j < s.length; j++) {
			if (g[i] <= s[j]) {
				i++;
			}
		}
		return i;
	}

}
