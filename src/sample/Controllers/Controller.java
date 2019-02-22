package sample.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.stage.Window;
import sample.DAO.WordDAO;
import sample.Entity.Word;
import sample.Service.StageBuilder;

import java.io.IOException;


public class Controller {


    @FXML
    private Button buttonPlay;

    @FXML
    private Button buttonAddNewWord;

    @FXML
    private Button buttonSearch;

    @FXML
    private TextField fieldSearch;

    @FXML
    private Button buttonChangeWord;

    @FXML
    private Button buttonDeleteWord;

    @FXML
    private TableView<Word> tableVoc;

    @FXML
    private TableColumn<Word, String> engVerbColumn;

    @FXML
    private TableColumn<Word, String> rusVerbColumn;
    private Parent fxmlAdd;
    private Parent fxmlEdit;

    private FXMLLoader fxmlLoader = new FXMLLoader();

    private VocController editDialogController;

    private Stage editDialogStage;
    private Stage addDialogStage;


    @FXML
    public void initialize() {
        engVerbColumn.setCellValueFactory(new PropertyValueFactory<Word, String>("engVerb"));
        rusVerbColumn.setCellValueFactory(new PropertyValueFactory<Word, String>("rusVerb"));


        tableVoc.setItems(WordDAO.getWordCollection().getWordList());

        fxmlInit();
    }

    public void fxmlInit() {
        try {
            fxmlAdd = FXMLLoader.load(getClass().getResource("../Scenes/addDialogWindow.fxml"));
            fxmlLoader.setLocation(getClass().getResource("../Scenes/editDialogWindow.fxml"));
            fxmlEdit = fxmlLoader.load();
            editDialogController = fxmlLoader.getController();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void actionButtonPressed(ActionEvent action) {
        Object source = action.getSource();
        if (!(source instanceof Button)) {
            return;
        }
        Window parentWindow = ((Node) action.getSource()).getScene().getWindow();

        Button clickedButton = (Button) source;

        Word selectedWord = tableVoc.getSelectionModel().getSelectedItem();


        switch (clickedButton.getId()) {
            case "buttonAddNewWord":
                showDialog(parentWindow, "Add");
                break;

            case "buttonChangeWord":
                if (selectedWord != null) {
                    editDialogController.setWord(selectedWord);
                    showDialog(parentWindow, "Edit");
                }
                break;

            case "buttonDeleteWord":
                if (selectedWord != null) {
                    editDialogController.setWord(selectedWord);
                    WordDAO.remove(selectedWord);
                }
                break;
        }


    }

    public void showDialog(Window parentWindow, String title) {
        if (title.equals("Edit")) {
            if (editDialogStage == null) {
                editDialogStage = StageBuilder.createScene(fxmlEdit, "Edit", parentWindow);
                editDialogStage.show();
            } else {
                editDialogStage.show();
            }
        } else if (title.equals("Add")) {
            if (addDialogStage == null) {
                addDialogStage = StageBuilder.createScene(fxmlAdd, "Add", parentWindow);
                addDialogStage.show();
            } else {
                addDialogStage.show();
            }
        }
    }


    public void startGame(ActionEvent action) {
    }
}



