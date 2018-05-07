package view;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import customhashtable.RecipeObject;
import javafx.event.ActionEvent;
import javafx.scene.control.ListView;
import parser.cli.CLIParser;
import scraper.WebsiteScraper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.cell.TextFieldListCell;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.Scene;

import java.net.IDN;

// import com.sun.xml.internal.ws.org.objectweb.asm.Label;

import customhashtable.HashBrowns;
import scraper.RecipeScraper;

public class MainViewController {

  ObservableList<String> items = FXCollections.observableArrayList("search");
  // ObservableList<String> itemsS = FXCollections.observableArrayList("Ingredients");
  ListView<String> list = new ListView<>(items);
  // ListView<String> listSpecific = new ListView<>(itemsS);
  WebsiteScraper getFood;
  RecipeObject[] parseData;
  HashBrowns table = new HashBrowns();
  String foodTEXT;


    @FXML
    private MenuItem quitapp;

    @FXML
    private Font x1;

    @FXML
    private Color x2;
    
    @FXML
    private TextArea foodtextbook;

    @FXML
    private Button SearchButton;

    @FXML
    private AnchorPane showOptions;

    @FXML
    private TextArea ShowIngredients;

    @FXML
    private TextArea ShowDirections;

    @FXML
    private Button wantMore;

    @FXML
    private Font x3;

    @FXML
    private Color x4;

    @FXML
    void ExitApp(ActionEvent event) {

    }

    @FXML
    void addToHash(ActionEvent event) throws Exception{
      int chosenString = Integer.parseInt(list.getSelectionModel().getSelectedItem().split(":")[0]);

      String chosenNode = parseData[chosenString].getURL();
      System.out.println(list.getSelectionModel().getSelectedItem());
      String justMarkup = WebsiteScraper.justGetMarkUp(chosenNode);

      String directions = RecipeScraper.furtherBeyond(justMarkup);
      String ingredients = RecipeScraper.getIngredients(justMarkup);
      // if(table.getFoodTable(foodTEXT) == null){
      // table.addNewFood(foodTEXT);
      // }
      // table.getFoodTable(foodTEXT).addFoodType(
      //   parseData[chosenString].getTitle(), 
      //   parseData[chosenString].getChef(), 
      //   " ", 
      //   directions, 
      //   ingredients 
      //   );

        // ObservableList<String> itemsS = FXCollections.observableArrayList();

        // Scene scene = new Scene(ShowIngredients, 300, 250);
        ShowIngredients.setText(ingredients);
        ShowDirections.setText(directions);

        // System.out.println(ShowIngredients.getText()+ "get----");
        // Text ingTxt = new Text(ingredients);
        // ingTxt.wrappingWidthProperty().bind(ShowIngredients.widthProperty());
        // ShowIngredients.setFitToWidth(true);
        // ShowIngredients.setContent(new TextArea().appendText("heejfsklfjslkf"));
   
        // ObservableList<String> itemsS = FXCollections.observableArrayList("Ingredients");

        // ListView<String> listSpecific = new ListView<>(itemsS);
        // listSpecific.setMaxHeight(1000);
        // // Text Ingredients = new Text(ingredients);
        // listSpecific.getItems().add(ingredients);

        // System.out.println(directions+ "-------------green");
        // // System.out.println(listSpecific.get)
        // listSpecific.setCellFactory(TextFieldListCell.forListView());
        // listSpecific.setEditable(false);
        // ingrtext.setText(ingredients);
        // ShowIngredients.getChildren().add(new Text("\n\n\n"+directions));
    }

    @FXML
    void searchForRecipes(ActionEvent event) throws Exception {
      foodTEXT = foodtextbook.getText();
      if(foodtextbook.getText() == "") {
        System.out.println(foodtextbook.getText());
        System.out.println("Try again");
      }
      else {
        getFood = new WebsiteScraper("https://www.foodnetwork.com/search/"+foodTEXT+"-");
        parseData = getFood.getMarkup("high");
        System.out.println(parseData[0].getTitle());
        // TableColumn table = new TableColumn("Options");
        // table.setMinWidth(90);
        // showOptions.setTopAnchor(list, 10.0);
        // showOptions.setLeftAnchor(list, 10.0);
        // showOptions.setRightAnchor(list, 65.0);
        // // Button will float on right edge
        // Button button = new Button("Add");
        int i = 0;
        for(RecipeObject data: parseData){
          try{
            list.getItems().add(i + ": " + data.getTitle()+ " by " + data.getChef());
            i++;
          }
          catch(Exception e){
            break;
          }
        }

        list.setCellFactory(TextFieldListCell.forListView());
        list.setEditable(false);
        showOptions.getChildren().addAll(list);
        System.out.println(list.getSelectionModel().getSelectedItem());
        // showOptions.getChildren().addAll(new Text("dads\n"),new Text("Heldasdlo\n"),new Text("Hedasdllo\n"),new Text("Heldasdlo\n"));
        wantMore.setDisable(false);
      }
    }

}

