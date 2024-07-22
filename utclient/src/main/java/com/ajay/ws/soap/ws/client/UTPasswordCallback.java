package com.ajay.ws.soap.ws.client;

import java.io.IOException;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;

import org.apache.wss4j.common.ext.WSPasswordCallback;

public class UTPasswordCallback implements CallbackHandler {

	@Override
	public void handle(Callback[] callbacks) throws IOException, UnsupportedCallbackException {
		// TODO Auto-generated method stub
		
		

		for(Callback callback:callbacks)
		{ 
			WSPasswordCallback passwordCallback = (WSPasswordCallback) callback;
			if(passwordCallback.getIdentifier().equals("cxf"))
			{
				passwordCallback.setPassword("cxf");
				return;
			}
		}

	}

}
