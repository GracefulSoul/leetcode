package gracefulsoul.problems;

import java.util.Arrays;

import gracefulsoul.util.PrintUtil;

public class PowerGridMaintenance {

	// https://leetcode.com/problems/power-grid-maintenance/submissions/1822288521/
	public static void main(String[] args) {
		PowerGridMaintenance test = new PowerGridMaintenance();
		PrintUtil.print(test.processQueries(5, new int[][] {
			{ 1, 2 },
			{ 2, 3 },
			{ 3, 4 },
			{ 4, 5 }
		}, new int[][] {
			{ 1, 3 },
			{ 2, 1 },
			{ 1, 1 },
			{ 2, 2 },
			{ 1, 2 }
		}));
		PrintUtil.print(test.processQueries(5, new int[][] {
		}, new int[][] {
			{ 1, 1 },
			{ 2, 1 },
			{ 1, 1 }
		}));
	}

	public int[] processQueries(int n, int[][] connections, int[][] queries) {
		int[] labels = new int[++n];
		for (int i = 1; i < n; i++) {
			labels[i] = i;
		}
		for (int[] connection : connections) {
			labels[this.getLabel(labels, connection[0])] = labels[this.getLabel(labels, connection[1])];
		}
		final int[] counts = new int[n];
		for (int i = 0; i < n; i++) {
			counts[this.getLabel(labels, i)]++;
		}
		this.updateCounts(counts);
		int[] starts = counts.clone();
		int[] sorted = new int[n];
		for (int i = 0; i < n; i++) {
			sorted[counts[labels[i]]++] = i;
		}
		int[] result = new int[queries.length];
		int index = 0;
		boolean[] offline = new boolean[n];
		for (int[] query : queries) {
			int x = query[1];
			if (query[0] == 1) {
				if (offline[x]) {
					int label = labels[x];
					int start = starts[label];
					int end = counts[label];
					while (start < end && offline[sorted[start]]) {
						start++;
					}
					starts[label] = start;
					result[index++] = start == end ? -1 : sorted[start];
				} else {
					result[index++] = x;
				}
			} else {
				offline[x] = true;
			}
		}
		return Arrays.copyOf(result, index);
	}

	private void updateCounts(int[] counts) {
		int sum = 0;
		for (int i = 0; i < counts.length; i++) {
			int temp = sum + counts[i];
			counts[i] = sum;
			sum = temp;
		}
	}

	private int getLabel(int[] labels, int i) {
		int current = labels[i];
		if (current == i || current < 0) {
			return i;
		} else {
			labels[i] = this.getLabel(labels, current);
			return labels[i];
		}
	}

}
