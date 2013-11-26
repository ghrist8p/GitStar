package randomwalks;

public class Collisions {
    public static void main(String[] args)
    {
        RandomWalk particle1 = new RandomWalk(100_000,2_000_000,-3,0);
        RandomWalk particle2 = new RandomWalk(100_000,2_000_000, 3,0);
        
        int collisionCount = 0;
        while( particle1.moreSteps() && particle1.moreSteps() )
        {
            particle1.takeStep();
            particle2.takeStep();
            if( samePosition(particle1,particle2) )
            ++collisionCount;
        }
        System.out.println(collisionCount + " collisions occured");
    }
    
    public static boolean samePosition(RandomWalk walk1, RandomWalk walk2)
    {
        return walk1.getX() == walk2.getX() && walk1.getY() == walk2.getY();
    }
}
