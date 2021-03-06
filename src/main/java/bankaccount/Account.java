package bankaccount;

import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.lang3.StringUtils;

public class Account {

	private final double INITIAL_BALANCE = 0.0;
	private static final String DATE_FORMAT = "dd/MM/yyyy";
	private SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
	private Double balance = INITIAL_BALANCE;
	private List<Transaction> transactions = new ArrayList<Transaction>();

	public void deposit(Double value, Date date) {
		recordTransaction(value, date, BankOperation.DEPOSIT);
	}

	public void withdraw(Double value, Date date) {
		recordTransaction(value, date, BankOperation.WITHDRAW);
	}

	private void recordTransaction(Double value, Date date, BankOperation bankOperation) {
		Transaction transaction = new Transaction(balance, value, date, bankOperation);
		transaction.doOperation();
		transactions.add(transaction);
		balance = transaction.getNextBalance();
	}

	public void printStatement(PrintStream printer) {

		StringBuilder builder = new StringBuilder();
		builder.append("Total Balance " + balance);
		builder.append(System.getProperty("line.separator"));
		builder.append("History ");
		builder.append(System.getProperty("line.separator"));

		for (Iterator<Transaction> iterator = transactions.iterator(); iterator.hasNext();) {
			Transaction transaction = (Transaction) iterator.next();
			// Add history of each transaction
			builder.append("old balance: ").append(StringUtils.rightPad(transaction.getCurrentBalance().toString(), 10))
					.append(" | ").append(sdf.format(transaction.getDate())).append(" | ")
					.append(transaction.getBankOperation().toString()).append(" ")
					.append(transaction.getValue().toString()).append(" | ").append("Balance ")
					.append(StringUtils.rightPad(transaction.getNextBalance().toString(), 10));

			builder.append(System.getProperty("line.separator"));

		}
		printer.println(builder.toString());

	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public SimpleDateFormat getsdf() {
		return sdf;
	}

	public void setsdf(SimpleDateFormat sdf) {
		this.sdf = sdf;
	}

}
