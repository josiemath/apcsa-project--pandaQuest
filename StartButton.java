/**
 * StartButton - Starts the main game world and toggles appearance on hover.
 */
import greenfoot.*;

public class StartButton extends Actor
{
    private static final GreenfootImage NORMAL_IMAGE = new GreenfootImage("startButton_normal.png");
    private static final GreenfootImage HOVER_IMAGE = new GreenfootImage("startButton_faded.png");
    
    /**
     * Constructor - Sets default start button image.
     */
    public StartButton()
    {
        setImage(NORMAL_IMAGE);
    }

    /**
     * Act - Launches PandaWorld on click and changes image on hover.
     */
    public void act()
    {
        if (Greenfoot.mouseClicked(this))
        {
            Greenfoot.setWorld(new PandaWorld());
            return; 
        }

        if (Greenfoot.mouseMoved(this))
        {
            // If the mouse is over the button, set the pre-faded image
            if (getImage() != HOVER_IMAGE) {
                setImage(HOVER_IMAGE);
            }
        }
        else
        {
            // If the mouse is NOT over the button, set the normal image
            if (getImage() != NORMAL_IMAGE) {
                setImage(NORMAL_IMAGE);
            }
        }
    }    
}