// package am.library.HttpM.ApiRequestsTests;

// import static org.junit.Assert.assertTrue;
// import static org.junit.jupiter.api.Assertions.assertEquals;
// import static org.junit.jupiter.api.Assertions.assertThrows;

// import java.io.IOException;
// import java.util.Map;
// import okhttp3.mockwebserver.MockResponse;
// import okhttp3.mockwebserver.MockWebServer;

// import org.junit.jupiter.api.AfterAll;
// import org.junit.jupiter.api.BeforeEach;
// import org.junit.jupiter.api.Disabled;
// import org.junit.jupiter.api.DisplayName;
// import org.junit.jupiter.api.Test;
// import org.mockito.Mock;
// import am.library.HttpM.ApiRequests.GetRequest;

// /*
//  * Test for GetRequest for 
//  * Validate input parameters
//  * Handle authentication types (
//  * Generate URL's with Queery params
//  * Hake Http calls
//  * Handle Responses
//  */
// public class GetRequestTest {
//     private GetRequest getRequest;
//     private MockWebServer mockWebServer;

//     @BeforeEach
//     void setUp() throws Exception{
//         getRequest = new GetRequest();
//         mockWebServer = new MockWebServer();
//     }

//     @DisplayName("Success Test Scenario")
//     @Test
//     void testExecuteGetRequest() throws Exception{
        
//         mockWebServer.enqueue(new MockResponse().setResponseCode(200).setBody("{\"message\":\"success\"}"));
//         mockWebServer.start();

//         String baseUrl = mockWebServer.url("/api/data").toString();
//         Map<String, String> params = Map.of("key1","value1","key2","value2");

//         //Act
//         String result = getRequest.executeGetRequest("oauth", "application/json", baseUrl,null,null, params);

//         //Assertions
//         assertEquals("{\"message\":\"success\"}", result);
//         assertEquals(1, mockWebServer.getRequestCount());
//     }


//     @AfterAll
//     void tearDown() throws Exception{
//         mockWebServer.shutdown();
//     }
// }
