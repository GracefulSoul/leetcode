package gracefulsoul.problems;

import java.util.Arrays;

import gracefulsoul.util.PrintUtil;

public class AsteroidCollision {

	// https://leetcode.com/submissions/detail/849056551/
	public static void main(String[] args) {
		AsteroidCollision test = new AsteroidCollision();
		PrintUtil.print(test.asteroidCollision(new int[] { 5, 10, -5 }));
		PrintUtil.print(test.asteroidCollision(new int[] { 8, -8 }));
		PrintUtil.print(test.asteroidCollision(new int[] { 10, 2, -5 }));
	}

	public int[] asteroidCollision(int[] asteroids) {
		int index = -1;
		for (int asteroid : asteroids) {
			boolean alive = true;
			while (alive && asteroid < 0 && index >= 0 && asteroids[index] > 0) {
				alive = asteroids[index] + asteroid < 0;
				if (asteroids[index] + asteroid <= 0) {
					index--;
				}
			}
			if (alive) {
				asteroids[++index] = asteroid;
			}
		}
		return Arrays.copyOf(asteroids, index + 1);
	}

}
