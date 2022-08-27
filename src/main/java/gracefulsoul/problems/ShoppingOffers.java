package gracefulsoul.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ShoppingOffers {

	// https://leetcode.com/submissions/detail/784371697/
	public static void main(String[] args) {
		ShoppingOffers test = new ShoppingOffers();
		System.out.println(test.shoppingOffers(Arrays.asList(2, 5), Arrays.asList(Arrays.asList(3, 0, 5), Arrays.asList(1, 2, 10)), Arrays.asList(3, 2)));
		System.out.println(test.shoppingOffers(Arrays.asList(2, 3, 4), Arrays.asList(Arrays.asList(1, 1, 0, 4), Arrays.asList(2, 2, 1, 9)), Arrays.asList(1, 2, 1)));
	}

	private int min;

	public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
		min = this.buyWithoutOffer(price, needs);
		this.dfs(price, special, needs, 0, 0);
		return min;
	}

	private void dfs(List<Integer> price, List<List<Integer>> special, List<Integer> needs, int index, int curr) {
		if (curr > min)
			return;
		if (index == special.size()) {
			curr += this.buyWithoutOffer(price, needs);
			if (curr < min) {
				min = curr;
			}
			return;
		}
		List<Integer> curOffer = special.get(index);
		if (this.isValid(curOffer, needs)) {
			List<Integer> updateNeeds = new ArrayList<>();
			for (int i = 0; i < needs.size(); i++) {
				updateNeeds.add(needs.get(i) - curOffer.get(i));
			}
			this.dfs(price, special, updateNeeds, index, curr + curOffer.get(curOffer.size() - 1));
		}
		this.dfs(price, special, needs, index + 1, curr);
	}

	private boolean isValid(List<Integer> curOffer, List<Integer> needs) {
		for (int idx = 0; idx < needs.size(); idx++) {
			if (needs.get(idx) < curOffer.get(idx)) {
				return false;
			}
		}
		return true;
	}

	private int buyWithoutOffer(List<Integer> price, List<Integer> needs) {
		int total = 0;
		for (int idx = 0; idx < needs.size(); idx++) {
			total += price.get(idx) * needs.get(idx);
		}
		return total;
	}

}
