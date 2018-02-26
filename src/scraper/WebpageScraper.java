package scraper;
import java.io.*;

import java.net.URL;

import java.net.URLConnection;

public class WebpageScraper {
  
  public static final String USER_AGENT = "Mozilla/5.0 (Windows; U; Windows NT 5.1; en-US; rv:1.9.2) Gecko/20100115 Firefox/3.6";
  
  public static InputStream getURLInputStream(String sURL) throws Exception {
  
  URLConnection oConnection = (new URL(sURL)).openConnection();
  
  oConnection.setRequestProperty("User-Agent", USER_AGENT);
  
  return oConnection.getInputStream();
  
  }

  public static BufferedReader read(String url) throws Exception {

  InputStream content = (InputStream)getURLInputStream(url);
  
  return new BufferedReader (new InputStreamReader(content));
  
  } // read
  
  public static BufferedReader read2(String url) throws Exception {
    
    return new BufferedReader(
    
    new InputStreamReader(
    
    new URL(url).openStream()));
  
  } // read

} // WebpageReaderWithAgent