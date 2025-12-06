/**
 * StartScreen - Main menu screen with options to start game, open shop, or view info.
 */
import greenfoot.*;

public class StartScreen extends World
{
    // Background music for the start screen
    public static GreenfootSound startMusic = 
        new GreenfootSound("Map (Night) - Tomodachi Life OST.mp3");

    /**
     * Constructor - Sets up start screen dimensions, music volume, and UI.
     */
    public StartScreen()
    {    
        // Create a new world with 500x500 cells and a cell size of 1x1 pixels.
        super(500, 500, 1); 
        // The size should match the size of your PandaWorld for a smooth transition.

        startMusic.setVolume(70); // 0–100, adjust if too loud/quiet
        prepare();
    }

    /**
     * started - Play looping menu music when start screen activates.
     */
    public void started()
    {
        startMusic.playLoop();
    }

    /**
     * stopped - Stop menu music when leaving start screen.
     */
    public void stopped()
    {
        startMusic.stop();
    }

    /**
     * prepare - Adds Start, Shop and Information buttons to the start screen.
     */
    private void prepare()
    {
        // Add the Start Button to the center of the screen
        StartButton startButton = new StartButton();
        addObject(startButton, getWidth()/2, 300); 
        ShopButton shopButton = new ShopButton();
        addObject(shopButton, getWidth()/2, 75);
        InformationButton informationButton = new InformationButton();
        addObject(informationButton, getWidth()/2-200, 450);
    }
}
