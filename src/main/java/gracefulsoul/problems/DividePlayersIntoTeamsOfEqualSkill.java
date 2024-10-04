package gracefulsoul.problems;

public class DividePlayersIntoTeamsOfEqualSkill {

	// https://leetcode.com/problems/divide-players-into-teams-of-equal-skill/submissions/1411411923/
	public static void main(String[] args) {
		DividePlayersIntoTeamsOfEqualSkill test = new DividePlayersIntoTeamsOfEqualSkill();
		System.out.println(test.dividePlayers(new int[] { 3, 2, 5, 1, 3, 4 }));
		System.out.println(test.dividePlayers(new int[] { 3, 4 }));
		System.out.println(test.dividePlayers(new int[] { 1, 1, 2, 3 }));
	}

	public long dividePlayers(int[] skill) {
		int[] count = new int[1001];
		int sum = 0;
		for (int s : skill) {
			count[s]++;
			sum += s;
		}
		int teams = skill.length / 2;
		if (sum % teams != 0) {
			return -1;
		} else {
			long result = 0;
			int divide = sum / teams;
			for (int s : skill) {
				int diff = divide - s;
				if (count[diff] == 0) {
					return -1;
				}
				result += (long) s * diff;
				count[diff]--;
			}
			return result / 2;
		}
	}

}
