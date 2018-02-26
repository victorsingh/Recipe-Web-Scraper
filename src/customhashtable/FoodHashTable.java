package customhashtable;
import java.util.Hashtable;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Set;

public class FoodHashTable {
  Hashtable<String,RecipieObject> RecipieTable;

  public FoodHashTable() {
    RecipieTable = new Hashtable();
  }
  
  public void addFoodType(String aft, String chef, String preptime, String directions, String rating ) {
    RecipieTable.put(aft, new RecipieObject(aft, preptime, directions, rating));
  }
  
  public RecipieObject getFood(String gfs) {
     return RecipieTable.get(gfs);
  }
  
}
