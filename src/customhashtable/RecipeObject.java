package customhashtable;
import java.util.Hashtable;
import java.util.Hashtable;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Set;

public class RecipeObject {
  public String title, chef, prepTime, directions, ingrediants, url;

  public RecipeObject(){

  }
  
  public RecipeObject(String t, String c, String u){
    title = t;
    chef = c;
    url = u;
  }
  
  public RecipeObject(String t, String c, String pT, String d, String i){
    title = t;
    chef = c;
    prepTime = pT;
    directions = d;
    ingrediants = i;
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
    
  public String ingrediants() {
    return ingrediants;
  }

  public String getURL(){
    return url;
  }
  
}
