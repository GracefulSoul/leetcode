package gracefulsoul.problems;

import java.util.Arrays;

public class DestroyingAsteroids {

	// https://leetcode.com/problems/destroying-asteroids/submissions/2018000558/
	public static void main(String[] args) {
		DestroyingAsteroids test = new DestroyingAsteroids();
		System.out.println(test.asteroidsDestroyed(10, new int[] { 3, 9, 19, 5, 21 }));
		System.out.println(test.asteroidsDestroyed(5, new int[] { 4, 9, 23, 4 }));

	}

	public boolean asteroidsDestroyed(int mass, int[] asteroids) {
		Arrays.sort(asteroids);
		for (int asteroid : asteroids) {
			if (mass < asteroid) {
				return false;
			} else if (100000 < mass) {
				return true;
			}
			mass += asteroid;
		}
		return true;
	}

}
