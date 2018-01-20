import java.util.*;
import javafx.scene.image.*;
public class Animate{
  public ArrayList<Image> pics = new ArrayList<>();
  public Image currentImage;
  public double x,y;
  public double w,h;
  public double timePerFrame = 300;
  public boolean repeat = false;
  public boolean playing = false;
  public double startTime = 0;
  public double time = 0;
  public int frame;
  public boolean done = false;

  public Animate(double xIn, double yIn, double wIn, double hIn){
    x  = xIn;
    y = yIn;
    w = wIn;
    h = hIn;

  }

  public void addPic(Image i){
    pics.add(i);
    currentImage = pics.get(0);

  }

//TODO
// add pic switching!

public void setPlay(boolean p){
  playing = p;
}

public void restart(){
  frame = 0;
  time = 0;
  startTime = 0;
  playing = false;
  done = false;
}

  public void play(){
    playing = true;

      if(startTime == 0){
          startTime = System.nanoTime();
      }




    time = System.nanoTime() - startTime ;
    System.out.println("* " + time  / 1000000000);

    if(((time / 1000000000) % .6)  > .1 ){
      frame++;



    }

      if(frame < pics.size()){
        currentImage = pics.get(frame);
      }else{
        done = true;
      }

    MissileGame.tank1.setAI(currentImage);

  }
}
