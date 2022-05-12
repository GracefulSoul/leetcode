package gracefulsoul.problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ZumaGame {

	public static void main(String[] args) {
		ZumaGame test = new ZumaGame();
		System.out.println(test.findMinStep("WRRBBW", "RB"));
		System.out.println(test.findMinStep("WWRRBBWW", "WRBRW"));
		System.out.println(test.findMinStep("G", "GGGGG"));
	}

	private char[] h;
	private int inf = (int) 1e9;
	private Map<String, Integer> dp = new HashMap<>();

	public int findMinStep(String board, String hand) {
		h = hand.toCharArray();
		Arrays.sort(h);
		int v = this.dfs(board, (1 << this.h.length) - 1);
		return v == inf ? -1 : v;
	}

	private int dfs(String cur, int avail) {
		String key = cur + avail;
		if (this.dp.containsKey(key)) {
			return this.dp.get(key);
		}
		int result = this.inf;
		for (int i = 0; i < this.h.length; i++) {
			if ((avail & (1 << i)) == 0) {
				continue;
			}
			int next = avail - (1 << i);
			char b = this.h[i];
			int len = cur.length();
			for (int j = 0; j < len; j++) {
				boolean ok = false;
				if (j > 0 && cur.charAt(j - 1) == cur.charAt(j) && b != cur.charAt(j)) {
					ok = true;
				}
				if ((j == 0 || cur.charAt(j - 1) != cur.charAt(j)) && b == cur.charAt(j)) {
					ok = true;
				}
				if (!ok) {
					continue;
				}
				StringBuilder sb = new StringBuilder(cur.substring(0, j)).append(b).append(cur.substring(j));
				int k = j;
				while (sb.length() > 0) {
					char tar = sb.charAt(k);
					int s = k - 1, e = k + 1;
					while (s >= 0 && sb.charAt(s) == tar) {
						s--;
					}
					while (e < sb.length() && sb.charAt(e) == tar) {
						e++;
					}
					if (e - s - 1 >= 3) {
						sb.delete(s + 1, e);
						k = s >= 0 ? s : s + 1;
					} else {
						break;
					}
				}
				result = Math.min(result, 1 + this.dfs(sb.toString(), next));
			}
		}
		this.dp.put(key, result);
		return result;
	}

}
