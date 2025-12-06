/**
 * Information2 - Displays additional info page with navigation and music controls.
 */
import greenfoot.*;

public class Information2 extends World
{
     // Background music for the information screen
    private GreenfootSound startMusic = 
        new GreenfootSound("Map (Night) - Tomodachi Life OST.mp3");

    /**
     * Constructor - Initializes additional info screen.
     */
    public Information2()
    {    
        // Create a new world with 500x500 cells and a cell size of 1x1 pixels.
        super(500, 500, 1); 

        startMusic.setVolume(70); // 0–100, adjust if too loud/quiet
        prepare();
    }

    /**
     * Called when this info page is activated; plays music.
     */
    public void started()
    {
        startMusic.playLoop();
    }

    /**
     * Called when leaving this info page; stops music.
     */
    public void stopped()
    {
        startMusic.stop();
    }

    /**
     * Adds navigation buttons to this info page.
     */
    private void prepare()
    {
        // Add the Start Button to the center of the screen
        HomeButton homeButton = new HomeButton();
        addObject(homeButton, getWidth()/2, 450);
        leftArrowButton lA = new leftArrowButton();
        addObject(lA, getWidth()/2, 50);
    }
}
