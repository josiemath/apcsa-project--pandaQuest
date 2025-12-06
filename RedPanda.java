/**
 * RedPanda - Selectable panda skin; sets avatar color to red when clicked.
 */
import greenfoot.*;

public class RedPanda extends Actor
{ 
    private static final GreenfootImage NORMAL_IMAGE = new GreenfootImage("redPanda.png");

    /**
     * Constructor - Sets red panda image.
     */
    public RedPanda()
    {
        setImage(NORMAL_IMAGE);
    }

    /**
     * Act - Sets the panda color to red on click.
     */
    public void act()
    {
        if (Greenfoot.mouseClicked(this))
        {
            Levels.color = 0;
            return;
        }
    }    
}