package gracefulsoul.problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BasicCalculatorIV {

	// https://leetcode.com/problems/basic-calculator-iv/submissions/862486650/
	public static void main(String[] args) {
		BasicCalculatorIV test = new BasicCalculatorIV();
		System.out.println(test.basicCalculatorIV("e + 8 - a + 5", new String[] { "e" }, new int[] { 1 }));
		System.out.println(test.basicCalculatorIV("e - 8 + temperature - pressure", new String[] { "e", "temperature" }, new int[] { 1, 12 }));
		System.out.println(test.basicCalculatorIV("(e + 8) * (e - 8)", new String[] {}, new int[] {}));
	}

	public List<String> basicCalculatorIV(String expression, String[] evalVars, int[] evalInts) {
		Map<String, Integer> evalMap = new HashMap<>();
		for (int i = 0; i < evalVars.length; i++) {
			evalMap.put(evalVars[i], evalInts[i]);
		}
		return this.parse(expression).evaluate(evalMap).toList();
	}

	public Poly make(String expression) {
		Poly poly = new Poly();
		List<String> list = new ArrayList<>();
		if (Character.isDigit(expression.charAt(0))) {
			poly.update(list, Integer.valueOf(expression));
		} else {
			list.add(expression);
			poly.update(list, 1);
		}
		return poly;
	}

	public Poly combine(Poly left, Poly right, char symbol) {
		switch (symbol) {
			case '+':
				return left.add(right);
			case '-':
				return left.sub(right);
			case '*':
				return left.mul(right);
			default:
				return null;
		}
	}

	public Poly parse(String expression) {
		List<Poly> bucket = new ArrayList<>();
		List<Character> symbols = new ArrayList<>();
		int i = 0;
		while (i < expression.length()) {
			if (expression.charAt(i) == '(') {
				int bal = 0, j = i;
				for (; j < expression.length(); j++) {
					if (expression.charAt(j) == '(')
						bal++;
					if (expression.charAt(j) == ')')
						bal--;
					if (bal == 0)
						break;
				}
				bucket.add(parse(expression.substring(i + 1, j)));
				i = j;
			} else if (Character.isLetterOrDigit(expression.charAt(i))) {
				int j = i;
				search: {
					for (; j < expression.length(); j++)
						if (expression.charAt(j) == ' ') {
							bucket.add(make(expression.substring(i, j)));
							break search;
						}
					bucket.add(make(expression.substring(i)));
				}
				i = j;
			} else if (expression.charAt(i) != ' ') {
				symbols.add(expression.charAt(i));
			}
			i++;
		}

		for (int j = symbols.size() - 1; j >= 0; j--) {
			if (symbols.get(j) == '*') {
				bucket.set(j, combine(bucket.get(j), bucket.remove(j + 1), symbols.remove(j)));
			}
		}
		if (bucket.isEmpty()) {
			return new Poly();
		}
		Poly poly = bucket.get(0);
		for (int j = 0; j < symbols.size(); j++) {
			poly = this.combine(poly, bucket.get(j + 1), symbols.get(j));
		}
		return poly;
	}
}

class Poly {

	private Map<List<String>, Integer> map;

	Poly() {
		this.map = new HashMap<>();
	}

	@Override
	public String toString() {
		return this.map.toString();
	}

	public void update(List<String> key, int val) {
		this.map.put(key, this.map.getOrDefault(key, 0) + val);
	}

	public Poly add(Poly that) {
		Poly poly = new Poly();
		for (List<String> key : this.map.keySet()) {
			poly.update(key, this.map.get(key));
		}
		for (List<String> key : that.map.keySet()) {
			poly.update(key, that.map.get(key));
		}
		return poly;
	}

	public Poly sub(Poly that) {
		Poly poly = new Poly();
		for (List<String> key : this.map.keySet()) {
			poly.update(key, this.map.get(key));
		}
		for (List<String> key : that.map.keySet()) {
			poly.update(key, -that.map.get(key));
		}
		return poly;
	}

	public Poly mul(Poly poly) {
		Poly newPoly = new Poly();
		for (List<String> thisKeySet : this.map.keySet())
			for (List<String> keySet : poly.map.keySet()) {
				List<String> list = new ArrayList<>();
				for (String key : thisKeySet) {
					list.add(key);
				}
				for (String key : keySet) {
					list.add(key);
				}
				list.sort(Comparator.naturalOrder());
				newPoly.update(list, this.map.get(thisKeySet) * poly.map.get(keySet));
			}
		return newPoly;
	}

	public Poly evaluate(Map<String, Integer> map) {
		Poly poly = new Poly();
		for (List<String> key : this.map.keySet()) {
			int value = this.map.get(key);
			List<String> list = new ArrayList<>();
			for (String token : key) {
				if (map.containsKey(token)) {
					value *= map.get(token);
				} else {
					list.add(token);
				}
			}
			poly.update(list, value);
		}
		return poly;
	}

	public int compareList(List<String> a, List<String> b) {
		int i = 0;
		for (String x : a) {
			String y = b.get(i++);
			if (x.compareTo(y) != 0) {
				return x.compareTo(y);
			}
		}
		return 0;
	}

	public List<String> toList() {
		List<String> list = new ArrayList<>();
		List<List<String>> keys = new ArrayList<>(this.map.keySet());
		Collections.sort(keys, (a, b) -> a.size() != b.size() ? b.size() - a.size() : compareList(a, b));
		for (List<String> key : keys) {
			int value = this.map.get(key);
			if (value == 0) {
				continue;
			}
			StringBuilder sb = new StringBuilder();
			sb.append(value);
			for (String token : key) {
				sb.append('*');
				sb.append(token);
			}
			list.add(sb.toString());
		}
		return list;
	}

}
