package parser.cli;

import customhashtable.HashBrowns;

public class CLIParser {
  private static boolean vflag = false;
  private static HashBrowns preMadeTable;

  /**
   * 
   * @param {String[]} cliArgs
   * @param {HashBrowns} x
   */
  
  public static void processArguments(String[] cliArgs, HashBrowns x) {
    
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
  
  public static void isVerbose() {
 // use this type of check for "wordy" arguments
        System.out.println("verbose mode on");
        vflag = true;
        System.out.println("Verbose: " + vflag);
  }
  
  public static int isInput(int index, String[] cliArgs, HashBrowns table) {
    //boolean isAdd = Boolean.parseBoolean(cliArgs[index++]);
    System.out.println("I made it");
    String addType = cliArgs[index++];
    if(addType.equals("-f")) {
      // add to hash table
      String foodTitle = cliArgs[index++];
      table.addNewFood(foodTitle);
      System.out.println("Added new Food type: " + foodTitle);
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
    }
    return index;
  }
  
  private static void isOutput(int index, String[] cliArgs) {
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
  

