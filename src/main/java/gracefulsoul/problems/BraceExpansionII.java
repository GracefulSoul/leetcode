package gracefulsoul.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class BraceExpansionII {

	// https://leetcode.com/problems/brace-expansion-ii/submissions/1248166984/
	public static void main(String[] args) {
		BraceExpansionII test = new BraceExpansionII();
		System.out.println(test.braceExpansionII("{a,b}{c,{d,e}}"));
		System.out.println(test.braceExpansionII("{{a,z},a{b,c},{ab,z}}"));
	}

	public List<String> braceExpansionII(String expression) {
		return this.dfs(expression.toCharArray(), 0, expression.length() - 1);
	}

	private List<String> dfs(char[] expression, int start, int end) {
		Set<String> result = new TreeSet<>();
		List<List<String>> groups = new ArrayList<>();
		groups.add(new ArrayList<>());
		int count = 0;
		for (int i = 0, j = start; j <= end; j++) {
			if (expression[j] == '{' && ++count == 1) {
				i = j + 1;
			} else if (expression[j] == '}' && --count == 0) {
				this.merge(groups, this.dfs(expression, i, j - 1));
			} else if (count == 0) {
				if (expression[j] == ',') {
					groups.add(new ArrayList<>());
				} else {
					this.merge(groups, new ArrayList<>(Arrays.asList(String.valueOf(expression[j]))));
				}
			}
		}
		for (List<String> group : groups) {
			for (String word : group) {
				result.add(word);
			}
		}
		return new ArrayList<>(result);
	}

	private void merge(List<List<String>> groups, List<String> group) {
		List<String> temp = groups.get(groups.size() - 1);
		if (temp.isEmpty()) {
			groups.set(groups.size() - 1, group);
		} else {
			List<String> result = new ArrayList<>();
			for (String s1 : temp) {
				for (String s2 : group) {
					result.add(s1 + s2);
				}
			}
			groups.set(groups.size() - 1, result);
		}
	}

}
