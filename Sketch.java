import processing.core.PApplet;
import processing.core.PImage;

public class Sketch extends PApplet {
  //create image variables, and create X, Y, and other variables for animation
	PImage imgUnderwater;
  PImage imgFish;
  int fishX = 25;
  int fishY = 100;
  int fishSpeedX = 2;
	int gemX = 50;
  int gemY = 200;
  double time;
  /**
   * Called once at the beginning of execution, put your size all in this method
   */
  
  
  public void settings() {
	// put your size call here
    size(400, 400);
    
  }

  /** 
   * Called once at the beginning of execution.  Add initial set up
   * values here i.e background, stroke, fill etc.
   */

  //load ocean image, resize it to the size of the screen, and  also resize fish image
  public void setup() {
    background(210, 255, 173);
  imgUnderwater = loadImage("underwater-wallpaper-7116-7379-hd-wallpapers.jpg");
    imgFish = loadImage("fishing-png-41459.png");
    imgUnderwater.resize(400, 400);
    imgFish.resize(100, 60);
    
  }

  /**
   * Called repeatedly, anything drawn to the screen goes here
   */
  public void draw() {
    //add ocean image as the background, loads fish which moves back and forth in a linear motion with collision detectors
	  image(imgUnderwater, 0, 0);
    image(imgFish, fishX, fishY);
    fishX += fishSpeedX;
    if (fishX < 0 || fishX > width - 100) {
      fishSpeedX *= -1;
    }

    //creates green circle aka gem which moves in a circular motion around the fish
    fill(136, 252, 104);
    ellipse(gemX, gemY, 50, 50);
    gemX = (int)((Math.sin(time) + 1) * (width - 50) / 2 + 25);
    gemY = (int)((Math.cos(time) + 1) * (height - 50) / 2 + 25);
    time += 0.02;
	
  }
  
  // define other methods down here.
  
}