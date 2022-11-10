package gracefulsoul.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

public class AccountsMerge {

	// https://leetcode.com/submissions/detail/840768935/
	public static void main(String[] args) {
		AccountsMerge test = new AccountsMerge();
		System.out.println(test.accountsMerge(Arrays.asList(
				Arrays.asList("John","johnsmith@mail.com","john_newyork@mail.com"),
				Arrays.asList("John","johnsmith@mail.com","john00@mail.com"),
				Arrays.asList("Mary","mary@mail.com"),
				Arrays.asList("John","johnnybravo@mail.com")
		)));
		System.out.println(test.accountsMerge(Arrays.asList(
				Arrays.asList("Gabe","Gabe0@m.co","Gabe3@m.co","Gabe1@m.co"),
				Arrays.asList("Kevin","Kevin3@m.co","Kevin5@m.co","Kevin0@m.co"),
				Arrays.asList("Ethan","Ethan5@m.co","Ethan4@m.co","Ethan0@m.co"),
				Arrays.asList("Hanzo","Hanzo3@m.co","Hanzo1@m.co","Hanzo0@m.co"),
				Arrays.asList("Fern","Fern5@m.co","Fern1@m.co","Fern0@m.co")
		)));
	}

	public List<List<String>> accountsMerge(List<List<String>> acts) {
		Map<String, String> owner = new HashMap<>();
		Map<String, String> parents = new HashMap<>();
		Map<String, TreeSet<String>> unions = new HashMap<>();
		for (List<String> a : acts) {
			for (int i = 1; i < a.size(); i++) {
				parents.put(a.get(i), a.get(i));
				owner.put(a.get(i), a.get(0));
			}
		}
		for (List<String> act : acts) {
			String parent = this.find(act.get(1), parents);
			for (int i = 2; i < act.size(); i++)
				parents.put(this.find(act.get(i), parents), parent);
		}
		for (List<String> act : acts) {
			String parent = this.find(act.get(1), parents);
			if (!unions.containsKey(parent))
				unions.put(parent, new TreeSet<>());
			for (int i = 1; i < act.size(); i++)
				unions.get(parent).add(act.get(i));
		}
		List<List<String>> result = new ArrayList<>();
		for (String key : unions.keySet()) {
			List<String> emails = new ArrayList<>(unions.get(key));
			emails.add(0, owner.get(key));
			result.add(emails);
		}
		return result;
	}

	private String find(String s, Map<String, String> p) {
		return p.get(s) == s ? s : find(p.get(s), p);
	}

}
