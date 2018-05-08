package parser.cli;

import java.io.IOException;

import customhashtable.HashBrowns;
import customhashtable.RecipeObject;
import filecreator.SimpleFile;
import scraper.RecipeScraper;
import scraper.WebsiteScraper;
import java.util.Scanner;
import customhashtable.FoodHashTable;

public class CLIParser {
  private static boolean vflag = false;
  private static HashBrowns preMadeTable;
  private static SimpleFile file;
  private static HashBrowns table = new HashBrowns();
  private static boolean verified = false;
  /**
   * 
   * @param {String[]} cliArgs
   * @param {HashBrowns} x
   * @throws IOException 
   */
  public static void checkauthwrapper() {
    
  }
  
  public static void processArguments(String[] cliArgs, HashBrowns x) throws Exception {
    preMadeTable = x;
    int i = 0;
    String arg;
    boolean living = false;
    
    // while (!verified) {
    //   System.out.println("Press 0 to create an account, press 1 to log in, press 2 to run as guest");
    //   Scanner authchoice = new Scanner(System.in);
    //   String acthChoice = authchoice.nextLine();
    //   if(checkauthwrapper(authChoice) == true) {
    //     verified = true;
    //   }
    //   else {
    //     continue;
    //   }
    // }


    
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
          while (true) {
          System.out.println("Add or search?");
          Scanner chooseAction = new Scanner(System.in);
          String cAction = chooseAction.nextLine();
          // chooseAction.close();
          System.out.print(cAction);
          if(cAction.equals("Search")){
            searchHashTable();
          }
          else{
          System.out.println("Enter the food you want");
          Scanner food = new Scanner(System.in);
          String foodTEXT = food.nextLine();
          // food.close();
          System.out.println(foodTEXT);
          if(foodTEXT == "EXIT"){
            break;
          }
          WebsiteScraper getFood = new WebsiteScraper("https://www.foodnetwork.com/search/"+foodTEXT+"-");
          RecipeObject[] parseData = getFood.getMarkup("high");
          System.out.println(parseData[0].title + "dlkfjsdlkf");
          for(RecipeObject data : parseData){
            System.out.println(data.getTitle() + " by "+ data.getChef());
          }
          System.out.println("Which one do you want?");
          Scanner pickone = new Scanner(System.in);
          RecipeObject chosenOne = parseData[Integer.parseInt(pickone.nextLine())];
          // pickone.close();
          String justMarkup = WebsiteScraper.justGetMarkUp(chosenOne.getURL());

          String directions = RecipeScraper.furtherBeyond(justMarkup);
          String ingredients = RecipeScraper.getIngredients(justMarkup);
          if(table.getFoodTable(foodTEXT) == null){
          table.addNewFood(foodTEXT);
          }
          table.getFoodTable(foodTEXT).addFoodType(
            foodTEXT,
            chosenOne.getTitle(), 
            chosenOne.getChef(), 
            " ", 
            directions, 
            ingredients 
            );

          System.out.println("You've added" + chosenOne.getTitle() + " to the hash table");
          SimpleFile.write(
            foodTEXT,
            chosenOne.getTitle(), 
            chosenOne.getChef(), 
            " ", 
            directions, 
            ingredients 
            );
        }
      }

          // should i add this to the hash table at this point???

          // also store in file afterwards
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

   public static void searchHashTable(){
    System.out.println("What do you want to search for?");
    Scanner thingToSearchfor = new Scanner(System.in);
    FoodHashTable copyTable = table.getFoodTable(thingToSearchfor.nextLine());
    if(copyTable != null){
      // Scanner thingToSearchfor = new Scanner(System.in);
      for(String val: copyTable.RecipeTable.keySet()){
        System.out.print(val);
        System.out.println(copyTable.RecipeTable.get(val).getTitle());
      }
    }
   }

  
  public static void isVerbose() {
 // use this type of check for "wordy" arguments
        System.out.println("verbose mode on");
        vflag = true;
        System.out.println("Verbose: " + vflag);
  }
  
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
      table.getFoodTable(foodType).addFoodType(foodType, title, chef, preptime, directions, rating);
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
  

