package gracefulsoul.problems;

public class TrappingRainWater {

	// https://leetcode.com/submissions/detail/497010956/
	public static void main(String[] args) {
		TrappingRainWater test = new TrappingRainWater();
		System.out.println(test.trap(new int[] {0,1,0,2,1,0,1,3,2,1,2,1}));
		System.out.println(test.trap(new int[] {4,2,0,3,2,5}));
	}
	
    public int trap(int[] height) {
    	int result = 0;
    	if (height == null || height.length == 0) {
    		return result;
    	}
        int left = 0;
        int right = height.length - 1;
    	int leftMax = -1;
    	int rightMax = -1;
    	while (left < right) {
        	leftMax = Math.max(leftMax, height[left]);
        	rightMax = Math.max(rightMax, height[right]);
        	if (leftMax < rightMax) {
        		result += leftMax - height[left];
        		left++;
        	} else {
        		result += rightMax - height[right];
        		right--;
        	}
        }
    	return result;
    }

}
