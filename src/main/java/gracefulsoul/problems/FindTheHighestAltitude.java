package gracefulsoul.problems;

public class FindTheHighestAltitude {

	// https://leetcode.com/problems/find-the-highest-altitude/submissions/974649847/
	public static void main(String[] args) {
		FindTheHighestAltitude test = new FindTheHighestAltitude();
		System.out.println(test.largestAltitude(new int[] { -5, 1, 5, 0, -7 }));
		System.out.println(test.largestAltitude(new int[] { -4, -3, -2, -1, 4, 3, 2 }));
	}

	public int largestAltitude(int[] gain) {
		int max = 0;
		int sum = 0;
		for (int num : gain) {
			sum += num;
			if (sum > max) {
				max = sum;
			}
		}
		return max;
	}

}
