package com.ajay.ws.soap;

import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import com.ajaydinakar.customerorders.CustomerOrdersPortType;
import com.ajaydinakar.customerorders.GetOrdersRequest;
import com.ajaydinakar.customerorders.GetOrdersResponse;
import com.ajaydinakar.customerorders.Order;

public class CustomerOrderWsClient {

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub
		
	CustomerOrdersWsImplService service=	new CustomerOrdersWsImplService(new URL("http://localhost:8080/wsdlfirstws/customerOrdersService?wsdl"));
	CustomerOrdersPortType customerOrdersPortType= service.getCustomerOrdersWsImplPort();
	GetOrdersRequest request=new GetOrdersRequest();
	request.setCustomerId(BigInteger.valueOf(1));
	GetOrdersResponse response=customerOrdersPortType.getOrders(request);
	
	List<Order> order=response.getOrder();
	System.out.println("number of orders "+ order.toString());

	}

}
