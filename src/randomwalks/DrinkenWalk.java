package randomwalks;

import java.util.Scanner;

public class DrinkenWalk {
    public static void main( String[] args )
    {
        int maxSteps;
        int bounds;
        int numDrunks;
        
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter maximum number of steps: ");
        maxSteps = scan.nextInt();
        System.out.print("Enter bounds: ");
        bounds = scan.nextInt();
        System.out.print("Enter number of drunks: ");
        numDrunks = scan.nextInt();
        scan.close();
        
        int drunksFellOff = 0;
        
        for( int i = 0; i < numDrunks; ++i )
        {
            RandomWalk walk = new RandomWalk(maxSteps, bounds);
            walk.walk();
            if( !walk.inBounds() ) ++drunksFellOff;
        }
        
        System.out.println(drunksFellOff + " out of " + numDrunks + " drunks fell off a " + bounds + " by " + bounds + " barge.");
    }
}
