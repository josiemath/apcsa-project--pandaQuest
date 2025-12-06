/**
 * BluePanda - Selectable panda skin; sets avatar color to blue when clicked.
 */
import greenfoot.*;

public class BluePanda extends Actor
{ 
    private static final GreenfootImage NORMAL_IMAGE = new GreenfootImage("bluePanda.PNG");

    /**
     * Constructor - Sets blue panda image.
     */
    public BluePanda()
    {
        setImage(NORMAL_IMAGE);
    }

    /**
     * Act - Changes the panda color on click.
     */
    public void act()
    {
        if (Greenfoot.mouseClicked(this))
        {
            Levels.color = 4;
            return; 
        }
    }    
}