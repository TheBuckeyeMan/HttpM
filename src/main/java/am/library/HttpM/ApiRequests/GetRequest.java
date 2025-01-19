package am.library.HttpM.ApiRequests;

import java.io.IOException;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

@Service
public class GetRequest implements GetInterfaces{
    private static final Logger log = LoggerFactory.getLogger(GetRequest.class);

    /*
     * @Params
     * @Returns: Response from API 
     */
    @Override
    public String executeGetRequest(String authType, String responseType, String url, String key, String keyName, Map<String, String> params){
        //Log type of API
        log.info("Get API Request Type: {" + authType + "}");

        //Validate Request by URL

        validateRequest(authType, url);

        //Add params
        String fullUrl = urlWithParams(url, params);
        log.info("The Created Request URL Is: " + fullUrl);

        //Build Request
        Request getRequest = buildRequest(fullUrl, authType, responseType, keyName, key);

        //Execute the Request
        return sendGetRequest(getRequest);
    }

    //Helper method
    private static void validateRequest(String authType, String url){
        if (authType == null || authType == ""){
            throw new IllegalArgumentException("Api Type Not Specified or is invalid. Please update ApiType");
        }
        if (url == null || url == ""){
            throw new IllegalArgumentException("No URL Provided, PLease Add URL");
        }
        if (!url.contains("http")){
            throw new IllegalArgumentException("A URL Is provided, but is not an Http Request");
        }
    }

    //SubService Method
    private static String urlWithParams(String url, Map<String, String> params){
        HttpUrl.Builder urlBuilder = HttpUrl.parse(url).newBuilder();
        //Add Queery Params to URL
        if (params != null && !params.isEmpty()){
            for (Map.Entry<String, String> entry : params.entrySet()){
                urlBuilder.addQueryParameter(entry.getKey(), entry.getValue());
            }
        }
        log.info(urlBuilder.build().toString());
        return urlBuilder.build().toString();
    }

    //SubService Method
    private Request buildRequest(String fullUrl, String authType, String responseType, String keyName, String key){
        //Create Request
        Request.Builder getRequestBuiler = new Request.Builder();

        //Add Response Type
        if (!"application/json".equals(responseType)){
            getRequestBuiler.addHeader("Accept", responseType);
        } else {
            getRequestBuiler.addHeader("Accept", "application/json");
        }

        //Add Auth
        try{
            switch (authType.toLowerCase()){
                case "oauth":
                    //Construct Request
                    validateApiKey(key);
                    getRequestBuiler.addHeader("Authorization", "Bearer " + key);
                    getRequestBuiler.url(fullUrl);
                    break;
                case "apik":
                    validateApiKey(key);
                    //Construct Request
                    if (keyName == null || keyName == ""){
                        getRequestBuiler.addHeader("Authorization", "Bearer " + key);
                    } else {
                        getRequestBuiler.addHeader(keyName, key);
                    }
                    getRequestBuiler.url(fullUrl);
                    break;
                case "apip":
                    //Construct Request
                    validateApiKey(key);
                    validateApiKeyName(keyName);
                    HttpUrl.Builder APIPurl = HttpUrl.parse(fullUrl).newBuilder();
                    APIPurl.addQueryParameter(keyName, key);
                    getRequestBuiler.url(APIPurl.toString());
                    break;
                case "noauth":
                    getRequestBuiler.url(fullUrl);
                    break;
                default:
                    log.error("Error API Key Type Parameter is not Valid in the Get Request Construction");
                    throw new IllegalArgumentException();

            } 
        } catch (RuntimeException e){
            log.error("Failed to add Authentication to the Request. Please Verify the Request parameters are structured properly.", e.getMessage(), e);
        }
        return getRequestBuiler.build();
    }

    //Helper method
    private void validateApiKeyName(String keyName){
        if (keyName == null || keyName.isEmpty()){
            throw new IllegalArgumentException("API Key Name is Required and was Not passed wiht the request");
        }
    }

    //Helper method
    private void validateApiKey(String key){
        if (key == null || key.isEmpty()){
            throw new IllegalArgumentException("API Key is Required and no API Key was passed with the request");
        }
    }
    
    //SubService Method
    private String sendGetRequest(Request getRequest){
        OkHttpClient client = new OkHttpClient();
        
        //Attempt to make the Request
        try (Response response = client.newCall(getRequest).execute()) {
            //VerifyResponse
            verifyResponse(response);

            //Return Response As String
            return response.body().string();

        } catch (IOException e){
            log.error("Error occured while executing the request " + getRequest + " To the requested API", e.getMessage(), e);
            throw new RuntimeException();
        }
    }

    //Helper Method
    private void verifyResponse(Response response){
        //Check if successful, but returned null
        if (response.code() == 200){
            if(response.body() == null){
                log.info("The API Request was successful with a 200 success code, but no response was provided.");
            }
        } else {
            log.info("API Failed || Chech all input parameters are valid. Response code provided was: " + response.code());
            throw new RuntimeException();
        }
    }
}
