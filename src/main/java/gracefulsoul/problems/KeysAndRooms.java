package gracefulsoul.problems;

import java.util.Arrays;
import java.util.List;

public class KeysAndRooms {

	// https://leetcode.com/problems/keys-and-rooms/submissions/899064136/
	public static void main(String[] args) {
		KeysAndRooms test = new KeysAndRooms();
		System.out.println(test.canVisitAllRooms(Arrays.asList(Arrays.asList(1), Arrays.asList(2), Arrays.asList(3), Arrays.asList())));
		System.out.println(test.canVisitAllRooms(Arrays.asList(Arrays.asList(1, 3), Arrays.asList(3, 0, 1), Arrays.asList(2), Arrays.asList())));
	}

	public boolean canVisitAllRooms(List<List<Integer>> rooms) {
		boolean[] visited = new boolean[rooms.size()];
		List<Integer> firstRoom = rooms.get(0);
		for (int i = 0; i < firstRoom.size(); i++) {
			this.dfs(rooms, visited, firstRoom.get(i));
		}
		for (int i = 1; i < rooms.size(); i++) {
			if (!visited[i]) {
				return false;
			}
		}
		return true;
	}

	private void dfs(List<List<Integer>> rooms, boolean[] visited, int index) {
		visited[index] = true;
		List<Integer> room = rooms.get(index);
		for (int i = 0; i < room.size(); i++) {
			if (!visited[room.get(i)]) {
				this.dfs(rooms, visited, room.get(i));
			}
		}
	}

}
