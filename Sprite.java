
import javafx.scene.image.*;
import javafx.scene.paint.*;
import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Sprite{
  ImageView image;

  Vector pos;

  double angle;
  double initialAngle;
  double width = 120;
  double height = 50;

  Missile curMissile;

  public Sprite(Image image, Vector pos, Missile curMissile){
    this.image = new ImageView(image);
    this.pos = pos;
    this.angle = 90 + ( 90 - curMissile.getlaunchAngle());
    initialAngle = this.angle;
    this.curMissile = curMissile;
  }

  public void update(){

    if(curMissile.isFired()){
      pos.update(curMissile);

      if(initialAngle != 90){
        setAngle(  initialAngle + ((angleChangeRate(timeToTop(pos.getDY()), initialAngle)) * curMissile.getTime() / 3) );
      }
    }

  }

  public ImageView getImage(){
    return image;
  }

  public Vector getPos(){
    return pos;
  }

  public double getAngle(){
    return angle;
  }
  public ImageView getIV(){
    return image;
  }
  public void setAngle(double angleIn){
    angle = angleIn;
    image.setRotate(angle);
  }
  public double getInitalAngle(){
    return initialAngle;
  }

  public void addLaunchAngle(double in){
    initialAngle += in;
    angle = initialAngle;
    image.setRotate(angle);
  }

  public void addAngle(double angleIn){
    angle += angleIn;
    image.setRotate(angle);

    System.out.println("Angle added of: " + angleIn);
  }

  public double getWidth(){
    return width;
  }

  public double getHeight(){
    return height;
  }

  public double timeToTop(double vi){

      return vi/ (9.8 * 50);
}

public double angleChangeRate(double timeToTop, double angle){

       double aps = angle / timeToTop;
      return aps;
}



}
