import java.io.BufferedReader;

public class launcher {

  public static void main(String[] args) throws Exception {
    // TODO Auto-generated method stub
    String a = "Hello world";
    System.out.println(a.hashCode());
    System.out.println("".hashCode());
    System.out.println("Hello world");
    HashBrowns x = new HashBrowns();
    x.addNewFood("Fried Chicken");
    System.out.println(x.getFoodTable("Fried Chicken"));
    x.getFoodTable("Fried Chicken").addFoodType("Southern Fried Chicken", "Ina Garten", "40 mins", "String with directions","5");
    System.out.println(x.getFoodTable("Fried Chicken").getFood("Southern Fried Chicken").prepTime());
    BufferedReader reader = WebpageReaderWithAgent.read("https://www.foodnetwork.com/search/pepper-pot-");
    System.out.println(reader);
    String line = reader.readLine();
      
    while (line != null) {
    
      System.out.println(line);
      
      line = reader.readLine();
    
     } // while

  }

}
