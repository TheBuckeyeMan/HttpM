package am.library.HttpM.ApiRequests;

import javax.management.RuntimeErrorException;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class GetRequest{
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
                getRequest.addHeader("Authorization", "Bearer " + key);
                break;

            case "APIK":
                getRequest.addHeader("Authorization", "Bearer " + key);
                break;

            case "APIP":
            url = addKeyToParam(url, key);
            case "NoAuth":
                break;
            default:
                log.error("Error API Key Type Parameter is not Valid in the Get Request Construction");
                throw new IllegalArgumentException();
        }
        getRequest.url(url);
        return getRequest.build();
    }

    private String addKeyToParam(String url, String key) {
        if (!url.contains("?")) {
            return url + "?" + key;
        } else {
            throw new IllegalArgumentException("API Key PArameter Invalid");
        } 

    }

    private String executeGetRequest(Request getRequest){

        return "";
    }

}
