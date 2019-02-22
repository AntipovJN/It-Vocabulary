package sample.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.DAO.WordDAO;
import sample.Entity.Word;

public class ChangeController {
    @FXML
    private TextField fieldNewWord ;

    @FXML
    private TextField fieldNewDescription;

    @FXML
    private Button editButton;

    private Word word;

    @FXML
    void CancelAction(ActionEvent event) {
        Stage stage = (Stage) editButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    void editAction(ActionEvent event) {

        Stage stage = (Stage) editButton.getScene().getWindow();
        String engVerb= fieldNewWord.getText();
        String rusVerb= fieldNewDescription.getText();
        WordDAO.editWord(word , engVerb,rusVerb);
        stage.close();
        System.out.println(WordDAO.getWordCollection().toString());
    }
        public void setWord (Word word){
        this.word = word;

        fieldNewWord.setText(word.getEngVerb());
        fieldNewDescription.setText(word.getRusVerb());
    }

}
