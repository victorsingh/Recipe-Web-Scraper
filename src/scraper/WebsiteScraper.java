package scraper;

import java.io.BufferedReader;

import javax.naming.directory.SearchControls;

public class WebsiteScraper implements Scraper {
  
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
    BufferedReader reader = WebpageScraper.read(url);
    System.out.println(reader);
    this.MARKUP = reader;
    return;
  }

  @Override
  public void getMarkup(String level) throws Exception {
    // TODO Auto-generated method stub
    String line = this.MARKUP.readLine();
    String cachedMarkup = "";
    while (line != null) {
      cachedMarkup = cachedMarkup + line;
      line = this.MARKUP.readLine();
     } // while
    if (level == "high"){
      RecipeScraper getResults = new RecipeScraper(cachedMarkup);
    }
    else if(level == "low"){
      RecipeScraper.furtherBeyond(cachedMarkup);
    }
  }

  public void getSSMarkup(){
    
  }
   
  public void generateImage() {
    
  }

}
