package sample.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.DAO.WordDAO;
import sample.Entity.Word;

public class VocController {


    @FXML
    private TextField fieldNewWord;

    @FXML
    private TextField fieldNewDescription;

    @FXML
    private Button addButton;

    private Word word;


    public void setWord(Word word) {
        this.word = word;
        fieldNewWord.setText(word.getEngVerb());
        fieldNewDescription.setText(word.getRusVerb());

    }

    public void addAction(ActionEvent actionEvent) {
        String engVerb = fieldNewWord.getText();
        String rusVerb = fieldNewDescription.getText();
        WordDAO.addWord(engVerb, rusVerb);
        CancelAction(actionEvent);
    }

    public void editAction(ActionEvent actionEvent) {
        String engVerb = fieldNewWord.getText();
        String rusVerb = fieldNewDescription.getText();
        WordDAO.editWord(word, engVerb, rusVerb);
        CancelAction(actionEvent);
    }

    public void CancelAction(ActionEvent actionEvent) {
        Stage stage = (Stage) addButton.getScene().getWindow();
        stage.hide();
    }


}