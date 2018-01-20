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


public class Map{


  public static void render(GraphicsContext gc){
    gc.setFill(Color.GREEN);
    gc.fillRect(0,650,2000,700);

    gc.setFill(Color.BLACK);
    gc.fillText("Angle: " + (180 - MissileGame.testMissile.missile.getInitalAngle()),50,50);
    gc.fillText("Velocity: " + (MissileGame.launchVelocity / 50),50,80);


  }

  public static void renderScale(GraphicsContext gc){
    gc.setFill(Color.BLACK);

    int distance = 0;
    for(int i = 100; i < 2000; i += 230){
      gc.fillText(distance + "", i, 640);
      distance += 5;
    }

  //  gc.fillText("10", 600,640);
    //gc.fillText("20", 1100,640);
    //gc.fillText("30", 1600,640);

  }

}
