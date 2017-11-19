package Account;

import java.util.Date;

/**
 * A single transaction for an account (if persisted this would need the actual account-ID as well)
 * 
 * @author heiko
 *
 */
public class Transaction {
	
	/**
	 * Time of transaction
	 */
	private Date date;
	
	/**
	 * Amount of transaction (can be positive or negative)
	 */
	private int amount;
	
	/**
	 * The balance AFTER the transaction
	 */
	private int balance;
	
	/**
	 * @param date
	 * @param amount
	 * @param balance
	 */
	public Transaction(Date date, int amount, int balance) {
		super();
		this.date = date;
		this.amount = amount;
		this.balance = balance;
	}
	
	/**
	 * String format for print statement
	 */
	public String toString() {
		return Account.STATEMENTS_FORMAT.format(date) + "\t" + ((amount > 0) ? "+" : "") + amount + "\t" + balance + "\n";
	}
}
