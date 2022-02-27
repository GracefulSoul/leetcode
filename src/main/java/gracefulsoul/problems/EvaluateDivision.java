package gracefulsoul.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class EvaluateDivision {

	// https://leetcode.com/submissions/detail/649555553/
	public static void main(String[] args) {
		EvaluateDivision test = new EvaluateDivision();
		List<List<String>> equations1 = new ArrayList<>();
		equations1.add(Arrays.asList(new String[] { "a", "b" }));
		equations1.add(Arrays.asList(new String[] { "b", "c" }));
		List<List<String>> queries1 = new ArrayList<>();
		queries1.add(Arrays.asList(new String[] { "a", "c" }));
		queries1.add(Arrays.asList(new String[] { "b", "a" }));
		print(test.calcEquation(equations1, new double[] { 2.0, 3.0 }, queries1));
		List<List<String>> equations2 = new ArrayList<>();
		equations2.add(Arrays.asList(new String[] { "a", "b" }));
		equations2.add(Arrays.asList(new String[] { "b", "c" }));
		equations2.add(Arrays.asList(new String[] { "bc", "cd" }));
		List<List<String>> queries2 = new ArrayList<>();
		queries2.add(Arrays.asList(new String[] { "a", "c" }));
		queries2.add(Arrays.asList(new String[] { "c", "b" }));
		queries2.add(Arrays.asList(new String[] { "bc", "cd" }));
		queries2.add(Arrays.asList(new String[] { "cd", "bc" }));
		print(test.calcEquation(equations2, new double[] { 1.5, 2.5, 5.0 }, queries2));
		List<List<String>> equations3 = new ArrayList<>();
		equations3.add(Arrays.asList(new String[] { "a", "b" }));
		List<List<String>> queries3 = new ArrayList<>();
		queries3.add(Arrays.asList(new String[] { "a", "b" }));
		queries3.add(Arrays.asList(new String[] { "b", "a" }));
		queries3.add(Arrays.asList(new String[] { "a", "c" }));
		queries3.add(Arrays.asList(new String[] { "x", "y" }));
		print(test.calcEquation(equations3, new double[] { 0.5 }, queries3));
	}

	public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
		Map<String, Map<String, Double>> map = new HashMap<>();
		for (int idx = 0; idx < values.length; idx++) {
			List<String> equation = equations.get(idx);
			map.putIfAbsent(equation.get(0), new HashMap<>());
			map.putIfAbsent(equation.get(1), new HashMap<>());
			map.get(equation.get(0)).put(equation.get(1), values[idx]);
			map.get(equation.get(1)).put(equation.get(0), 1 / values[idx]);
		}
		double[] result = new double[queries.size()];
		for (int idx = 0; idx < queries.size(); idx++) {
			List<String> query = queries.get(idx);
			result[idx] = this.dfs(query.get(0), query.get(1), 1, map, new HashSet<>());
		}
		return result;
	}

	private double dfs(String s, String t, double num, Map<String, Map<String, Double>> map, Set<String> set) {
		if (!map.containsKey(s) || !set.add(s)) {
			return -1;
		} else if (s.equals(t)) {
			return num;
		} else {
			Map<String, Double> next = map.get(s);
			for (String str : next.keySet()) {
				double result = this.dfs(str, t, num * next.get(str), map, set);
				if (result != -1) {
					return result;
				}
			}
			return -1;
		}
	}

	private static void print(double[] array) {
		for (int idx = 0; idx < array.length; idx++) {
			System.out.print(array[idx]);
			if (idx < array.length - 1) {
				System.out.print(", ");
			}
		}
		System.out.println();
	}

}
