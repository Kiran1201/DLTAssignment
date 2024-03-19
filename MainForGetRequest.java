package com.assignment.assignment;

import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

import javax.net.ssl.HttpsURLConnection;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class MainForGetRequest {

	public static void main(String[] args) throws IOException {
		
		URL urlObj = new URL("https://time.com");
		HttpsURLConnection connection = (HttpsURLConnection) urlObj.openConnection();
		connection.setRequestMethod("GET");

		int responseCode = connection.getResponseCode();
		// System.out.println("Response code" + responseCode);

		if (responseCode == HttpsURLConnection.HTTP_OK) {
			StringBuilder sb = new StringBuilder();
			Scanner scanner = new Scanner(connection.getInputStream());
			while (scanner.hasNext()) {
				sb.append(scanner.nextLine());
			}
			//System.out.println(sb);
			ObjectMapper objectMapper = new ObjectMapper();
			Story[] story = objectMapper.readValue(String.valueOf(sb), new TypeReference<Story[]>() {}); 
			
			System.out.println(story[1].toString());
		} else {
			System.out.println("Error occured in sending request");
		}
	}

}
