
package twil;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.text.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;
import javafx.scene.image.Image;

public class fx extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage){
        primaryStage.setTitle("2FA Concept Demo");
        primaryStage.getIcons().add(new Image("https://upload.wikimedia.org/wikipedia/commons/thumb/8/8d/NSU_1960_Logo.svg/220px-NSU_1960_Logo.svg.png"));
        //Initialzing the Scencs
        GridPane gridPane = new GridPane();
        GridPane gridPane2 = new GridPane();
        GridPane gridPane3 = new GridPane();

        //--------beginning of first scene


        Text phonetxt = new Text("Phone Number :");
        Button btnSubmit = new Button("Send Key");

        TextField field = new TextField();




        gridPane.setMinSize(400,200);

        gridPane.setPadding(new Insets(10,10,10,10));

        gridPane.setVgap(5);
        gridPane.setHgap(5);

        gridPane.setAlignment(Pos.CENTER);

        gridPane.add(phonetxt,0,0);
        gridPane.add(field,1,0);
        gridPane.add(btnSubmit, 0, 1);



        btnSubmit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String num = field.getText();
                TwilioSender.sendText(num);
                primaryStage.setScene(new Scene(gridPane2, 400, 200));

            }
        });

// *************start second screaft button condition is met


        Button btn = new Button("Verify");
        TextField field2 = new TextField();
        Text keyText = new Text("Enter Key Recived:");



        gridPane2.setMinSize(400,200);

        gridPane2.setPadding(new Insets(10,10,10,10));

        gridPane2.setVgap(5);
        gridPane2.setHgap(5);

        gridPane2.setAlignment(Pos.CENTER);

        gridPane2.add(keyText,0,0);
        gridPane2.add(field2,1,0);
        gridPane2.add(btn, 0, 1);



        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String secretCode = field2.getText();
                if(secretCode.equals(TwilioSender.generatedString) && !secretCode.equals(""))
                    primaryStage.setScene(new Scene(gridPane3, 400, 200));
                else
                    System.out.println(secretCode + " does not equal " + TwilioSender.generatedString);
            }
        });


//-----------Begining of third scene


        Text t = new Text();
        t.setFont(new Font(20));

        t.setText("Login Success");
        Button btnAgain = new Button("See Demo Again");



        gridPane3.setMinSize(400,200);

        gridPane3.setPadding(new Insets(10,10,10,10));

        gridPane3.setVgap(5);
        gridPane3.setHgap(5);

        gridPane3.setAlignment(Pos.CENTER);


        gridPane3.add(t,1,0);
        gridPane3.add(btnAgain,1,2);

        btnAgain.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {


                start(primaryStage);

            }
        });

//***^^^ End of thrid scence


        //** finishing the creation of scene one



        Scene scene = new Scene(gridPane);

        primaryStage.setScene(scene);

        primaryStage.show();


    }
}
