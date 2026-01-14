package gracefulsoul.problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SeparateSquaresII {

	// https://leetcode.com/problems/separate-squares-ii/submissions/1884709254/
	public static void main(String[] args) {
		SeparateSquaresII test = new SeparateSquaresII();
		System.out.println(test.separateSquares(new int[][] {
			{ 0, 0, 1 },
			{ 2, 2, 1 }
		}));
		System.out.println(test.separateSquares(new int[][] {
			{ 0, 0, 2 },
			{ 1, 1, 1 }
		}));
	}

	public double separateSquares(int[][] squares) {
		List<Event> events = new ArrayList<>();
		for (int[] square : squares) {
			int x = square[0];
			int y = square[1];
			int l = square[2];
			events.add(new Event(y, 1, x, x + l));
			events.add(new Event(y + l, -1, x, x + l));
		}
		Collections.sort(events);
		List<Interval> intervals = new ArrayList<>();
		List<double[]> strips = new ArrayList<>();
		double area = 0;
		int prev = events.get(0).y;
		for (Event event : events) {
			if (event.y > prev) {
				double width = this.getUnionWidth(intervals);
				double height = (double) event.y - prev;
				if (width > 0) {
					strips.add(new double[] { prev, height, width });
					area += height * width;
				}
			}
			if (event.type == 1) {
				intervals.add(new Interval(event.xStart, event.xEnd));
			} else {
				intervals.remove(new Interval(event.xStart, event.xEnd));
			}
			prev = event.y;
		}
		double half = area / 2.0;
		double sum = 0;
		for (double[] strip : strips) {
			double y = strip[0];
			double height = strip[1];
			double width = strip[2];
			area = height * width;
			if (half <= sum + area) {
				return y + ((half - sum) / width);
			}
			sum += area;
		}
		return 0.0;
	}

	private double getUnionWidth(List<Interval> intervals) {
		if (intervals.isEmpty()) {
			return 0;
		}
		List<Interval> list = new ArrayList<>(intervals);
		Collections.sort(list);
		double length = 0;
		double curr = -1e18;
		for (Interval interval : list) {
			if (interval.start >= curr) {
				length += (interval.end - interval.start);
				curr = interval.end;
			} else if (interval.end > curr) {
				length += (interval.end - curr);
				curr = interval.end;
			}
		}
		return length;
	}

	private class Interval implements Comparable<Interval> {
		int start, end;

		Interval(int start, int end) {
			this.start = start;
			this.end = end;
		}

		public int compareTo(Interval other) {
			if (this.start != other.start) {
				return Integer.compare(this.start, other.start);
			} else {
				return Integer.compare(this.end, other.end);
			}
		}

		public boolean equals(Object o) {
			if (this == o) {
				return true;
			} else if (o == null || getClass() != o.getClass()) {
				return false;
			} else {
				Interval interval = (Interval) o;
				return start == interval.start && end == interval.end;
			}
		}
	}

	private class Event implements Comparable<Event> {
		int y;
		int type;
		int xStart, xEnd;

		Event(int y, int type, int xStart, int xEnd) {
			this.y = y;
			this.type = type;
			this.xStart = xStart;
			this.xEnd = xEnd;
		}

		public int compareTo(Event other) {
			return Integer.compare(this.y, other.y);
		}
	}

}
