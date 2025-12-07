/**
 * OrangePanda - Selectable panda skin; sets avatar color to orange when clicked.
 */
import greenfoot.*;

public class OrangePanda extends Actor
{ 
    private static final GreenfootImage NORMAL_IMAGE = new GreenfootImage("orangePanda.PNG");
    private GreenfootSound clickSound = new GreenfootSound("SelectSound.mp3");

    /**
     * Constructor - Sets orange panda image.
     */
    public OrangePanda()
    {
        setImage(NORMAL_IMAGE);
    }

    /**
     * Act - Sets the panda color to orange on click.
     */
    public void act()
    {
        if (Greenfoot.mouseClicked(this))
        {
            Levels.color = 1;
            clickSound.play();
            return;
        }
    }    
}
