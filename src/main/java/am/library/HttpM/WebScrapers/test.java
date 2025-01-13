package am.library.HttpM.WebScrapers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import am.library.HttpM.ApiRequests.GetRequest;

@Service
public class test {
    private static final Logger log = LoggerFactory.getLogger(test.class);
    private GetRequest getRequest;

    public test(GetRequest getRequest){
        this.getRequest = getRequest;
    }

    public void testTrigger(){
        String testUrl = "";
        String testKey = "";
        String testType = "";
        String testParams = "";

        getRequest.executeGetRequest(testType, testUrl, testKey, testParams);

    }
    
}
