/* Filename: RandomTurtleTester.java
* Created by: Judy Chun, cs8afug
* Date: 10/22/2017
*/

import java.util.Random;

public class RandomTurtleTester {
    //takeStep method 
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
       int count = judy2.countSteps(5, generator);
       System.out.println(count);
       
       

    }
}
