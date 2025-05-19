package gracefulsoul.problems;

public class TypeOfTriangle {

	// https://leetcode.com/problems/type-of-triangle/submissions/1638149520/
	public static void main(String[] args) {
		TypeOfTriangle test = new TypeOfTriangle();
		System.out.println(test.triangleType(new int[] { 3, 3, 3 }));
		System.out.println(test.triangleType(new int[] { 3, 4, 5 }));
	}

	public String triangleType(int[] nums) {
		if (nums[0] + nums[1] <= nums[2] || nums[0] + nums[2] <= nums[1] || nums[1] + nums[2] <= nums[0]) {
			return "none";
		} else if (nums[0] == nums[1] && nums[1] == nums[2]) {
			return "equilateral";
		} else if (nums[0] == nums[1] || nums[1] == nums[2] || nums[0] == nums[2]) {
			return "isosceles";
		} else {
			return "scalene";
		}
	}

}
