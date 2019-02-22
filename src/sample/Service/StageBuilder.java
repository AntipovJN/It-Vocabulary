package sample.Service;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;

public class StageBuilder {
    public static Stage createScene( Parent parent, String title, Window parentWindow){
        Stage stage = new Stage();
        stage.setTitle(title);
        stage.setHeight(130);
        stage.setWidth(300);
        stage.setResizable(false);
        stage.setScene(new Scene(parent));
        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner(parentWindow);
        return stage;
    }
}
