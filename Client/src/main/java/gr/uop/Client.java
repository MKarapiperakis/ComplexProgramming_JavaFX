package gr.uop;



import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class Client extends Application {

    @Override
    public void start(Stage stage) {
        GridPane gp = new GridPane();
        String arr[] = {"Q","W","E","R","T","Y","U","I","O","1","2","3","P","A","S","D","F","G","H","J","K","4","5","6","L","Z","X","C","V","B","N","M","7","8","9"} ;
        int max=12;
        int min=0;
        int row=0;
        int column=0;

        TextField tf = new TextField();
        tf.setPrefSize(1200,80);
        tf.setMaxSize(1200,80);
        tf.setFont(Font.font("Verdana", FontWeight.BOLD, 35));
        tf.setEditable(false);
        Button del = new Button();
        del.setPrefSize(100,60);
        del.setMaxSize(100,60);
        for(int j = 0; j<3; j++)
        {       
            if(j==2)
                max--;
            for(int i = min; i<max; i++)
            {
                   
                        if(i == max-3 && j==2)
                        { 
                            gp.add (del, column, row);
                            ImageView backspace = new ImageView(new Image(getClass().getResourceAsStream("images/backspace.png")));
                            backspace.setFitWidth(45);
                            backspace.setFitHeight(30);
                            del.setGraphic(backspace);
                            column++;
                        }
                        
                        if(i == max-3)
                        {
                            Button temp = new Button();
                            temp.setPrefSize(100,60);
                            gp.add (temp, column, row );
                            column++;
                            temp.setVisible(false);
                        }
                        
                        Button btn = new Button(arr[i]);
                        btn.setPrefSize(100,60);
                        
                        gp.add (btn, column, row );
                        btn.setOnAction((event) -> { 
                            tf.setText(tf.getText() + btn.getText());
                        });
                    
                
                    
                ++column;
            }
            
            column=0;
            min=min+12;
            max=max+12;
            ++row;
        }
        
       
       

        
        gp.setAlignment(Pos.CENTER);
        
        
        Button space = new Button();
        ImageView spaceImage = new ImageView(new Image(getClass().getResourceAsStream("images/space.png")));
        spaceImage.setFitWidth(70);
        spaceImage.setFitHeight(50);
        space.setGraphic(spaceImage);
        space.setPrefSize(600,60);
        

        Button zero= new Button("0");
        gp.add(zero,10,5);
        zero.setPrefSize(100,60);

        Button dash = new Button("-");
        gp.add(dash,11,5);
        dash.setPrefSize(100,60);

        Button dot = new Button(".");
        gp.add(dot,12,5);
        dot.setPrefSize(100,60);
      
        VBox vb2 = new VBox();
        vb2.getChildren().addAll(gp,space);
        vb2.setSpacing(10);
        vb2.setAlignment(Pos.CENTER);
        
        Button submit = new Button();
        ImageView submits = new ImageView(new Image(getClass().getResourceAsStream("images/submit.png")));
        submit.setPrefSize(70,70);
        submits.setFitWidth(70);
        submits.setFitHeight(70);
        submit.setGraphic(submits);
        


        HBox hb2 = new HBox();
        hb2.getChildren().addAll(tf,submit);
        hb2.setSpacing(10);
        HBox.setHgrow(space, Priority.ALWAYS);
        hb2.setAlignment(Pos.CENTER);


        ImageView imageView = new ImageView(new Image(getClass().getResourceAsStream("images/services.jpg")));
        
        imageView.setFitHeight(500); 
        imageView.setFitWidth(500); 
        imageView.setPreserveRatio(true);   
        Group root = new Group(imageView);  

        VBox vb = new VBox();
        vb.setPadding(new Insets(0,5,10,5));
        vb.setSpacing(10);
        vb.getChildren().addAll(root,hb2,vb2);
        vb.setAlignment(Pos.BOTTOM_CENTER);

        vb.setBackground(new Background(new BackgroundFill(Color.SKYBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
        
        del.setDisable(true);
        submit.setDisable(true);
        space.setDisable(true);
        //event listener for the textfield.If the textfield is empty, then we disable the submit,the space and the delete button
        tf.textProperty().addListener((observable, oldValue, newValue) -> {
            
           if(tf.getLength() == 0)
           {
                del.setDisable(true);
                submit.setDisable(true);
                space.setDisable(true);
           }
           else
           {
                del.setDisable(false);
                submit.setDisable(false);
                space.setDisable(false);
           }
           if(tf.getLength() < 2)
                 submit.setDisable(true);
           else
                 submit.setDisable(false);
            
        });
        //event handler for the delete button
        del.setOnAction((event) -> {  
            tf.deleteText(tf.getLength()-1, tf.getLength());
        });

        //event handler for the space button
        space.setOnAction((event) -> {  
            tf.setText(tf.getText() + " ");
        });

        //event handler for the number "0"
        zero.setOnAction((event) -> { 
            tf.setText(tf.getText() + zero.getText());
        });;

        //event handler for the character "-"
        dash.setOnAction((event) -> { 
            tf.setText(tf.getText() + dash.getText());
        });;

        //event handler for the character "."
        dot.setOnAction((event) -> { 
            tf.setText(tf.getText() + dot.getText());
        });;
       
        program pr = new program();

        submit.setOnAction((event) -> {
            pr.start(stage,tf.getText());
            tf.clear();
            
            String text = pr.client();
            
            send(text);
        });;

        

        var scene = new Scene(vb, 640, 480);
        
        stage.setScene(scene);
        stage.setMinWidth(1024);
        stage.setMinHeight(768);
        stage.setMaxWidth(1920);
        stage.setMaxHeight(1080);
        stage.setTitle("Αριθμός Κυκλοφορίας");
        stage.show();
    }

    public void send(String text){
        if(text != "null")      //if client press the "Cancel button,we will not proceed the connection with the server
        {
            try(Socket clientSocket = new Socket("localhost",8601);
            PrintWriter toServer = new PrintWriter(clientSocket.getOutputStream(),true);
            ){

            
            
            //we send the sum,that the client must pay and his Vehicle registration plate separated with ';'
            //So the server will receive something like that: xx;yy where ww is the sum and yy is the Vehicle registration plate
            toServer.println(text);

            clientSocket.close();
            


            }
            catch (IOException e)
            {
                System.out.println(e);
            }
        }
    }
    public static void main(String[] args) {
        launch(args);
    }

}
