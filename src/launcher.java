import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

import customhashtable.HashBrowns;
import filecreator.FileCreator;
import filecreator.SimpleFile;
import parser.cli.CLIParser;
import scraper.WebsiteScraper;
import scraper.RecipeScraper;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import view.MainViewController;


/**
 * 
 * @author Victor Singh CS 370 Software Engineering
 *
 */

public class launcher extends Application {
  
  public static void testHashTable(HashBrowns x) {
    x.addNewFood("Fried Chicken");
  //  System.out.println(x.getFoodTable("Fried Chicken"));
    x.getFoodTable("Fried Chicken").addFoodType("Southern Fried Chicken", "Ina Garten", "40 mins", "String with directions","5");
    x.getFoodTable("Fried Chicken").addFoodType("Tomato Fried Chicken", "Ina Garten", "40 mins", "String with directions","5");
   // System.out.println(x.getFoodTable("Fried Chicken").getFood("Southern Fried Chicken").prepTime());
    
    x.addNewFood("Pasta");
    x.getFoodTable("Pasta").addFoodType("Beef Ravioli", "Guy Fierei", "30 mins", "Throw pasta in hot water", "3.5");
    x.addNewFood("Chef Victor");
    x.getFoodTable("Fish").addFoodType("Artic char", "Fake Salmon(jk)", "23 mins", "Recipe learned at work", "3.3");
  }

  public static void testWebScraper() throws Exception {
      WebsiteScraper foodNetworks = new WebsiteScraper("https://www.foodnetwork.com/search/pepper-pot-");
      foodNetworks.getMarkup("high");

      WebsiteScraper foodNetwork = new WebsiteScraper("https://www.foodnetwork.com/recipes/jamaican-pepper-pot-soup-recipe-1926895");
      foodNetwork.getMarkup("low");
  }

  public static void testCLIParser(String[] args, HashBrowns preMade) throws Exception {
    CLIParser.processArguments(args, preMade);
  }

  public void start(Stage stage) throws Exception {
    Parent root = FXMLLoader.load(getClass().getResource("view/MainView.fxml"));
 
     Scene scene = new Scene(root, 1270, 800);
 
     stage.setTitle("FXML Welcome");
     stage.setScene(scene);
     stage.show();
 }

  public static void main(String[] args) throws Exception {
    launch(args);
    // SampleController x = new SampleController();
    // x.increment();
//    Scanner victor = new Scanner(System.in);
//    System.out.println(victor.nextLine());
 
    HashBrowns x = new HashBrowns();
    // testHashTable(x);
    
//    testWebScraper();
    /*
     * This is where the command line arguments go. The hash table is brought in here to allow the parser to add to it while reading the command line arguments
     * example: java ./launcher -input -f Pizza -input -r Pizza Pepperioni_Pizza Bobby Flay 20_mins Stringwithdirections 3
     */

    testCLIParser(args, x);    
  }

}
