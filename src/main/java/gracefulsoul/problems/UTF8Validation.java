package gracefulsoul.problems;

public class UTF8Validation {

	// https://leetcode.com/submissions/detail/645870882/
	public static void main(String[] args) {
		UTF8Validation test = new UTF8Validation();
		System.out.println(test.validUtf8(new int[] { 197, 130, 1 }));
		System.out.println(test.validUtf8(new int[] { 235, 140, 4 }));
	}

	public boolean validUtf8(int[] data) {
		int bytes = 0;
		for (int num : data) {
			int mask = 128;
			if (bytes == 0) {
				while ((mask & num) != 0) {
					bytes++;
					mask >>= 1;
				}
				if (bytes > 4 || bytes == 1) {
					return false;
				}
			} else {
				if ((num & mask) == 0 || (num & (mask >> 1)) != 0) {
					return false;
				}
			}
			if (bytes != 0) {
				bytes--;
			}
		}
		return bytes == 0;
	}

}
