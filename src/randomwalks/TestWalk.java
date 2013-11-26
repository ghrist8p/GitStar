package randomwalks;

//************************************************************
//TestWalk.java
//
//Program to test methods in the RandomWalk class.
//************************************************************
import java.util.Scanner;

public class TestWalk {
    public static void main(String[] args) {
        
        RandomWalk walk3 = new RandomWalk(200,10);
        walk3.walk();
        System.out.println(walk3);
        
        int maxSteps;   // maximum number of steps in a walk
        int maxCoord;   // the maximum x and y coordinate
        int x, y;       // starting x and y coordinates for a walk
        
        RandomWalk walk1;
        RandomWalk walk2;
        
        Scanner scan = new Scanner(System.in);
        
        System.out.println("\nRandom Walk Test Program");
        System.out.println();
        
        System.out.print("Enter the boundary for the square: ");
        maxCoord = scan.nextInt();
        
        System.out.print("Enter the maximum number of steps: ");
        maxSteps = scan.nextInt();
        
        System.out.print("Enter the starting x and y coordinates with "
                + "a space between: ");
        
        x = scan.nextInt();
        y = scan.nextInt();
        
        scan.close();
        
        walk1 = new RandomWalk(10,5);
        walk2 = new RandomWalk(maxSteps,maxCoord,x,y);
        
        System.out.println("\n\n" + walk1 + "\n\n" + walk2);
        
        for( int i = 0; i < 5; ++i )
        {
            walk1.takeStep();
            walk2.takeStep();
            System.out.println("\n\n" + walk1 + "\nMax distance:" + walk1.getMaxDistance() + "\n\n" + walk2 + "\nMax distance:" + walk2.getMaxDistance());
        }
    }
}