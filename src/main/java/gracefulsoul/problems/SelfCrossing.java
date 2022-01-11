package gracefulsoul.problems;

public class SelfCrossing {

	// https://leetcode.com/submissions/detail/617572069/
	public static void main(String[] args) {
		SelfCrossing test = new SelfCrossing();
		System.out.println(test.isSelfCrossing(new int[] { 2, 1, 1, 2 }));
		System.out.println(test.isSelfCrossing(new int[] { 1, 2, 3, 4 }));
		System.out.println(test.isSelfCrossing(new int[] { 1, 1, 1, 1 }));
	}

	public boolean isSelfCrossing(int[] distance) {
		int length = distance.length;
		if (length <= 3) {
			return false;
		}
		int idx = 2;
		while (idx < length && distance[idx] > distance[idx - 2]) {
			idx++;
		}
		if (idx >= length) {
			return false;
		}
		if ((idx >= 4 && distance[idx] >= distance[idx - 2] - distance[idx - 4]) ||
			(idx == 3 && distance[idx] == distance[idx - 2])) {
			distance[idx - 1] -= distance[idx - 3];
		}
		idx++;
		while (idx < length) {
			if (distance[idx] >= distance[idx - 2]) {
				return true;
			}
			idx++;
		}
		return false;
	}

}
