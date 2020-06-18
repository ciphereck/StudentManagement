package com.flipkart.gateway;

import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;

import com.flipkart.exception.PaymentFailedException;

public class PaymentGateway {
	Logger logger = Logger.getLogger(PaymentGateway.class);
	public static final String FAILIURE_MESSAGE = "FAILIURE";
	Scanner sc = new Scanner(System.in);
	
	public String makePayment(int amount) throws PaymentFailedException {
		logger.info("Enter 1. For Debit/Credit Card and 2. For Netbanking");
		int modeOfPayment = sc.nextInt();
		String txId;
		if(modeOfPayment == 1)
			txId = payThroughDebitCard(amount);
		else 
			txId = payThroughNetBanking(amount);
		
		if(txId == FAILIURE_MESSAGE) {
			throw new PaymentFailedException();
		}
		return txId;
	}
	
	private String payThroughDebitCard(int amount) {
		if(payCompletion(amount)) {
			return "DEBIT_CREDIT_CARD" + System.currentTimeMillis();
		} else {
			return FAILIURE_MESSAGE;
		}
	}
	
	private String payThroughNetBanking(int amount) {
		if(payCompletion(amount)) {
			return "NET_BANKING" + System.currentTimeMillis();
		} else {
			return FAILIURE_MESSAGE;
		}
	}
	
	private boolean payCompletion(int amount) {
		Random rand = new Random(System.currentTimeMillis());
		int paymentCompletion = rand.nextInt(10);
		for(int i=0; i<5; i++) {
			logger.info(String.format("Procedding Payment. Wait for %d seconds", 5-i));
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				logger.error(e.getMessage());
				return false;
			}
		}
		if(paymentCompletion % 4 != 0) {
			return true;
		} else {
			return false;
		}
	}
}
