/**
 * YellowPanda - Selectable panda skin; sets avatar color to red when clicked.
 */
import greenfoot.*;

public class YellowPanda extends Actor
{ 
    private static final GreenfootImage NORMAL_IMAGE = new GreenfootImage("yellowPanda.PNG");
    
    /**
     * Constructor - Sets yellow panda image.
     */
    public YellowPanda()
    {
        setImage(NORMAL_IMAGE);
    }

    /**
     * Act - Sets the panda color to yellow on click.
     */
    public void act()
    {
        if (Greenfoot.mouseClicked(this))
        {
            Levels.color = 2;
            return; 
        }
    }    
}