/**
 * Level_3 - Actor displaying level intro, removed after any key is pressed.
 */
import greenfoot.*;

public class Level_3 extends Actor
{
    /**
     * Constructor - Prepares the intro image/text for Level 3.
     */
    public Level_3()
    {
    }
    
    /**
     * Act - Removes level intro when a key is pressed.
     */
    public void act()
    {
        if (Greenfoot.isKeyDown("up") || Greenfoot.isKeyDown("down") || Greenfoot.isKeyDown("left") || Greenfoot.isKeyDown("right") || Greenfoot.isKeyDown("space") || Greenfoot.isKeyDown("a") || Greenfoot.isKeyDown("b"))
        {
            getWorld().removeObject(this);
        }
    }
}