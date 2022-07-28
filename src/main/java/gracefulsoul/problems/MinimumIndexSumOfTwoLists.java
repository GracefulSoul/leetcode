package gracefulsoul.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import gracefulsoul.util.PrintUtil;

public class MinimumIndexSumOfTwoLists {

	// https://leetcode.com/submissions/detail/758905194/
	public static void main(String[] args) {
		MinimumIndexSumOfTwoLists test = new MinimumIndexSumOfTwoLists();
		PrintUtil.print(test.findRestaurant(new String[] { "Shogun", "Tapioca Express", "Burger King", "KFC" }, new String[] { "Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun" }));
		PrintUtil.print(test.findRestaurant(new String[] { "Shogun", "Tapioca Express", "Burger King", "KFC" }, new String[] { "KFC", "Shogun", "Burger King" }));
	}

	public String[] findRestaurant(String[] list1, String[] list2) {
		Map<String, Integer> map = new HashMap<>();
		List<String> result = new ArrayList<>();
		int min = Integer.MAX_VALUE;
		for (int idx = 0; idx < list1.length; idx++) {
			map.put(list1[idx], idx);
		}
		for (int idx = 0; idx < list2.length && idx <= min; idx++) {
			if (map.containsKey(list2[idx])) {
				int sum = idx + map.get(list2[idx]);
				if (sum < min) {
					result.clear();
					result.add(list2[idx]);
					min = sum;
				} else if (sum == min) {
					result.add(list2[idx]);
				}
			}
		}
		return result.toArray(new String[result.size()]);
	}

}
