
package twil;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.text.*;


public class fx extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage){
        primaryStage.setTitle("numberInput");
        StackPane root = new StackPane();
        StackPane root2 = new StackPane();
        StackPane root3 = new StackPane();


        VBox vb = new VBox();
        VBox vb2 = new VBox();
        VBox vb3 = new VBox();

        Button btn = new Button("Go");
        Button btnCheck = new Button("Verify");

        TextField field = new TextField();
        TextField field2 = new TextField();
        Text t = new Text();
        t.setFont(new Font(20));
        t.setText("Login Success");

        vb.getChildren().addAll(btn, field);
        vb2.getChildren().addAll(field2, btnCheck);
        vb3.getChildren().addAll(t);

        root.getChildren().add(vb);
        root2.getChildren().add(vb2);
        root3.getChildren().add(vb3);

        primaryStage.setScene(new Scene(root, 300, 250));
        primaryStage.show();

        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String num = field.getText();
                TwilioSender.sendText(num);
                primaryStage.setScene(new Scene(root2, 300, 250));
            }
        });

        btnCheck.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String secretCode = field2.getText();
                if(secretCode.equals(TwilioSender.generatedString) && !secretCode.equals(""))
                    primaryStage.setScene(new Scene(root3, 300, 250));
                else
                    System.out.println(secretCode + " does not equal " + TwilioSender.generatedString);
            }
        });


    }
}
