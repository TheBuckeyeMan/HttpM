package am.library.HttpM;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import am.library.HttpM.ApiRequests.GetRequest;
//Delete class when finished

@SpringBootApplication
public class HttpMApplication {
	private static final Logger log = LoggerFactory.getLogger(HttpMApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(HttpMApplication.class, args);
		testGetRequest();
	}
	private static void testGetRequest(){
		GetRequest getRequest = new GetRequest();

		// Fake parameters
        String authType = "OAuth"; // Authentication type
        String url = "https://www.googleapis.com/youtube/v3/videos"; // Test API
        String key = "ya29.a0ARW5m77As1Ez84EiFYtBSt5P8L9i1KzlGWXDLDnkTA7QifjkkBpQn9BV_BHXTzrkClv685XA6isNGwinikJlT7wg2LTEEiN_3ehfu8S7fcpcPoD1zorwlceztTTQ0yuWDoRr2ARjawDgR_sTL2V5IhPr4nQ8FQMnjkUkxKfIaCgYKAdgSARMSFQHGX2MiFJELqrtZpcC7ttyxy0w1lQ0175"; // Fake API key
        Map<String, String> params = Map.of("id","oEkAKKwDwMc"); // Query parameters
		String keyName = "";
		String responseType = "application/json";

		try {
            // Call the method and print the response
			log.info("Attempting to OAuth Request");
            String request = getRequest.executeGetRequest(authType,responseType, url, key, keyName,  params);
            System.out.println("OAuth Sample Request: " + request);
			log.info("Attempting to APIK Request");
			String request2 = getRequest.executeGetRequest("APIK","application/json", "https://api.collegefootballdata.com/games", "OjsY5xQX5AYP4xYURwX2Uylw/xg1SNYkAL7kTljjDfv3bjtf6WS/6oVaVON0QpsO", "",  Map.of("year","2024","week","1","seasonType","regular","team","ohio state"));
            System.out.println("APIK Sample Request: " + request2);
			log.info("Attempting to APIP Request");
			String request3 = getRequest.executeGetRequest("APIP","application/json", "https://weather.visualcrossing.com/VisualCrossingWebServices/rest/services/timeline/columbus%20ohio", "APBLK5Q42W884G6SR6MU9WXF6", "key",  params);
            System.out.println("APIP Sample Request: " + request3);
			log.info("Attempting to NoAuth Request");
			String request4= getRequest.executeGetRequest("NoAuth","application/json", "https://catfact.ninja/fact", "", "",  Map.of("max_length","140"));
            System.out.println("NoAuth Sample Request: " + request4);
        } catch (Exception e) {
            // Print error if something goes wrong
            System.err.println("Error: " + e.getMessage());
        }
	}
}
