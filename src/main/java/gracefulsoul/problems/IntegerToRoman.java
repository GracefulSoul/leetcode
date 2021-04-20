package gracefulsoul.problems;

public class IntegerToRoman {

	public static void main(String[] args) {
		IntegerToRoman test = new IntegerToRoman();
		System.out.println(test.intToRoman(3));
		System.out.println(test.intToRoman(4));
		System.out.println(test.intToRoman(9));
		System.out.println(test.intToRoman(58));
		System.out.println(test.intToRoman(1994));
	}
	
	public String intToRoman(int num) {
		String[] romans = new String[] {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
		int[] nums = new int[] {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
		StringBuilder sb = new StringBuilder();
		int idx = 0;
        while (num > 0) {
        	int multiple =  num / nums[idx];
        	for (int i = 0; i < multiple; i++) {
        		num -= nums[idx];
        		sb.append(romans[idx]);
        	}
        	idx++;
        }
        return sb.toString();
    }
	
//	public String intToRoman(int num) {
//        StringBuilder sb = new StringBuilder();
//        while (num > 0) {
//        	if (num / 1000 > 0) {
//        		num -= 1000;
//        		sb.append("M");
//        	} else if (num / 900 > 0) {
//        		num -= 900;
//        		sb.append("CM");
//        	} else if (num / 500 > 0) {
//        		num -= 500;
//        		sb.append("D");
//        	} else if (num / 400 > 0) {
//        		num -= 400;
//        		sb.append("CD");
//        	} else if (num / 100 > 0) {
//        		num -= 100;
//        		sb.append("C");
//        	} else if (num / 90 > 0) {
//        		num -= 90;
//        		sb.append("XC");
//        	} else if (num / 50 > 0) {
//        		num -= 50;
//        		sb.append("L");
//        	} else if (num / 40 > 0) {
//        		num -= 40;
//        		sb.append("XL");
//        	} else if (num / 10 > 0) {
//        		num -= 10;
//        		sb.append("X");
//        	} else if (num / 9 > 0) {
//        		num -= 9;
//        		sb.append("IX");
//        	} else if (num / 5 > 0) {
//        		num -= 5;
//        		sb.append("V");
//        	} else if (num / 4 > 0) {
//        		num -= 4;
//        		sb.append("IV");
//        	} else if (num / 1 > 0) {
//        		num -= 1;
//        		sb.append("I");
//        	}
//        }
//        return sb.toString();
//    }

}
