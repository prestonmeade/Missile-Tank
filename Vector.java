import javafx.geometry.*;
import java.lang.Math.*;

public class Vector{

  double x;
  double y;
  double dx;
  double dy;
  double GRAVITY = 9.8 * 50;



  public Vector(double x, double y, double vel, double ang){
  this.x  =x;
  this.y = y;
    this.dx = calculateX(vel,90 + ang);
    this.dy = calculateY(vel, 90 + ang);
    System.out.println(dx);
    System.out.println(dy);
  }
  public void update(Missile curMissile){
    x =   (dy * curMissile.getTime());

   y = 650 - (-1 * dx * curMissile.getTime()) + (.5 * GRAVITY * (curMissile.getTime() * curMissile.getTime()) );

   MissileGame.testMissile.hitTracker.setBounds((int)x,(int)y,10,10);
  }
  public double getX(){
   return  x;
  }

  public double getY(){
   return  y;
  }

  public void setX(double xIn){ x = xIn;}
  public void setY(double yIn){ y = yIn;}

  public double getDY(){
    return dy;
  }
  public double getDX(){
    return dx;
  }

  public void setVelocity(double magnitude, double theta){
    System.out.println(magnitude + " " + theta + " mag and theta");
    System.out.println("Velocity set: x=" + dy + " || y=" + dx);

  }
  public void setDx(double dx){
    this.dx = dx;
  }

  public void setDy(double dy){
    this.dy = dy;
  }

  private double calculateX(double mag, double theta){
    return Math.cos(Math.toRadians( theta)) * mag;

  }

  private double calculateY(double mag, double theta){
    return Math.sin( Math.toRadians (theta))  * mag ;


  }

}
