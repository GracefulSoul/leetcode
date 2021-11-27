package gracefulsoul.problems;

import java.util.Arrays;

public class HIndex {

	// https://leetcode.com/submissions/detail/593218715/
	public static void main(String[] args) {
		HIndex test = new HIndex();
		System.out.println(test.hIndex(new int[] { 3, 0, 6, 1, 5 }));
		System.out.println(test.hIndex(new int[] { 1, 3, 1 }));
	}

	public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int idx = citations.length - 1;
        int count = 0;
        while (idx >= 0 && citations[idx] > count) {
        	count++;
            idx--;
        }
        return count;
	}

}
