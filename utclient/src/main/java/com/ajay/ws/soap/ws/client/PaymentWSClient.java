package com.ajay.ws.soap.ws.client;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.endpoint.Endpoint;
import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.ws.security.wss4j.WSS4JInInterceptor;
import org.apache.cxf.ws.security.wss4j.WSS4JOutInterceptor;
import org.apache.wss4j.dom.WSConstants;
import org.apache.wss4j.dom.handler.WSHandlerConstants;

import com.ajay.ws.soap.PaymentProcessor;
import com.ajay.ws.soap.PaymentProcessorImplService;
import com.ajay.ws.soap.PaymentProcessorRequest;
import com.ajay.ws.soap.PaymentProcessorResponse;


public class PaymentWSClient {

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub
		
		PaymentProcessorImplService service=
				new PaymentProcessorImplService(new URL("http://localhost:8080/javafirstws/paymentProcessor?wsdl"));
		PaymentProcessor port =service.getPaymentProcessorImplPort();
		
		Client client= ClientProxy.getClient(port);
		Endpoint endpoint=client.getEndpoint();
		
		Map<String, Object> props=new HashMap<>();
		props.put(WSHandlerConstants.ACTION, WSHandlerConstants.USERNAME_TOKEN);
		props.put(WSHandlerConstants.USER, "cxf");
		props.put(WSHandlerConstants.PASSWORD_TYPE, WSConstants.PW_TEXT);
		props.put(WSHandlerConstants.PW_CALLBACK_CLASS, UTPasswordCallback.class.getName());
		WSS4JOutInterceptor wssout=new WSS4JOutInterceptor(props);
		endpoint.getOutInterceptors().add(wssout);
		
		PaymentProcessorResponse response=port.processPayment(new PaymentProcessorRequest());
		System.out.println(response.isResult());

	}

}
