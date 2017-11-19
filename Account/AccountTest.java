package Account;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

public class AccountTest {
	
	Account a;
	
	@Before
	public void setUp() {
		a = new Account();
	}

	@Test
	public void testDeposit() throws Exception {
		a.deposit(100);
		assertEquals(100, a.getBalance());
		a.deposit(50);
		assertEquals(150, a.getBalance());
	}
	
	@Test(expected = Exception.class)
	public void testDepositNegNr() throws Exception {
		a.deposit(-100);
	}
	
	@Test(expected = Exception.class)
	public void testDepositZero() throws Exception {
		a.deposit(0);
	}

	@Test
	public void testWithdraw() throws Exception {
		a.deposit(200);
		a.withdraw(100);
		assertEquals(100, a.getBalance());
		a.withdraw(50);
		assertEquals(50, a.getBalance());
	}
	
	@Test(expected = Exception.class)
	public void testWithdrawNegNr() throws Exception {
		a.withdraw(-100);
	}

	@Test(expected = Exception.class)
	public void testWithdrawZero() throws Exception {
		a.withdraw(0);
	}
	
	@Test(expected = Exception.class)
	public void testWithdrawGreaterThanBalance() throws Exception {
		a.withdraw(100);
	}
	
	@Test
	public void testDepositAndWithdraw() throws Exception {
		a.deposit(100);
		assertEquals(100, a.getBalance());
		a.withdraw(50);
		assertEquals(50, a.getBalance());
	}
	
	@Test
	public void testPrintStatement() throws Exception {
		a.deposit(100);
		a.withdraw(50);
		Date today 			 	= new Date();
		String statement = "Date\tAmount\tBalance\n" +
				Account.STATEMENTS_FORMAT.format(today) + "\t+100\t100\n" +
				Account.STATEMENTS_FORMAT.format(today) + "\t-50\t50\n";
		assertEquals(statement, a.printStatement());
	}

}
