/**
 * GreenPanda - Selectable panda skin; sets avatar color to green when clicked.
 */
import greenfoot.*;

public class GreenPanda extends Actor
{ 
    private static final GreenfootImage NORMAL_IMAGE = new GreenfootImage("greenPanda.PNG");
    private GreenfootSound clickSound = new GreenfootSound("SelectSound.mp3");

    /**
     * Constructor - Sets green panda image.
     */
    public GreenPanda()
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
            Levels.color = 3;
            clickSound.play();
            return; 
        }
    }    
}
