package com.ajay.ws.soap;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;

import org.springframework.beans.propertyeditors.InputStreamEditor;

public class FileWSImpl implements FileWS {

	@Override
	public void upload(DataHandler attachment) {
		// TODO Auto-generated method stub
		InputStream input=null;
		OutputStream output=null;
try {
 input=	attachment.getInputStream();
output= new FileOutputStream(new File("/Users/ajaydinakar/Documents/uploaded/test.jpg"));
byte[] b=new byte[1000000];
int bytesRead=0;
while((bytesRead=input.read(b))!=-1)
{
	output.write(b,0,bytesRead);
	}


} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
finally
{
	try {
		input.close();
		output.close();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
	}

	@Override
	public DataHandler download() {
		// TODO Auto-generated method stub
		return new DataHandler(new FileDataSource(new File("/Users/ajaydinakar/Documents/uploaded/test.jpg")));
	}

}
