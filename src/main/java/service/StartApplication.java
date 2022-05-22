package service;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import bankaccount.Account;

public class StartApplication {
	public static void main(String[] args) throws ParseException {
		Account Account = new Account();

		// Statement statement =new Statement();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Account.deposit(3000.0, dateFormat.parse("20/05/2022"));
		Account.deposit(1000.0, dateFormat.parse("21/05/2022"));
		Account.withdraw(200.00, dateFormat.parse("22/05/2022"));
		Account.printStatement(System.out);
	}

}
