package gracefulsoul.problems;

import java.util.Map;
import java.util.TreeMap;

public class MyCalendarI {

	// https://leetcode.com/submissions/detail/844502070/
	public static void main(String[] args) {
		MyCalendar myCalendar = new MyCalendar();
		System.out.println(myCalendar.book(10, 20)); // return True
		System.out.println(myCalendar.book(15, 25)); // return False, It can not be booked because time 15 is already booked by another event.
		System.out.println(myCalendar.book(20, 30)); // return True, The event can be booked, as the first event takes every time less than 20, but not including 20.
	}

}

class MyCalendar {

	private TreeMap<Integer, Integer> bookings;

	public MyCalendar() {
		this.bookings = new TreeMap<>();
	}

	public boolean book(int start, int end) {
		Map.Entry<Integer, Integer> booking = this.bookings.floorEntry(--end);
		if (booking == null || booking.getValue() < start) {
			this.bookings.put(start, end);
			return true;
		} else {
			return false;
		}
	}

}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */