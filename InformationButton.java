/**
 * InformationButton - Button that opens the information screen; changes appearance on hover.
 */
import greenfoot.*;

public class InformationButton extends Actor
{
    private static final GreenfootImage NORMAL_IMAGE = new GreenfootImage("informationButton.png");
    private static final GreenfootImage HOVER_IMAGE = new GreenfootImage("informationButton.png");
    
    /**
     * Constructor - Sets default image for information button.
     */
    public InformationButton()
    {
        setImage(NORMAL_IMAGE);
    }

    /**
     * Act - Opens info screen on click, switches appearance on hover.
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
