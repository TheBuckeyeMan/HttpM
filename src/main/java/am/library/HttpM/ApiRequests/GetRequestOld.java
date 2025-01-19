// package am.library.HttpM.ApiRequests;

// import java.io.IOException;
// import java.util.List;
// import java.util.Optional;

// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;
// import org.springframework.stereotype.Service;

// import okhttp3.OkHttpClient;
// import okhttp3.Request;
// import okhttp3.Response;

// @Service
// public class GetRequestOld {
//     private static final Logger log = LoggerFactory.getLogger(GetRequest.class);

//     public String executeGetRequest(String Apitype,String responseType, String url, String key,String keyName, String params){

//         //Validate Request by URL
//         this.validateRequest(url);

//         //Create Request
//         Request getRequest = this.buildRequest(Apitype, responseType, url, key, key, params);
//         log.info("The Constructed get Request is: " + getRequest);

//         //Execute Request
//         return executeGetRequest(getRequest);
//     }

//     private void validateRequest(String url){
//         if (url == null || url == ""){
//             throw new IllegalArgumentException("No URL Provided, PLease Add URL");
//         }
//         if (!url.contains("http")){
//             throw new IllegalArgumentException("A URL Is provided, but is not an Http Request");
//         }
//     }

//     private Request buildRequest(String type, String responseType, String url, String key, String keyName,List<String> params){
//         log.info("Attemptin to build API Request. Type: {" + type + "}");
//         Request.Builder getRequest = new Request.Builder();

//         //Create URL With params


//         // //Add Static Headers
//         // getRequest.addHeader("Accept", responseType);
//         // switch (type){
//         //     case "OAuth":
//         //         validateKey(key);
//         //         this.exportRequestDetails(url, key, keyName, params);
//         //         getRequest.addHeader("Authorization", "Bearer " + key);
//         //         break;

//         //     case "APIK":
//         //         validateKey(key);
//         //         getRequest.addHeader("Authorization", "Bearer " + key);
//         //         this.exportRequestDetails(url, key, keyName, params);
//         //         break;

//         //     case "APIP":
//         //         validateKey(key);
//         //         url = this.addKeyToParam(url, key, keyName, params);
//         //         this.exportRequestDetails(url, key, keyName, params);
//         //     case "NoAuth":
//         //         this.exportRequestDetails(url, key, keyName, params);
//         //         break;
//         //     default:
//         //         log.error("Error API Key Type Parameter is not Valid in the Get Request Construction");
//         //         throw new IllegalArgumentException();
//         // }
//         // getRequest.url(url);
//         // return getRequest.build();
//     }

//     private String addParams(String url, List<String> params){

//         for (String string : params) {
//             if (url.contains("?"))
//         }

//         return "";
//     }

// //this method needs work
//     private String addKeyToParam(String url, String key, String keyName, String params) {
//         if (url == null || url.isEmpty()) {
//             throw new IllegalArgumentException("URL cannot be null or empty");
//         }
//         if (key == null || key.isEmpty()) {
//             throw new IllegalArgumentException("API key cannot be null or empty");
//         }
//         if (keyName == null || keyName.isEmpty()) {
//             throw new IllegalArgumentException("API key name cannot be null or empty");
//         }
//     StringBuilder fullUrl = new StringBuilder(url);

//     // Determine if we need to add a '?' or '&'
//     if (params == null || params.isEmpty()) {
//         fullUrl.append("?").append(keyName).append("=").append(key);
//     } else {
//         fullUrl.append("?").append(params).append("&").append(keyName).append("=").append(key);
//     }

//     return fullUrl.toString();
        
//     }
    
//     private void validateKey(String key){
//         if (key == null || key == ""){
//             throw new IllegalArgumentException("A Key is required for this request and a key was not passed.");
//         }
//     }

//     private String executeGetRequest(Request getRequest){

//         OkHttpClient client = new OkHttpClient();
        
//         try(Response getResponse = client.newCall(getRequest).execute()){
//             //Check Response
//             this.executeRequestCheck(getResponse);

//         } catch (IOException e){
//             log.info("Error occured while executing HTTP Request: " + e.getMessage(), e);
//         }
//         return "";
//     }

//     private void exportRequestDetails(String url, String key, String keyName, String params){
//         log.info("The value of the URL is: " + url);
//         log.info("The Value of the Key is: " + key);
//         log.info("The value of the keyName is: " + keyName);
//         log.info("The value of the params is: " + params);
//     }

//     private void executeRequestCheck(Response getResponse){
//         log.info("API Response Code: " + getResponse.code());
//         if (getResponse.isSuccessful()){
//         } else if (getResponse.body().toString() == null || getResponse.body().toString() == ""){
//             log.info("The API Returned Null with Response code: " + getResponse.code());
//         } else {
//             throw new RuntimeException("Http Request Failed to execute with status code: " + getResponse.code());
//         }
//     }
// }
