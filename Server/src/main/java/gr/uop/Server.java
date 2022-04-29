package gr.uop;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import javafx.application.Platform;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.beans.property.ReadOnlyIntegerWrapper;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.Files;

/**
 * JavaFX App
 */
public class Server extends Application {
    List<String> service = new ArrayList<>();
    List<Integer> sumPrice = new ArrayList<>();
    List<String> datec = new ArrayList<>();
    ObservableList<String> obv1 = FXCollections.observableArrayList();
    ObservableList<Integer> obv2 = FXCollections.observableArrayList();
    ObservableList<String> obv3 = FXCollections.observableArrayList();
    TableView<Integer> table = new TableView<>();
    VBox vb = new VBox();
    Button submit = new Button("sumbit");
    Button delete = new Button("delete");
   
    
    @Override
    public void start(Stage stage) {
       
        
        //We create a table that contains the Vehicle registration plate, the money they have to pay and the current date.
        for (int i = 0; i < sumPrice.size() && i < service.size(); i++) {
            table.getItems().add(i);
             }
             
            TableColumn<Integer, String> nameColumn = new TableColumn<>("AK");
            nameColumn.setCellValueFactory(cellData -> {
            Integer rowIndex = cellData.getValue();
            return new ReadOnlyStringWrapper(service.get(rowIndex));
            });
    
            TableColumn<Integer, Number> intColumn = new TableColumn<>("Sum Price");
            intColumn.setCellValueFactory(cellData -> {
            Integer rowIndex = cellData.getValue();
            return new ReadOnlyIntegerWrapper(sumPrice.get(rowIndex));
            });
    
            TableColumn<Integer, String> nameColumn2 = new TableColumn<>("Date");
            nameColumn2.setCellValueFactory(cellData -> {
            Integer rowIndex = cellData.getValue();
            return new ReadOnlyStringWrapper(datec.get(rowIndex));
            });
    
            intColumn.setSortable(false);
            nameColumn.setSortable(false);
            nameColumn2.setSortable(false);
            
    
    
            table.getColumns().add(nameColumn);
            table.getColumns().add(intColumn);
            table.getColumns().add(nameColumn2);
     
        //we added 2 buttons(submit to pay and delete for cancel)
       
        submit.setPrefSize(100, 60);
        submit.setPadding(new Insets(10,10,10,10));
    
       
        delete.setPrefSize(100,60);
        delete.setPadding(new Insets(10,10,10,10));

        submit.setDisable(true);
        delete.setDisable(true);
    
        HBox hb = new HBox();
        hb.getChildren().addAll(submit,delete);

        vb.getChildren().addAll(table,hb);
        vb.setPrefWidth(1000);
        vb.setPrefHeight(500);
        vb.setSpacing(10);
        vb.setAlignment(Pos.CENTER);
        vb.setPadding(new Insets(10,10,10,10));
    
        submit.setOnAction((event) -> { 
           
            int position = table.getSelectionModel().getSelectedIndex();
            System.out.println("position is " +position);
            Integer selectedItem = table.getSelectionModel().getSelectedItem();
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
            LocalDateTime now = LocalDateTime.now();  
            
            
            

            Dialog<Integer> dialog = new Dialog<>();
            dialog.initOwner(stage);
            dialog.setTitle("Warning");


            Label warning1 = new Label("Price is " + obv2.get(position) +" and date is "+ dtf.format(now));
          
            Label warning2 = new Label("Are you sure you want to submit?");
            

            VBox vb3 = new VBox();
            vb3.setAlignment(Pos.CENTER);
            vb3.getChildren().addAll(warning1,warning2);

            dialog.getDialogPane().setContent(vb3);

            dialog.getDialogPane().getButtonTypes().addAll(ButtonType.YES, ButtonType.NO);

            
            dialog.setResultConverter((button) -> {
            
                if (button == ButtonType.YES) {
                    
 
                   
                    return 1;
                }                
                else {
                    //e.consume();
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
        
            
           
 
         });

         delete.setOnAction((event) -> { 
            
            int position = table.getSelectionModel().getSelectedIndex();
            System.out.println(position);
            Integer selectedItem = table.getSelectionModel().getSelectedItem();
            Dialog<Integer> dialog = new Dialog<>();
            dialog.initOwner(stage);
            dialog.setTitle("Warning");


            Label warning1 = new Label("You are about to delete a record");
            Label warning2 = new Label("Are you sure you want to delete?");
            

            VBox vb4 = new VBox();
            vb4.setAlignment(Pos.CENTER);
            vb4.getChildren().addAll(warning1,warning2);

            dialog.getDialogPane().setContent(vb4);

            dialog.getDialogPane().getButtonTypes().addAll(ButtonType.YES, ButtonType.NO);

            
            dialog.setResultConverter((button) -> {
            
                if (button == ButtonType.YES) {
                    table.getItems().remove(selectedItem);
                    
                   
                   
                    String remove =  obv1.get(position) +","+ obv2.get(position) +","+ obv3.get(position);
                    System.out.println("Remove is " + remove);
                    
                    String currentLine;
                    File inputFile = new File("test.txt");
                    File tempFile = new File("temptest.txt");
                    
                    BufferedReader reader;
                    try {
                        reader = new BufferedReader(new FileReader(inputFile));
                        BufferedWriter writer;
                        try {
                            writer = new BufferedWriter(new FileWriter(tempFile));
                            while((currentLine = reader.readLine()) != null) {
                                // trim newline when comparing with lineToRemove
                                String trimmedLine = currentLine.trim();
                                if(trimmedLine.equals(remove)) continue;
                                writer.write(currentLine + System.getProperty("line.separator"));
                            }
                            writer.close(); 
                            reader.close(); 

                            Path source = Paths.get("C:/Users/Καραπιπεράκης Μάνος/Desktop/LAB JAVA/project-karapiperakis-papachristou/Server/temptest.txt");
                            File del = new File("C:/Users/Καραπιπεράκης Μάνος/Desktop/LAB JAVA/project-karapiperakis-papachristou/Server/test.txt");
                            del.delete();
                            try{
                              Files.move(source, source.resolveSibling("test.txt"),StandardCopyOption.REPLACE_EXISTING);
                          
                            } catch (IOException e) {
                              e.printStackTrace();
                            }
                          

                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                    
                    obv1.remove(position);
                    obv2.remove(position);
                    obv3.remove(position);

                    if(obv1.size() == 0)
                    {
                        submit.setDisable(true);
                        delete.setDisable(true);
                    }
                    return 1;
                    
                }                
                else {
                    //e.consume();
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
        
            
           
 
         });

         


         stage.addEventFilter(WindowEvent.WINDOW_CLOSE_REQUEST, (e) -> {
            if(!obv1.isEmpty())
            {


                Dialog<Integer> dialog = new Dialog<>();
                dialog.initOwner(stage);
                dialog.setTitle("Warning");


                Label warning1 = new Label("There are still records on the board");
                Label warning2 = new Label("Do you still want to close the window?");


                VBox vb2 = new VBox();
                vb2.setAlignment(Pos.CENTER);
                vb2.getChildren().addAll(warning1,warning2);

                dialog.getDialogPane().setContent(vb2);

                dialog.getDialogPane().getButtonTypes().addAll(ButtonType.YES, ButtonType.NO);


                dialog.setResultConverter((button) -> {

                    if (button == ButtonType.YES) {
                        return 1;

                    }
                    else {
                        e.consume();
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
        });
            
        
      
        
        var scene = new Scene(vb, 640, 480);

        
        stage.setScene(scene);
        stage.setMinWidth(1024);
        stage.setMinHeight(768);
        stage.setMaxWidth(1920);
        stage.setMaxHeight(1080);
        stage.setTitle("Ταμείο");
        stage.show();

        new Thread( () -> {
            try
            {
            ServerSocket serverSocket = new ServerSocket(8601);
          

                while(true)
                {  
                    Socket socket = serverSocket.accept();
                    
                    Platform.runLater( () -> {
                        //Everytime a new client arrives, the cashier will see an information alert box.
                        Alert alert = new Alert(AlertType.INFORMATION);
                        alert.setTitle("New Client");
                        alert.setHeaderText("New client has arrived.");
                        alert.setContentText("Current time: " + new Date());
                        alert.initModality(Modality.WINDOW_MODAL);
                        alert.initOwner(stage);
                        alert.showAndWait();

                    });
                    
                    new Thread(new HandleAClient(socket)).start();
                }
            }
            catch(IOException ex)
            {
                System.err.println(ex);
            }
        }).start();
    }

    public static void main(String[] args) {
        launch(args);
    }

    class HandleAClient implements Runnable{
        private Socket socket;
        String line;
        public HandleAClient(Socket socket)
        {
           
            this.socket = socket;
        }
        public void run()
        {
            
        
            try
            {
                Scanner fromClient = new Scanner(socket.getInputStream());
            while(true){
                
                do{
                    line = fromClient.nextLine();
                    System.out.println("Received: " + line);
     
                }while(fromClient.hasNextLine());
               

                Platform.runLater(() -> {

                    
                    String temp2 = line;
                    String sum = "";
                    String num = "";
                    Scanner scanner = new Scanner(temp2);
                    while (scanner.hasNextLine()) {
                        String line = scanner.nextLine();
                        Scanner lineScanner = new Scanner(line);
                        lineScanner.useDelimiter(";");
                        int j = 0;
                        while (lineScanner.hasNext()) {
                            if(j == 0)
                                 sum = lineScanner.next();
                            else
                                num = lineScanner.next();

                            j++;
                        }
                    }
                    String date = "Date: " + new Date();

                    //We create new book object
                    book b = new book(sum,num,date);
                    //System.out.println("Sum = " + b.sum_print());
                    //System.out.println("Ak = " + b.ak_print());
                    //System.out.println(b.date_print());
                   
                    FileWriter fileWriter;
                    //we update the "test.txt" file with the informations we received from the client and we also added the current date.
                    //All these values are separated with the character ","
                    try {
                        fileWriter = new FileWriter("test.txt",true);
                        PrintWriter printWriter = new PrintWriter(fileWriter);
                        printWriter.print(num + "," + sum + "," + date + '\n');
                        printWriter.close();
                        fileWriter.close();
                    } catch (IOException e) {

                        e.printStackTrace();
                    }
                    File file = new File("test.txt");
                   
                    Scanner sc;
                    table.getItems().clear();
                    service.clear();
                    sumPrice.clear();
                    datec.clear();
                    
                    try {
                        BufferedReader br = new BufferedReader(new FileReader(file));
                        sc = new Scanner(file);
                        int c=0;
                        String st;
                        String st1="" ;
                        String st2 = "";
                        String st3 = "";
                            while ((st = br.readLine()) != null)
                            {
                                Scanner scanner2 = new Scanner(st);
                                while (scanner2.hasNextLine()) {
                                    String line = scanner2.nextLine();
                                    Scanner lineScanner2 = new Scanner(line);
                                    lineScanner2.useDelimiter(",");
                                    int j = 0;
                                    while (lineScanner2.hasNext()) {
                                        if(j == 0)
                                        {
                                             st1 = lineScanner2.next();
                                             service.add(st1);
                                        }
                                        else if(j==1)
                                        {
                                            int number;
                                            st2 = lineScanner2.next();
                                            number=Integer.parseInt(st2);
                                            sumPrice.add(number);
                                        }
                                            
                                        else
                                        {
                                            st3 = lineScanner2.next();
                                            datec.add(st3);
                                        }
            
                                        j++;
                                    }
                                    lineScanner2.close();
                                }
                            }
                            br.close();
                            sc.close();
                                //System.out.println(st1+st2+st3);
                                
                            for (int i = 0; i < sumPrice.size() && i < service.size(); i++) {
                            table.getItems().add(i);
                             }
                             
                            TableColumn<Integer, String> nameColumn = new TableColumn<>("AK");
                            nameColumn.setCellValueFactory(cellData -> {
                            Integer rowIndex = cellData.getValue();
                            return new ReadOnlyStringWrapper(service.get(rowIndex));
                            });

                            TableColumn<Integer, Number> intColumn = new TableColumn<>("Sum Price");
                            intColumn.setCellValueFactory(cellData -> {
                            Integer rowIndex = cellData.getValue();
                            return new ReadOnlyIntegerWrapper(sumPrice.get(rowIndex));
                            });

                            TableColumn<Integer, String> nameColumn2 = new TableColumn<>("Date");
                            nameColumn2.setCellValueFactory(cellData -> {
                            Integer rowIndex = cellData.getValue();
                            return new ReadOnlyStringWrapper(datec.get(rowIndex));
                            });


                            intColumn.setSortable(false);
                            nameColumn.setSortable(false);
                            nameColumn2.setSortable(false);
                            //we update the tableview we created before
                            table.getColumns().set(0,nameColumn);
                            table.getColumns().set(1,intColumn);
                            table.getColumns().set(2,nameColumn2);
                            obv1 = FXCollections.observableArrayList(service);
                            obv2 = FXCollections.observableArrayList(sumPrice);
                            obv3 = FXCollections.observableArrayList(datec);
                            submit.setDisable(false);
                            delete.setDisable(false);
                            }
                    
                         
                     catch (FileNotFoundException e) {
                        //  Auto-generated catch block
                        e.printStackTrace();
                    } catch (IOException e) {
                        // Auto-generated catch block
                        e.printStackTrace();
                    }
  
                  
                    
  
                   
                    
                });
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    }
    

}
