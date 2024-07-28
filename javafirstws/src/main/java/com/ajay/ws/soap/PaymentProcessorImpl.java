package com.ajay.ws.soap;

import javax.sql.rowset.serial.SerialException;

import com.ajay.ws.soap.dto.PaymentProcessorRequest;
import com.ajay.ws.soap.dto.PaymentProcessorResponse;
import com.ajay.ws.soap.exceptions.ServiceException;

public class PaymentProcessorImpl implements PaymentProcessor {

	public PaymentProcessorResponse processPayment(PaymentProcessorRequest paymentProcessorRequest) throws ServiceException {
		PaymentProcessorResponse paymentProcessorResponse = new PaymentProcessorResponse();
		// Business Logic or a call to a Business Logic Class Goes Here.
		if(paymentProcessorRequest.getCreditCardInfo().getCardNumber()==null 
				|| paymentProcessorRequest.getCreditCardInfo().getCardNumber().length()==0)
		{
			throw new ServiceException("Invalid card number ");
		}
		paymentProcessorResponse.setResult(true);
		return paymentProcessorResponse;
	}

}
