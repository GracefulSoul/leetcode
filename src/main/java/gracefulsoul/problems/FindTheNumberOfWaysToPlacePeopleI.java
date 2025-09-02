package gracefulsoul.problems;

public class FindTheNumberOfWaysToPlacePeopleI {

	// https://leetcode.com/problems/find-the-number-of-ways-to-place-people-i/submissions/1756859644/
	public static void main(String[] args) {
		FindTheNumberOfWaysToPlacePeopleI test = new FindTheNumberOfWaysToPlacePeopleI();
		System.out.println(test.numberOfPairs(new int[][] {
			{ 1, 1 },
			{ 2, 2 },
			{ 3, 3 }
		}));
		System.out.println(test.numberOfPairs(new int[][] {
			{ 6, 2 },
			{ 4, 4 },
			{ 2, 6 }
		}));
		System.out.println(test.numberOfPairs(new int[][] {
			{ 3, 1 },
			{ 1, 3 },
			{ 1, 1 }
		}));
	}

	public int numberOfPairs(int[][] points) {
		int length = points.length;
		int count = 0;
		for (int i = 0; i < length; i++) {
			int[] a = points[i];
			for (int j = 0; j < length; j++) {
				if (i == j) {
					continue;
				}
				int[] b = points[j];
				if (a[0] <= b[0] && a[1] >= b[1]) {
					boolean isEmpty = true;
					for (int k = 0; k < length; k++) {
						if (k == i || k == j) {
							continue;
						}
						int[] curr = points[k];
						if (a[0] <= curr[0] && curr[0] <= b[0] && b[1] <= curr[1] && curr[1] <= a[1]) {
							isEmpty = false;
							break;
						}
					}
					if (isEmpty) {
						count++;
					}
				}
			}
		}
		return count;
	}

}
