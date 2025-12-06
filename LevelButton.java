/**
 * LevelButton - Button to start the main game; changes style on hover.
 */
import greenfoot.*;

public class LevelButton extends Actor
{
    private static final GreenfootImage NORMAL_IMAGE = new GreenfootImage("levelButton_normal.png");
    private static final GreenfootImage HOVER_IMAGE = new GreenfootImage("levelButton_faded.png");
    
    /**
     * Constructor - Sets default image for level button.
     */
    public LevelButton()
    {
        setImage(NORMAL_IMAGE);
    }

    /**
     * Act - Starts game world on click, and updates button image on hover.
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