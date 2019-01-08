package com.pg;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

public class Client {

	public static void main(String[] args) {
		
		final String SERVICE_ADDRESS = "http://localhost:9393/artwork?WSDL";
		final String NAMESPACE = "http://pg.com/";
		final String SERVICE_NAME = "ArtworkImplementationService";
		
		try {
			
			URL url = new URL(SERVICE_ADDRESS);
			
			QName qName = new QName(NAMESPACE, SERVICE_NAME);
			
			Service service = Service.create(url, qName);
			
			ArtworkInterface artworkMessage = service.getPort(ArtworkInterface.class);

			String xmlMessage = artworkMessage.getXMLContent();
			
			System.out.println("The received message from services : \n"+xmlMessage);
			
		} catch (MalformedURLException e) {
			
			System.out.println("-----CALL--------"+e.getMessage());
			e.printStackTrace();
		}
		
	}
}