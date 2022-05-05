package gracefulsoul.object.solution.random.point;

import java.util.Random;

public class Solution {

	private double radius;
	private double x_center;
	private double y_center;
	private Random random;

	public Solution(double radius, double x_center, double y_center) {
		this.radius = radius;
		this.x_center = x_center;
		this.y_center = y_center;
		this.random = new Random();
	}

	public double[] randPoint() {
		double x = this.getCoordinate(this.x_center);
		double y = this.getCoordinate(this.y_center);
		while (this.getDistanceAboutCenter(x, y) >= this.radius * this.radius) {
			x = this.getCoordinate(this.x_center);
			y = this.getCoordinate(this.y_center);
		}
		return new double[] { x, y };
	}

	private double getDistanceAboutCenter(double x, double y) {
		double x_distance = this.x_center - x;
		double y_distance = this.y_center - y;
		return (x_distance * x_distance) + (y_distance * y_distance);
	}

	private double getCoordinate(double center) {
		return center - this.radius + (this.random.nextDouble() * 2 * this.radius);
	}

}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(radius, x_center, y_center);
 * double[] param_1 = obj.randPoint();
 */