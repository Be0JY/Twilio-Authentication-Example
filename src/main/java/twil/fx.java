
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

public class fx extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("numberInput");


        TextField field = new TextField();
        TextField field2 = new TextField();


        Button btn = new Button("Go");
        Button btnCheck = new Button("Verify");

        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String num = field.getText();
                TwilioSender.sendText(num);
            }
        });

        btnCheck.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String secretCode = field2.getText();
                if(secretCode.equals(TwilioSender.generatedString) && !secretCode.equals(""))
                    System.out.println("Login Success!");
                else
                    System.out.println(secretCode + " does not equal " + TwilioSender.generatedString);
            }
        });

        StackPane root = new StackPane();
        VBox vb = new VBox();

        vb.getChildren().addAll(btn, field,field2,btnCheck);

        root.getChildren().add(vb);

        primaryStage.setScene(new Scene(root, 300, 250));
        primaryStage.show();
    }
}