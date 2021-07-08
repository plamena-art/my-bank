package com.mybank.account;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CheckingAccountTest {
	//class under test
	CheckingAccount account;
	
	@BeforeEach
	void setup() {
		this.account = new CheckingAccount(
				"customer 1",
				"test account",
				0,
				"test account number"
				);
	}
	
	@Test
	void deposit_amount_greater_than_zero_works() {
		// try with good amount (greater than zero)
		double amount = 42.0;
		
		// do the actual test
		account.deposit(amount);
		
		//get the actual balance
		double balance = account.getBalance();
		
		//check it did work
		assertEquals(amount, balance);
	}
	
	@Test
	void deposit_amount_less_than_zero_throws() {
		//bad amount 
		double amount = -1.0;
		
		//do it
		assertThrows(IllegalArgumentException.class, () -> {
		account.deposit(amount);
		});
	}
	
	@Test
	void deposit_amount_equal_to_zero_throws() {
		// another bad amount 
		double amount = 0.0;
		
		//do it
		assertThrows(IllegalArgumentException.class, () -> {
			account.deposit(amount);
			});
		
	}
}
