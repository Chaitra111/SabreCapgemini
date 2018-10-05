package com.bridgelabz.sabre.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Chaitra Ankolekar
 * Purpose :To access Sabre APIs
 */
@RestController
@RequestMapping("/sabre")
public class Controller {

	private static final String CONTENT_TYPE="application/x-www-form-urlencoded";
	
	private static final String AUTORIZATION= "Basic VmpFNk5uVndibUl4Wkc4NVkzZ3hjRFJrTVRwUVZVSk1TVU02UlZoVTpTVEJMTTBwMWRtdz0=";
	
	/**
	 * @param uri
	 * @return token
	 * @throws IOException
	 * @method To get the token from url
	 */
	@RequestMapping(value="/getToken", method=RequestMethod.POST)
	private String  getToken(@RequestParam String uri) throws IOException{
	    	
			String param="grant_type=client_credentials";
	              
            URL url = new URL(uri);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestProperty("Content-Type",CONTENT_TYPE );
            conn.setRequestProperty("Authorization",AUTORIZATION);
            conn.setRequestMethod("POST");
            conn.setDoOutput(true);
            OutputStream os = conn.getOutputStream();
            os.write(param.getBytes());
            os.flush();
            os.close();
            StringBuffer response = new StringBuffer();
            int responseCode = conn.getResponseCode();
            System.out.println("POST Response Code : " + responseCode);

            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                String inputLine;
                
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                System.out.println("Token:" +response.toString());
            } else {
                System.out.println("POST request not worked");
            }
			return response.toString();
        }
	
	/**
	 * @param uri
	 * @param token
	 * @throws IOException
	 * @method To access the endpoint and get information about cheapest flight from token
	 */
	@RequestMapping(value="/getEndPoint")
	public static void getResult(@RequestParam String uri) throws IOException {

		URL obj = new URL(uri);
		HttpURLConnection conn = (HttpURLConnection) obj.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Authorization",
				"Bearer T1RLAQKoz8ID8LcVu8o/9UUH38gDHb1gmBA3YDjWesydZ4NjxAzcJXAMAACwnKWQRWidE+YTvYjDknfTB74C7y09F8tVEw99yK4s0al0ZWbTb4u3uRY9/zc2OhKk44sKIs27rIuk1y4KJ+G6tySYQIJjwvlPefs2di2UYItTaAGG8AOEA52jliq9mReHnfWbGN7MrJZ6SFVDUi66yJmGA/OIeNj3+RVl6n13bOzH+fFnKEXgum5OqoA3qDCkwRU2XwBLXpdYVGzwpFkAWmMXxG17ylRj8b2LPtuwq5Q*");
		int responseCode = conn.getResponseCode();
		System.out.println("GET Response Code :: " + responseCode);
		if (responseCode == HttpURLConnection.HTTP_OK) { // success
			BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
			System.out.println(response.toString());
		} else {
			System.out.println("GET request not worked");
		}
	}
}
