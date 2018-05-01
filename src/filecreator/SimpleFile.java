package filecreator;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class SimpleFile {
  
  public static void write (String Food) throws IOException{

    Path getFile = Paths.get("food.txt");

    List<String> lines = Arrays.asList("\n", Food);
    Files.write(getFile, lines, Charset.forName("UTF-8"));
  }

  public static void write (String Food, String Recipie, String Chef, String prepTime, String directions, String rating) throws IOException{
    Path getFile = Paths.get("food.txt");

    List<String> lines = Arrays.asList("\n", Food, Recipie, Chef, prepTime, directions, rating);
    Files.write(getFile, lines, Charset.forName("UTF-8"));
    
  }
  
  public static void writeTextFile () throws IOException{
    Path getFile = Paths.get("input.txt");
    Path foodoutputFile = Paths.get("food.txt");
    List<String> checkLines = Files.readAllLines(getFile);    
    
    Files.write(foodoutputFile, checkLines, Charset.forName("UTF-8"));
    
  }
  
  
  public static void writeTextFile (String Food, String Recipie, String Chef, String prepTime, String directions, String rating) throws IOException{
    Path getFile = Paths.get("input.txt");
    Path foodoutputFile = Paths.get("food.txt");
    List<String> checkLines = Files.readAllLines(getFile);    
    
    Files.write(foodoutputFile, checkLines, Charset.forName("UTF-8"));
    
  }
  
  public static void readFile() throws IOException {
    Path getFile = Paths.get("food.txt");

    List<String> checkLines = Files.readAllLines(getFile);    

    for(String line : checkLines){
      // Do whatever you want
     System.out.println(line);
   }
  }
}
