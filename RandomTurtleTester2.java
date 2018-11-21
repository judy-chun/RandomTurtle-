/* Filename: RandomTurtleTester2.java
* Created by: Judy Chun, cs8afug
* Date: 10/22/2017
* 
* A) The average final signed-displacement for a random walker after making 100 random steps with a value of 0.5 for the probabilitytoRight is 0.126
* The average final signed-displacement for a random walker after making 100 random steps with a value of 0.8 for probabilitytoRight is 121.725
* Whereas, the average final signed-displacement for a random walker after making 100 random steps with a value of 0.3 for the probabilitytoRight is -78.485
* 
* B) When varying the number of random steps to 200 and probabilitytoRight as 0.5, the average final-signed displacement is -0.394
* When varying the number of random steps to 50 and probabilitytoRight as 0.5, the average final-signed displacement is -2.535
* When varying the number of random steps to 200 and probabilitytoRight as 0.3, the average final-signed displacement is -159.985
* When varying the number of random steps to 200 and probabilitytoRight as 0.8, the average final-signed displacement is 237.253
* When varying the number of random steps to 50 and probabilitytoRight as 0.3, the average final-signed displacement is -39.415
* When varying the number of random steps to 50 and probabilitytoRight as 0.8, the average final-signed displacement is 61.422
* 
*/

import java.util.Random;

public class RandomTurtleTester2 {
    //The line below is magic, you don't have to understand it (yet)
    public static void main (String[] args) {
       World world1 = new World(500,500);
       Turtle judy = new Turtle(250,500,world1);
       Random generator = new Random();
       judy.takeStep(1, generator);
       judy.takeStep(-1, generator);
       

       
       //rwPosition method
       World world2 = new World(500,500);
       Turtle judy1 = new Turtle(250,500,world2);
       int displacement = judy1.rwPosition(8, generator);
       System.out.println(displacement);
       
       //countSteps method
       World world3 = new World(500,500);
       Turtle judy2 = new Turtle(250,500,world3);
       int count = judy2.countSteps(6, generator);
       System.out.println(count);
       
       //rwPositionPlain method 
       World world4 = new World();
       //It's not important where the Turtle starts because you won't actually move the Turtle
       Turtle judy3 = new Turtle(world4);
       int numTrials = 0;
       double totalDisplacement = 0.0;
       while (numTrials < 142)  //refers to the number of different trials so you can take their average 
       {
         totalDisplacement = totalDisplacement + judy3.rwPositionPlain(100, generator);  //experimenting by changing the value 100 to other values of nSteps 
         numTrials = numTrials + 1;
       }
       //Find the average here
       double average = totalDisplacement/numTrials; 
       System.out.println(average);   //Print out the results of the final average 
    
    }
}
