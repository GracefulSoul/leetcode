package gracefulsoul.problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class DesignTaskManager {

	// https://leetcode.com/problems/design-task-manager/submissions/1774792298/
	public static void main(String[] args) {
		TaskManager taskManager = new TaskManager(Arrays.asList(
				Arrays.asList(1, 101, 10),
				Arrays.asList(2, 102, 20),
				Arrays.asList(3, 103, 15)));		// Initializes with three tasks for Users 1, 2, and 3.
		taskManager.add(4, 104, 5);					// Adds task 104 with priority 5 for User 4.
		taskManager.edit(102, 8);					// Updates priority of task 102 to 8.
		System.out.println(taskManager.execTop());	// return 3. Executes task 103 for User 3.
		taskManager.rmv(101);						// Removes task 101 from the system.
		taskManager.add(5, 105, 15);				// Adds task 105 with priority 15 for User 5.
		System.out.println(taskManager.execTop());	// return 5. Executes task 105 for User 5.
	}

}

class TaskManager {

	private final TreeMap<Task, Integer> treeMap;
	private final Map<Integer, Task> taskMap;

	public TaskManager(List<List<Integer>> tasks) {
		this.treeMap = new TreeMap<>();
		this.taskMap = new HashMap<>();
		for (List<Integer> task : tasks) {
			this.add(task.get(0), task.get(1), task.get(2));
		}
	}

	public void add(int userId, int taskId, int priority) {
		Task task = new Task(userId, taskId, priority);
		this.treeMap.put(task, userId);
		this.taskMap.put(taskId, task);
	}

	public void edit(int taskId, int newPriority) {
		Task task = this.taskMap.get(taskId);
		if (task != null) {
			this.treeMap.remove(task);
			task.setPriority(newPriority);
			this.treeMap.put(task, task.getUserId());
		}
	}

	public void rmv(int taskId) {
		Task task = this.taskMap.get(taskId);
		if (task != null) {
			this.treeMap.remove(task);
			this.taskMap.remove(taskId);
		}
	}

	public int execTop() {
		if (this.treeMap.isEmpty()) {
			return -1;
		} else {
			Task task = this.treeMap.firstKey();
			this.treeMap.remove(task);
			this.taskMap.remove(task.getTaskId());
			return task.getUserId();
		}
	}

}

class Task implements Comparable<Task> {

	private int userId;
	private int taskId;
	private int priority;

	Task(int userId, int taskId, int priority) {
		this.userId = userId;
		this.taskId = taskId;
		this.priority = priority;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getTaskId() {
		return taskId;
	}

	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	@Override
	public int compareTo(Task task) {
		return this.priority == task.priority ? task.taskId - this.taskId : task.priority - this.priority;
	}

}
/**
 * Your TaskManager object will be instantiated and called as such:
 * TaskManager obj = new TaskManager(tasks);
 * obj.add(userId,taskId,priority);
 * obj.edit(taskId,newPriority);
 * obj.rmv(taskId);
 * int param_4 = obj.execTop();
 */