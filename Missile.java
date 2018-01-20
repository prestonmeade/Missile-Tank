
import javafx.geometry.*;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
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
import java.awt.Rectangle;
import javafx.scene.SnapshotParameters;


public class Missile{

  public Sprite missile;

  boolean alive = false;
  Point2D spawn = new Point2D(0,650);
  double fireSpeed;
  boolean fired = false;
  Rectangle hitTracker;

  //Time for projectile motion
  double intial = 0;
  double time = 0;
  double launchAngle;
  double timeToArc = 0;
  double distance;

  public Missile(double launchVelocity, double launchAngle){

    this.launchAngle = launchAngle;
    fireSpeed = launchVelocity;
    System.out.println(fireSpeed + " " + launchAngle);
    missile =  new Sprite(new Image("aimMissile.png", 100, 30,false, false),
                          new Vector(spawn.getX(), spawn.getY(), launchVelocity, launchAngle), this);
    alive = true;
    System.out.println("MISSILE HOT");
    hitTracker = new Rectangle((int)missile.pos.getX(), (int)missile.pos.getY(),10,10);

  }



  public void update(){
    System.out.println(alive + " " + fired);
    getSprite().update();

    if(fired){
          checkHit();
      time = (System.nanoTime() - intial) / 1000000000;

      if(missile.pos.getY() + missile.getHeight() > 1000){
        alive = false;
        fired = false;
        relaunch();
      }
    }
  }

  public void relaunch(){
    System.out.println(missile.pos.getX());
    System.out.println("Relaunch please!");
    fired = false;
    alive = true;
    missile.pos.setX(spawn.getX());
    missile.pos.setY(spawn.getY());
    missile.setAngle(missile.getInitalAngle());
  //  render(Window.gc);

  }

  public void render(GraphicsContext gc){
    gc.setFill(Color.GREEN);
    Window.gc.fillText("X",(-1 * missile.pos.getDX() * (missile.timeToTop(missile.pos.getDY()) * 2)), 630 );

    if(alive && fired){
      gc.setFill(Color.RED);
      gc.fillRect(missile.pos.getX(), missile.pos.getY(),10,10);
      drawRotatedImage(gc,missile.getImage().getImage(),missile.getAngle(),missile.pos.getX(),missile.pos.getY());
    }else{
    }
  }

  private void checkHit(){
    Window.gc.setFill(Color.BLUE);
    Window.gc.fillRect(missile.pos.getX(), missile.pos.getY(), 5,5);


      if (hitTracker.intersects(MissileGame.tank1.getBounds())){
        if(MissileGame.tank1.hit == false){
        System.out.println("HIT");
        MissileGame.tank1.hit();
      }
      }
  }




  public boolean isAlive(){
    return alive;
  }

  public void setFired(boolean in){
    fired = in;
  }
  public boolean getFired(){
    return fired;
  }
  public void fire(){
    fired = true;

    System.out.println("Missile fired");
    intial = System.nanoTime();
    missile.getPos().setVelocity(fireSpeed , 180 - missile.getAngle());
  }

  public void setAlive(boolean in){
    alive = in;
  }

  public Sprite getSprite(){
    return missile;
  }

  public double getTime(){
    return time;
  }

  public Point2D getSpawn(){
    return spawn;
  }

  public boolean isFired(){
    return fired;
  }

  public double getlaunchAngle(){
    return launchAngle;
  }

  private void rotate(GraphicsContext gc, double angle, double px, double py) {
      Rotate r = new Rotate(angle, px, py);
      gc.setTransform(r.getMxx(), r.getMyx(), r.getMxy(), r.getMyy(), r.getTx(), r.getTy());
  }

  private void drawRotatedImage(GraphicsContext gc, Image image, double angle, double tlpx, double tlpy) {
        gc.save(); // saves the current state on stack, including the current transform
        rotate(gc, angle, tlpx + image.getWidth() / 2, tlpy + image.getHeight() / 2);
        gc.drawImage(image, tlpx, tlpy);
        gc.restore(); // back to original state (before rotation)
    }

    public String toString(){
      return ("Missile Specs speed: " + fireSpeed + " launchAngle: " + launchAngle  +"\n" +
      " Flight Time: " + missile.timeToTop(missile.pos.getDY()) * 2 + " \n " +
      "Distance: " + (-1 * missile.pos.getDX() * (missile.timeToTop(missile.pos.getDY()) * 2))  );
    }

}
