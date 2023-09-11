package gracefulsoul.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupThePeopleGivenTheGroupSizeTheyBelongTo {

	// https://leetcode.com/problems/group-the-people-given-the-group-size-they-belong-to/submissions/1046389823/
	public static void main(String[] args) {
		GroupThePeopleGivenTheGroupSizeTheyBelongTo test = new GroupThePeopleGivenTheGroupSizeTheyBelongTo();
		System.out.println(test.groupThePeople(new int[] { 3, 3, 3, 3, 3, 1, 3 }));
		System.out.println(test.groupThePeople(new int[] { 2, 1, 3, 3, 3, 2 }));
	}

	public List<List<Integer>> groupThePeople(int[] groupSizes) {
		List<List<Integer>> result = new ArrayList<>();
		Map<Integer, List<Integer>> groups = new HashMap<>();
		for (int i = 0; i < groupSizes.length; i++) {
			List<Integer> list = groups.computeIfAbsent(groupSizes[i], k -> new ArrayList<>());
			list.add(i);
			if (list.size() == groupSizes[i]) {
				result.add(list);
				groups.put(groupSizes[i], new ArrayList<>());
			}
		}
		return result;
	}

}
