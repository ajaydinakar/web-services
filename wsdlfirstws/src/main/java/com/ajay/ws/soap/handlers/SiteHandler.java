package com.ajay.ws.soap.handlers;

import java.util.Iterator;
import java.util.Set;

import javax.xml.namespace.QName;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPHeader;
import javax.xml.soap.SOAPMessage;
import javax.xml.soap.Node;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;

public class SiteHandler implements SOAPHandler<SOAPMessageContext> {

	@Override
	public void close(MessageContext context) {
	
		System.out.println("close");
	}

	@Override
	public boolean handleFault(SOAPMessageContext arg0) {
		System.out.println("HandleFault");
		return false;
	}

	@Override
	public boolean handleMessage(SOAPMessageContext context) {
		System.out.println("Handleing the message");
		Boolean isResponse=(Boolean) context.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);
		if(!isResponse)
		{
			SOAPMessage soapMsg=context.getMessage();
		try {
			SOAPEnvelope envelope=	soapMsg.getSOAPPart().getEnvelope();
			SOAPHeader header=envelope.getHeader();
			Iterator childelements=header.getChildElements();
			while(childelements.hasNext())
			{
				
				Node eachElement=(Node) childelements.next();
				String name=eachElement.getLocalName();
				if(name!=null && name.equals("SiteName"))
				{
					System.out.println("Site Name is"+eachElement.getValue());
				}
			}
		} catch (SOAPException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		else
		{
			System.out.println("Response on the way");
		}
		return true;
	}

	@Override
	public Set<QName> getHeaders() {
	
		System.out.println("getting headers");
		
		return null;
	}

}
