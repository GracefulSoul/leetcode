package gracefulsoul.problems;

public class SimpleBankSystem {

	// https://leetcode.com/problems/simple-bank-system/submissions/1811939639/
	public static void main(String[] args) {
		Bank bank = new Bank(new long[] { 10, 100, 20, 50, 30 });
		// return true, account 3 has a balance of $20, so it is valid to withdraw $10.
		System.out.println(bank.withdraw(3, 10));
		// Account 3 has $20 - $10 = $10.
		// return true, account 5 has a balance of $30, so it is valid to transfer $20.
		System.out.println(bank.transfer(5, 1, 20)); 
		// Account 5 has $30 - $20 = $10, and account 1 has $10 + $20 = $30.
		// return true, it is valid to deposit $20 to account 5.
		System.out.println(bank.deposit(5, 20)); 
		// Account 5 has $10 + $20 = $30.
		// return false, the current balance of account 3 is $10,
		System.out.println(bank.transfer(3, 4, 15)); 
		// so it is invalid to transfer $15 from it.
		// return false, it is invalid because account 10 does not exist.
		System.out.println(bank.withdraw(10, 50)); 
	}

}

class Bank {

	private long[] balance;
	private int length;

	public Bank(long[] balance) {
		this.balance = balance;
		this.length = balance.length;
	}

	public boolean transfer(int account1, int account2, long money) {
		if (!this.isValidAccount(account1) || !this.isValidAccount(account2) || this.balance[account1 - 1] < money) {
			return false;
		} else {
			this.balance[account1 - 1] -= money;
			this.balance[account2 - 1] += money;
			return true;
		}
	}

	public boolean deposit(int account, long money) {
		if (!this.isValidAccount(account)) {
			return false;
		} else {
			this.balance[account - 1] += money;
			return true;
		}
	}

	public boolean withdraw(int account, long money) {
		if (!this.isValidAccount(account) || this.balance[account - 1] < money) {
			return false;
		} else {
			this.balance[account - 1] -= money;
			return true;
		}
	}

	private boolean isValidAccount(int account) {
		return 0 < account && account <= this.length;
	}

}

/**
 * Your Bank object will be instantiated and called as such:
 * Bank obj = new Bank(balance);
 * boolean param_1 = obj.transfer(account1,account2,money);
 * boolean param_2 = obj.deposit(account,money);
 * boolean param_3 = obj.withdraw(account,money);
 */