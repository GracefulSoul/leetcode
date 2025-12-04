package gracefulsoul.problems;

public class CountCollisionsOnARoad {

	// https://leetcode.com/problems/count-collisions-on-a-road/submissions/1846664785/
	public static void main(String[] args) {
		CountCollisionsOnARoad test = new CountCollisionsOnARoad();
		System.out.println(test.countCollisions("RLRSLL"));
		System.out.println(test.countCollisions("LLRLRLLSLRLLSLSSSS"));
	}

	public int countCollisions(String directions) {
		char[] charArray = directions.toCharArray();
		int length = charArray.length;
		int i = 0;
		while (i < length && charArray[i] == 'L') {
			i++;
		}
		int j = directions.length() - 1;
		while (j >= 0 && charArray[j] == 'R') {
			j--;
		}
		int result = 0;
		for (int k = i; k <= j; k++) {
			if (charArray[k] != 'S') {
				result++;
			}
		}
		return result;
	}

}
