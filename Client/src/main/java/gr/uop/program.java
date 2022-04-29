package gr.uop;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javafx.beans.property.ReadOnlyIntegerWrapper;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class program {
    public int typ = 0;
    public int sum = 0;
    public int temp_sum = 0;	
    public String aknumber;
    boolean flag;
    Button btn1 = new Button("Πλύσιμο εξωτερικό");
    Button btn2 = new Button("Πλύσιμο εσωτερικό");
    Button btn3 = new Button("Πλύσιμο εξωτ.+εσωτ");
    Button btn4 = new Button("Πλύσιμο εξωτ. σπέσιαλ");
    Button btn5 = new Button("Πλύσιμο εσωτ. σπέσιαλ");
    Button btn6 = new Button("Πλύσιμο εξωτ. + εσωτ. σπέσιαλ");
    Button btn7 = new Button("Βιολογικός καθαρισμός εσωτ.");
    Button btn8 = new Button("Κέρωμα‐Γυάλισμα");
    Button btn9 = new Button("Καθαρισμός κινητήρα");
    Button btn10 = new Button("Πλύσιμο σασί");
    
    public void start(Stage stage,String ak) {
        
        GridPane gp = new GridPane();
        String arr[] = {"Πλύσιμο εξωτερικό","Πλύσιμο εσωτερικό ","Πλύσιμο εξωτ.+εσωτ","Πλύσιμο εξωτ. σπέσιαλ ","Πλύσιμο εσωτ. σπέσιαλ","Πλύσιμο εξωτ. + εσωτ. σπέσιαλ ","Βιολογικός καθαρισμός εσωτ.","Κέρωμα‐Γυάλισμα","Καθαρισμός κινητήρα","Πλύσιμο σασί"};
        int arrcar[]={7,6,12,9,8,15,80,80,20,3};
        int arrsuv[]={8,7,14,10,9,17,80,90,20,3};
        int arrbike[]={6,0,0,8,0,0,0,40,10,0};
        Label type = new Label("Select vehicle type");

        ComboBox<String> cb = new ComboBox<>();
        cb.getItems().addAll("Car", "Suv", "Bike");
        cb.setVisibleRowCount(3);
        cb.getSelectionModel().select(-1);
        
        TextField tf = new TextField();
        tf.setMaxSize(450, 40);
        tf.setPrefSize(450, 40);
        tf.setPromptText("Ποσό Πληρωμής");
        tf.setEditable(false);
        tf.setFocusTraversable(false);
        
      
       

        cb.setOnAction((event) -> {  
            
            
             if(cb.getSelectionModel().getSelectedIndex() == 0)
             {
                 cb.setVisible(false);
                 type.setVisible(false);
                typ = 1;

                btn1.setPrefSize(250,40); 
                btn2.setPrefSize(250,40);
                btn3.setPrefSize(250,40);
                btn4.setPrefSize(250,40);
                btn5.setPrefSize(250,40);
                btn6.setPrefSize(250,40);
                btn7.setPrefSize(250,40);
                btn8.setPrefSize(250,40);
                btn9.setPrefSize(250,40);
                btn10.setPrefSize(250,40);
                gp.add(btn1,0,0);
                gp.add(btn2,0,1);
                gp.add(btn3,0,2);
                gp.add(btn4,0,3);
                gp.add(btn5,0,4);
                gp.add(btn6,0,5);
                gp.add(btn7,0,6);
                gp.add(btn8,0,7);
                gp.add(btn9,0,8);
                gp.add(btn10,0,9);
             }
             if(cb.getSelectionModel().getSelectedIndex() == 1)
             {
                cb.setVisible(false);
                 type.setVisible(false);
                 typ = 2;
                 btn1.setPrefSize(250,40); 
                 btn2.setPrefSize(250,40);
                 btn3.setPrefSize(250,40);
                 btn4.setPrefSize(250,40);
                 btn5.setPrefSize(250,40);
                 btn6.setPrefSize(250,40);
                 btn7.setPrefSize(250,40);
                 btn8.setPrefSize(250,40);
                 btn9.setPrefSize(250,40);
                 btn10.setPrefSize(250,40);
                 gp.add(btn1,0,0);
                 gp.add(btn2,0,1);
                 gp.add(btn3,0,2);
                 gp.add(btn4,0,3);
                 gp.add(btn5,0,4);
                 gp.add(btn6,0,5);
                 gp.add(btn7,0,6);
                 gp.add(btn8,0,7);
                 gp.add(btn9,0,8);
                 gp.add(btn10,0,9);
              
             }
             if(cb.getSelectionModel().getSelectedIndex() == 2)
             {
                typ = 3;
                cb.setVisible(false);
                type.setVisible(false);
                

                 
                 btn1.setPrefSize(250,40); 
                 btn2.setPrefSize(250,40);
                 btn3.setPrefSize(250,40);
                 btn4.setPrefSize(250,40);
                 btn5.setPrefSize(250,40);
                 btn6.setPrefSize(250,40);
                 btn7.setPrefSize(250,40);
                 btn8.setPrefSize(250,40);
                 btn9.setPrefSize(250,40);
                 btn10.setPrefSize(250,40);
                 gp.add(btn1,0,0);
                 gp.add(btn2,0,1);
                 gp.add(btn3,0,2);
                 gp.add(btn4,0,3);
                 gp.add(btn5,0,4);
                 gp.add(btn6,0,5);
                 gp.add(btn7,0,6);
                 gp.add(btn8,0,7);
                 gp.add(btn9,0,8);
                 gp.add(btn10,0,9);

                 btn2.setDisable(true);
                 btn3.setDisable(true);
                 btn5.setDisable(true);
                 btn6.setDisable(true);
                 btn7.setDisable(true);
                 btn10.setDisable(true);
                
                
                
             }
         });
         
         btn1.setOnAction((event) -> { 
           
            if(typ == 1 || typ == 2)
            {
                btn1.setDisable(true);
                btn3.setDisable(true);
                btn4.setDisable(true);
                btn6.setDisable(true);
                if(typ == 1)
                    sum = sum + arrcar[0];
                else
                    sum = sum + arrsuv[0];
                tf.setText("Ποσό προς πληρωμή: " + sum);
            } 
            else if(typ == 3)
            {
                btn1.setDisable(true);
                btn4.setDisable(true);
                sum = sum + arrbike[0];
                tf.setText("Ποσό προς πληρωμή: " + sum);
            }

            });

        btn2.setOnAction((event) -> { 
        
            if(typ == 1 || typ == 2)
            {
                btn2.setDisable(true);
                btn3.setDisable(true);
                btn5.setDisable(true);
                btn6.setDisable(true);
                btn7.setDisable(true);
                if(typ == 1)
                    sum = sum + arrcar[1];
                else
                    sum = sum + arrsuv[1];
                tf.setText("Ποσό προς πληρωμή: " + sum);
            } 
        });

        btn3.setOnAction((event) -> { 
        
            if(typ == 1 || typ == 2)
            {
                btn1.setDisable(true);
                btn2.setDisable(true);
                btn3.setDisable(true);
                btn4.setDisable(true);
                btn5.setDisable(true);
                btn6.setDisable(true);
                btn7.setDisable(true);
                if(typ == 1)
                    sum = sum + arrcar[2];
                else
                    sum = sum + arrsuv[2];
                tf.setText("Ποσό προς πληρωμή: " + sum);
            } 
        });

        btn4.setOnAction((event) -> { 
        
            if(typ == 1 || typ == 2)
            {
                btn1.setDisable(true);
                btn3.setDisable(true);
                btn4.setDisable(true);
                btn6.setDisable(true);
                
                if(typ == 1)
                    sum = sum + arrcar[3];
                else
                    sum = sum + arrsuv[3];
                tf.setText("Ποσό προς πληρωμή: " + sum);
            } 
            else if(typ == 3)
            {
                btn1.setDisable(true);
                btn4.setDisable(true);
                sum = sum + arrbike[3];
                tf.setText("Ποσό προς πληρωμή: " + sum);
            }
        });

        btn5.setOnAction((event) -> { 
        
            if(typ == 1 || typ == 2)
            {
                btn2.setDisable(true);
                btn3.setDisable(true);
                btn5.setDisable(true);
                btn6.setDisable(true);
                btn7.setDisable(true);
                
                if(typ == 1)
                    sum = sum + arrcar[4];
                else
                    sum = sum + arrsuv[4];
                tf.setText("Ποσό προς πληρωμή: " + sum);
            } 
        });

        btn6.setOnAction((event) -> { 
        
            if(typ == 1 || typ == 2)
            {
                btn1.setDisable(true);
                btn2.setDisable(true);
                btn3.setDisable(true);
                btn4.setDisable(true);
                btn5.setDisable(true);
                btn6.setDisable(true);
                btn7.setDisable(true);
                
                if(typ == 1)
                    sum = sum + arrcar[5];
                else
                    sum = sum + arrsuv[5];
                tf.setText("Ποσό προς πληρωμή: " + sum);
            } 
        });

        btn7.setOnAction((event) -> { 
        
            if(typ == 1 || typ == 2)
            {
                
                btn2.setDisable(true);
                btn3.setDisable(true);
                btn5.setDisable(true);
                btn6.setDisable(true);
                btn7.setDisable(true);
                
                if(typ == 1)
                    sum = sum + arrcar[6];
                else
                    sum = sum + arrsuv[6];
                tf.setText("Ποσό προς πληρωμή: " + sum);
            } 
        });

        btn8.setOnAction((event) -> { 
        
            if(typ == 1 || typ == 2)
            {
                btn8.setDisable(true);
                
                if(typ == 1)
                    sum = sum + arrcar[7];
                else
                    sum = sum + arrsuv[7];
                tf.setText("Ποσό προς πληρωμή: " + sum);
            } 
            else if(typ == 3)
            {
                
                btn8.setDisable(true);
                sum = sum + arrbike[7];
                tf.setText("Ποσό προς πληρωμή: " + sum);
            }
        });

        btn9.setOnAction((event) -> { 
        
            if(typ == 1 || typ == 2)
            {
                btn9.setDisable(true);
                
                if(typ == 1)
                    sum = sum + arrcar[8];
                else
                    sum = sum + arrsuv[8];
                tf.setText("Ποσό προς πληρωμή: " + sum);
            } 
            else if(typ == 3)
            {
                
                btn9.setDisable(true);
                sum = sum + arrbike[8];
                tf.setText("Ποσό προς πληρωμή: " + sum);
            }
        });

        btn10.setOnAction((event) -> { 
        
            if(typ == 1 || typ == 2)
            {
                btn10.setDisable(true);
                
                if(typ == 1)
                    sum = sum + arrcar[9];
                else
                    sum = sum + arrsuv[9];
                tf.setText("Ποσό προς πληρωμή: " + sum);
            } 
        });
        
         
        List<String> Service = Arrays.asList("Πλύσιμο εξωτερικό","Πλύσιμο εσωτερικό ","Πλύσιμο εξωτ.+εσωτ","Πλύσιμο εξωτ. σπέσιαλ ","Πλύσιμο εσωτ. σπέσιαλ","Πλύσιμο εξωτ. + εσωτ. σπέσιαλ ","Βιολογικός καθαρισμός εσωτ.","Κέρωμα‐Γυάλισμα","Καθαρισμός κινητήρα","Πλύσιμο σασί");
        List<Integer> intValues = Arrays.asList(7,6,12,9,8,15,80,80,20,3);
        List<String> stringValues = Arrays.asList("8","7","14","10","9","17","80","90","20","3");
        List<String> stringValues2 = Arrays.asList("6","-","-","8","-","-","-","40","10","-");
        
        TableView<Integer> table = new TableView<>();
        for (int i = 0; i < intValues.size() && i < stringValues.size(); i++) {
            table.getItems().add(i);
        }

        TableColumn<Integer, Number> intColumn = new TableColumn<>("Car Price");
        intColumn.setCellValueFactory(cellData -> {
            Integer rowIndex = cellData.getValue();
            return new ReadOnlyIntegerWrapper(intValues.get(rowIndex));
        });

        TableColumn<Integer, String> nameColumn = new TableColumn<>("Suv Price");
        nameColumn.setCellValueFactory(cellData -> {
            Integer rowIndex = cellData.getValue();
            return new ReadOnlyStringWrapper(stringValues.get(rowIndex));
        });

        TableColumn<Integer, String> nameColumn2 = new TableColumn<>("Bike Price");
        nameColumn2.setCellValueFactory(cellData -> {
            Integer rowIndex = cellData.getValue();
            return new ReadOnlyStringWrapper(stringValues2.get(rowIndex));
        });

        TableColumn<Integer, String> nameColumn3 = new TableColumn<>("Service");
        nameColumn3.setCellValueFactory(cellData -> {
            Integer rowIndex = cellData.getValue();
            return new ReadOnlyStringWrapper(Service.get(rowIndex));
        });

        intColumn.setSortable(false);
        nameColumn.setSortable(false);
        nameColumn2.setSortable(false);
        nameColumn3.setSortable(false);

        table.getColumns().add(nameColumn3);
        table.getColumns().add(intColumn);
        table.getColumns().add(nameColumn);
        table.getColumns().add(nameColumn2);
        
       
        table.setMaxWidth(398);
        table.setPrefWidth(398);
        table.setMaxHeight(413);
        table.setPrefHeight(413);

        FlowPane fp = new FlowPane();
        fp.getChildren().addAll(table);
        fp.setPadding(new Insets(10, 0, 0, 0));

         gp.setPadding(new Insets(10, 5, 10, 5));
         gp.setVgap(10);
         gp.setHgap(10);

        FlowPane fp2 = new FlowPane();
        fp2.getChildren().addAll(tf);
        fp2.setPadding(new Insets(10, 0, 0, 250));

         

         HBox hb = new HBox();
         hb.getChildren().addAll(fp,gp);
         
        VBox vb = new VBox();
        //vb.setBackground(new Background(new BackgroundFill(Color.SKYBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
        vb.getChildren().addAll(type,cb,hb,fp2);
        vb.setPrefWidth(1000);
        vb.setPrefHeight(500);

        Dialog<Integer> dialog = new Dialog<>();
        dialog.initOwner(stage);
        dialog.setTitle("Υπηρεσίες για αριθμό κυκλοφορίας: " + ak );
        dialog.getDialogPane().setContent(vb);
        dialog.getDialogPane().getButtonTypes().addAll(ButtonType.CANCEL, ButtonType.OK);
        dialog.setResultConverter((button) -> {
        
        if (button == ButtonType.OK) {
            flag = true;
            aknumber = ak;
            temp_sum = sum;
            sum = 0;
            btn1.setDisable(false);
            btn2.setDisable(false);
            btn3.setDisable(false);
            btn4.setDisable(false);
            btn5.setDisable(false);
            btn6.setDisable(false);
            btn7.setDisable(false);
            btn8.setDisable(false);
            btn9.setDisable(false);
            btn10.setDisable(false);
            return 1;
        }

        else
        {
            flag = false;
            temp_sum = sum;
            sum = 0;
            btn1.setDisable(false);
            btn2.setDisable(false);
            btn3.setDisable(false);
            btn4.setDisable(false);
            btn5.setDisable(false);
            btn6.setDisable(false);
            btn7.setDisable(false);
            btn8.setDisable(false);
            btn9.setDisable(false);
            btn10.setDisable(false);
            return 0;
        }
            
        });

        Optional<Integer> result = dialog.showAndWait();
        if (result.isPresent()) {
            System.out.println(result.get());
        }
        else {
            System.out.println("No result");
        }

    }

    public String client()
    {
        if(flag == true)
            return temp_sum+";" + aknumber;
        else
            return "null";
    }
    
}
