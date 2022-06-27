package gracefulsoul.problems;

public class StudentAttendanceRecordI {

	// https://leetcode.com/submissions/detail/732456688/
	public static void main(String[] args) {
		StudentAttendanceRecordI test = new StudentAttendanceRecordI();
		System.out.println(test.checkRecord("PPALLP"));
		System.out.println(test.checkRecord("PPALLL"));
	}

	public boolean checkRecord(String s) {
		return s.indexOf("A") == s.lastIndexOf("A") && !s.contains("LLL");
	}

}
