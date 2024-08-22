package gracefulsoul.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InvalidTransactions {

	// https://leetcode.com/problems/invalid-transactions/submissions/1364422756/
	public static void main(String[] args) {
		InvalidTransactions test = new InvalidTransactions();
		System.out.println(test.invalidTransactions(new String[] { "alice,20,800,mtv", "alice,50,100,beijing" }));
		System.out.println(test.invalidTransactions(new String[] { "alice,20,800,mtv", "alice,50,1200,mtv" }));
		System.out.println(test.invalidTransactions(new String[] { "alice,20,800,mtv", "bob,50,1200,mtv" }));
	}

	public List<String> invalidTransactions(String[] transactions) {
		Map<String, List<String[]>> map = new HashMap<>();
		for (String transaction : transactions) {
			String[] split = transaction.split(",");
			map.putIfAbsent(split[0], new ArrayList<>());
			map.get(split[0]).add(split);
		}
		List<String> result = new ArrayList<>();
		for (String transaction : transactions) {
			String[] split = transaction.split(",");
			if (Integer.parseInt(split[2]) > 1000) {
				result.add(transaction);
			} else {
				for (String[] curr : map.get(split[0])) {
					if (Math.abs(Integer.parseInt(split[1]) - Integer.parseInt(curr[1])) <= 60 && !split[3].equals(curr[3])) {
						result.add(transaction);
						break;
					}
				}
			}
		}
		return result;
	}

}
