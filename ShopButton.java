/**
 * ShopButton - Opens the in-game shop screen; updates appearance on hover.
 */
import greenfoot.*;

public class ShopButton extends Actor
{
    private static final GreenfootImage NORMAL_IMAGE = new GreenfootImage("shopButton.png");
    private static final GreenfootImage HOVER_IMAGE = new GreenfootImage("shopButton.png");
    
    /**
     * Constructor - Sets default shop button image.
     */
    public ShopButton()
    {
        setImage(NORMAL_IMAGE);
    }

    /**
     * Act - Switches to ShopScreen on click and toggles hover image.
     */
    public void act()
    {
        if (Greenfoot.mouseClicked(this))
        {
            Greenfoot.setWorld(new ShopScreen());
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