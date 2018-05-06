package scraper;
import customhashtable.RecipeObject;

public class RecipeScraper {
 public String FOODNAME;
 public String URL;
 public  String AUTHORNAME;
 public String RATING;
 public RecipeObject []foodNamehigh = new RecipeObject[10];
 public RecipeObject furtherBeyond;
 public int indexG = 0;
  RecipeScraper(String cachedMarkup){
    int index = 0;
    int counter = 1;
   
    String []searchString;
    while(true) {
      searchString = cachedMarkup.split("<!-- searchResults index:"+ index++ + " count:"+counter++ +"-->");
      if(searchString.length < 2){
        break;
      }
      AUTHORNAME = getAuthor(searchString);
      if(AUTHORNAME == ""){
        //NOT A VALID RECIPIE
        continue;
      }
      FOODNAME = getFoodName(searchString);
      URL = getRecipieUrl(searchString);
      // RATING = getRating(searchString);
      indexG++;
    }

  }

  public String getFoodName(String[] passIn){
    String []searchForTitle = passIn[1].split("<span class=\"m-MediaBlock__a-HeadlineText\">")[1].split("</span>");
    System.out.println(searchForTitle[0]);
    foodNamehigh[indexG].title = searchForTitle[0];
    return searchForTitle[0];
  }

  public String getAuthor(String[] passIn){
    //m-Info__a-AssetInfo
    String []searchForRecipe = passIn[1].split("<span class=\"m-Info__a-AssetInfo\">")[1].split("</span>");
    String []courtesyCheck = searchForRecipe[0].split("Courtesy of ");
    if(courtesyCheck.length == 1){
      foodNamehigh[indexG].chef = "None";
      return "None";
    }
    System.out.println(courtesyCheck[1] + "-=------");
    String author = courtesyCheck[1];
    System.out.println(foodNamehigh[0]);
    foodNamehigh[indexG] = new RecipeObject();
    foodNamehigh[indexG].chef = author;
    System.out.println(author);
    return author;

  }

  public String getRecipieUrl(String[] passIn){
    //m-MediaBlock__a-Headline
    String []searchForRecipe = passIn[1].split("<a href=\"//")[1].split("\">");
    String url = searchForRecipe[0];
    System.out.println(url);
    foodNamehigh[indexG].url = url;

    return url;
  }

  // public String getRating(String passIn) {
  //   // <span class="gig-rating-stars" title="of 5 stars">
  //   String []rating = passIn[1].split("<span class=\"gig-rating-stars\" title=\"")[1].split(" of 5 stars\">");
  //   System.out.println(rating+"\n");
  //   return rating.length > 1 ? rating[0] : "No rating";
  // }

  public static String furtherBeyond(String passFromMarkup){
    // System.out.println(passFromMarkup);
    String result = passFromMarkup.split("<div class=\"o-Method__m-Body\">")[1].split("</div>")[0].replace("<p>","").replace("</p>", "").replaceAll("\\s\\s+","");
    System.out.println(passFromMarkup.split("<div class=\"o-Method__m-Body\">")[1].split("</div>")[0].replace("<p>","").replace("</p>", "").replaceAll("\\s\\s+",""));
    // System.out.println(passFromMarkup.split("<div class=\"o-Ingredients__m-Body\">")[1].split("</div>")[0].replace("<p>","").replace("</p>", "").replaceAll("\\s\\s+",""));
    return result;
    // //iterate through ingredients
    // String ingrediants = getIngredients(passFromMarkup);

  }

  public static String getIngredients(String passFromMarkup){
    int index = 0;
    // System.out.println(passFromMarkup.split("<div class=\"o-Ingredients__m-Body\">")[1].split("</div>")[0]);
    while(true) {
      String[] searchString = passFromMarkup.split("<label class=\"o-Ingredients__a-ListItemText\" for=\"Ingredient0"+index+++"\">");
      if(searchString.length < 2){
        break;
      }
      // System.out.println(searchString[0]);
      System.out.println(searchString[1].split("</label>")[0]);
      return searchString[1].split("</label>")[0];
      // String AUTHORNAME = getAuthor(searchString);
      // if(AUTHORNAME == ""){
      //   //NOT A VALID RECIPIE
      //   continue;
      // }
      // String FOODNAME = getFoodName(searchString);
      // String URL = getRecipieUrl(searchString);
      // // String RATING = getRating(searchString);

    }
    return "";
  }


}