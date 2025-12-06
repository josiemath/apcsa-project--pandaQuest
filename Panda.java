/**
 * Panda - Main player actor; handles movement, color, and tile interaction.
 */
import greenfoot.*;

public class Panda extends Actor
{
    private int moveDelay;
    private static final int MOVE_SPEED = 10;
    
    /**
     * Constructor - Initializes panda and movement delay.
     */
    public Panda()
    {
        moveDelay = 0;
    }
    
    /**
     * Act - Handles movement and tile interaction per tick.
     */
    public void act()
    {
        if (moveDelay > 0) {
            moveDelay--;
            return;
        }
        
        handleMovement();
        handleAction();
    }
    
    /**
     * setColor - Changes the panda skin color.
     */
    public void setColor(int i)
    {
        if (i==0)
        {
            setImage("redPanda.png");
        }
        else if (i==1)
        {
            setImage("orangePanda.PNG");
        }
        else if (i==2)
        {
            setImage("yellowPanda.PNG");
        }
        else if (i==3)
        {
            setImage("greenPanda.PNG");
        }
        else if (i==4)
        {
            setImage("bluePanda.PNG");
        }
        else if (i==5)
        {
            setImage("purplePanda.PNG");
        }
        else if (i==6)
        {
            setImage("brownPanda.PNG");
        }
        else if (i==7)
        {
            setImage("Panda.png");
        }
    }
    
    /**
     * Handles player movement using arrow keys.
     */
    private void handleMovement()
    {
        int dx = 0;
        int dy = 0;
        
        if (Greenfoot.isKeyDown("up")) {
            dy = -1;
        }
        else if (Greenfoot.isKeyDown("down")) {
            dy = 1;
        }
        else if (Greenfoot.isKeyDown("left")) {
            dx = -1;
        }
        else if (Greenfoot.isKeyDown("right")) {
            dx = 1;
        }
        
        if (dx != 0 || dy != 0) {
            int newX = getX() + dx;
            int newY = getY() + dy;
            
            PandaWorld world = (PandaWorld) getWorld();
            if (world != null && newX >= 0 && newX < world.getWidth() && 
                newY >= 0 && newY < world.getHeight()) {
                setLocation(newX, newY);
                moveDelay = MOVE_SPEED;
            }
        }
    }
    
    /**
     * Handles revealing tiles, flagging tiles, and removing flags.
     */
    private void handleAction()
    {
        if (Greenfoot.isKeyDown("space")) {
            PandaWorld world = (PandaWorld) getWorld();
            if (world != null) {
                int x = getX();
                int y = getY();
                
                if (!world.isRevealed(x, y)) {
                    boolean hitBamboo = world.revealTile(x, y);
                    
                    if (!hitBamboo) {
                        int adjacent = world.getAdjacentBambooCount(x, y);
                        if (adjacent > 0) {
                        }
                    }
                }
            }
            moveDelay = MOVE_SPEED;
        }
        String key = Greenfoot.getKey();
        if ("a".equals(key)) {
            PandaWorld world = (PandaWorld) getWorld();
            if (world != null) {
                int x = getX();
                int y = getY();
                if (!world.isRevealed(x, y)) {
                    world.addFlag(x, y);
                }
            }
        }
        if ("b".equals(key)) {
            PandaWorld world = (PandaWorld) getWorld();
            if (world != null) {
                int x = getX();
                int y = getY();
                if (!world.isRevealed(x, y)) {
                    world.removeFlag(x, y);
                }
            }
        }
        }
    }
