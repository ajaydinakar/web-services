package com.ajay.ws.soap;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.ws.Holder;

import com.ajaydinakar.customerorders.CreateOrdersRequest;
import com.ajaydinakar.customerorders.CreateOrdersResponse;
import com.ajaydinakar.customerorders.CustomerOrdersPortType;
import com.ajaydinakar.customerorders.GetOrdersResponse;
import com.ajaydinakar.customerorders.Order;
import com.ajaydinakar.customerorders.Product;



public class CustomerOrdersWsImpl implements CustomerOrdersPortType {

Map<BigInteger,List<Order>> customerOrders=new HashMap();
int currentId;
	public CustomerOrdersWsImpl()
	{
		init();
	}
	public void init()
	{
		List<Order> orders =new ArrayList<>();
		Order order=new Order();
		order.setId(BigInteger.valueOf(1));
		Product product=new Product();
		product.setId("1");
		product.setDescription("Iphone");
		product.setQuantity(BigInteger.valueOf(1));
		order.getProduct().add(product);
		orders.add(order);
		customerOrders.put(BigInteger.valueOf(++currentId),orders);
		
		
	}
	
	
	
	
	@Override
	public GetOrdersResponse getOrders(CreateOrdersRequest request) {
		BigInteger customerId=request.getCustomerId();
		List<Order> orders=customerOrders.get(customerId);
		
		GetOrdersResponse response=new GetOrdersResponse();
		response.getOrder().addAll(orders);
		return response;
	}

	@Override
	public void createOrders(Holder<CreateOrdersResponse> parameters) {
		// TODO Auto-generated method stub

	}

}
