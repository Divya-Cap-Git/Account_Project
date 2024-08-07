package com.spring.app;
 
public class Account {
 
	private String accNumber;
	private String accHolderName;
	private double accBalance;
	private Loan loanInfo;
 
//fill the code
	
	public Account(){}
	
	public Account(String accNumber, String accHolderName, double accBalance, Loan loanInfo) {
		super();
		this.accNumber = accNumber;
		this.accHolderName = accHolderName;
		this.accBalance = accBalance;
		this.loanInfo = loanInfo;
	}
	
	public String getAccNumber() {
		return accNumber;
	}
	
	public void setAccNumber(String accNumber) {
		this.accNumber = accNumber;
	}
 
	public String getAccHolderName() {
		return accHolderName;
	}
	public void setAccHolderName(String accHolderName) {
		this.accHolderName = accHolderName;
	}
	public double getAccBalance() {
		return accBalance;
	}
	public void setAccBalance(double accBalance) {
		this.accBalance = accBalance;
	}
	public Loan getLoanInfo() {
		return loanInfo;
	}
	public void setLoanInfo(Loan loanInfo) {
		this.loanInfo = loanInfo;
	}
}