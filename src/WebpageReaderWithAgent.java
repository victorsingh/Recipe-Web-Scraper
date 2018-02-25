import java.io.*;

import java.net.URL;

import java.net.URLConnection;

public class WebpageReaderWithAgent {

  private static String webpage = null;
  
  public static final String USER_AGENT = "Mozilla/5.0 (Windows; U; Windows NT 5.1; en-US; rv:1.9.2) Gecko/20100115 Firefox/3.6";
  
  public static InputStream getURLInputStream(String sURL) throws Exception {
  
  URLConnection oConnection = (new URL(sURL)).openConnection();
  
  oConnection.setRequestProperty("User-Agent", USER_AGENT);
  
  return oConnection.getInputStream();
  
  }

  public static BufferedReader read(String url) throws Exception {

  //InputStream content = (InputStream)uc.getInputStream();
  
  // BufferedReader in = new BufferedReader (new InputStreamReader
  
  // (content));
  
  InputStream content = (InputStream)getURLInputStream(url);
  
  return new BufferedReader (new InputStreamReader(content));
  
  } // read
  
  public static BufferedReader read2(String url) throws Exception {
    
    return new BufferedReader(
    
    new InputStreamReader(
    
    new URL(url).openStream()));
  
  } // read
  
  public static void main (String[] args) throws Exception{
  
    if (args.length == 0) {
    
    System.out.println("No URL inputted.");
    
    System.exit(1);
  
    } // any inputs?
  
    webpage = args[0];
    
    System.out.println("Contents of the following URL: "+webpage+"\n");
    
    BufferedReader reader = read(webpage);
    
    String line = reader.readLine();
    
    while (line != null) {
    
      System.out.println(line);
      
      line = reader.readLine();
    
     } // while
    
  } // main

} // WebpageReaderWithAgent