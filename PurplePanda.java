/**
 * PurplePanda - Selectable panda skin; sets avatar color to purple when clicked.
 */
import greenfoot.*;

public class PurplePanda extends Actor
{ 
    private static final GreenfootImage NORMAL_IMAGE = new GreenfootImage("purplePanda.PNG");
    
    /**
     * Constructor - Sets purple panda image.
     */
    public PurplePanda()
    {
        setImage(NORMAL_IMAGE);
    }
  
    /**
     * Act - Sets the panda color to purple on click.
     */
    public void act()
    {
        if (Greenfoot.mouseClicked(this))
        {
            Levels.color = 5;
            return; 
        }
    }    
}
