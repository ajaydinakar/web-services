package com.ajay.ws.soap;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import org.apache.cxf.feature.Features;

import com.ajay.ws.soap.dto.PaymentProcessorRequest;
import com.ajay.ws.soap.dto.PaymentProcessorResponse;
@WebService(name="PaymentProcessor")
@Features(features="org.apache.cxf.feature.LoggingFeature")
public interface PaymentProcessor {
@WebMethod
	public @WebResult(name="response") PaymentProcessorResponse processPayment(@WebParam(name="paymentProcessorRequest")  PaymentProcessorRequest paymentProcessorRequest);
}
