package gracefulsoul.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FindAllPossibleRecipesFromGivenSupplies {

	// https://leetcode.com/problems/find-all-possible-recipes-from-given-supplies/submissions/1581158035/
	public static void main(String[] args) {
		FindAllPossibleRecipesFromGivenSupplies test = new FindAllPossibleRecipesFromGivenSupplies();
		System.out.println(test.findAllRecipes(new String[] { "bread" }, Arrays.asList(
			Arrays.asList("yeast", "flour")
		), new String[] { "yeast", "flour", "corn" }));
		System.out.println(test.findAllRecipes(new String[] { "bread", "sandwich" }, Arrays.asList(
			Arrays.asList("yeast", "flour"),
			Arrays.asList("bread", "meat")
		), new String[] { "yeast", "flour", "corn" }));
		System.out.println(test.findAllRecipes(new String[] { "bread", "sandwich", "burger" }, Arrays.asList(
			Arrays.asList("yeast", "flour"),
			Arrays.asList("bread", "meat"),
			Arrays.asList("sandwich", "meat", "bread")
		), new String[] { "yeast", "flour", "meat" }));
	}

	public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
		Map<String, Integer> recipesMap = new HashMap<>();
		Set<String> set = new HashSet<>(Arrays.asList(supplies));
		int recipesLength = recipes.length;
		int[] dp = new int[recipesLength];
		for (int i = 0; i < recipesLength; i++) {
			recipesMap.put(recipes[i], i);
		}
		for (int i = 0; i < recipesLength; i++) {
			if (dp[i] == 0) {
				this.dfs(ingredients, set, recipesMap, i, dp);
			}
		}
		List<String> result = new ArrayList<>();
		for (int i = 0; i < recipesLength; i++) {
			if (dp[i] == 1) {
				result.add(recipes[i]);
			}
		}
		return result;
	}

	private boolean dfs(List<List<String>> ingredients, Set<String> suppliesSet, Map<String, Integer> recipesMap, int curr, int[] dp) {
		if (dp[curr] != 0) {
			return dp[curr] == 1;
		}
		dp[curr] = -1;
		for (String ingredient : ingredients.get(curr)) {
			if (!suppliesSet.contains(ingredient) && !(recipesMap.containsKey(ingredient) && this.dfs(ingredients, suppliesSet, recipesMap, recipesMap.get(ingredient), dp))) {
				return false;
			}
		}
		dp[curr] = 1;
		return true;
	}

}
