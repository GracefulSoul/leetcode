package gracefulsoul.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import gracefulsoul.object.Employee;

public class EmployeeImportance {

	// https://leetcode.com/submissions/detail/820058754/
	public static void main(String[] args) {
		EmployeeImportance test = new EmployeeImportance();
		List<Employee> list = new ArrayList<>();
		list.add(new Employee(1, 5, Arrays.asList(2, 3)));
		list.add(new Employee(2, 3, new ArrayList<>()));
		list.add(new Employee(3, 3, new ArrayList<>()));
		System.out.println(test.getImportance(list, 1));
		list = new ArrayList<>();
		list.add(new Employee(1, 2, Arrays.asList(5)));
		list.add(new Employee(5, -3, new ArrayList<>()));
		System.out.println(test.getImportance(list, 5));
	}

	public int getImportance(List<Employee> employees, int id) {
		Map<Integer, Employee> map = new HashMap<>();
		for (Employee employee : employees) {
			map.put(employee.id, employee);
		}
		Queue<Integer> queue = new LinkedList<>();
		queue.add(id);
		int importance = 0;
		while (!queue.isEmpty()) {
			int size = queue.size();
			while (size-- > 0) {
				Employee employee = map.get(queue.poll());
				importance += employee.importance;
				queue.addAll(employee.subordinates);
			}
		}
		return importance;
	}

}
