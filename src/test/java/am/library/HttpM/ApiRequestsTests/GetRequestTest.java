package am.library.HttpM.ApiRequestsTests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import am.library.HttpM.ApiRequests.GetRequest;

/*
 * Test for GetRequest
 */
public class GetRequestTest {

    private GetRequest getRequest;

    @BeforeEach
    void setUp(){
        getRequest = new GetRequest();
    }

    // @Test
    // void testExceptionGetRequest_ValidInput(){
    //     String type = "APIK";
    //     String url = "https://example.com";
    //     String key = "testKey";
    //      Map<String, String> params = Map.of("param1","value1"); // Query parameters
    //     String keyName = "";
    //     String responseType = "application/json";

    //     String result = getRequest.executeGetRequest(type,responseType, url, key,keyName, params);

    //     assertEquals("", result, "Expected empty string as executeGetRequest output");
    // }
    
}
