import customhashtable.HashBrowns;
import parser.cli.CLIParser;
import scraper.WebsiteScraper;

/**
 * 
 * @author Victor Singh CS 370 Software Engineering
 *
 */

public class launcher {
  
  public static void testHashTable(HashBrowns x) {
    x.addNewFood("Fried Chicken");
//    System.out.println(x.getFoodTable("Fried Chicken"));
    x.getFoodTable("Fried Chicken").addFoodType("Southern Fried Chicken", "Ina Garten", "40 mins", "String with directions","5");
    x.getFoodTable("Fried Chicken").addFoodType("Tomato Fried Chicken", "Ina Garten", "40 mins", "String with directions","5");
//    System.out.println(x.getFoodTable("Fried Chicken").getFood("Southern Fried Chicken").prepTime());
    
    x.addNewFood("Pasta");
    x.getFoodTable("Pasta").addFoodType("Beef Ravioli", "Guy Fierei", "30 mins", "Throw pasta in hot water", "3.5");

  }
  
  public static void testWebScraper() throws Exception {
      WebsiteScraper foodNetwork = new WebsiteScraper("https://www.foodnetwork.com/search/pepper-pot-");
      foodNetwork.getMarkup();
  }
  
  public static void testCLIParser(String[] args, HashBrowns preMade) {
    CLIParser.processArguments(args, preMade);
  }

  public static void main(String[] args) throws Exception {
    // TODO Auto-generated method stub
    HashBrowns x = new HashBrowns();
    testHashTable(x);
//    testWebScraper();
    /*
     * This is where the command line arguments go. The hash table is brought in here to allow the parser to add to it while reading the command line arguments
     * example: java ./launcher -input -f Pizza -input -r Pizza Pepperioni_Pizza Bobby Flay 20_mins Stringwithdirections 3
     */
    testCLIParser(args, x);
    System.out.println(x.getFoodTable("Pizza"));
  }

}
