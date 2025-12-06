/**
 * FinalScoreLabel - Displays the player's final score after completing the game.
 */
import greenfoot.*;

public class FinalScoreLabel extends Actor
{
    /**
     * Constructor - Initializes score label graphic for final score.
     */
    public FinalScoreLabel()
    {
        GreenfootImage img = new GreenfootImage("Final Score: " + PandaWorld.savedScore, 30, Color.WHITE, null); // null for transparent background
        img.setFont(new Font("Comic Sans MS", 30));
        setImage(img);
        
    }
    
    /**
     * Act - Removes the label object if any click is detected.
     */
    public void act()
    {
        if (Greenfoot.mouseClicked(null))
        {
            World world = getWorld();
            world.removeObject(this);
        }
    }
}
