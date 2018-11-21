import java.util.*;
import java.awt.*;
import java.util.Random;

/**
 * Class that represents a turtle which is similar to a Logo turtle.
 * This class inherts from SimpleTurtle and is for students
 * to add methods to.
 *         Filename: Turtle.java
 *         Created by: Judy Chun, cs8afug
 *         Date: 10/22/2017
 */
/** 
  * PROGRAM DESCRIPTION FOR LITTLE KIDS/GRANDMA
  * 
  * Turtle.java displays methods that are called by the RandomTurtleTester class and RandomTurtleTester2 class. In this case, calling the takeStep method displays a random 
  * step of the turtle. The direction of -1 refers to a step to the left, whereas direction of 1 refers to a step to the right. The generator refers to the Random object 
  * that helps to generate a random number. The turtle stimulates a random walk by passing it in a random value for the direction. The rwPosition method is called to
  * input the number of random walk steps that the Turtle will take, which will make the Turtle take nSteps randomly. The getRandomStep method is used to determine
  * whether the turtle will take a step to the left or to the right by passing the probabilityToRight as 0.5, which represents the probability that the Turtle moves to 
  * the right. By the end, the Turtle's final displacement in terms of steps horizontally to the left or to the right of the Turtle's original position is being returned. 
  * Finally, the countSteps method is used to display the Turtle's randomly walking up the page until it reaches the maximum displacement distance from its starting 
  * position, either to the left or the right. The number of steps the Turtle takes before it hits the maximum displacement is finally returned.  
  * 
  * RandomTurtleTester displays the main method of the RandomTurtleTester class where a new World is created with a Turtle to take random directions for its steps. In this
  * case, the takeStep method is used to pass a random value for the direction in order to simulate a random walk. Whereas, the rwPosition method is used to input the number
  * of random walk steps that the Turtle takes. Moreover, each time the Turtle takes a step, the displacement is updated. Lastly, the countSteps method is used to display the
  * Turtle's randomly walking up the page until it reaches the maximum displacement distance from its starting position, either to the left or the right. In turn, this method
  * will return the number of steps that the Turtle takes before it hits the maximum displacement. The path that the Turtle takes is different every time due to its random walks. 
  * 
  * RandomTurtleTester2 is used to determine how varying the number of steps and probabilitytoRight affects the result of final average displacement. In this case, the
  * rwPositionPlain method is called to simply return the final displacement value. For example, I varied the probabilitytoRight as 0.3 and changed the number of random steps 
  * to 200, which gives the final average of -159.985
  * 
  */ 

public class Turtle extends SimpleTurtle {
    ////////////////// constructors ///////////////////////

    /**
     * Constructor that takes the x and y and a picture to
     * draw on
     *
     * @param x       the starting x position
     * @param y       the starting y position
     * @param picture the picture to draw on
     */
    public Turtle(int x, int y, Picture picture) {
        // let the parent constructor handle it
        super(x, y, picture);
    }

    /**
     * Constructor that takes the x and y and a model
     * display to draw it on
     *
     * @param x              the starting x position
     * @param y              the starting y position
     * @param modelDisplayer the thing that displays the model
     */
    public Turtle(int x, int y,
                  ModelDisplay modelDisplayer) {
        // let the parent constructor handle it
        super(x, y, modelDisplayer);
    }

    /**
     * Constructor that takes the model display
     *
     * @param modelDisplay the thing that displays the model
     */
    public Turtle(ModelDisplay modelDisplay) {
        // let the parent constructor handle it
        super(modelDisplay);
    }

    /**
     * Constructor that takes a picture to draw on
     *
     * @param p the picture to draw on
     */
    public Turtle(Picture p) {
        // let the parent constructor handle it
        super(p);
    }

    /////////////////// methods ///////////////////////

    /**
     * Return whether or not the turtle should take a step to the left
     * or the right
     * Parameters: probabilityToRight: the probability the turtle moves to the right.
     *                                 Should between 0-1.
     *             generator: a Random object that will help to generate random number.
     * Output: -1 to represent a step to the left, 1 to represent a step to the right.
     */
    public int getRandomStep(double probabilityToRight, Random generator) {
        // Choose either 0 or 1 (note that next int is NON inclusive
        // of its argument).
        double choice = generator.nextDouble();
        if (choice < probabilityToRight) {
          return 1;
        } else {
          return -1;
        }
    }

    public int generateOffset(Random generator) {
      int step = 1+generator.nextInt(3); //generating random number between 1 and 3 inclusive  
      return step;
    }
    
    public int takeStep(int direction, Random generator){
      this.turn(direction*45);  //direction is -1 for step to the left or 1 for step to the right 
      int step1 = this.generateOffset(generator); //call a helper method to determine how large of a step Turtle takes 
      this.forward(step1 * 20);
      this.turn(-direction*45);  //rotate the Turtle to facing up again before it ends 
      return step1; 
      
      
    }
    
    public int rwPosition(int nSteps, Random generator) {   //input the number of random walk steps that the calling object Turtle will take and Random object 
      int displacement = 0;
      for(int i = 0; i < nSteps; i++){
        //probabiliy of moving right or moving left is 0.5 
        int direction = this.getRandomStep(0.5, generator);
        int step = this.takeStep(direction, generator);
        //Direction is either -1 or 1 and multiplying that to step in order to get displacement
        displacement += direction * step; 
        
      }
      return displacement; 
      
    }
    
 
    public int countSteps(int maxDisplacement, Random generator) {
      int numSteps = 0;
      int currentDisplacement = 0;
      
      //check whether absolute value of turtle's displacement exceeded the maxDisplacement 
      while(Math.abs(currentDisplacement) <= maxDisplacement) {   //randomly walking until it reaches maxDisplacement distance 
   
        int direction = this.getRandomStep(0.5, generator);  //calling getRandomStep method with probabilityToRight as 0.5  
        int step = this.takeStep(direction, generator); //calling takeStep method either moving left or right randomly 
        System.out.println("steps" + numSteps);
       
        currentDisplacement += (step*direction); //adding onto the currentDisplacement value 
        numSteps++;
        System.out.println("Current Displacement is " + currentDisplacement);

        
    }
      return numSteps;  //count and return the number of steps the Turtle took until it reaches maxDisplacement distance 
    }
    
    public int rwPositionPlain(int nSteps, Random generator){
      int displacement = 0;
      for(int i = 0; i < nSteps; i++){
        //Probabiliy of moving right or moving left is 0.5 
        int direction = this.getRandomStep(0.5, generator);   //probabilitytoRight refers to the parameter passed to getRandomStep in rwPositionPlain 
        int step = this.generateOffset(generator); //caling generateOffset intead of takeStep
        //Direction is either -1 or 1 and multiplying that to steps in order to get displacement
        displacement += direction * step; 
        
      }
      return displacement;  //return the final displacement 
      
    }
    
     
} // this } is the end of class Turtle
