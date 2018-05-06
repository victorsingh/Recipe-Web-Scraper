package customhashtable;
import java.util.Hashtable;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Hashtable;
import customhashtable.RecipeObject;

import java.util.Set;

public class FoodHashTable {
  public Hashtable<String,RecipeObject> RecipeTable;

  public FoodHashTable() {
    RecipeTable = new Hashtable<String, RecipeObject>();
  }
  
  public void addFoodType(String aft, String chef, String preptime, String directions, String ingredients ) {
    RecipeTable.put(aft, new RecipeObject(aft, chef, preptime, directions, ingredients));
  }
  
  public RecipeObject getFood(String gfs) {
     return RecipeTable.get(gfs);
  }
  
}
