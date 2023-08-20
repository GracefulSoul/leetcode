package gracefulsoul.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import gracefulsoul.util.PrintUtil;

public class SortItemsByGroupsRespectingDependencies {

	// https://leetcode.com/problems/sort-items-by-groups-respecting-dependencies/submissions/1026241879/
	public static void main(String[] args) {
		SortItemsByGroupsRespectingDependencies test = new SortItemsByGroupsRespectingDependencies();
		PrintUtil.print(test.sortItems(8, 2, new int[] { -1, -1, 1, 0, 0, 1, 0, -1 }, Arrays.asList(
			Arrays.asList(),
			Arrays.asList(6),
			Arrays.asList(5),
			Arrays.asList(6),
			Arrays.asList(3, 6),
			Arrays.asList(),
			Arrays.asList(),
			Arrays.asList()
		)));
		PrintUtil.print(test.sortItems(8, 2, new int[] { -1, -1, 1, 0, 0, 1, 0, -1 }, Arrays.asList(
			Arrays.asList(),
			Arrays.asList(6),
			Arrays.asList(5),
			Arrays.asList(6),
			Arrays.asList(3),
			Arrays.asList(),
			Arrays.asList(4),
			Arrays.asList()
		)));
	}

	private List<Integer>[] groups;
	private List<Integer>[] graph;
	private int[] indegrees;
	private int[] indegreeGroups;

	public int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {
		this.buildGroups(n, group);
		this.buildGraph(n, beforeItems, group);
		int[] result = new int[n];
		int top = 0;
		Queue<Integer> queue = new LinkedList<>();
		for (int i = 0; i < this.indegreeGroups.length; i++) {
			if (this.indegreeGroups[i] == 0) {
				queue.add(i);
			}
		}
		while (!queue.isEmpty()) {
			Integer groupId = queue.poll();
			List<Integer> groupItems = this.groups[groupId];
			if (groupItems == null)
				continue;
			Queue<Integer> itemQueue = new LinkedList<>();
			for (int item : groupItems) {
				if (this.indegrees[item] == 0) {
					itemQueue.add(item);
				}
			}
			while (!itemQueue.isEmpty()) {
				Integer item = itemQueue.poll();
				result[top++] = item;
				if (this.graph[item] == null) {
					continue;
				}
				for (Integer itm : this.graph[item]) {
					this.indegrees[itm]--;
					if (group[itm] != groupId) {
						if (--this.indegreeGroups[group[itm]] == 0) {
							queue.offer(group[itm]);
						}
					} else if (this.indegrees[itm] == 0) {
						itemQueue.offer(itm);
					}
				}
			}
		}
		return top < n - 1 ? new int[] {} : result;
	}

	@SuppressWarnings("unchecked")
	private void buildGroups(int n, int[] group) {
		this.groups = new List[n];
		int index = n - 1;
		for (int i = 0; i < group.length; i++) {
			if (group[i] == -1) {
				group[i] = index--;
			}
			if (this.groups[group[i]] == null) {
				this.groups[group[i]] = new ArrayList<Integer>();
			}
			this.groups[group[i]].add(i);
		}
	}

	@SuppressWarnings("unchecked")
	private void buildGraph(int n, List<List<Integer>> beforeItems, int[] group) {
		this.graph = new List[n];
		this.indegrees = new int[n];
		this.indegreeGroups = new int[n];
		for (int i = 0; i < n; i++) {
			for (int item : beforeItems.get(i)) {
				if (this.graph[item] == null) {
					this.graph[item] = new ArrayList<>();
				}
				this.graph[item].add(i);
				this.indegrees[i]++;
				if (group[i] != group[item]) {
					this.indegreeGroups[group[i]]++;
				}
			}
		}
	}

}
