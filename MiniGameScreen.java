/**
 * MiniGameScreen - Displays the mini-game for chest selection after level completion.
 */
import greenfoot.*;

public class MiniGameScreen extends World {
    
    /**
     * Constructor - Sets up mini-game layout with chests.
     */
    public MiniGameScreen() {
        super(500, 500, 1);
        setBackground("500px MiniGameScreen.png");
        prepare();
    }

    /**
     * Adds chest objects for the mini-game.
     */
    private void prepare() {
        addObject(new Chest(), 125, 360);
        addObject(new Chest(), 250, 360);
        addObject(new Chest(), 375, 360);
    }

    /**
     * Called by Chest to reveal chest summary results.
     */
    public void revealSummary(int amount) {
        Greenfoot.setWorld(new MiniGameSummary(amount));
    }
}


