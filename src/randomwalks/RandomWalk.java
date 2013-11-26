package randomwalks;

import static java.lang.Math.abs;

import java.util.Random;

public class RandomWalk {

    private static final int UP = 0;
    private static final int DOWN = 1;
    private static final int LEFT = 2;
    private static final int RIGHT = 3;
    
    private static final Random RAND_GEN = new Random();
    
    private int x;
    private int y;
    private int steps;
    private int bounds;
    private int maxSteps;
    
    private int maxDistance;
    
    public RandomWalk(int max, int edge)
    {
        x = 0;
        y = 0;
        steps = 0;
        maxSteps = max;
        bounds = edge;
        
        maxDistance = 0;
    }
    
    public RandomWalk(int max, int edge, int xStart, int yStart)
    {
        x = xStart;
        y = yStart;
        steps = 0;
        maxSteps = max;
        bounds = edge;
        
        maxDistance = 0;
    }
    
    public int getX()
    {
        return x;
    }
    
    public int getY()
    {
        return y;
    }
    
    public int getMaxDistance()
    {
        return maxDistance;
    }
    
    public void takeStep()
    {
        switch( RAND_GEN.nextInt(4) )
        {
        case UP:    ++y; break;
        case DOWN:  --y; break;
        case LEFT:  --x; break;
        case RIGHT: ++x; break;
        }
        ++steps;
        maxDistance = max(maxDistance,max(abs(x),abs(y)));
    }
    
    public boolean moreSteps()
    {
        return steps < maxSteps;
    }
    
    public boolean inBounds()
    {
        return abs(x) <= bounds && abs(y) <= bounds;
    }
    
    public void walk()
    {
        while( moreSteps() && inBounds() ) takeStep();
    }
    
    @Override
    public String toString()
    {
        return "RandomWalk[steps:"+steps+",position:("+x+","+y+")]";
    }
    
    private int max( int a, int b )
    {
        return a > b ? a : b;
    }
}
