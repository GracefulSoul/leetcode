package gracefulsoul.problems;

import java.util.Map;
import java.util.TreeMap;

public class MyCalendarIII {

	// https://leetcode.com/submissions/detail/847960393/
	public static void main(String[] args) {
		MyCalendarThree myCalendarThree = new MyCalendarThree();
		System.out.println(myCalendarThree.book(10, 20));	// return True, The event can be booked. 
		System.out.println(myCalendarThree.book(50, 60));	// return True, The event can be booked. 
		System.out.println(myCalendarThree.book(10, 40));	// return True, The event can be double booked. 
		System.out.println(myCalendarThree.book(5, 15));	// return False, The event cannot be booked, because it would result in a triple booking.
		System.out.println(myCalendarThree.book(5, 10));	// return True, The event can be booked, as it does not use time 10 which is already double booked.
		System.out.println(myCalendarThree.book(25, 55));	// return True, The event can be booked, as the time in [25, 40) will be double booked with the third event, the time [40, 50) will be single booked, and the time [50, 55) will be double booked with the second event.
	}

}

class MyCalendarThree {

	private TreeMap<Integer, Integer> map;
	private int max;

	public MyCalendarThree() {
		this.map = new TreeMap<>();
		this.map.put(-1, 0);
		this.max = 0;
	}

	public int book(int startTime, int endTime) {
		this.map.put(startTime, this.map.floorEntry(startTime).getValue());
		this.map.put(endTime, this.map.floorEntry(endTime).getValue());
		for (Map.Entry<Integer, Integer> entry : map.subMap(startTime, endTime).entrySet()) {
			int value = entry.getValue() + 1;
			entry.setValue(value);
			this.max = Math.max(this.max, value);
		}
		return this.max;
	}

}

/**
 * Your MyCalendarThree object will be instantiated and called as such:
 * MyCalendarThree obj = new MyCalendarThree();
 * int param_1 = obj.book(startTime,endTime);
 */