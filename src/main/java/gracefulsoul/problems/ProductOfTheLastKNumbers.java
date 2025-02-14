package gracefulsoul.problems;

import java.util.ArrayList;
import java.util.List;

public class ProductOfTheLastKNumbers {

	// https://leetcode.com/problems/product-of-the-last-k-numbers/submissions/1542739985/
	public static void main(String[] args) {
		ProductOfNumbers productOfNumbers = new ProductOfNumbers();
		productOfNumbers.add(3);							// [3]
		productOfNumbers.add(0);							// [3,0]
		productOfNumbers.add(2);							// [3,0,2]
		productOfNumbers.add(5);							// [3,0,2,5]
		productOfNumbers.add(4);							// [3,0,2,5,4]
		System.out.println(productOfNumbers.getProduct(2));	// return 20. The product of the last 2 numbers is 5 * 4 = 20
		System.out.println(productOfNumbers.getProduct(3));	// return 40. The product of the last 3 numbers is 2 * 5 * 4 = 40
		System.out.println(productOfNumbers.getProduct(4));	// return 0. The product of the last 4 numbers is 0 * 2 * 5 * 4 = 0
		productOfNumbers.add(8);							// [3,0,2,5,4,8]
		System.out.println(productOfNumbers.getProduct(2));	// return 32. The product of the last 2 numbers is 4 * 8 = 32 
	}

}

class ProductOfNumbers {

	private List<Integer> list;
	private int product;

	public ProductOfNumbers() {
		this.list = new ArrayList<>();
		this.product = 1;
	}

	public void add(int num) {
		if (num != 0) {
			this.product *= num;
			this.list.add(product);
		} else {
			this.list.clear();
			this.product = 1;
		}
	}

	public int getProduct(int k) {
		int size = this.list.size();
		if (size < k) {
			return 0;
		} else {
			int num = this.list.get(size - 1);
			if (size == k) {
				return num;
			} else {
				return num / this.list.get(size - 1 - k);
			}
		}
	}

}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */