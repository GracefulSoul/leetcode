package gracefulsoul.problems;

public class ComplexNumberMultiplication {

	// https://leetcode.com/submissions/detail/725611238/
	public static void main(String[] args) {
		ComplexNumberMultiplication test = new ComplexNumberMultiplication();
		System.out.println(test.complexNumberMultiply("1+1i", "1+1i"));
		System.out.println(test.complexNumberMultiply("1+-1i", "1+-1i"));
	}

	public String complexNumberMultiply(String num1, String num2) {
		int[] num1Array = this.splitNumber(num1);
		int[] num2Array = this.splitNumber(num2);
		return new StringBuilder()
				.append(num1Array[0] * num2Array[0] - num1Array[1] * num2Array[1])
				.append('+')
				.append(num2Array[0] * num1Array[1] + num1Array[0] * num2Array[1])
				.append('i')
				.toString();
	}

	private int[] splitNumber(String num) {
		int index = num.indexOf('+');
		return new int[] { Integer.parseInt(num.substring(0, index)), Integer.parseInt(num.substring(index + 1, num.length() - 1)) };
	}

}
