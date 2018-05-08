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


import customhashtable.HashBrowns;
import scraper.RecipeScraper;

public class MainViewController {

  ObservableList<String> items = FXCollections.observableArrayList("search");
  ListView<String> list; //= new ListView<>();
  WebsiteScraper getFood;
  RecipeObject[] parseData;
  HashBrowns table = new HashBrowns();
  RecipeObject potentialSave;
  ListView<String> listSaved = new ListView<>();


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
    private Button selectSave;

    @FXML
    private AnchorPane showSaved;

    @FXML
    private Button saveButton;

    @FXML
    private Button removeSaved;

    @FXML
    void ExitApp(ActionEvent event) {

    }


    @FXML
    void removeFromSave(ActionEvent event) {
      showSaved.getChildren().remove(listSaved.getSelectionModel().getSelectedItem());
    }

    @FXML
    void saveRecipe(ActionEvent event) {
      String nameofReci = potentialSave.getTitle();
      String urlOfReci = potentialSave.getURL();
      listSaved.getItems().add(potentialSave.getType() + ":" + potentialSave.getTitle());
      showSaved.getChildren().addAll(listSaved);
    }

    @FXML
    void getValueFromSave(ActionEvent event) throws Exception {
      String[] chosenString = listSaved.getSelectionModel().getSelectedItem().split(":");
      System.out.println(chosenString[0]+ "-------" + chosenString[1]);
      String desiredUrl = table.getFoodTable(chosenString[0]).RecipeTable.get(chosenString[1]).getURL();
      System.out.println(desiredUrl);
      String justMarkup = WebsiteScraper.justGetMarkUp(desiredUrl);

      String directions = RecipeScraper.furtherBeyond(justMarkup);
      String ingredients = RecipeScraper.getIngredients(justMarkup);

      ShowIngredients.setText(ingredients);
      ShowDirections.setText(directions);

    }


    @FXML
    void addToHash(ActionEvent event) throws Exception{
      int chosenString = Integer.parseInt(list.getSelectionModel().getSelectedItem().split(":")[0]);

      String chosenNode = parseData[chosenString].getURL();
      System.out.println(list.getSelectionModel().getSelectedItem());
      String justMarkup = WebsiteScraper.justGetMarkUp(chosenNode);

      String directions = RecipeScraper.furtherBeyond(justMarkup);
      String ingredients = RecipeScraper.getIngredients(justMarkup);
      if(table.getFoodTable(foodTEXT) == null){
      table.addNewFood(foodTEXT);
      }
      table.getFoodTable(foodTEXT).addFoodType(
        parseData[chosenString].getTitle(), 
        foodTEXT,
        parseData[chosenString].getChef(), 
        " ", 
        directions, 
        ingredients,
        chosenNode
        );
      // System.out.println(table.getFoodTable("apple").getFood(parseData[chosenString].getTitle()).getURL()+ "apppppppppple");
      this.potentialSave = new RecipeObject(
        foodTEXT,
        parseData[chosenString].getTitle(), 
        parseData[chosenString].getChef(), 
        " ", 
        directions, 
        ingredients,
        chosenNode
        );

        ShowIngredients.setText(ingredients);
        ShowDirections.setText(directions);
    }

    @FXML
    void searchForRecipes(ActionEvent event) throws Exception {
      showOptions.getChildren().removeAll(list);
      list = new ListView<>();
      foodTEXT = foodtextbook.getText();
      if(foodtextbook.getText() == "") {
        System.out.println(foodtextbook.getText());
        System.out.println("Try again");
      }
      else {
        getFood = new WebsiteScraper("https://www.foodnetwork.com/search/"+foodTEXT+"-");
        parseData = getFood.getMarkup("high");
        System.out.println(parseData[0].getTitle());
        
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
        wantMore.setDisable(false);
      }
    }

}

