package filecreator;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileCreator {
  private Path file;
  private ArrayList<String> childtabs = new ArrayList<String>();
  private String childtab = "\n";
  
  public FileCreator(String nameOfParent) throws IOException{

    List<String> lines = Arrays.asList("{\n", "  " + nameOfParent + ": {\n", "  }\n", "}\n");
    file = Paths.get("food.txt");
    Files.write(file, lines, Charset.forName("UTF-8"));
    Path fileM = Paths.get("newFood.txt");
    
    List<String> checkLines = Files.readAllLines(file);    
 
    for(String line : checkLines){
      // Do whatever you want
     //System.out.println(line);
   }
    
  }
  
  /*
   * Goal, check for the latest { in the file: when you find it,  create what you want to create
   */
  public void addObject() throws IOException {
    
    List<String> lines = Arrays.asList("Pizza" + ": {\n", "  }\n", "}");
    List<String> checkLines = Files.readAllLines(this.file);    
    List<String> newLines = new ArrayList<String>();
    int i = 0;
    for(String line = checkLines.get(i); i <= checkLines.size()-2; line = checkLines.get(++i) ) {
      System.out.println(line);
      newLines.add(line);
      if(line.equals("  " + "FoodNetwork" + ": {")) {
        System.out.println("    Good to food network");
        newLines.add("    Good to food network" + ": { ");
      }
      
    }
    System.out.println(newLines);
    Path fileM = Paths.get("newFood.txt");
    Files.write(fileM, newLines, Charset.forName("UTF-8"));

    

  }
}
