package gracefulsoul.problems;

public class CapacityToShipPackagesWithinDDays {

	// https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/submissions/1115409456/
	public static void main(String[] args) {
		CapacityToShipPackagesWithinDDays test = new CapacityToShipPackagesWithinDDays();
		System.out.println(test.shipWithinDays(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }, 5));
		System.out.println(test.shipWithinDays(new int[] { 3, 2, 2, 4, 1, 4 }, 3));
		System.out.println(test.shipWithinDays(new int[] { 1, 2, 3, 1, 1 }, 4));
	}

	public int shipWithinDays(int[] weights, int days) {
		int max = 0;
		int sum = 0;
		for (int weight : weights) {
			max = Math.max(max, weight);
			sum += weight;
		}
		while (max < sum) {
			int mid = max + ((sum - max) / 2);
			int count = 1;
			int curr = 0;
			for (int weight : weights) {
				if (curr + weight > mid) {
					count++;
					curr = 0;
				}
				curr += weight;
			}
			if (count > days) {
				max = mid + 1;
			} else {
				sum = mid;
			}
		}
		return max;
	}

}
