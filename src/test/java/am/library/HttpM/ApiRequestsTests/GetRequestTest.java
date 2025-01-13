package am.library.HttpM.ApiRequestsTests;

import static org.junit.jupiter.api.Assertions.assertEquals;

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

    @Test
    void testExceptionGetRequest_ValidInput(){
        String type = "APIK";
        String url = "https://example.com";
        String key = "testKey";
        String params = "param1=value1";

        String result = getRequest.executeGetRequest(type, url, key, params);

        assertEquals("", result, "Expected empty string as executeGetRequest output");
    }
    
}
