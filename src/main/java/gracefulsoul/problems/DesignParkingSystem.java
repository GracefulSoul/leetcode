package gracefulsoul.problems;

public class DesignParkingSystem {

	// https://leetcode.com/problems/design-parking-system/submissions/959369833/
	public static void main(String[] args) {
		ParkingSystem parkingSystem = new ParkingSystem(1, 1, 0);
		System.out.println(parkingSystem.addCar(1)); // return true because there is 1 available slot for a big car
		System.out.println(parkingSystem.addCar(2)); // return true because there is 1 available slot for a medium car
		System.out.println(parkingSystem.addCar(3)); // return false because there is no available slot for a small car
		System.out.println(parkingSystem.addCar(1)); // return false because there is no available slot for a big car. It is already occupied.
	}

}

class ParkingSystem {

	private int[] count;

	public ParkingSystem(int big, int medium, int small) {
		this.count = new int[] { big, medium, small };
	}

	public boolean addCar(int carType) {
		return this.count[carType - 1]-- > 0;
	}

}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */