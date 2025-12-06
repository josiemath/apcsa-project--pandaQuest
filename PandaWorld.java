/**
 * PandaWorld - The main game world for PandaQuest; manages grid, tiles, actors, and game rules.
 */
import greenfoot.*;

public class PandaWorld extends World
{
    private GreenfootSound levelUpSound = new GreenfootSound("PowerUpSound.mp3"); // Sound played on level up.
    private GreenfootSound levelDownSound = new GreenfootSound("Level Down Sound Effect.mp3"); // Sound for losing life.

    private static final int CELL_SIZE = 50; // Size of each cell in pixels.
    
    // Playable grid size (derived from Levels.currentLevel).
    private static int PLAY_WIDTH = Levels.currentLevel * 2 + 7;
    private static int PLAY_HEIGHT = Levels.currentLevel * 2 + 7;

    // Frame width (in cells) around the playable board for status/HUD.
    private static int FRAME_SIZE = 1;

    // World dimensions include frame.
    private static int WORLD_WIDTH = PLAY_WIDTH + 2;
    private static int WORLD_HEIGHT = PLAY_WIDTH + 2;

    private int level = Levels.currentLevel; // Current numeric level.
    private int lives; // Player lives count.
    private int score; // Current score.
    public static int savedScore = 0; // Persisted score between screens.

    private boolean[][] bambooGrid; // Bamboo placement grid.
    private boolean[][] revealedGrid; // Revealed tiles grid.
    private boolean[][] starGrid; // Star placement grid.

    /**
     * Constructor - Creates the game world, initializes state, and sets up UI/actors.
     */
    public PandaWorld()
    {
        super(Levels.currentLevel * 2 + 9, Levels.currentLevel * 2 + 9, CELL_SIZE);
        level = Levels.currentLevel;
        lives = 3;
        score = savedScore;
        PLAY_WIDTH = Levels.currentLevel * 2 + 7;
        PLAY_HEIGHT = Levels.currentLevel * 2 + 7;
        WORLD_WIDTH = PLAY_WIDTH + 2;
        WORLD_HEIGHT = PLAY_WIDTH + 2;

        initializeGame(); // Initialize grids and place items.
        prepare(); // Add initial actors (panda, HUD).
        drawFrame(); // Draw playable area frame.
        
        // Add level intro actor for current level.
        if (level == 1)
        {
            addObject(new Level_1(), getWidth()/2, getHeight()/2);
        }
        else if (level == 2)
        {
            addObject(new Level_2(), getWidth()/2, getHeight()/2);
        }
        else if (level == 3)
        {
            addObject(new Level_3(), getWidth()/2, getHeight()/2);
        }
        else if (level == 4)
        {
            addObject(new Level_4(), getWidth()/2, getHeight()/2);
        }
        else if (level == 5)
        {
            addObject(new Level_5(), getWidth()/2, getHeight()/2);
        }

        setPaintOrder(Panda.class, Star.class, Bamboo.class, TileMarker.class); // Ensure render order (top to bottom)
    }

    /**
     * initializeGame - Allocates grids and places bamboo and stars.
     */
    private void initializeGame()
    {
        bambooGrid = new boolean[PLAY_WIDTH][PLAY_HEIGHT];
        revealedGrid = new boolean[PLAY_WIDTH][PLAY_HEIGHT];
        starGrid = new boolean[PLAY_WIDTH][PLAY_HEIGHT];

        int bambooCount = 5 + (level * 4); // Bamboo count by level.
        placeBambooRandomly(bambooCount);

        int starCount = 2 + level; // Star count by level.
        placeStarsRandomly(starCount);
    }

    /**
     * placeBambooRandomly - Randomly places specified number of bamboo tiles.
     */
    private void placeBambooRandomly(int count)
    {
        int placed = 0;
        while (placed < count) {
            int x = Greenfoot.getRandomNumber(PLAY_WIDTH);
            int y = Greenfoot.getRandomNumber(PLAY_HEIGHT);

            if (!bambooGrid[x][y]) {
                bambooGrid[x][y] = true;
                placed++;
            }
        }
    }

    /**
     * placeStarsRandomly - Randomly places stars ensuring no overlap with bamboo.
     */
    private void placeStarsRandomly(int count)
    {
        int placed = 0;
        while (placed < count) {
            int x = Greenfoot.getRandomNumber(PLAY_WIDTH);
            int y = Greenfoot.getRandomNumber(PLAY_HEIGHT);

            if (!bambooGrid[x][y] && !starGrid[x][y]) {
                starGrid[x][y] = true;
                placed++;
            }
        }
    }

    /**
     * prepare - Adds the player and draws initial HUD.
     */
    private void prepare()
    {
    Panda panda = new Panda();
    panda.setColor(Levels.color);
    addObject(panda, FRAME_SIZE, FRAME_SIZE);
    drawHUD();
    }

    /**
     * drawHUD - Renders a semi-transparent frame area used for HUD/status.
     */
    private void drawHUD()
    {
    GreenfootImage bg = getBackground();

    int cellSize       = getCellSize();
    int frameThickness = FRAME_SIZE * cellSize;
    int W = bg.getWidth();
    int H = bg.getHeight();

    // ----- 70% opacity green -----
    // Original solid color: new Color(46, 107, 51)
    // Now with alpha = 179 (70% opacity)
    Color frameGreenTransparent = new Color(46, 107, 51, 179);

    bg.setColor(frameGreenTransparent);

    // Top frame
    bg.fillRect(0, 0, W, frameThickness);

    // Bottom frame
    bg.fillRect(0, H - frameThickness, W, frameThickness);

    // Left frame
    bg.fillRect(0, 0, frameThickness, H);

    // Right frame
    bg.fillRect(W - frameThickness, 0, frameThickness, H);
    }
    
    /**
     * drawFrame - Draws a black outline around the playable grid area.
     */
    private void drawFrame()
    {
        GreenfootImage bg = getBackground();
        if (bg == null) return;

        bg.setColor(Color.BLACK);
        int left = FRAME_SIZE * CELL_SIZE;
        int top = FRAME_SIZE * CELL_SIZE;
        int width = PLAY_WIDTH * CELL_SIZE;
        int height = PLAY_HEIGHT * CELL_SIZE;

        // Draw outer rectangle around playable area
        bg.drawRect(left, top, width - 1, height - 1);

        // Optionally draw a thin inner rectangle for a clearer frame (subtle)
        bg.setColor(Color.BLACK);
        bg.drawRect(left + 2, top + 2, width - 5, height - 5);
    }

    /**
     * act - Ensures Panda stays within playable bounds each tick.
     */
    public void act()
    {
        // Clamp any Panda instances to stay within playable area
        for (Object obj : getObjects(Panda.class)) {
            Panda p = (Panda)obj;
            int px = p.getX();
            int py = p.getY();

            int minX = FRAME_SIZE;
            int minY = FRAME_SIZE;
            int maxX = FRAME_SIZE + PLAY_WIDTH - 1;
            int maxY = FRAME_SIZE + PLAY_HEIGHT - 1;

            boolean moved = false;
            int newX = px;
            int newY = py;
            if (px < minX) { newX = minX; moved = true; }
            if (py < minY) { newY = minY; moved = true; }
            if (px > maxX) { newX = maxX; moved = true; }
            if (py > maxY) { newY = maxY; moved = true; }

            if (moved) {
                p.setLocation(newX, newY);
            }
        }
    }

    /**
     * revealTile - Reveals a world tile; returns true if an instant-effect tile (bamboo/star) was hit.
     */
    public boolean revealTile(int worldX, int worldY)
    {
        int x = worldToPlayX(worldX);
        int y = worldToPlayY(worldY);

        if (x < 0 || x >= PLAY_WIDTH || y < 0 || y >= PLAY_HEIGHT) {
            return false;
        }

        if (revealedGrid[x][y]) {
            return false;
        }

        revealedGrid[x][y] = true;

        // Bamboo: lose a life
        if (bambooGrid[x][y]) {
            lives--;
            addObject(new Bamboo(), worldX, worldY); // show bamboo visually at world coords
            Greenfoot.playSound("Wood PlacingBreaking (Nr. 4  Minecraft Sound) - Sound Effect for.mp3");
            levelDownSound.play();
            updateDisplay();

            if (lives <= 0) {
                gameOver();
            }
            return true;
        }

        // Star: gain a life (opposite of bamboo).
        // This only happens when revealTile is called explicitly (e.g. press SPACE),
        // not via autoRevealAdjacent.
        if (starGrid[x][y]) {
            lives++;
            addObject(new Star(), worldX, worldY); // show star visually at world coords
            Greenfoot.playSound("StarSound.mp3");
            updateDisplay();
            return true;
        }

        // Normal safe tile path:

        // Count adjacent bamboo (playable coords)
        int adjacentBamboo = countAdjacentBamboo(x, y);

        // Add visual marker for this tile at world coords
        TileMarker marker = new TileMarker(adjacentBamboo);
        addObject(marker, worldX, worldY);

        // Auto-reveal if no adjacent bamboo
        if (adjacentBamboo == 0) {
            autoRevealAdjacent(x, y);
        }

        score += 10;
        updateDisplay();

        // Check if level is complete
        if (isLevelComplete()) {
            levelComplete();
        }

        return false;
    }

    /**
     * addFlag - Adds a flag marker at given world coordinates.
     */
    public void addFlag(int worldX, int worldY)
    {
        FlagMarker flag = new FlagMarker();
        addObject(flag, worldX, worldY);
        Greenfoot.playSound("FlagSound_.mp3");
        updateDisplay();
    }

    /**
     * removeFlag - Removes any flag markers at given world coordinates.
     */
    public void removeFlag(int worldX, int worldY)
    {
        removeObjects(getObjectsAt(worldX, worldY, FlagMarker.class));
        Greenfoot.playSound("FlagSound_.mp3");
        updateDisplay();
    }

    /**
     * countAdjacentBamboo - Counts bamboo surrounding a playable tile.
     */
    private int countAdjacentBamboo(int x, int y)
    {
        int count = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0) continue;
                int newX = x + i;
                int newY = y + j;
                if (newX >= 0 && newX < bambooGrid.length &&
                    newY >= 0 && newY < bambooGrid[0].length) {

                    if (bambooGrid[newX][newY]) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    /**
     * autoRevealAdjacent - Recursively auto-reveals adjacent safe tiles (skips stars).
     */
    private void autoRevealAdjacent(int x, int y)
    {
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0) continue;
                int newX = x + i;
                int newY = y + j;

                if (newX >= 0 && newX < PLAY_WIDTH &&
                    newY >= 0 && newY < PLAY_HEIGHT &&
                    !revealedGrid[newX][newY] &&
                    !bambooGrid[newX][newY] &&
                    !starGrid[newX][newY]) {   // <-- skip stars here

                    revealedGrid[newX][newY] = true;

                    // Add visual marker at corresponding world coords
                    int adjacentBamboo = countAdjacentBamboo(newX, newY);
                    TileMarker marker = new TileMarker(adjacentBamboo);
                    addObject(marker, playToWorldX(newX), playToWorldY(newY));

                    // Recurse if still zero
                    if (adjacentBamboo == 0) {
                        autoRevealAdjacent(newX, newY);
                    }
                }
            }
        }
    }

    /**
     * isLevelComplete - Returns true when all safe path tiles are revealed.
     */
    private boolean isLevelComplete()
    {
        for (int x = 0; x < PLAY_WIDTH; x++) {
            for (int y = 0; y < PLAY_HEIGHT; y++) {
            // Check if the tile is a safe path tile (not bamboo AND not a star)
            // AND it is not yet revealed.
                if (!bambooGrid[x][y] && !starGrid[x][y] && !revealedGrid[x][y]) {
                return false; // Found an unrevealed safe path tile
                }
            }
        }
    // All safe path tiles have been revealed.
        return true;
    }

    /**
     * levelComplete - Handles progression and transitions after finishing a level.
     */
    private void levelComplete()
{
    levelUpSound.play();
    level++;
    if (level == 6)
    {
        // Final level finished → straight to game complete screen
        Greenfoot.setWorld(new GameComplete());
    }
    else
    {
        // Level finished → bump level variables
        Levels.currentLevel += 1;
        Levels.advance = 1;

        // Now go to the minigame instead of AdvanceLevel
        Greenfoot.setWorld(new MiniGameScreen());
    }
}


    /**
     * gameOver - Handles game over transition and saves state for replay screen.
     */
    private void gameOver()
    {
        showText("Game Over! Final Score: " + score,
                 WORLD_WIDTH / 2, WORLD_HEIGHT / 2);
        Levels.advance = 2;
        Greenfoot.setWorld(new ReplayLevel());
    }

    /**
     * updateDisplay - Updates HUD text and saves the current score.
     */
    private void updateDisplay()
    {
        showText("Level: " + level + " Lives: " + lives + " Score: " + score,
                 WORLD_WIDTH / 2, 0);

        savedScore = score;
    }

    /**
     * isRevealed - Returns whether a world-position tile has been revealed.
     */
    public boolean isRevealed(int worldX, int worldY)
    {
        int x = worldToPlayX(worldX);
        int y = worldToPlayY(worldY);

        if (x < 0 || x >= PLAY_WIDTH || y < 0 || y >= PLAY_HEIGHT) {
            return false;
        }
        return revealedGrid[x][y];
    }

    /**
     * getAdjacentBambooCount - Returns adjacent bamboo count for a world-position.
     */
    public int getAdjacentBambooCount(int worldX, int worldY)
    {
        int x = worldToPlayX(worldX);
        int y = worldToPlayY(worldY);
        if (x < 0 || x >= PLAY_WIDTH || y < 0 || y >= PLAY_HEIGHT) {
            return 0;
        }
        return countAdjacentBamboo(x, y);
    }

    /**
     * Helper: convert world X coordinate to playable grid X coordinate.
     */
    private int worldToPlayX(int worldX)
    {
        return worldX - FRAME_SIZE;
    }

    /**
     * Helper: convert world Y coordinate to playable grid Y coordinate.
     */
    private int worldToPlayY(int worldY)
    {
        return worldY - FRAME_SIZE;
    }

    /**
     * Helper: convert playable X to world X.
     */
    private int playToWorldX(int playX)
    {
        return playX + FRAME_SIZE;
    }

    /**
     * Helper: convert playable Y to world Y.
     */
    private int playToWorldY(int playY)
    {
        return playY + FRAME_SIZE;
    }
}
