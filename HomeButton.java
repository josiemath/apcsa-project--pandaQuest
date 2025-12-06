/**
 * HomeButton - Button to navigate player to the main or replay screen based on current game state.
 */
import greenfoot.*;

public class HomeButton extends Actor
{
    private static final GreenfootImage NORMAL_IMAGE = new GreenfootImage("homeButton.png");
    private static final GreenfootImage HOVER_IMAGE = new GreenfootImage("homeButton.png");
    
    /**
     * Constructor - Sets default home button image.
     */
    public HomeButton()
    {
        setImage(NORMAL_IMAGE);
    }

    /**
     * Act - Handles screen change on click, and updates button image on hover.
     */
    public void act()
    {
        if (Greenfoot.mouseClicked(this))
        {
            if (Levels.advance == 0)
            {
                Greenfoot.setWorld(new StartScreen());
            }
            else if (Levels.advance == 1)
            {
                Greenfoot.setWorld(new AdvanceLevel());
            }
            else
            {
                Greenfoot.setWorld(new ReplayLevel());
            }
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