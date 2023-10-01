package gracefulsoul.problems;

public class FindTheTownJudge {

	// https://leetcode.com/problems/find-the-town-judge/submissions/1062678831/
	public static void main(String[] args) {
		FindTheTownJudge test = new FindTheTownJudge();
		System.out.println(test.findJudge(2, new int[][] {
			{ 1, 2 }
		}));
		System.out.println(test.findJudge(3, new int[][] {
			{ 1, 3 },
			{ 2, 3 }
		}));
		System.out.println(test.findJudge(3, new int[][] {
			{ 1, 3 },
			{ 2, 3 },
			{ 3, 1 }
		}));
	}

	public int findJudge(int n, int[][] trust) {
		int[] count = new int[n + 1];
		for (int[] t : trust) {
			count[t[0]]--;
			count[t[1]]++;
		}
		for (int i = 1; i <= n; i++) {
			if (count[i] == n - 1) {
				return i;
			}
		}
		return -1;
	}

}
