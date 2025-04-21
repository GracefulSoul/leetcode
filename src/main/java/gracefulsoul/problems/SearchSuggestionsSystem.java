package gracefulsoul.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SearchSuggestionsSystem {

	// https://leetcode.com/problems/search-suggestions-system/submissions/1612230744/
	public static void main(String[] args) {
		SearchSuggestionsSystem test = new SearchSuggestionsSystem();
		System.out.println(test.suggestedProducts(new String[] { "mobile", "mouse", "moneypot", "monitor", "mousepad" }, "mouse"));
		System.out.println(test.suggestedProducts(new String[] { "havana" }, "havana"));
	}

	public List<List<String>> suggestedProducts(String[] products, String searchWord) {
		Arrays.sort(products);
		StringBuilder sb = new StringBuilder();
		List<List<String>> result = new ArrayList<>();
		for (char c : searchWord.toCharArray()) {
			sb.append(c);
			String prefix = sb.toString();
			int index = Arrays.binarySearch(products, prefix);
			if (index < 0) {
				index = -index - 1;
			}
			List<String> list = new ArrayList<>();
			for (int j = index; list.size() < 3 && j < products.length && products[j].startsWith(prefix); j++) {
				list.add(products[j]);
			}
			result.add(list);
		}
		return result;
	}

}
