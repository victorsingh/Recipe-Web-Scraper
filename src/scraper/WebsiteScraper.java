package scraper;

import java.io.BufferedReader;

public class WebsiteScraper implements Scraper{
  
  private String URL;
  private BufferedReader MARKUP;
  
  public WebsiteScraper(String url) throws Exception{
     this.URL = url;
     runScraper(url);
  }
  
  public String getUrl() {
    return URL;
  }

  @Override
  public void runScraper(String url) throws Exception {
    // TODO Auto-generated method stub
    BufferedReader reader = WebpageScraper.read("https://www.foodnetwork.com/search/pepper-pot-");
    System.out.println(reader);
    this.MARKUP = reader;
    return;
  }

  @Override
  public void getMarkup() throws Exception {
    // TODO Auto-generated method stub
    String line = this.MARKUP.readLine();
    
    while (line != null) {
      
      System.out.println(line);
      
      line = this.MARKUP.readLine();
    
     } // while
    
  }

}
