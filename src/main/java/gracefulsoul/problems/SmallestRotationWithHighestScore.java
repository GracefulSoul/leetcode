package gracefulsoul.problems;

public class SmallestRotationWithHighestScore {

	// https://leetcode.com/problems/smallest-rotation-with-highest-score/submissions/875384586/
	public static void main(String[] args) {
		SmallestRotationWithHighestScore test = new SmallestRotationWithHighestScore();
		System.out.println(test.bestRotation(new int[] { 2, 3, 1, 4, 0 }));
		System.out.println(test.bestRotation(new int[] { 1, 3, 0, 2, 4 }));
	}

	public int bestRotation(int[] nums) {
		int length = nums.length;
		int change[] = new int[length];
		for (int idx = 0; idx < length; idx++) {
			change[(idx - nums[idx] + 1 + length) % length]--;
		}
		int rotation = 0;
		for (int idx = 1; idx < length; idx++) {
			change[idx] += change[idx - 1] + 1;
			rotation = change[idx] > change[rotation] ? idx : rotation;
		}
		return rotation;
	}

}
