package scraper;

import java.awt.image.*;
import javax.imageio.*;
import java.io.*;
import java.net.URL;
import java.net.MalformedURLException;

public class ImageScraper {
  
  ImageScraper(String URL, String IMAGE){
    
  }

  URL url = null;
  
  File outputFile = null;
  
  public static BufferedImage image = null;

  public static void fetchImageFromURL (URL url) {
  
    try {
    
    // Read from a URL
    
    // URL url = new URL("http://hostname.com/image.gif");
    
      image = ImageIO.read(url);
    
    } 
    catch (IOException e) {
    
    } // catch
    
   } // fetchImageFromURL
  
  // Create a URL from the specified address, open a connection to it,
  
  // and then display information about the URL.
  
  public static void main(String[] args)
  
    throws MalformedURLException, IOException {
    
    URL url = new URL(args[0]);
    
    File outputFile = new File(args[1]);
    
    fetchImageFromURL(url);
    
    ImageIO.write(image, "jpg", outputFile);
    
    } // main
  
  } // GetURLImage