package lines.fx.sample.sample01;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class ClickMe extends Application {

    public static void main(String[] args) {
        launch(args);
        System.out.println("Done");
    }

    Button btn;

    @Override
    public void start(Stage stage) throws Exception {
        // Create the button
        btn = new Button();
        btn.setText("Click me please!");
        btn.setOnAction(e -> buttonClick());

        // Add the button to a layout pane
        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(btn);

        // Add the layout pane to a scene
        Scene scene = new Scene(borderPane, 300, 250);

        // Add the scene to the stage , set the title
        // and show the stage
        stage.setScene(scene);
        stage.setTitle("The Click Me App");
        stage.show();

    }

    public void buttonClick(){
        if(btn.getText() == "Click me please!"){
            btn.setText("You clicked me!");
        }else{
            btn.setText("Click me please!");
        }
    }
}
