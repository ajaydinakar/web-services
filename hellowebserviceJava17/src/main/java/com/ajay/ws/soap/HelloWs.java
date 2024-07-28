package com.ajay.ws.soap;


import jakarta.jws.WebService;
import org.apache.cxf.feature.Features;

@WebService
@Features(features="org.apache.cxf.feature.LoggingFeature")
public class HelloWs {


	public String hello()
{

return "this is sample";
}

}
