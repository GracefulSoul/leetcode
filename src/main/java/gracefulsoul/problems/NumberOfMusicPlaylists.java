package gracefulsoul.problems;

public class NumberOfMusicPlaylists {

	// https://leetcode.com/problems/number-of-music-playlists/submissions/946603763/
	public static void main(String[] args) {
		NumberOfMusicPlaylists test = new NumberOfMusicPlaylists();
		System.out.println(test.numMusicPlaylists(3, 3, 1));
		System.out.println(test.numMusicPlaylists(2, 3, 0));
		System.out.println(test.numMusicPlaylists(2, 3, 1));
	}

	public int numMusicPlaylists(int n, int goal, int k) {
		int mod = 1000000007;
		long[][] dp = new long[goal + 1][n + 1];
		dp[0][0] = 1;
		for (int i = 1; i <= goal; i++) {
			for (int j = 1; j <= n; j++) {
				dp[i][j] = (dp[i - 1][j - 1] * (n - (j - 1))) % mod;
				if (j > k) {
					dp[i][j] = (dp[i][j] + (dp[i - 1][j] * (j - k)) % mod) % mod;
				}
			}
		}
		return (int) dp[goal][n];
	}

}
