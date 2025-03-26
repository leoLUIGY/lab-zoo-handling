package com.example.labzoojfx;

import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.*;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

public class ZooController  {

    GridPane grid = new GridPane();
    Tiger tiger = new Tiger();
    Dolphin dolphin = new Dolphin();
    Penguin penguin = new Penguin();


    @FXML
    private VBox inputFieldsBox;

    @FXML
    public void initialize() {

        PauseTransition delay = new PauseTransition(Duration.seconds(0.5));
        delay.setOnFinished(event -> {

            System.out.println("Ação executada após o delay");
            initialConfig();

        });
        delay.play();
    }
    public void initialConfig(){
        // Inicia o delay
        grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Scene scene = new Scene(grid, 300, 275);
        HelloApplication.primaryStage.setScene(scene);

        Text scenetitle = new Text("Welcome");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(scenetitle, 0, 0, 2, 1);

        Button btn = new Button("Tiger");
        grid.add(btn, 1, 1);
        btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
                try {
                    selectTiger();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        Button btn1 = new Button("Dolphin");
        grid.add(btn1, 1, 2);
        btn1.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
                try {
                   selectDolphin();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        Button btn2 = new Button("Penguin");
        grid.add(btn2, 1, 3);
        btn2.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
                try {
                    selectPenguin();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });



        Button btn4 = new Button("Sair");
        grid.add(btn4, 1, 5);
        btn4.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
                setOptions();
                //loadNewScene("hello-view.fxml");
            }
        });
    }




    @FXML
    private void selectTiger() throws IOException {
        HelloApplication.selected = "Tiger";
        setOptions();
        //loadNewScene("animal-view.fxml");
    }

    @FXML
    private void selectDolphin() throws IOException {
        HelloApplication.selected="Dolphin";
        setOptions();
        //loadNewScene("animal-view.fxml");
    }

    @FXML
    private void selectPenguin() throws IOException {
        HelloApplication.selected="Penguin";
        setOptions();
        //loadNewScene("animal-view.fxml");
    }

    @FXML
    public void setOptions()
    {
        grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Scene scene = new Scene(grid, 300, 275);
        HelloApplication.primaryStage.setScene(scene);

        Text scenetitle = new Text("Welcome");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(scenetitle, 0, 0, 2, 1);

        Button btn = new Button("Modificar propriedades");
        grid.add(btn, 1, 1);
        btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
                try {
                    setProperties();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        Button btn1 = new Button("Mostrar Propriedades");
        grid.add(btn1, 1, 2);
        btn1.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
                try {
                    showProperties();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        Button btn2 = new Button("Mostrar Movimento");
        grid.add(btn2, 1, 3);
        btn2.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
                showMoviment();
            }
        });

        Button btn3 = new Button("Mostrar Comendo");
        grid.add(btn3, 1, 4);
        btn3.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
                showEating();
            }
        });

        Button btn4 = new Button("Sair");
        grid.add(btn4, 1, 5);
        btn4.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
                setOptions();
                //loadNewScene("hello-view.fxml");
            }
        });
    }



    @FXML
    private void setProperties() throws IOException {
        grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Scene scene = new Scene(grid, 300, 275);
        HelloApplication.primaryStage.setScene(scene);

        Text scenetitle = new Text("Welcome");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(scenetitle, 0, 0, 2, 1);

//        addTextField("test");
        System.out.println("teste " + HelloApplication.selected);
        switch (HelloApplication.selected)
        {
            case "Tiger":

                Label numOfStribes = new Label("Number of Stripes:");
                grid.add(numOfStribes, 0, 1);
                TextField numOfStribesField = new TextField();
                grid.add(numOfStribesField, 1, 1);

                Label speed= new Label("Speed:");
                grid.add(speed, 0, 2);
                TextField speedField = new TextField();
                grid.add(speedField, 1, 2);

                Label roar= new Label("Sound Level of Roar:");
                grid.add(roar, 0, 3);
                TextField roarField = new TextField();
                grid.add(roarField, 1, 3);

                Button btn = new Button("Save");
                grid.add(btn, 1, 4);
                btn.setOnAction(new EventHandler<ActionEvent>() {

                    @Override
                    public void handle(ActionEvent e) {
                        setOptions();
                    }
                });
                break;
            case "Dolphin":
                Label color = new Label("Color:");
                grid.add(color, 0, 1);
                TextField colorField = new TextField();
                grid.add(colorField, 1, 1);

                Label swimming= new Label("Swimming Speed:");
                grid.add(swimming, 0, 2);
                TextField swimmingField = new TextField();
                grid.add(swimmingField, 1, 2);

                Button btnDolphin = new Button("Save");
                grid.add(btnDolphin, 1, 4);
                btnDolphin.setOnAction(new EventHandler<ActionEvent>() {

                    @Override
                    public void handle(ActionEvent e) {
                        setOptions();
                    }
                });
                break;
            case "Penguin":
                Label isSwimming = new Label("isPenguin Swimming:");
                grid.add(isSwimming, 0, 1);
                TextField isSwimmingField = new TextField();
                grid.add(isSwimmingField, 1, 1);

                Label speedPenguin= new Label("Walking Speed:");
                grid.add(speedPenguin, 0, 2);
                TextField speedFieldPenguin = new TextField();
                grid.add(speedFieldPenguin, 1, 2);

                Label roarPenguin= new Label("Swimming Speed:");
                grid.add(roarPenguin, 0, 3);
                TextField roarFieldPenguin = new TextField();
                grid.add(roarFieldPenguin, 1, 3);

                Button btnPenguin = new Button("Save");
                grid.add(btnPenguin, 1, 4);
                btnPenguin.setOnAction(new EventHandler<ActionEvent>() {

                    @Override
                    public void handle(ActionEvent e) {
                        setOptions();
                    }
                });
                break;

        }



    }

    @FXML
    private void showProperties() throws IOException {
        grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Scene scene = new Scene(grid, 300, 275);
        HelloApplication.primaryStage.setScene(scene);

        Text scenetitle = new Text("Welcome");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(scenetitle, 0, 0, 2, 1);

//        addTextField("test");
        System.out.println("teste " + HelloApplication.selected);
        switch (HelloApplication.selected)
        {
            case "Tiger":

                Label introTigerLabel = new Label(tiger.getName() + " " +tiger.getAge() + " "+
                        tiger.getHeight());
                grid.add(introTigerLabel, 0, 1);

                Label weightTigerLabel =  new Label("" + tiger.getWeight());
                grid.add(weightTigerLabel, 0, 2);

                Label numTigerLabel= new Label("" + tiger.getNumberOfStripes());
                grid.add(numTigerLabel, 0, 3);

                Label speedTigerLabel= new Label("" + tiger.getSpeed());
                grid.add(speedTigerLabel, 0, 4);

                Label levelTigerLabel= new Label("" + tiger.getSoundLevel());
                grid.add(levelTigerLabel, 0, 5);

                Button btn = new Button("Exit");
                grid.add(btn, 1, 6);
                btn.setOnAction(new EventHandler<ActionEvent>() {

                    @Override
                    public void handle(ActionEvent e) {
                        setOptions();
                    }
                });
                break;
            case "Dolphin":
                Label introDolphinLabel = new Label(dolphin.getName() + " " +dolphin.getAge() + " "+ dolphin.getHeight());
                grid.add(introDolphinLabel, 0, 1);

                Label roar= new Label("" + dolphin.getWeight());
                grid.add(roar, 0, 2);

                Label color= new Label(dolphin.getColor());
                grid.add(color, 0, 3);

                Label speedLabel= new Label("" + dolphin.getSwimmingSpeed());
                grid.add(speedLabel, 0, 4);



                Button btnDolphin = new Button("Exit");
                grid.add(btnDolphin, 1, 5);
                btnDolphin.setOnAction(new EventHandler<ActionEvent>() {

                    @Override
                    public void handle(ActionEvent e) {
                        setOptions();
                    }
                });
                break;
            case "Penguin":
                Label introPenguinLabel = new Label(penguin.getName() + " " +penguin.getAge() + " "+ penguin.getHeight());
                grid.add(introPenguinLabel, 0, 1);

                Label weightPenguinLabel= new Label("" +penguin.getWeight());
                grid.add(weightPenguinLabel, 0, 2);

                Label speedPenguinLabel= new Label("" + penguin.getWalkSpeed());
                grid.add(speedPenguinLabel, 0, 3);

                Label swimSpeedLabel= new Label("" + penguin.getSwimSpeed());
                grid.add(swimSpeedLabel, 0, 4);



                Button btnPenguin = new Button("Exit");
                grid.add(btnPenguin, 1, 5);
                btnPenguin.setOnAction(new EventHandler<ActionEvent>() {

                    @Override
                    public void handle(ActionEvent e) {
                        setOptions();
                    }
                });
                break;

        }
    }

    @FXML
    private void showMoviment()
    {

    }

    @FXML
    private void showEating()
    {

    }

//
//    private void loadNewScene(String fxml) throws IOException {
//        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource(fxml));
//        Scene scene = new Scene(fxmlLoader.load(), 320, 400);
//
//        HelloApplication.primaryStage.setScene(scene);
//        HelloApplication.primaryStage.show();
//
//
//    }



//
//    private void handleButtonClick(TextField input1, TextField input2) {
//        String valor1 = input1.getText();
//        String valor2 = input2.getText();
//        System.out.println("Valor 1: " + valor1);
//        System.out.println("Valor 2: " + valor2);
//    }


}
