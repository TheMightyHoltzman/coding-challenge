package Account;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * A simple account class
 * 
 * I assumed that the Account can only have a positive balance!
 * 
 * @author heiko
 *
 */
public class Account {
	
	/**
	 * The balance of the account
	 */
	private int balance;
	
	/**
	 * List of all transactions ascending chronologically
	 */
	private List<Transaction> transactions;
	
	/**
	 * Day.Month.Year Format for string output
	 */
	public static final SimpleDateFormat STATEMENTS_FORMAT = new SimpleDateFormat("d.M.YYYY");
	
	/**
	 * Default constructor
	 */
	public Account() {
		balance      = 0;
		// I used a linked list, since it has O(1)-time-complexity to add new elements and,
		// in this example, we are not doing anything except adding and iterating over it
		transactions = new LinkedList<>();
	}
	
	/**
	 * Default getter for balance
	 * @return
	 */
	public int getBalance() {
		return balance;
	}

	/**
	 * Deposit given amount on account
	 * @param amount
	 * @throws Exception
	 */
	public void deposit(int amount) throws Exception {
		handleTransaction(amount, false);
	}
	
	/**
	 * Withdraw given amount from account
	 * @param amount
	 * @throws Exception
	 */
	public void withdraw(int amount) throws Exception {
		handleTransaction(amount, true);
	}
	
	/**
	 * Enlists all transactions for account (Date,Amount,Balance)
	 * @return
	 */
	public String printStatement() {
		StringBuilder statement = new StringBuilder("Date\tAmount\tBalance\n");
		for (Transaction transaction : transactions) {
			statement.append(transaction.toString());
		}
		return statement.toString();
	}
	
	/**
	 * Handles generic transactions for the account (deposit AND withdrawal)
	 * @param amount
	 * @param isWithdrawal
	 * @throws Exception
	 */
	private void handleTransaction(int amount, boolean isWithdrawal) throws Exception {
		if (amount <= 0) {
			throw new Exception("The transaction amount must be positive");
		}
		if (isWithdrawal) {
			if (amount > balance) {
				throw new Exception("Can't withdraw more than you have.\nRequested: " + amount + "\nActualBalance: " + balance);
			}
			amount = -amount;
		}
		
		balance += amount;
		Transaction transaction = new Transaction(new Date(), amount, balance);
		transactions.add(transaction);
	}
}
