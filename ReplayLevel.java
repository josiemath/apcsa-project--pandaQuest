/**
 * ReplayLevel - Screen shown when player can replay a level; includes navigation and music.
 */
import greenfoot.*;

public class ReplayLevel extends World
{
    // Background music for the start screen
    private GreenfootSound startMusic = 
        new GreenfootSound("Map (Night) - Tomodachi Life OST.mp3");

    /** Constructor - Initializes replay screen and UI. */
    public ReplayLevel()
    {    
        // Create a new world with 500x500 cells and a cell size of 1x1 pixels.
        super(500, 500, 1); 
        // The size should match the size of your PandaWorld for a smooth transition.

        startMusic.setVolume(70); // 0–100, adjust if too loud/quiet
        prepare();
    }

    /** started - Play looping music when this world becomes active. */
    public void started()
    {
        startMusic.playLoop();
    }
    
    /** stopped - Stop music when leaving this world. */
    public void stopped()
    {
        startMusic.stop();
    }

    /** prepare - Adds UI elements (replay, shop, info) to the screen. */
    private void prepare()
    {
        // Add the Start Button to the center of the screen
        ReplayButton replayButton = new ReplayButton();
        addObject(replayButton, getWidth()/2, 300);
        ShopButton shopButton = new ShopButton();
        addObject(shopButton, getWidth()/2, 75);
        InformationButton informationButton = new InformationButton();
        addObject(informationButton, getWidth()/2-200, 450);
    }
}

