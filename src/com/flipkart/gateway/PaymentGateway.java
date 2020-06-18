package com.flipkart.gateway;

import java.sql.SQLException;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;

import com.flipkart.exception.PaymentFailedException;
import com.flipkart.model.Payment;
import com.flipkart.model.Transaction;
import com.flipkart.service.PaymentService;

/**
 * @author ciphereck
 * @category Dummy Gateway
 *
 */
public class PaymentGateway {
	PaymentService paymentService = new PaymentService();
	Logger logger = Logger.getLogger(PaymentGateway.class);
	public static final String FAILIURE_MESSAGE = "FAILIURE";
	Scanner sc = new Scanner(System.in);
	
	/**
	 * 
	 * @param amount
	 * @return Transaction Information
	 * @throws PaymentFailedException
	 */
	public Transaction makePayment(int amount) throws PaymentFailedException {
		List<Payment> paymentMode = null;
		try {
			paymentMode = paymentService.getPaymentMode();
		} catch (SQLException e) {
			logger.error(e.getMessage());
			throw new PaymentFailedException();
		}
		
		for(int i=0; i<paymentMode.size(); i++) {
			logger.info("Enter " + i + " for: " + paymentMode.get(i));
		}
		
		int modeOfPayment = sc.nextInt();
		
		if(payCompletion(amount)) {
			Transaction transaction = new Transaction();
			transaction.setPaymentModeid(paymentMode.get(modeOfPayment).getPaymentModeId());
			transaction
				.setTransactionId(paymentMode.get(modeOfPayment).getPaymentModeId() 
							+ System.currentTimeMillis() + amount);
			logger.info(transaction);
			return transaction;
		}
		throw new PaymentFailedException();
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
