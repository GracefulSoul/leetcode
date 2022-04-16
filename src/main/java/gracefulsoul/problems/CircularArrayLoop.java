package gracefulsoul.problems;

public class CircularArrayLoop {

	// https://leetcode.com/submissions/detail/681215406/
	public static void main(String[] args) {
		CircularArrayLoop test = new CircularArrayLoop();
		System.out.println(test.circularArrayLoop(new int[] { 2, -1, 1, 2, 2 }));
		System.out.println(test.circularArrayLoop(new int[] { -1, 2 }));
		System.out.println(test.circularArrayLoop(new int[] { -2, 1, -1, -2, -2 }));
	}

	public boolean circularArrayLoop(int[] nums) {
		int[] visited = new int[nums.length];
		for (int idx = 0; idx < nums.length; idx++) {
			if (visited[idx] == 0 && this.dfs(nums, visited, idx)) {
				return true;
			}
		}
		return false;
	}

	private boolean dfs(int[] nums, int[] visited, int start) {
		if (visited[start] == 2) {
			return false;
		}
		visited[start] = 1;
		int next = ((start + nums[start]) % nums.length + nums.length) % nums.length;
		if (next == start || nums[next] * nums[start] < 0) {
			visited[start] = 2;
			return false;
		} else if (visited[next] == 1) {
			visited[start] = 2;
			return true;
		} else if (this.dfs(nums, visited, next)) {
			return true;
		} else {
			visited[start] = 2;
			return false;
		}
	}

}
