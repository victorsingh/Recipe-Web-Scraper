package scraper;
public class RecipeScraper {
  RecipeScraper(String cachedMarkup){
    int index = 0;
    int counter = 1;
    String []searchString;
    while(true) {
      searchString = cachedMarkup.split("<!-- searchResults index:"+ index++ + " count:"+counter++ +"-->");
      if(searchString.length < 2){
        break;
      }
      String AUTHORNAME = getAuthor(searchString);
      if(AUTHORNAME == ""){
        //NOT A VALID RECIPIE
        continue;
      }
      String FOODNAME = getFoodName(searchString);
      String URL = getRecipieUrl(searchString);
      // String RATING = getRating(searchString);

    }

  }

  public static String getFoodName(String[] passIn){
    String []searchForTitle = passIn[1].split("<span class=\"m-MediaBlock__a-HeadlineText\">")[1].split("</span>");
    System.out.println(searchForTitle[0]);
    return searchForTitle[0];
  }

  public static String getAuthor(String[] passIn){
    //m-Info__a-AssetInfo
    String []searchForRecipe = passIn[1].split("<span class=\"m-Info__a-AssetInfo\">")[1].split("</span>");
    String []courtesyCheck = searchForRecipe[0].split("Courtesy of ");
    if(courtesyCheck.length == 1){
      return "";
    }
    String author = courtesyCheck[1];
    System.out.println(author);
    return author;

  }

  public static String getRecipieUrl(String[] passIn){
    //m-MediaBlock__a-Headline
    String []searchForRecipe = passIn[1].split("<a href=\"//")[1].split("\">");
    String url = searchForRecipe[0];
    System.out.println(url);
    return url;
  }

  // public static String getRating(String passIn) {
  //   // <span class="gig-rating-stars" title="of 5 stars">
  //   String []rating = passIn[1].split("<span class=\"gig-rating-stars\" title=\"")[1].split(" of 5 stars\">");
  //   System.out.println(rating+"\n");
  //   return rating.length > 1 ? rating[0] : "No rating";
  // }

  public static void furtherBeyond(String passFromMarkup){
    // System.out.println(passFromMarkup);
    System.out.println(passFromMarkup.split("<div class=\"o-Method__m-Body\">")[1].split("</div>")[0].replace("<p>","").replace("</p>", "").replaceAll("\\s\\s+",""));
    // System.out.println(passFromMarkup.split("<div class=\"o-Ingredients__m-Body\">")[1].split("</div>")[0].replace("<p>","").replace("</p>", "").replaceAll("\\s\\s+",""));

    //iterate through ingredients
    String ingrediants = getIngredients(passFromMarkup);

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