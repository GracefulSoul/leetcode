package gracefulsoul.problems;

public class FurthestPointFromOrigin {

	// https://leetcode.com/problems/furthest-point-from-origin/submissions/1986876813/
	public static void main(String[] args) {
		FurthestPointFromOrigin test = new FurthestPointFromOrigin();
		System.out.println(test.furthestDistanceFromOrigin("L_RL__R"));
		System.out.println(test.furthestDistanceFromOrigin("_R__LL_"));
		System.out.println(test.furthestDistanceFromOrigin("_______"));
	}

	public int furthestDistanceFromOrigin(String moves) {
		int[] counts = new int[3];
		for (char move : moves.toCharArray()) {
			switch (move) {
				case 'L':
					counts[0]++;
					break;
				case 'R':
					counts[1]++;
					break;
				default:
					counts[2]++;
			}
		}
		if (counts[0] < counts[1]) {
			return counts[1] - counts[0] + counts[2];
		} else {
			return counts[0] - counts[1] + counts[2];
		}
	}

}
