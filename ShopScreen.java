/**
 * ShopScreen - Presents purchasable panda skins and navigation for the shop.
 */
import greenfoot.*;

public class ShopScreen extends World
{
    // Background music for the start screen
    private GreenfootSound startMusic = 
        new GreenfootSound("Map (Night) - Tomodachi Life OST.mp3");

    /**
     * Constructor - Initializes shop world, music and UI.
     */
    public ShopScreen()
    {    
        // Create a new world with 500x500 cells and a cell size of 1x1 pixels.
        super(500, 500, 1); 
        // The size should match the size of your PandaWorld for a smooth transition.

        startMusic.setVolume(70); // 0–100, adjust if too loud/quiet
        prepare();
    }

    /**
     * started - Play looping music when shop becomes active.
     */
    public void started()
    {
        startMusic.playLoop();
    }

    /**
     * stopped - Stop music when leaving the shop.
     */
    public void stopped()
    {
        startMusic.stop();
    }

    /**
     * prepare - Adds navigation and panda skin options to the shop UI.
     */
    private void prepare()
    {
        // Add the Start Button to the center of the screen
        HomeButton homeButton = new HomeButton();
        addObject(homeButton, getWidth()/2, 75);
        RedPanda redPanda = new RedPanda();
        addObject(redPanda, getWidth()/2-150, 300);
        OrangePanda orangePanda = new OrangePanda();
        addObject(orangePanda, getWidth()/2-50, 300);
        YellowPanda yellowPanda = new YellowPanda();
        addObject(yellowPanda, getWidth()/2+50, 300);
        GreenPanda greenPanda = new GreenPanda();
        addObject(greenPanda, getWidth()/2+150, 300);
        BluePanda bluePanda = new BluePanda();
        addObject(bluePanda, getWidth()/2-150, 400);
        PurplePanda purplePanda = new PurplePanda();
        addObject(purplePanda, getWidth()/2-50, 400);
        BrownPanda brownPanda = new BrownPanda();
        addObject(brownPanda, getWidth()/2+50, 400);
        BlackPanda blackPanda = new BlackPanda();
        addObject(blackPanda, getWidth()/2+150, 400);
    }
}