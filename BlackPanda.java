/**
 * BlackPanda - Selectable panda skin; sets avatar color to black when clicked.
 */
import greenfoot.*;

public class BlackPanda extends Actor
{ 
    private static final GreenfootImage NORMAL_IMAGE = new GreenfootImage("blackPanda.PNG");
    private GreenfootSound clickSound = new GreenfootSound("SelectSound.mp3");

    /**
     * Constructor - Sets black panda image.
     */
    public BlackPanda()
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
            Levels.color = 7;
            clickSound.play();
            return; 
        }
    }    
}
