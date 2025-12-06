/**
 * ReplayButton - Allows player to retry the level or return to start, toggles hover image.
 */
import greenfoot.*;

public class ReplayButton extends Actor
{
    private static final GreenfootImage NORMAL_IMAGE = new GreenfootImage("smallerReplaybutton.png");
    private static final GreenfootImage HOVER_IMAGE = new GreenfootImage("smallerReplaybutton.png");
    
    /**
     * Constructor - Sets default replay button image.
     */
    public ReplayButton()
    {
        setImage(NORMAL_IMAGE);
    }

    /** Act - Restarts the game on click and updates hover appearance; special handling on GameComplete. */
    public void act()
    {
        if (Greenfoot.mouseClicked(this) && !(getWorld() instanceof GameComplete))
        {
            if (Levels.advance == 1)
            {
                Levels.currentLevel -= 1;
            }
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
        if (getWorld() instanceof GameComplete)
        {
            Levels.currentLevel = 1;
            if (Greenfoot.mouseClicked(this))
            {
                Greenfoot.setWorld(new StartScreen());
            }
        }
    }    
}