package com.ajay.ws.soap;

import jakarta.xml.ws.Endpoint;

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

		Endpoint endpoint	=new EndpointImpl(bus, new HelloWs());
		endpoint.publish("/hello");
		return endpoint;


	}

}
