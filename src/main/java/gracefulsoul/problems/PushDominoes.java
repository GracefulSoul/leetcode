package gracefulsoul.problems;

public class PushDominoes {

	// https://leetcode.com/problems/push-dominoes/submissions/897093663/
	public static void main(String[] args) {
		PushDominoes test = new PushDominoes();
		System.out.println(test.pushDominoes("RR.L"));
		System.out.println(test.pushDominoes(".L.R...LR..L.."));
	}

	public String pushDominoes(String dominoes) {
		char[] charArray = dominoes.toCharArray();
		int index = -1;
		char c = '.';
		for (int idx = 0; idx < charArray.length; idx++) {
			if (charArray[idx] == 'L') {
				if (index == -1 || c == 'L') {
					while (index < idx - 1) {
						charArray[++index] = 'L';
					}
				} else if (c == 'R') {
					int left = index + 1;
					int right = idx - 1;
					while (left < right) {
						charArray[left++] = 'R';
						charArray[right--] = 'L';
					}
				}
				index = idx;
				c = 'L';
			} else if (charArray[idx] == 'R') {
				if (c == 'R') {
					while (index < idx - 1) {
						charArray[++index] = 'R';
					}
				}
				index = idx;
				c = 'R';
			}
		}
		if (c == 'R') {
			while (index < charArray.length - 1) {
				charArray[++index] = 'R';
			}
		}
		return String.valueOf(charArray);
	}

}
