/**
 * Level_2 - Actor displaying level intro, removed after any key is pressed.
 */
import greenfoot.*;

public class Level_2 extends Actor
{
    /**
     * Constructor - Prepares the intro image/text for Level 2.
     */
    public Level_2()
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