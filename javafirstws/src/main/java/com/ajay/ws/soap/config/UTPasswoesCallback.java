package com.ajay.ws.soap.config;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;

import org.apache.wss4j.common.ext.WSPasswordCallback;

public class UTPasswoesCallback implements CallbackHandler {
	
	private Map<String, String> passwords=new HashMap<>();
	
	public UTPasswoesCallback()
	{
		
		passwords.put("ajay", "ajay");
		passwords.put("cxf", "cxf");
		
	}

	@Override
	public void handle(Callback[] callbacks) throws IOException, UnsupportedCallbackException {
		// TODO Auto-generated method stub

		for(Callback callback:callbacks)
		{ 
			WSPasswordCallback passwordCallback = (WSPasswordCallback) callback;
			String password=passwords.get(passwordCallback.getIdentifier());
			if(password!=null)
			{
				passwordCallback.setPassword(password);
				return;
			}
		}
	}

}
