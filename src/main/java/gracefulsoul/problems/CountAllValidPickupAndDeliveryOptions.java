package gracefulsoul.problems;

public class CountAllValidPickupAndDeliveryOptions {

	// https://leetcode.com/problems/count-all-valid-pickup-and-delivery-options/submissions/1045413412/
	public static void main(String[] args) {
		CountAllValidPickupAndDeliveryOptions test = new CountAllValidPickupAndDeliveryOptions();
		System.out.println(test.countOrders(1));
		System.out.println(test.countOrders(2));
		System.out.println(test.countOrders(3));
	}

	public int countOrders(int n) {
		long result = 1;
		long mod = (long) 1e9 + 7;
		for (int i = 1; i <= n; i++) {
			result = (result * (i * 2 - 1) * i) % mod;
		}
		return (int) result;
	}

}
