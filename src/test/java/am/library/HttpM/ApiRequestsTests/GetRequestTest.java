package am.library.HttpM.ApiRequestsTests;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.IOException;
import java.util.Map;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import am.library.HttpM.ApiRequests.GetRequest;

/*
 * Test for GetRequest for 
 * Validate input parameters
 * Handle authentication types (
 * Generate URL's with Queery params
 * Hake Http calls
 * Handle Responses
 */


@ExtendWith(SpringExtension.class) //Allows @Autowired to work in our class
@ContextConfiguration(classes = GetRequest.class) //Tels spring to specifically add GetRequest.class to the context and loads the class for spring managed dependency injection
public class GetRequestTest {
    @Autowired //Injects the class to the test
    private GetRequest getRequest;

    private MockWebServer mockWebServer;

    @BeforeEach
    void setUp() throws Exception{
        mockWebServer = new MockWebServer();
        mockWebServer.start();
    }

    @DisplayName("Test Success on NoAuth auth type")
    @Test
    void testExecuteGetRequestNoAuth() throws Exception{
        //Arrange
        mockWebServer.enqueue(new MockResponse().setResponseCode(200).setBody("{\"message\":\"success\"}"));
        String baseUrl = mockWebServer.url("/api/data").toString();
        Map<String, String> params = Map.of("key1","value1","key2","value2");

        //Act
        String result = getRequest.executeGetRequest("noauth", "application/json", baseUrl,null,null, params);

        //Assert
        assertEquals("{\"message\":\"success\"}", result);
        assertEquals(1, mockWebServer.getRequestCount());
    }

    @DisplayName("Test Success on APIK auth type")
    @Test
    void testExecuteGetRequestAPIK() throws Exception{
        //Arrange
        mockWebServer.enqueue(new MockResponse().setResponseCode(200).setBody("{\"message\":\"success\"}"));
        String baseUrl = mockWebServer.url("/api/data").toString();
        String key = "hbceh809834fp9ncr";
        Map<String, String> params = Map.of("key1","value1","key2","value2");

        //Act
        String result = getRequest.executeGetRequest("apik", "application/json", baseUrl,key,null, params);

        //Assert
        // assertEquals("Bearer hbceh809834fp9ncr", request.getHeader("Authorization"));
        assertEquals("{\"message\":\"success\"}", result);
        assertEquals(1, mockWebServer.getRequestCount());
    }

    @DisplayName("Test Success on APIK auth type with Custom Headder")
    @Test
    void testExecuteGetRequestAPIKCustomHeader() throws Exception{
        //Arrange
        mockWebServer.enqueue(new MockResponse().setResponseCode(200).setBody("{\"message\":\"success\"}"));
        String baseUrl = mockWebServer.url("/api/data").toString();
        String key = "hbceh809834fp9ncr";
        String keyName = "X-API-Key";
        Map<String, String> params = Map.of("key1","value1","key2","value2");

        //Act
        String result = getRequest.executeGetRequest("apik", "application/json", baseUrl,key,keyName, params);

        //Assert
        assertEquals("{\"message\":\"success\"}", result);
        assertEquals(1, mockWebServer.getRequestCount());
    }


    @DisplayName("Test Success on APIP auth type")
    @Test
    void testExecuteGetRequestAPIP() throws Exception{
        //Arrange
        mockWebServer.enqueue(new MockResponse().setResponseCode(200).setBody("{\"message\":\"success\"}"));
        String baseUrl = mockWebServer.url("/api/data").toString();
        String key = "hbceh809834fp9ncr";
        String keyName = "X-API-Key";
        Map<String, String> params = Map.of("key1","value1","key2","value2");

        //Act
        String result = getRequest.executeGetRequest("apip", "application/json", baseUrl,key,keyName, params);

        //Assert
        assertEquals("{\"message\":\"success\"}", result);
        assertEquals(1, mockWebServer.getRequestCount());
    }

    @DisplayName("Test Success on OAuth auth type")
    @Test
    void testExecuteGetRequestOAuth() throws Exception{
        //Arrange
        mockWebServer.enqueue(new MockResponse().setResponseCode(200).setBody("{\"message\":\"success\"}"));
        String baseUrl = mockWebServer.url("/api/data").toString();
        String key = "hbceh809834fp9ncr";
        String keyName = "X-API-Key";
        Map<String, String> params = Map.of("key1","value1","key2","value2");

        //Act
        String result = getRequest.executeGetRequest("oauth", "application/json", baseUrl,key,keyName, params);

        //Assert
        assertEquals("{\"message\":\"success\"}", result);
        assertEquals(1, mockWebServer.getRequestCount());
    }


    @AfterEach
    void tearDown() throws Exception{
            mockWebServer.shutdown();
    }
}
