package am.library.HttpM.ApiRequests;

import java.util.Map;

public interface GetInterfaces {

    String executeGetRequest(String authType, String responseType, String url, String key, String keyName, Map<String, String> params);
    
}
