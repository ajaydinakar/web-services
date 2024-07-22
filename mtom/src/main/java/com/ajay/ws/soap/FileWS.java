package com.ajay.ws.soap;

import javax.activation.DataHandler;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.crypto.Data;
@WebService
public interface FileWS {
void upload(@WebParam(name="file") DataHandler attachment);
DataHandler download();
}
