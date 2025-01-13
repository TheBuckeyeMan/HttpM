package am.library.HttpM.ApiRequests;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import okhttp3.Request;

@Service
public class GetRequest {
    private static final Logger log = LoggerFactory.getLogger(GetRequest.class);

    public String executeGetRequest(String type,String url, String key, String params){

        //Validate Request by URL
        this.validateRequest(url);

        //Create Request
        Request getRequest = this.buildRequest(type, url, key, key, params);

        //Execute Request
        return executeGetRequest(getRequest);
    }

    private void validateRequest(String url){
        if (url == null || url == ""){
            throw new IllegalArgumentException("No URL Provided, PLease Add URL");
        }
    }

    private Request buildRequest(String type,String url, String key, String keyName,String params){
        log.info("Attemptin to build API Request. Type: {" + type + "}");
        Request.Builder getRequest = new Request.Builder();
        switch (type){
            case "Oauth":
                validateKey(key);
                getRequest.addHeader("Authorization", "Bearer " + key);
                break;

            case "APIK":
                validateKey(key);
                getRequest.addHeader("Authorization", "Bearer " + key);
                break;

            case "APIP":
                validateKey(key);
                url = this.addKeyToParam(url, key, keyName, params);
            case "NoAuth":
                break;
            default:
                log.error("Error API Key Type Parameter is not Valid in the Get Request Construction");
                throw new IllegalArgumentException();
        }
        getRequest.url(url);
        return getRequest.build();
    }
//this method needs work
    private String addKeyToParam(String url, String key, String keyName, String params) {
        if (url == null || url.isEmpty()) {
            throw new IllegalArgumentException("URL cannot be null or empty");
        }
        if (key == null || key.isEmpty()) {
            throw new IllegalArgumentException("API key cannot be null or empty");
        }
        if (keyName == null || keyName.isEmpty()) {
            throw new IllegalArgumentException("API key name cannot be null or empty");
        }
    StringBuilder fullUrl = new StringBuilder(url);

    // Determine if we need to add a '?' or '&'
    if (params == null || params.isEmpty()) {
        fullUrl.append("?").append(keyName).append("=").append(key);
    } else {
        fullUrl.append("?").append(params).append("&").append(keyName).append("=").append(key);
    }

    return fullUrl.toString();
        
    }
    
    private void validateKey(String key){
        if (key == null || key == ""){
            throw new IllegalArgumentException("A Key is required for this request and a key was not passed.");
        }
    }

    private String executeGetRequest(Request getRequest){

        return "";
    }

    
}
