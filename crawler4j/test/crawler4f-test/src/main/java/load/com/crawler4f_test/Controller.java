package load.com.crawler4f_test;

import edu.uci.ics.crawler4j.fetcher.PageFetcher;
import edu.uci.ics.crawler4j.robotstxt.*;
import edu.uci.ics.crawler4j.crawler.*;
import edu.uci.ics.crawler4j.crawler.authentication.*;

public class Controller {
    private static org.slf4j.Logger log =
            org.slf4j.LoggerFactory.getLogger(Controller.class);
    
    public static void main(String[] args) throws Exception {
        String crawlStorageFolder = "/Users/load/data/crawl/";
        crawlStorageFolder = crawlStorageFolder + System.currentTimeMillis();
        String username = "";
        String passwd = "";
        String loginURL = "https://passport.csdn.net/";
        String usernamename = "username";
        String passwdname = "password";
        AuthInfo myauth = new FormAuthInfo(username,passwd,loginURL,usernamename,passwdname);
        int numberOfCrawlers = 1;

        CrawlConfig config = new CrawlConfig();
        config.setCrawlStorageFolder(crawlStorageFolder);
        config.setMaxDepthOfCrawling(1);
        config.setMaxPagesToFetch(1000);
        config.addAuthInfo(myauth);

        /*
         * Instantiate the controller for this crawl.
         */
        PageFetcher pageFetcher = new PageFetcher(config);
        RobotstxtConfig robotstxtConfig = new RobotstxtConfig();
        RobotstxtServer robotstxtServer = new RobotstxtServer(robotstxtConfig, pageFetcher);
        CrawlController controller = new CrawlController(config, pageFetcher, robotstxtServer);

        /*
         * For each crawl, you need to add some seed urls. These are the first
         * URLs that are fetched and then the crawler starts following links
         * which are found in these pages
         */
    //    controller.addSeed("https://http://passport.csdn.net/");
        controller.addSeed("http://my.csdn.net/");
//        controller.addSeed("https://www.liepin.com/");
//        controller.addSeed("https://www.liepin.com/zhaopin/?searchField=1&key=Java#sfrom=click-pc_homepage-centre_keywordjobs-search_new");
//        controller.addSeed("https://article.liepin.com/#sfrom=click-pc_homepage-front_navigation-aritcle_new");

        /*
         * Start the crawl. This is a blocking operation, meaning that your code
         * will reach the line after this only when crawling is finished.
         */
        controller.start(MyCrawler.class, numberOfCrawlers);
    }

}
