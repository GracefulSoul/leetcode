package gracefulsoul.problems;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class ExamRoom {

	// https://leetcode.com/problems/exam-room/submissions/906864376/
	public static void main(String[] args) {
		ExamRoom examRoom = new ExamRoom(10);
		System.out.println(examRoom.seat()); // return 0, no one is in the room, then the student sits at seat number 0.
		System.out.println(examRoom.seat()); // return 9, the student sits at the last seat number 9.
		System.out.println(examRoom.seat()); // return 4, the student sits at the last seat number 4.
		System.out.println(examRoom.seat()); // return 2, the student sits at the last seat number 2.
		examRoom.leave(4);
		System.out.println(examRoom.seat()); // return 5, the student sits at the last seat number 5.
	}

	private int n;
	private Queue<Interval> queue;

	public ExamRoom(int n) {
		this.queue = new PriorityQueue<>((a, b) -> a.length != b.length ? b.length - a.length : a.start - b.start);
		this.n = n;
		this.queue.offer(new Interval(n, 0, this.n - 1));
	}

	public int seat() {
		Interval interval = this.queue.poll();
		int result;
		if (interval.start == 0) {
			result = 0;
		} else if (interval.end == this.n - 1) {
			result = this.n - 1;
		} else {
			result = interval.start + interval.length;
		}
		if (result > interval.start) {
			this.queue.offer(new Interval(n, interval.start, result - 1));
		}
		if (result < interval.end) {
			this.queue.offer(new Interval(n, result + 1, interval.end));
		}
		return result;
	}

	public void leave(int p) {
		List<Interval> list = new ArrayList<>(this.queue);
		Interval prev = null;
		Interval next = null;
		for (Interval interval : list) {
			if (interval.end + 1 == p) {
				prev = interval;
			}
			if (interval.start - 1 == p) {
				next = interval;
			}
		}
		this.queue.remove(prev);
		this.queue.remove(next);
		this.queue.offer(new Interval(n, prev == null ? p : prev.start, next == null ? p : next.end));
	}

}

class Interval {
	int start;
	int end;
	int length;

	public Interval(int n, int start, int end) {
		this.start = start;
		this.end = end;
		if (start == 0 || end == n - 1) {
			this.length = end - start;
		} else {
			this.length = (end - start) / 2;
		}
	}
}

/**
 * Your ExamRoom object will be instantiated and called as such:
 * ExamRoom obj = new ExamRoom(n);
 * int param_1 = obj.seat();
 * obj.leave(p);
 */