package gracefulsoul.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import gracefulsoul.util.PrintUtil;

public class SmallestSufficientTeam {

	// https://leetcode.com/problems/smallest-sufficient-team/submissions/995431526/
	public static void main(String[] args) {
		SmallestSufficientTeam test = new SmallestSufficientTeam();
		PrintUtil.print(test.smallestSufficientTeam(new String[] { "java", "nodejs", "reactjs" },
				Arrays.asList(Arrays.asList("java"), Arrays.asList("nodejs"), Arrays.asList("nodejs", "reactjs"))));
		PrintUtil.print(
				test.smallestSufficientTeam(new String[] { "algorithms", "math", "java", "reactjs", "csharp", "aws" },
						Arrays.asList(Arrays.asList("algorithms", "math", "java"),
								Arrays.asList("algorithms", "math", "reactjs"), Arrays.asList("java", "csharp", "aws"),
								Arrays.asList("reactjs", "csharp"), Arrays.asList("csharp", "math"),
								Arrays.asList("aws", "java"))));
	}

	@SuppressWarnings("unchecked")
	public int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {
		int length = req_skills.length;
		Map<String, Integer> list = new HashMap<>();
		for (int i = 0; i < length; i++) {
			list.put(req_skills[i], i);
		}
		List<Integer>[] dp = new List[1 << length];
		dp[0] = new ArrayList<>();
		for (int i = 0; i < people.size(); ++i) {
			int cur_skill = 0;
			for (String s : people.get(i)) {
				cur_skill |= 1 << list.get(s);
			}
			for (int prev = 0; prev < dp.length; ++prev) {
				if (dp[prev] == null) {
					continue;
				}
				int comb = prev | cur_skill;
				if (dp[comb] == null || dp[prev].size() + 1 < dp[comb].size()) {
					dp[comb] = new ArrayList<>(dp[prev]);
					dp[comb].add(i);
				}
			}
		}
		return dp[(1 << length) - 1].stream().mapToInt(i -> i).toArray();
	}

}
