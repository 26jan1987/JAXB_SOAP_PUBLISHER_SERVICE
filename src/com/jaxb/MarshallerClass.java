package com.jaxb;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import com.art.Artwork;

public class MarshallerClass {
	
	public void marshell(Artwork artwork) throws JAXBException, FileNotFoundException{
		JAXBContext contextObj = JAXBContext.newInstance(Artwork.class);
	    Marshaller marshallerObj = contextObj.createMarshaller();  
	    marshallerObj.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);	      
	    marshallerObj.marshal(artwork, new FileOutputStream("C:\\Shashank\\Artwork.xml"));
	}
	
}
