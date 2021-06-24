package gracefulsoul.problems;

public class MinimumWindowSubstring {

	// https://leetcode.com/submissions/detail/512748176/
	public static void main(String[] args) {
		MinimumWindowSubstring test = new MinimumWindowSubstring();
		System.out.println(test.minWindow("ADOBECODEBANC", "ABC"));
		System.out.println(test.minWindow("a", "a"));
		System.out.println(test.minWindow("a", "aa"));
	}

	public String minWindow(String s, String t) {
		int[] charArray = new int[128];
        for (char c : t.toCharArray()) {
        	charArray[c]++;
        }
        int start = 0;
        int length = Integer.MAX_VALUE;
        int counter = t.length();
        for (int i = 0, j = 0; i < s.length(); i++) {
            if (charArray[s.charAt(i)]-- > 0) {
            	counter--;
            }
            while (counter == 0) {
                if (i - j + 1 < length) {
                	length = i - j + 1;
                	start = j;
                }
                if (++charArray[s.charAt(j++)] > 0) {
                	counter++;
                }
            }
        }
        return length == Integer.MAX_VALUE ? "" : s.substring(start, start + length);
	}

}
