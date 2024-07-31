package gracefulsoul.problems;

import java.util.TreeMap;

public class SnapshotArray {

	// https://leetcode.com/problems/snapshot-array/submissions/1339350919/
	public static void main(String[] args) {
		SnapshotArray snapshotArr = new SnapshotArray(3);	// set the length to be 3
		snapshotArr.set(0, 5); 								// Set array[0] = 5
		System.out.println(snapshotArr.snap());				// Take a snapshot, return snap_id = 0
		snapshotArr.set(0, 6);
		System.out.println(snapshotArr.get(0, 0));			// Get the value of array[0] with snap_id = 0, return 5
	}

	private TreeMap<Integer, Integer>[] snapshotArray;
	private int snapId;

	@SuppressWarnings("unchecked")
	public SnapshotArray(int length) {
		this.snapshotArray = new TreeMap[length];
		for (int i = 0; i < length; i++) {
			this.snapshotArray[i] = new TreeMap<>();
			this.snapshotArray[i].put(0, 0);
		}
	}

	public void set(int index, int val) {
		this.snapshotArray[index].put(this.snapId, val);
	}

	public int snap() {
		return this.snapId++;
	}

	public int get(int index, int snap_id) {
		return this.snapshotArray[index].floorEntry(snap_id).getValue();
	}

}

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */