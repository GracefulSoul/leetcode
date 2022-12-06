package gracefulsoul.problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ContainVirus {

	// https://leetcode.com/problems/contain-virus/submissions/855335183/
	public static void main(String[] args) {
		ContainVirus test = new ContainVirus();
		System.out.println(test.containVirus(new int[][] {
			{ 0, 1, 0, 0, 0, 0, 0, 1 },
			{ 0, 1, 0, 0, 0, 0, 0, 1 },
			{ 0, 0, 0, 0, 0, 0, 0, 1 },
			{ 0, 0, 0, 0, 0, 0, 0, 0 }
		}));
		System.out.println(test.containVirus(new int[][] {
			{ 1, 1, 1 },
			{ 1, 0, 1 },
			{ 1, 1, 1 }
		}));
		System.out.println(test.containVirus(new int[][] {
			{ 1, 1, 1, 0, 0, 0, 0, 0, 0 },
			{ 1, 0, 1, 0, 1, 1, 1, 1, 1 },
			{ 1, 1, 1, 0, 0, 0, 0, 0, 0 }
		}));
	}

	public int containVirus(int[][] isInfected) {
		int rows = isInfected.length;
		int cols = isInfected[0].length;
		int result = 0;
		while (true) {
			List<Region> regions = new ArrayList<>();
			boolean[][] visited = new boolean[rows][cols];
			for (int i = 0; i < rows; i++) {
				for (int j = 0; j < cols; j++) {
					if (isInfected[i][j] == 1 && !visited[i][j]) {
						Region region = new Region();
						this.dfs(isInfected, rows, cols, i, j, region, visited);
						if (!region.uninfected.isEmpty()) {
							regions.add(region);
						}
					}
				}
			}
			if (regions.isEmpty()) {
				break;
			}
			Collections.sort(regions, (a, b) -> {
				return a.uninfected.size() - b.uninfected.size();
			});
			Region mostToBeInfected = regions.remove(regions.size() - 1);
			result += mostToBeInfected.wallNeeded;
			for (int x : mostToBeInfected.infected) {
				int i = x / cols, j = x % cols;
				isInfected[i][j] = 2;
			}
			for (Region region : regions) {
				for (int x : region.uninfected) {
					int i = x / cols, j = x % cols;
					isInfected[i][j] = 1;
				}
			}
		}
		return result;
	}

	private void dfs(int[][] grid, int rows, int cols, int i, int j, Region region, boolean[][] visited) {
		if (i < 0 || i == rows || j < 0 || j == cols) {
			return;
		} else if (grid[i][j] == 1 && !visited[i][j]) {
			visited[i][j] = true;
			region.infected.add(i * cols + j);
			this.dfs(grid, rows, cols, i - 1, j, region, visited);
			this.dfs(grid, rows, cols, i + 1, j, region, visited);
			this.dfs(grid, rows, cols, i, j - 1, region, visited);
			this.dfs(grid, rows, cols, i, j + 1, region, visited);
		} else if (grid[i][j] == 0) {
			region.wallNeeded += 1;
			region.uninfected.add(i * cols + j);
		}
	}

}

class Region {

	public int wallNeeded;
	public Set<Integer> infected;
	public Set<Integer> uninfected;

	public Region() {
		this.infected = new HashSet<>();
		this.uninfected = new HashSet<>();
	}

}
