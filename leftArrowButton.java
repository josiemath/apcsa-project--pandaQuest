/**
 * leftArrowButton - Navigates to the previous information page and toggles hover image.
 */
import greenfoot.*;

public class leftArrowButton extends Actor
{
    private static final GreenfootImage NORMAL_IMAGE = new GreenfootImage("leftArrow.png"); //
    private static final GreenfootImage HOVER_IMAGE = new GreenfootImage("leftArrow.png"); //
    
    /**
     * Constructor - Sets default left arrow image.
     */
    public leftArrowButton()
    {
        setImage(NORMAL_IMAGE);
    }

    /**
     * Act - Switches to Information screen on click and updates hover state.
     */
    public void act()
    {
        if (Greenfoot.mouseClicked(this))
        {
            Greenfoot.setWorld(new Information());
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

