package customhashtable;
import java.util.Hashtable;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Set;

public class FoodHashTable {
  Hashtable<String,RecipeObject> RecipeTable;

  public FoodHashTable() {
    RecipeTable = new Hashtable<String, RecipeObject>();
  }
  
  public void addFoodType(String aft, String chef, String preptime, String directions, String rating ) {
    RecipeTable.put(aft, new RecipeObject(aft, preptime, directions, rating));
  }
  
  public RecipeObject getFood(String gfs) {
     return RecipeTable.get(gfs);
  }
  
}
