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

import static java.lang.Integer.parseInt;

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
        ConfigPanel("Animais:");

        Button btn = new Button("Tigre");
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

        Button btn1 = new Button("Golfinho");
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

        Button btn2 = new Button("Pinguin");
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

        Button btn3 = new Button("Salvar dados");
        grid.add(btn3, 1, 4);
        btn3.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
                writeObjectsToFile(tiger, penguin, dolphin);
            }
        });

        Button btn4= new Button("Ler dados");
        grid.add(btn4, 1, 5);
        btn4.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
               readObjectsFromFile();
            }
        });



        Button btn5 = new Button("Sair");
        grid.add(btn5, 1, 6);
        btn5.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
                setOptions();
                //loadNewScene("hello-view.fxml");
            }
        });
    }




    @FXML
    private void selectTiger() throws IOException {
        HelloApplication.selected = "Tigre";
        setOptions();
        //loadNewScene("animal-view.fxml");
    }

    @FXML
    private void selectDolphin() throws IOException {
        HelloApplication.selected="Golfinho";
        setOptions();
        //loadNewScene("animal-view.fxml");
    }

    @FXML
    private void selectPenguin() throws IOException {
        HelloApplication.selected="Pinguin";
        setOptions();
        //loadNewScene("animal-view.fxml");
    }

    @FXML
    public void setOptions()
    {
        ConfigPanel("Opções");

        Button btn = new Button("Mudar Caracteristicas");
        grid.add(btn, 1, 1);
        btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
                try {
                    setProperties(HelloApplication.selected);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        Button btn1 = new Button("Ver Caracteristicas");
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

        Button btn2 = new Button("Ver Movimento");
        grid.add(btn2, 1, 3);
        btn2.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
                showMoviment();
            }
        });

        Button btn3 = new Button("Ver se Alimentando");
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
                initialize();
                //loadNewScene("hello-view.fxml");
            }
        });
    }



    @FXML
    private void setProperties(String animalName) throws IOException {
        ConfigPanel("Caracteristicas: "+ animalName);

//        addTextField("test");
        System.out.println("teste " + HelloApplication.selected);

        Label ageAnimal = new Label("idade:");
        grid.add(ageAnimal, 0, 1);
        TextField ageAnimalField = new TextField();
        grid.add(ageAnimalField, 1, 1);

        Label weightAnimal = new Label("Peso:");
        grid.add(weightAnimal, 0, 2);
        TextField weightAnimalField = new TextField();
        grid.add(weightAnimalField, 1, 2);


        Label heightAnimal = new Label("Altura:");
        grid.add(heightAnimal, 0, 3);
        TextField heightAnimalField = new TextField();
        grid.add(heightAnimalField, 1, 3);
        switch (HelloApplication.selected)
        {
            case "Tigre":



                Label numOfStribes = new Label("Numero de listras:");
                grid.add(numOfStribes, 0, 4);
                TextField numOfStribesField = new TextField();
                grid.add(numOfStribesField, 1, 4);

                Label speed= new Label("velocidade de corrida:");
                grid.add(speed, 0, 5);
                TextField speedField = new TextField();
                grid.add(speedField, 1, 5);

                Label roar= new Label("Nivel de som do rugido:");
                grid.add(roar, 0, 6);
                TextField roarField = new TextField();
                grid.add(roarField, 1, 6);

                Button btn = new Button("Salvar");
                grid.add(btn, 1, 7);
                btn.setOnAction(new EventHandler<ActionEvent>() {

                    @Override
                    public void handle(ActionEvent e) {
                        tiger.setAge(Integer.parseInt(ageAnimalField.getText()));
                        tiger.setWeight(Float.parseFloat(weightAnimalField.getText()));
                        tiger.setHeight(Float.parseFloat(heightAnimalField.getText()));
                        tiger.setSoundLevel(Integer.parseInt(roarField.getText()));
                        tiger.setNumberOfStripes(Integer.parseInt(numOfStribesField.getText()));
                        tiger.setSpeed(Integer.parseInt(speedField.getText()));
                        tiger.setSoundLevel(Integer.parseInt(roarField.getText()));
                        setOptions();
                    }
                });
                break;
            case "Golfinho":

                Label color = new Label("Cor:");
                grid.add(color, 0, 4);
                TextField colorField = new TextField();
                grid.add(colorField, 1, 4);

                Label swimming= new Label("Velocidade de Mergulho:");
                grid.add(swimming, 0, 5);
                TextField swimmingField = new TextField();
                grid.add(swimmingField, 1, 5);

                Button btnDolphin = new Button("Salvar");
                grid.add(btnDolphin, 1, 6);
                btnDolphin.setOnAction(new EventHandler<ActionEvent>() {

                    @Override
                    public void handle(ActionEvent e) {
                        dolphin.setAge(Integer.parseInt(ageAnimalField.getText()));
                        dolphin.setWeight(Float.parseFloat(weightAnimalField.getText()));
                        dolphin.setHeight(Float.parseFloat(heightAnimalField.getText()));
                        dolphin.setColor(colorField.getText());
                        dolphin.setSwimmingSpeed(Integer.parseInt(swimmingField.getText()));
                        setOptions();
                    }
                });
                break;
            case "Pinguin":
                Label isSwimming = new Label("pinguin esta nadando?(sim ou nao):");
                grid.add(isSwimming, 0, 4);
                TextField isSwimmingField = new TextField();
                grid.add(isSwimmingField, 1, 4);

                Label speedPenguin= new Label("Velocidade de Caminhada:");
                grid.add(speedPenguin, 0, 5);
                TextField speedFieldPenguin = new TextField();
                grid.add(speedFieldPenguin, 1, 5);

                Label swimmingSpeedPenguin= new Label("velocidade de Mergulho:");
                grid.add(swimmingSpeedPenguin, 0, 6);
                TextField swimmingFieldPenguin = new TextField();
                grid.add(swimmingFieldPenguin, 1, 6);

                Button btnPenguin = new Button("Salvar");
                grid.add(btnPenguin, 1, 7);
                btnPenguin.setOnAction(new EventHandler<ActionEvent>() {

                    @Override
                    public void handle(ActionEvent e) {
                        penguin.setAge(Integer.parseInt(ageAnimalField.getText()));
                        penguin.setWeight(Float.parseFloat(weightAnimalField.getText()));
                        penguin.setHeight(Float.parseFloat(heightAnimalField.getText()));
                        penguin.setSwimming((isSwimming.getText().equalsIgnoreCase("yes")));
                        penguin.setWalkSpeed(Integer.parseInt(speedFieldPenguin.getText()));
                        penguin.setSwimSpeed(Integer.parseInt(swimmingFieldPenguin.getText()));
                        setOptions();
                    }
                });
                break;

        }



    }

    private void ConfigPanel(String Caracteristicas) {
        grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Scene scene = new Scene(grid, 500, 400);
        HelloApplication.primaryStage.setScene(scene);

        Text scenetitle = new Text(Caracteristicas);
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(scenetitle, 0, 0, 2, 1);
    }

    @FXML
    private void showProperties() throws IOException {
        ConfigPanel("Caracteristicas: " + HelloApplication.selected);

//        addTextField("test");
        System.out.println("teste " + HelloApplication.selected);
        switch (HelloApplication.selected)
        {
            case "Tigre":

                Label introTigerLabel = new Label( "Idade: " +tiger.getAge() + " Altura"+
                        tiger.getHeight());
                grid.add(introTigerLabel, 0, 1);

                Label weightTigerLabel =  new Label("Peso: " + tiger.getWeight());
                grid.add(weightTigerLabel, 0, 2);

                Label numTigerLabel= new Label("Numero de Listras: " + tiger.getNumberOfStripes());
                grid.add(numTigerLabel, 0, 3);

                Label speedTigerLabel= new Label("Velocidade: " + tiger.getSpeed());
                grid.add(speedTigerLabel, 0, 4);

                Label levelTigerLabel= new Label("Nivel de Som" + tiger.getSoundLevel());
                grid.add(levelTigerLabel, 0, 5);

                Button btn = new Button("sair");
                grid.add(btn, 1, 6);
                btn.setOnAction(new EventHandler<ActionEvent>() {

                    @Override
                    public void handle(ActionEvent e) {
                        setOptions();
                    }
                });
                break;
            case "Golfinho":
                Label introDolphinLabel = new Label("Idade: " +dolphin.getAge() +
                        " Altura: "+ dolphin.getHeight());
                grid.add(introDolphinLabel, 0, 1);

                Label roar= new Label("Peso: " + dolphin.getWeight());
                grid.add(roar, 0, 2);

                Label color= new Label("Cor: " + dolphin.getColor());
                grid.add(color, 0, 3);

                Label speedLabel= new Label("Velocidade de Mergulho: " + dolphin.getSwimmingSpeed());
                grid.add(speedLabel, 0, 4);



                Button btnDolphin = new Button("Sair");
                grid.add(btnDolphin, 1, 5);
                btnDolphin.setOnAction(new EventHandler<ActionEvent>() {

                    @Override
                    public void handle(ActionEvent e) {
                        setOptions();
                    }
                });
                break;
            case "Pinguin":
                Label introPenguinLabel = new Label("Idade: " +penguin.getAge() +
                        " Altura: "+ penguin.getHeight());
                grid.add(introPenguinLabel, 0, 1);

                Label weightPenguinLabel= new Label("Peso: " +penguin.getWeight());
                grid.add(weightPenguinLabel, 0, 2);

                Label speedPenguinLabel= new Label("Velocidade de Passo: " + penguin.getWalkSpeed());
                grid.add(speedPenguinLabel, 0, 3);

                Label swimSpeedLabel= new Label("Velocidade de Mergulho: " + penguin.getSwimSpeed());
                grid.add(swimSpeedLabel, 0, 4);



                Button btnPenguin = new Button("Sair");
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
        ConfigPanel("Movimento: " + HelloApplication.selected);

//        addTextField("test");
        System.out.println("teste " + HelloApplication.selected);
        switch (HelloApplication.selected)
        {
            case "Tigre":

                Label introTigerLabel = new Label( tiger.walking());
                grid.add(introTigerLabel, 0, 1);



                Button btn = new Button("sair");
                grid.add(btn, 1, 2);
                btn.setOnAction(new EventHandler<ActionEvent>() {

                    @Override
                    public void handle(ActionEvent e) {
                        setOptions();
                    }
                });
                break;
            case "Golfinho":
                Label introDolphinLabel = new Label(dolphin.swimming());
                grid.add(introDolphinLabel, 0, 1);


                Button btnDolphin = new Button("Sair");
                grid.add(btnDolphin, 1, 2);
                btnDolphin.setOnAction(new EventHandler<ActionEvent>() {

                    @Override
                    public void handle(ActionEvent e) {
                        setOptions();
                    }
                });
                break;
            case "Pinguin":
                Label introPenguinLabel = new Label((penguin.isSwimming()? penguin.swimming() : penguin.walking()));
                grid.add(introPenguinLabel, 0, 2);


                Button btnPenguin = new Button("Sair");
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
    private void showEating()
    {
        ConfigPanel("Movimento: " + HelloApplication.selected);

//        addTextField("test");
        System.out.println("teste " + HelloApplication.selected);
        switch (HelloApplication.selected)
        {
            case "Tigre":

                Label introTigerLabel = new Label( tiger.eatingCompleted());
                grid.add(introTigerLabel, 0, 1);



                Button btn = new Button("sair");
                grid.add(btn, 1, 2);
                btn.setOnAction(new EventHandler<ActionEvent>() {

                    @Override
                    public void handle(ActionEvent e) {
                        setOptions();
                    }
                });
                break;
            case "Golfinho":
                Label introDolphinLabel = new Label(dolphin.eatingCompleted());
                grid.add(introDolphinLabel, 0, 1);


                Button btnDolphin = new Button("Sair");
                grid.add(btnDolphin, 1, 2);
                btnDolphin.setOnAction(new EventHandler<ActionEvent>() {

                    @Override
                    public void handle(ActionEvent e) {
                        setOptions();
                    }
                });
                break;
            case "Pinguin":
                Label introPenguinLabel = new Label((penguin.eatingCompleted()));
                grid.add(introPenguinLabel, 0, 2);


                Button btnPenguin = new Button("Sair");
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


    private  void writeObjectsToFile(Tiger tiger, Penguin penguin, Dolphin dolphin) {
        ConfigPanel("Arquivo");

        try {
            ObjectOutputStream oosTiger = new ObjectOutputStream(new FileOutputStream("tiger.txt"));
            ObjectOutputStream oosPenguin = new ObjectOutputStream(new FileOutputStream("penguin.txt"));
            ObjectOutputStream oosDolphin = new ObjectOutputStream(new FileOutputStream("dolphin.txt"));
            oosTiger.writeObject(tiger);
            oosPenguin.writeObject(penguin);
            oosDolphin.writeObject(dolphin);
            Label result = new Label( "Dados salvos");
            grid.add(result, 0, 1);

        } catch (IOException e) {
            e.printStackTrace();
            Label result = new Label( "Não foi possivel salvar dados no momento");
            grid.add(result, 0, 1);
        }





        Button btn = new Button("sair");
        grid.add(btn, 0, 2);
        btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
                initialize();
            }
        });
    }




    private void readObjectsFromFile() {
        ConfigPanel("Arquivo");
        try {
            ObjectInputStream oosTiger = new ObjectInputStream(new FileInputStream("tiger.txt"));
            ObjectInputStream oosPenguin = new ObjectInputStream(new FileInputStream("penguin.txt"));
            ObjectInputStream oosDolphin = new ObjectInputStream(new FileInputStream("dolphin.txt"));
            Tiger tiger = (Tiger) oosTiger.readObject();
            Penguin penguin = (Penguin) oosPenguin.readObject();
            Dolphin dolphin = (Dolphin) oosDolphin.readObject();
            System.out.println("Tiger data retrieved from file: " + tiger.toString());
            System.out.println("Penguin data retrieved from file: " + penguin.toString());
            System.out.println("Dolphin data retrieved from file:  " + dolphin.toString());
            Label result = new Label( tiger.toString() + "\n" + penguin.toString() + "\n" + dolphin.toString());
            grid.add(result, 0, 1);
        } catch (IOException e) {
            e.printStackTrace();
            Label result = new Label( "Não foi possivel ler os arquivos");
            grid.add(result, 0, 1);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        Button btn = new Button("sair");
        grid.add(btn, 0, 2);
        btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
                initialize();
            }
        });
    }



}
