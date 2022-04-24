package gracefulsoul.problems;

public class CountTheRepetitions {

	// https://leetcode.com/submissions/detail/686297325/
	public static void main(String[] args) {
		CountTheRepetitions test = new CountTheRepetitions();
		System.out.println(test.getMaxRepetitions("acb", 4, "ab", 2));
		System.out.println(test.getMaxRepetitions("acb", 1, "acb", 1));

	}

	public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
		int length = s2.length();
		int[] indexArray = new int[length + 1];
		int[] countArray = new int[length + 1];
		int index = 0;
		int count = 0;
		for (int i = 0; i < n1; i++) {
			for (int j = 0; j < s1.length(); j++) {
				if (s1.charAt(j) == s2.charAt(index)) {
					index++;
				}
				if (index == length) {
					index = 0;
					count++;
				}
			}
			countArray[i] = count;
			indexArray[i] = index;
			for (int k = 0; k < i; k++) {
				if (indexArray[k] == index) {
					return (countArray[k] + (countArray[i] - countArray[k]) * ((n1 - 1 - k) / (i - k)) + (countArray[k + (n1 - 1 - k) % (i - k)] - countArray[k])) / n2;
				}
			}
		}
		return countArray[n1 - 1] / n2;
	}

}
