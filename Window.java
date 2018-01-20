import java.awt.image.BufferedImage;
import java.io.File;
import javafx.application.Application;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.*;
import javafx.scene.*;
import javafx.scene.image.*;
import java.util.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.*;
import javax.imageio.ImageIO;
import java.io.*;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Rectangle;
import javafx.scene.input.*;


public class Window{

  static boolean open = false;
  static Stage window;
  static Group root;
  static BorderPane main;

  static Scene scene;
  static Canvas canvas;
  static GraphicsContext gc;




  static  int WIDTH = 2000, HEIGHT = 700;

    public static void open(){

      window = new Stage();
      window.setTitle("Missile Launcher");
      window.setOnCloseRequest(e -> exitProgram());

      root = new Group();
      main = new BorderPane();

      main.setCenter(root);

      scene = new Scene(main,WIDTH,HEIGHT);
      canvas = new Canvas(WIDTH,HEIGHT);
      canvas.setFocusTraversable(true);


      gc = canvas.getGraphicsContext2D();


      root.getChildren().addAll(canvas);

      window.setScene(scene);
      window.show();

      addKeyCommands();
      open = true;
    }


    public boolean isOpen(){
      return open;
    }
      private static void repaint(){
      gc.setFill(Color.BLUE);
      gc.fillRect(0,0,WIDTH,700);
    }

    private static void addKeyCommands(){
      scene.setOnKeyPressed(
       keyEvent -> {



         KeyCode key = keyEvent.getCode();

         if(key == KeyCode.LEFT){

         }
         if(key == KeyCode.RIGHT){



         }
         if(key == KeyCode.E){
           editPayload();
         }
         if(key == KeyCode.W){

         }
         if(key == KeyCode.R){
           MissileGame.tank1.respawn();
         }
         if(key == KeyCode.SPACE){
           System.out.println("FIRE!");
           MissileGame.testMissile.fire();

         }

       });


       scene.setOnKeyReleased(
        keyEvent -> {
          KeyCode key = keyEvent.getCode();
          if(key == KeyCode.A ){

          }
          if( key == KeyCode.D ){

          }
          if( key == KeyCode.SPACE){

          }

        });
    }



    private static void exitProgram(){
      System.out.println("Program exited, now closing...");
      System.exit(0);
    }

    public static void openDataWindow(){

         Stage dataBox = new Stage();
          dataBox.setTitle("Program Missile");
          dataBox.initModality(Modality.NONE);

         VBox mainData;
          mainData = new VBox();


         Scene sceneData;

        int WIDTH = 350, HEIGHT = 500;

            TextField launchVelocity = new TextField();
              launchVelocity.setPromptText("Inital Velocity...");
            TextField launchAngle = new TextField();

              launchAngle.setPromptText("Initail Angle...");

            Button submit = new Button("Countine to launch!");

              submit.setOnAction((event) -> {
                  System.out.println(launchVelocity.getText() + " " + launchAngle.getText());

                  MissileGame.launchAngle = Double.parseDouble(launchAngle.getText());
                  MissileGame.launchVelocity = Double.parseDouble(launchVelocity.getText()) * 50;

                  MissileGame.init();
                  dataBox.close();

                });



            sceneData = new Scene(mainData,WIDTH,HEIGHT);


            mainData.getChildren().addAll(launchVelocity, launchAngle, submit);

            dataBox.setScene(sceneData);
            dataBox.show();


    }
    public static void editPayload(){

         Stage payloadStage = new Stage();
          payloadStage.setTitle("Edit Flight of Missile");
          payloadStage.initModality(Modality.NONE);

         VBox payloadData;
          payloadData = new VBox();


         Scene payloadScene;

        int WIDTH = 350, HEIGHT = 500;

            TextField launchVelocity = new TextField();
              launchVelocity.setPromptText("Inital Velocity...");
            TextField launchAngle = new TextField();

              launchAngle.setPromptText("Initail Angle...");

            Button submit = new Button("Countine to launch!");

              submit.setOnAction((event) -> {
                  System.out.println(launchVelocity.getText() + " " + launchAngle.getText());

                  MissileGame.launchAngle = Double.parseDouble(launchAngle.getText());
                  MissileGame.launchVelocity = Double.parseDouble(launchVelocity.getText()) * 50;
                  System.out.println(MissileGame.launchAngle + " " + MissileGame.launchVelocity);
                  MissileGame.createMainMissile();
                  payloadStage.close();

                });

              Label curAngle = new Label("Current Angle: " + MissileGame.launchAngle);
              Label curVel = new Label("Current Velocity: " + MissileGame.launchVelocity);



            payloadScene = new Scene(payloadData,WIDTH,HEIGHT);


            payloadData.getChildren().addAll(launchVelocity, launchAngle, submit, curAngle, curVel);

            payloadStage.setScene(payloadScene);
            payloadStage.show();


    }

}
