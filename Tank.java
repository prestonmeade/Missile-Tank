
import javafx.geometry.*;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import java.util.*;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.animation.*;
import javafx.scene.image.Image;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.transform.Rotate;
import javafx.geometry.Insets;
import javafx.scene.canvas.*;
import javafx.scene.paint.*;
import javafx.scene.canvas.Canvas;
import javafx.scene.Group;
import java.util.*;
import javafx.scene.SnapshotParameters;
import java.awt.Rectangle;

public class Tank{


  private ImageView tankImage;
  public double x,y = 600;
  public double w = 100,h = 50;
  public Rectangle hitBox;
  public Image animateImage;
  public boolean hit = false;

  public Animate explosion;

  public Tank(double xIn){
    x = xIn;

    Image ti  = new Image("tank.png", w, h, false, false);
    tankImage = new ImageView(ti);
    hitBox = new Rectangle((int)x,(int)y,(int)w,(int)h);
    explosion = new Animate(x,y,w,h);
    explosion.addPic(new Image("e1.png", w, w,false,false));
    explosion.addPic(new Image("e2.png", w, w,false,false));
    explosion.addPic(new Image("e3.png", w, w,false,false));
    explosion.addPic(new Image("e4.png", w, w,false,false));
    explosion.addPic(new Image("e5.png", w, w,false,false));
    explosion.addPic(new Image("e6.png", w, w,false,false));
    explosion.addPic(new Image("e7.png", w, w,false,false));
    explosion.addPic(new Image("e8.png", w, w,false,false));
    explosion.addPic(new Image("e9.png", w, w,false,false));

  }

  public void update(){
    if(hit){
      explosion.play();
    }
  }

  public void render(GraphicsContext gc){


    if(hit){
      if(explosion.done == false){
      explosion.play();

      gc.drawImage(animateImage,x,y);
    }
    }else{
      gc.setFill(Color.BLUE);
      gc.strokeRect(x,y,w,h);
      gc.drawImage(tankImage.getImage(), x,y);

    }

  }

  public void hit(){
    hit = true;
    explosion.play();
    respawn();
  }

  public void respawn(){
    x = (Math.random() * 1500) + 500;
    hit = false;
    explosion.restart();
    hitBox.setBounds((int)x,(int)y,(int)w,(int)h);
  }

  public ImageView getIV(){
    return tankImage;
  }

  public double getY(){
    return y;
  }
  public double getX(){
    return x;
  }
  public double getWidth(){
    return w;
  }

  public void setAI(Image in){
    animateImage = in;
  }

  public Rectangle getBounds(){
    return hitBox;
  }


}
