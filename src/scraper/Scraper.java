package scraper;

public interface Scraper {
  public void runScraper(String url) throws Exception;
  public void getMarkup() throws Exception;
}
