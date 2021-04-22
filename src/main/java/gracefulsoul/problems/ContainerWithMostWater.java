package gracefulsoul.problems;

public class ContainerWithMostWater {

	// https://leetcode.com/submissions/detail/482578956/
	public static void main(String[] args) {
		ContainerWithMostWater test = new ContainerWithMostWater();
		System.out.println(test.maxArea(new int[] { 1, 8, 6, 2, 5, 4, 8, 3, 7 }));
		System.out.println(test.maxArea(new int[] { 1, 1 }));
		System.out.println(test.maxArea(new int[] { 4, 3, 2, 1, 4 }));
		System.out.println(test.maxArea(new int[] { 1, 2, 1 }));
		System.out.println(test.maxArea(new int[] { 2, 3, 4, 5, 18, 17, 6 }));
		System.out.println(test.maxArea(new int[] { 1, 8, 6, 2, 5, 4, 8, 25, 7 }));
	}

	public int maxArea(int[] height) {
		int start = 0;
		int end = height.length - 1;
		int max = 0;
		while (start < end) {
			max = Math.max(max, Math.min(height[start], height[end]) * (end - start));
			if (height[start] < height[end]) {
				start++;
			} else {
				end--;
			}
		}
		return max;
	}

}
