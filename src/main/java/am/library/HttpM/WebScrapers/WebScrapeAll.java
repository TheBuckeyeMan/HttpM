package am.library.HttpM.WebScrapers;

import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


//TODO Work on this class and make sure exceptions are higher quality
@Service
public class WebScrapeAll {
    private static final Logger log = LoggerFactory.getLogger(WebScrapeAll.class);

    public static String webScrapeAllHtml(String url){
        log.info("Attempting to Scrape all HTML from URL: " + url);
        try{
            Document document = Jsoup.connect(url)
                                .timeout(300000)
                                .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/89.0.4389.82 Safari/537.36")
                                .get();
        
        return document.html();

        } catch (IOException e){
            log.error(("Error occured while scraping HTML data from URL " + url + " please check that the source url is a valid website and not an api endpoint"), e.getMessage(), e);
            return "Error Occurred while scraping Data";
        } catch (Exception e){
            log.error("Generic Error Occured", e.getMessage(), e);
            return "Generic Error Occurred while scraping HTML Data";
        }
    }

    public static String webScrapeAllText(String url){
        log.info("Attempting to Scrape all Text from URL: " + url);
        try{
            Document document = Jsoup.connect(url)
                                .timeout(300000)
                                .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/89.0.4389.82 Safari/537.36")
                                .get();
        
        return document.text();

        } catch (IOException e){
            log.error(("Error occured while scraping Text data from URL " + url + " please check that the source url is a valid website and not an api endpoint"), e.getMessage(), e);
            return "Error Occurred while scraping Data";
        } catch (Exception e){
            log.error("Generic Error Occured", e.getMessage(), e);
            return "Generic Error Occurred while scraping Text Data";
        }
    }
}
