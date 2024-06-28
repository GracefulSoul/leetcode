package gracefulsoul.problems;

public class FindCenterOfStarGraph {

	// https://leetcode.com/problems/find-center-of-star-graph/submissions/1301864472/
	public static void main(String[] args) {
		FindCenterOfStarGraph test = new FindCenterOfStarGraph();
		System.out.println(test.findCenter(new int[][] {
			{ 1, 2 },
			{ 2, 3 },
			{ 4, 2 }
		}));
		System.out.println(test.findCenter(new int[][] {
			{ 1, 2 },
			{ 5, 1 },
			{ 1, 3 },
			{ 1, 4 }
		}));
	}

	public int findCenter(int[][] edges) {
		return edges[0][0] == edges[1][0] || edges[0][0] == edges[1][1] ? edges[0][0] : edges[0][1];
	}

}
