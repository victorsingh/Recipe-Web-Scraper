package customhashtable;
import java.util.Hashtable;
import java.util.Hashtable;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Set;

public class RecipeObject {
  private String title, chef, prepTime, directions;
  
  RecipeObject(){
    
  }
  
  RecipeObject(String t, String c, String pT, String d){
    title = t;
    chef = c;
    prepTime = pT;
    directions = d;
  }
  
  public String getTitle() {
    return title;
  }
  
  public String getChef() {
    return chef;
  }
  
  public String prepTime() {
    return prepTime;
  }
  
  public String directions() {
    return directions;
  }
  
}
