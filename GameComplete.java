/**
 * GameComplete - Shows the victory screen with score and replay option.
 */
import greenfoot.*;

public class GameComplete extends World
{

    /**
     * Constructor - Initializes the win screen and plays victory music.
     */
    public GameComplete()
    {    
        super(500, 500, 1);
        addObject(new FinalScoreLabel(), getWidth()/2, 139);
        Greenfoot.playSound("victoryMusic.mp3");
        addObject(new ReplayButton(), getWidth()/2, 212);
        setPaintOrder(ReplayButton.class, FinalScoreLabel.class);
    }
    
}
