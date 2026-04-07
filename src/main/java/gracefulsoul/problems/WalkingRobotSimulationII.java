package gracefulsoul.problems;

import gracefulsoul.util.PrintUtil;

public class WalkingRobotSimulationII {

	// https://leetcode.com/problems/walking-robot-simulation-ii/submissions/1971484998/
	public static void main(String[] args) {
		Robot robot = new Robot(6, 3);		// Initialize the grid and the robot at (0, 0) facing East.
		robot.step(2);						// It moves two steps East to (2, 0), and faces East.
		robot.step(2);						// It moves two steps East to (4, 0), and faces East.
		PrintUtil.print(robot.getPos());	// return [4, 0]
		System.out.println(robot.getDir());	// return "East"
		robot.step(2);						// It moves one step East to (5, 0), and faces East.
											// Moving the next step East would be out of bounds, so it turns and faces North.
											// Then, it moves one step North to (5, 1), and faces North.
		robot.step(1);						// It moves one step North to (5, 2), and faces North (not West).
		robot.step(4);						// Moving the next step North would be out of bounds, so it turns and faces West.
											// Then, it moves four steps West to (1, 2), and faces West.
		PrintUtil.print(robot.getPos());	// return [1, 2]
		System.out.println(robot.getDir());	// return "West"
	}

}

class Robot {

	private int width;
	private int height;
	private int[] position;
	private String direction;

	public Robot(int width, int height) {
		this.width = width;
		this.height = height;
		this.position = new int[2];
		this.direction = "East";
	}

	public void step(int num) {
		int perimeter = (this.width * 2) + (this.height * 2) - 4;
		num %= perimeter;
		if (num == 0) {
			num = perimeter;
		}
		for (int i = 0; i < num; i++) {
			switch (this.direction) {
				case "East":
					if (this.position[0] == this.width - 1) {
						this.direction = "North";
						this.position[1]++;
					} else {
						this.position[0]++;
					}
					break;
				case "North":
					if (this.position[1] == this.height - 1) {
						this.direction = "West";
						this.position[0]--;
					} else {
						this.position[1]++;
					}
					break;
				case "West":
					if (this.position[0] == 0) {
						this.direction = "South";
						this.position[1]--;
					} else {
						this.position[0]--;
					}
					break;
				case "South":
					if (this.position[1] == 0) {
						this.direction = "East";
						this.position[0]++;
					} else {
						this.position[1]--;
					}
					break;
			}
		}
	}

	public int[] getPos() {
		return this.position;
	}

	public String getDir() {
		return this.direction;
	}

}

/**
 * Your Robot object will be instantiated and called as such:
 * Robot obj = new Robot(width, height);
 * obj.step(num);
 * int[] param_2 = obj.getPos();
 * String param_3 = obj.getDir();
 */