/**
 * rightArrowButton - Navigates to the next information page and toggles hover image.
 */
import greenfoot.*;

public class rightArrowButton extends Actor
{
    private static final GreenfootImage NORMAL_IMAGE = new GreenfootImage("rightArrow.png"); //
    private static final GreenfootImage HOVER_IMAGE = new GreenfootImage("rightArrow.png"); //
    
    /**
     * Constructor - Sets default right arrow image.
     */
    public rightArrowButton()
    {
        setImage(NORMAL_IMAGE);
    }

    /**
     * Act - Switches to Information2 screen on click and updates hover state.
     */
    public void act()
    {
        if (Greenfoot.mouseClicked(this))
        {
            Greenfoot.setWorld(new Information2());
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
