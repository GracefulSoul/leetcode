package gracefulsoul.problems;

public class CountOfMatchesInTournament {

	// https://leetcode.com/problems/count-of-matches-in-tournament/submissions/1112813048/
	public static void main(String[] args) {
		CountOfMatchesInTournament test = new CountOfMatchesInTournament();
		System.out.println(test.numberOfMatches(7));
		System.out.println(test.numberOfMatches(14));
	}

	public int numberOfMatches(int n) {
		return n - 1;
	}

}
