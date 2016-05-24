package rocketBase;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import javax.swing.JOptionPane;

import exceptions.RateException;

public class rate_test {
	 
	// TODO - RocketDAL rate_test
	// Check to see if a known credit score returns a known interest rate
	@Test
	public void rate_test() {
		int credit_score = 600;
		try {
			assertEquals(5.0, RateBLL.getRate(credit_score), 0.001);
		} catch (RateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test(expected=RateException.class)
	public void no_rate_test() throws RateException {
		int credit_score = 400;
			RateBLL.getRate(credit_score);
    }
	
	//true, true
	@Test
	public void income_test1() {
	double pmt = Math.abs(RateBLL.getPayment((0.04/12), 360, 300000, 0, false));
	boolean income_test =  5115.20 * (0.28) > pmt;
	boolean income_and_expenses = (5115.2 - 1000) *(0.36) > pmt;
	assertEquals(true, income_test);
	assertEquals(true, income_and_expenses);
	}
	
	//true, false
	@Test
	public void income_test2() {
	double pmt = Math.abs(RateBLL.getPayment((0.04/12), 360, 300000, 0, false));
	boolean income_test =  5120.20 * (0.28) > pmt;
	boolean income_and_expenses = (5120.2 - 5000) * (0.36) > pmt;
	assertEquals(true, income_test);
	assertEquals(false, income_and_expenses);
	}
	
	//false, true
	@Test
	public void income_test3() {
	double pmt = Math.abs(RateBLL.getPayment((0.04/12), 360, 300000, 0, false));
	boolean income_test =  5000 * (0.28) > pmt;
	boolean income_and_expenses = (5000) *(0.36) > pmt;
	assertEquals(false, income_test);
	assertEquals(true, income_and_expenses);
	}
	
	//false, false
	@Test
	public void income_test4() {
	double pmt = Math.abs(RateBLL.getPayment((0.04/12), 360, 300000, 0, false));
	boolean income_test =  200 * (0.28) > pmt;
	boolean income_and_expenses = (200-100) *(0.36) > pmt;
	assertEquals(false, income_test);
	assertEquals(false, income_and_expenses);
	}
}
