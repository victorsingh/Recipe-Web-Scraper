package parser.cli;

import java.io.IOException;

import customhashtable.HashBrowns;
import filecreator.SimpleFile;
import scraper.WebsiteScraper;
import java.util.Scanner;

public class CLIParser {
  private static boolean vflag = false;
  private static HashBrowns preMadeTable;
  private static SimpleFile file;

  /**
   * 
   * @param {String[]} cliArgs
   * @param {HashBrowns} x
   * @throws IOException 
   */
  
  public static void processArguments(String[] cliArgs, HashBrowns x) throws Exception {
    preMadeTable = x;
    int i = 0;
    String arg;
    
    while (i < cliArgs.length && cliArgs[i].startsWith("-")) {
      
        arg = cliArgs[i++];
        
        if (arg.equals("-verbose")) {
          isVerbose();
        }
        else if (arg.equals("-input")) {
          i = isInput(i, cliArgs, preMadeTable);
          
        }
        // use this type of check for arguments that require arguments
        else if (arg.equals("-output")) {
            isOutput(i, cliArgs);
        }
        else if (arg.equals("-i")) {
          // getFileInput(arg);
        }
        else if (arg.equals("-o")) {
          // getFileOutput(arg);
        }
        else if (arg.equals("-scrape")){
          printScraper("first_arg");
          System.out.println("Enter the food you want");
          Scanner food = new Scanner(System.in);
          System.out.println(food.nextLine());
          WebsiteScraper getFood = new WebsiteScraper("https://www.foodnetwork.com/search/pepper-pot-");
          getFood.getMarkup("high");
          System.out.println("Which one do you want?");
          Scanner pickone = new Scanner(System.in);
          System.out.println(food.nextLine());
          WebsiteScraper getType = new WebsiteScraper("https://www.foodnetwork.com/search/pepper-pot-");
          getType.getMarkup("low");
          // should i add this to the hash table at this point???

          // also store in file
        }
        // use this type of check for a series of flag arguments
        else {
            runArgumentCommand(arg);
        }
     }
    
    if (i == cliArgs.length)
        System.err.println("Usage: ParseCmdLine [-verbose] [-xn] [-output afile] filename");
    else
        System.out.println("Success!");
    
   }
  
  public static void printScraper(String arg){
    /**
     * Scraper -> Asks for recipie -> then asks which of the recipies to choose from
     * If no results are found, then say error and try again
     */
    Scanner victor = new Scanner(System.in);
    System.out.println(victor.nextLine());

  }

  
  public static void isVerbose() {
 // use this type of check for "wordy" arguments
        System.out.println("verbose mode on");
        vflag = true;
        System.out.println("Verbose: " + vflag);
  }
  
  // public static int getFileInput(int index, String[] cliArgs) throws IOException {
  //   String addType = cliArgs[index++];
  //   if(getFileType(addType) == ".html") {
  //     String myHtmlFile = new WebsiteScraper();
  //     myHtmlFile.getinput();
  //   }
    
  // }
  
  // public static int getFileOutput(int index, String[] cliArgs) throws IOException {
  //   String addType = cliArgs[index++];
  //   if(getFileType(addType) == ".html") {
  //     String myHtmlFile = new WebsiteScraper(addType);
  //     myHtmlFile.getinput()
  //   }
  //   if(getFileType(addType) == ".jpg") {
  //     String myHtmlFile = new WebsiteScraper(Type);
  //     myHtmlFile.getinput()
  //   }
  //   if(getFileType(addType) == ".pdf") {
  //     String myHtmlFile = new WebsiteScraper(addType);
  //     myHtmlFile.getOuput()
  //   }
  //   if(getFileType(addType) == ".png") {
  //     String myHtmlFile = new WebsiteScraper(addType);
  //     myHtmlFile.getOutput()
  //   }
  // }
  
  // public static int getFileInput(int index, String[] cliArgs) throws IOException {
  //   String addType = cliArgs[index++];
  //   if(getFileType(addType) == ".html") {
  //     String myHtmlFile = new WebsiteScraper();
  //     myHtmlFile.getinput()
  //   }
  // }
  
  public static int isInput(int index, String[] cliArgs, HashBrowns table) throws IOException {
    //boolean isAdd = Boolean.parseBoolean(cliArgs[index++]);
    String addType = cliArgs[index++];
    if(addType.equals("-f")) {
      // add to hash table
      String foodTitle = cliArgs[index++];
      table.addNewFood(foodTitle);
      System.out.println("Added new Food type: " + foodTitle);
      SimpleFile.write(foodTitle);
    }
    else if(addType.equals("-r")){
      String foodType = cliArgs[index++];
      String title = cliArgs[index++];
      String chef = cliArgs[index++];
      String preptime = cliArgs[index++];
      String directions = cliArgs[index++];
      String rating = cliArgs[index++];
      table.getFoodTable(foodType).addFoodType(title, chef, preptime, directions, rating);
      System.out.println(table.getFoodTable(foodType).getFood(title).getTitle());
      SimpleFile.write(foodType, title, chef, preptime, directions, rating);
    }
    else if(addType.equals("-c")) {
      SimpleFile.writeTextFile();
    }
    return index;
  }
  
  private static void isOutput(int index, String[] cliArgs) throws IOException {
    String outputfile = "";

    if (index < cliArgs.length) {
      outputfile = cliArgs[index++];
    }
    else {
        System.err.println("-output requires a filename");
    }
    if (vflag) {
        System.out.println("output file = " + outputfile);
    }
    SimpleFile.readFile();
    
  }
  
  /**
   * 
   * @param {String} arg
   */
  private static void runArgumentCommand(String arg) {
    char flag;
    
    for (int j = 1; j < arg.length(); j++) {
      flag = arg.charAt(j);
      switch (flag) {
      case 'x':
          if (vflag) System.out.println("Option x");
          break;
      case 'n':
          if (vflag) System.out.println("Option n");
          break;
      default:
          System.err.println("ParseCmdLine: illegal option " + flag);
          break;
      }
    }
  }
}
  

