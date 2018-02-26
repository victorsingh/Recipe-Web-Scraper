package customhashtable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Set;

/**
 * HashBrowns is the custom data structure used in CS 370
 * Different HashBrowns can be used for Recipies, Authtors, and Prep time.
 * The hash browns will take up more space, but will have faster runtime
 * 
 * @author victor
 *
 */

public class HashBrowns {

  Hashtable<String,FoodHashTable> FoodTable;
  
  public HashBrowns() {
     FoodTable = new Hashtable();
   }
  
  public void addNewFood(String s) {
    FoodTable.put(s, new FoodHashTable());
  }
  
  public FoodHashTable getFoodTable(String s) {
    return FoodTable.get(s);
  }

}
