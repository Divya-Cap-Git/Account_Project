package com.spring.app;
 
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.spring.app.Account;
 
public class Driver {

	public static Account loadAccount()
	{
		//fill the code
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		Account account = (Account) context.getBean("account");
		return account;
	}
 
	public static void main(String[] args) 
	{
		//fill the code
		Account account = loadAccount();
		System.out.println("Account number:" + account.getAccNumber());
		System.out.println("Account holder name:" + account.getAccHolderName());
		System.out.println("Balance:" + account.getAccBalance());
		System.out.println("Loan type:" + account.getLoanInfo().getLoanType());
		System.out.println("Loan amount:" + account.getLoanInfo().getLoanAmount());
	}	 	  	    	    		        	 	
}