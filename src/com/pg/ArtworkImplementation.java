package com.pg;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import javax.jws.WebService;
import javax.xml.bind.JAXBException;

import com.art.Artwork;
import com.jaxb.MarshallerClass;

@WebService(endpointInterface="com.pg.ArtworkInterface")
public class ArtworkImplementation implements ArtworkInterface{

	@Override
	public String getXMLContent() {
		Artwork artwork = new Artwork();
		artwork.setFormName("FormArt");
		artwork.setContactEmailAddress("tester@pg.com");
		artwork.setIntendedIPMSGCAS("ipm_gas");
		artwork.setIsTemplate("false");
		artwork.setLanguage("English");
		artwork.setLifeCycleStatus("Release");
		artwork.setMaterialSubType("soap");
		artwork.setOtherNames("Form_Dup_Name");
		artwork.setPOANumber("123");
		artwork.setProjectName("SOAPProject");
		artwork.setProjectNumber("1");
		artwork.setReleaseDate("10-Jan-2019");
		artwork.setSecurityStatus("Safe");
		artwork.setShareWithSuppliers("Shared");
		artwork.setSignatureDates("10-Jan-2019");
		artwork.setSignatureNames("signer");
		MarshallerClass marshell = new MarshallerClass();
		try {
			marshell.marshell(artwork);
		} catch (FileNotFoundException e) {
			System.out.println("FILE NOT FOUND "+e);
		} catch (JAXBException e) {
			System.out.println("JAXB EXCEPTION "+e);
		}
		StringBuilder sb = new StringBuilder();
		File file = new File("C:\\Shashank\\Artwork.xml");
		BufferedReader br; 
		try{
		String line;
		br = new BufferedReader(new FileReader(file));
		while((line=br.readLine())!= null){
		    sb.append(line.trim());
		}
		}catch(Exception e){
			System.out.println("FILE READ EXCEPTION: "+e);
		}
		return sb.toString();
	}
}
