import javafx.scene.paint.*;

public class MissileGame extends Window{

  static boolean pauseState = false;



//Test var
static double launchVelocity = 0;
static double launchAngle = 0;

static Missile testMissile;
static Tank tank1 = new Tank(1500);
public  void load(){
  openDataWindow();
}

public static void init(){

  open();
  createMainMissile();
    runGameLoop();
}

public static void createMainMissile(){

  testMissile = new Missile(launchVelocity, launchAngle);
  System.out.println("Missile created " + testMissile.toString());
}



public static void update(){
  //Test draw a missile
testMissile.update();
//stats.update();
}

public static  void render(){
gc.clearRect(0,0, WIDTH, HEIGHT);


Map.render(gc);

Map.renderScale(gc);
Window.gc.setFill(Color.RED);
Window.gc.fillRect(0,650,2000,2000);
renderTanks();
testMissile.render(gc);

//stats.render();
}

public static void renderTanks(){
  tank1.render(gc);
}

public static void runGameLoop(){
    Thread loop = new Thread()
    {
       public void run()
       {
          gameLoop();
          System.out.println("Run game loop");
       }
    };
    loop.start();
 }

 public static void gameLoop()
 {
   while(true)
          {
                long time = System.currentTimeMillis();
                int fps = 60;
                update();
                render();

                //  delay for each frame  -   time it took for one frame
                time = (1000 / fps) - (System.currentTimeMillis() - time);

                if (time > 0){
                     try{
                      Thread.sleep(time);
                    } catch(Exception e){}
                  }
          }
  }



}
