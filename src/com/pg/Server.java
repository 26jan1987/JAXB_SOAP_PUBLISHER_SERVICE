package com.pg;

import javax.xml.ws.Endpoint;

public class Server {

	public static void main(String[] args) {

		final String SERVER_ADDRESS = "http://localhost:9393/artwork";

		ArtworkInterface message = new ArtworkImplementation();

		Endpoint endpoint = Endpoint.publish(SERVER_ADDRESS, message);

		if (endpoint.isPublished()) {

			System.out.println("Service is running at " + SERVER_ADDRESS);
		} else {

			System.out.println("Service not published...");
		}
	}

}
