package gracefulsoul.problems;

import java.util.Stack;
import java.util.TreeMap;

public class NumberOfAtoms {

	// https://leetcode.com/submissions/detail/843221770/
	public static void main(String[] args) {
		NumberOfAtoms test = new NumberOfAtoms();
		System.out.println(test.countOfAtoms("H2O"));
		System.out.println(test.countOfAtoms("Mg(OH)2"));
		System.out.println(test.countOfAtoms("K4(ON(SO3)2)2"));
	}

	public String countOfAtoms(String formula) {
		TreeMap<String, Integer> map = new TreeMap<>();
		Stack<TreeMap<String, Integer>> stack = new Stack<>();
		int i = 0;
		int length = formula.length();
		while (i < length) {
			if (formula.charAt(i) == '(') {
				stack.push(map);
				map = new TreeMap<>();
				i++;
			} else if (formula.charAt(i) == ')') {
				int val = 0;
				i++;
				while (i < formula.length() && Character.isDigit(formula.charAt(i))) {
					val = val * 10 + formula.charAt(i++) - '0';
				}
				if (val == 0) {
					val = 1;
				}
				if (!stack.isEmpty()) {
					TreeMap<String, Integer> temp = map;
					map = stack.pop();
					for (String atom : temp.keySet()) {
						map.put(atom, temp.get(atom) * val + map.getOrDefault(atom, 0));
					}
				}
			} else {
				int j = i + 1;
				while (j < formula.length() && Character.isLowerCase(formula.charAt(j))) {
					j++;
				}
				String str = formula.substring(i, j);
				int val = 0;
				while (j < formula.length() && Character.isDigit(formula.charAt(j))) {
					val = val * 10 + (formula.charAt(j++) - '0');
				}
				val = val == 0 ? 1 : val;
				map.put(str, map.getOrDefault(str, 0) + val);
				i = j;
			}
		}
		StringBuilder sb = new StringBuilder();
		for (String value : map.keySet()) {
			sb.append(value);
			sb.append(map.get(value) == 1 ? "" : map.get(value));
		}
		return sb.toString();
	}

}
