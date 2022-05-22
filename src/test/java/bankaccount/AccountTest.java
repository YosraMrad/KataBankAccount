package bankaccount;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import org.junit.Test;

public class AccountTest {
	@Test
	public void depositAmount() throws ParseException {
		Account account = new Account();
		assertEquals(0, account.getBalance(), 0);
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		account.deposit(2000.0, dateFormat.parse("22/05/2022"));
		assertEquals("The balance will be 2000 ",2000.0, account.getBalance(), 0);
	}

	@Test
	public void withdrawAmount() throws ParseException {
		Account account = new Account();
		account.setBalance(2000.0);
		assertEquals(2000.0, account.getBalance(), 0);
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		account.withdraw(200.0, dateFormat.parse("23/05/2022"));
		assertEquals("The balance will be 20000 - 200 = 1800  ",1800.0, account.getBalance(), 0);
	}

	@SuppressWarnings("resource")
	@Test
	public void historyAccount() throws ParseException, IOException {
		Account account = new Account();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		account.deposit(2000.0, dateFormat.parse("20/05/2022"));
		account.withdraw(300.0, dateFormat.parse("21/05/2022"));
		FileOutputStream output = new FileOutputStream("src/test/resources/bankaccount/result", true);
		FileOutputStream outputExpected = new FileOutputStream("src/test/resources/bankaccount/resultExpected", true);
		PrintStream printer = new PrintStream(outputExpected);
		PrintStream printerResult = new PrintStream(output);
		account.printStatement(printer);
		account.printStatement(printerResult);
		String expected = new Scanner(new File("src/test/resources/bankaccount/resultExpected")).useDelimiter("\\Z")
				.next();
		String result = new Scanner(new File("src/test/resources/bankaccount/result")).useDelimiter("\\Z")
				.next();
		assertTrue("the two results must be equals",expected.trim().equals(result.trim()));

	}

}
