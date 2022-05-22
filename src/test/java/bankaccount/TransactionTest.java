package bankaccount;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Test;

public class TransactionTest {
	
	@Test
	public void depositOperation() {
		Transaction transaction = new Transaction(2000.0,200.0, new Date(), BankOperation.DEPOSIT);
		transaction.doOperation();
		assertEquals(2000.0, transaction.getCurrentBalance(), 0);
		assertEquals(2200.0, transaction.getNextBalance(), 0);
	}

	@Test
	public void withdrawOperation() {
		Transaction transaction = new Transaction(2000.0,200.0, new Date(), BankOperation.WITHDRAW);
		transaction.doOperation();
		assertEquals(2000.0, transaction.getCurrentBalance(), 0);
		assertEquals(1800.0, transaction.getNextBalance(), 0);
	}
	@Test(expected= NullPointerException.class)
	public void DoNullOperation() {
		Transaction transaction = new Transaction(2000.0,200.0, new Date(), null);
		transaction.doOperation();
	}
}
