package scraper;

import java.io.BufferedReader;

import javax.naming.directory.SearchControls;

import customhashtable.RecipeObject;

public class WebsiteScraper {
  
  private String URL;
  private BufferedReader MARKUP;
  
  public WebsiteScraper(String url) throws Exception{
    System.out.println(url);
     this.URL = url;
     runScraper(url);
  }
  
  public String getUrl() {
    return URL;
  }

  public void runScraper(String url) throws Exception {
    // TODO Auto-generated method stub
    BufferedReader reader = WebpageScraper.read(url);
    System.out.println(reader);
    this.MARKUP = reader;
    return;
  }

  public RecipeObject[] getMarkup(String level) throws Exception {
    // TODO Auto-generated method stub
    String line = this.MARKUP.readLine();
    String cachedMarkup = "";
    while (line != null) {
      cachedMarkup = cachedMarkup + line;
      line = this.MARKUP.readLine();
     } // while
    if (level == "high"){
      RecipeScraper getResults = new RecipeScraper(cachedMarkup);
      return getResults.foodNamehigh;
    }
    else {
      RecipeScraper getResults = new RecipeScraper(cachedMarkup);

      RecipeScraper.furtherBeyond(cachedMarkup);
      return getResults.foodNamehigh;
    }
  }

  public static String justGetMarkUp(String url) throws Exception{
    System.out.println("You have chosen "+ url);
    BufferedReader reader = WebpageScraper.read("https://"+url);
    String line = reader.readLine();
    String cachedMarkup = "";
    while (line != null) {
      cachedMarkup = cachedMarkup + line;
      line = reader.readLine();
     } // while
     System.out.println("Done");
     return cachedMarkup;
  }

  public void getSSMarkup(){
    
  }
   
  public void generateImage() {
    
  }

}
