package bankaccount;

import java.util.Date;

public class Transaction {
	private Double currentBalance;
	private Double nextBalance;
	private Double value;
	private Date date;
	private BankOperation bankOperation;

	public Transaction(Double currentBalance, Double value, Date date, BankOperation bankOperation) {
		this.currentBalance = currentBalance;
		this.value = value;
		this.date = date;
		this.bankOperation = bankOperation;
	}

	public void doOperation() {

		switch (bankOperation) {
		
		case DEPOSIT:
			this.nextBalance = currentBalance + value;
			break;
		case WITHDRAW:
			this.nextBalance = currentBalance - value;
			break;
		default:
			throw new AssertionError("Other operation ");
		}
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public BankOperation getBankOperation() {
		return bankOperation;
	}

	public void setBankOperation(BankOperation bankOperation) {
		this.bankOperation = bankOperation;
	}

	public Double getCurrentBalance() {
		return currentBalance;
	}

	public void setCurrentBalance(Double currentBalance) {
		this.currentBalance = currentBalance;
	}

	public Double getNextBalance() {
		return nextBalance;
	}

	public void setNextBalance(Double nextBalance) {
		this.nextBalance = nextBalance;
	}

}
