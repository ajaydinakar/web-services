package com.ajay.jaxb.jaxbxjc;

import java.io.StringWriter;
import java.io.StringReader;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.ajay.patient.Patient;

/**
 * Hello world!
 *
 */
public class JaxBDemo 
{
    public static void main( String[] args )
    {
     try {
		JAXBContext context =JAXBContext.newInstance(Patient.class);
		Marshaller marshaller=context.createMarshaller();
		
		Patient patient=new Patient();
		patient.setId(123);
		patient.setName("Ajay");
		StringWriter writer=new StringWriter();
		marshaller.marshal(patient,writer);
		System.out.println(writer.toString());
		Unmarshaller unmarshaller=context.createUnmarshaller();
		
		Patient patientResult=(Patient) unmarshaller.unmarshal(new StringReader(writer.toString()));
		System.out.println(patientResult.getName());
	} catch (JAXBException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    }
}
