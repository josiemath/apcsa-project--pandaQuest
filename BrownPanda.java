/**
 * BrownPanda - Selectable panda skin that sets the player's color when clicked.
 */
import greenfoot.*;

public class BrownPanda extends Actor
{ 
    private static final GreenfootImage NORMAL_IMAGE = new GreenfootImage("brownPanda.PNG");
    private GreenfootSound clickSound = new GreenfootSound("SelectSound.mp3");

    /**
     * Constructor - Sets brown panda image.
     */
    public BrownPanda()
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
            Levels.color = 6;
            clickSound.play();
            return; 
        }
    }    
}
