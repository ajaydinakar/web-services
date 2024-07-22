package com.ajay.ws.soap;


import javax.xml.ws.Endpoint;
import javax.xml.ws.soap.SOAPBinding;

import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration

public class WebserviceConfig {
	
	@Autowired
	private Bus bus;
	
	@Bean
	public Endpoint endpoint() {
		
		Endpoint endpoint	=new EndpointImpl(bus, new FileWSImpl());
		endpoint.publish("/fileWS");
	SOAPBinding binding=	(SOAPBinding)endpoint.getBinding();
	binding.setMTOMEnabled(true);
		return endpoint;
		
		
	}

}
