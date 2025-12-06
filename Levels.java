/**
 * Levels - Central class for level state, size, and panda color selection.
 */
import greenfoot.*;

public class Levels extends Actor
{
    public static int[] gridSizes = {8,10,12,14,16}; 
    public static int currentLevel = 1;
    public static int PlayWidth = gridSizes[currentLevel-1];
    public static int PlayHeight = PlayWidth + 2;
    public static int advance = 0;
    public static int color = 7;
    
    /**
     * Constructor - Initializes level actor.
     */
    public Levels()
    {
    }
    
    /**
     * Act - Placeholder for future level-related actions.
     */
    public void act()
    {
    }
    
    /**
     * Returns playable grid width for current level.
     */
    public static int getPLAY_WIDTH()
    {
        int PlayWidth = gridSizes[currentLevel-1];
        return PlayWidth;
    }
    
    /**
     * Returns playable grid height for current level.
     */
    public static int getWORLD_WIDTH()
    {
        int PlayHeight = PlayWidth + 2;
        return PlayHeight;
    }
}
