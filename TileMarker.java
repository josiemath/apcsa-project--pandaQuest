/**
 * TileMarker - Visual marker for a revealed tile showing adjacent bamboo count.
 */
import greenfoot.*;

/**
 * Displays the number of adjacent bamboo shoots for a revealed tile.
 */
public class TileMarker extends Actor
{
    private int adjacentCount;
    
    /**
     * Constructor - Creates a marker showing the given adjacent bamboo count.
     */
    public TileMarker(int count)
    {
        this.adjacentCount = count;
        updateImage();
        getFlag();
    }
    
    /**
     * updateImage - Renders the tile marker graphic based on adjacentCount.
     */
    private void updateImage()
    {
        GreenfootImage img = new GreenfootImage(50, 50);
        
        if (adjacentCount > 0) {
            img.setColor(Color.WHITE);
            img.fillRect(0, 0, 50, 50);
            img.setColor(Color.BLACK);
            img.drawRect(0, 0, 49, 49);
            
            Font font = new Font("Arial", true, false, 24);
            img.setFont(font);
            img.drawString(String.valueOf(adjacentCount), 18, 35);
        }
        else {
            // Empty tile
            img.setColor(new Color(200, 200, 200));
            img.fillRect(0, 0, 50, 50);
            img.setColor(Color.GRAY);
            img.drawRect(0, 0, 49, 49);
        }
        
        setImage(img);
    }
    
    /**
     * Act - TileMarker has no per-frame behavior.
     */
    public void act()
    {
    }
    
    /**
     * getFlag - Simple demo: toggles marker color if Enter key pressed.
     */
    public void getFlag()
    {
        if (Greenfoot.isKeyDown("enter"))
        {
            GreenfootImage img = new GreenfootImage(50,50);
            img.setColor(new Color(219,101,101));
            img.fillRect(0, 0, 50, 50);
            img.setColor(Color.GRAY);
            img.drawRect(0, 0, 49, 49);
            setImage(img);

        }
    }
}

