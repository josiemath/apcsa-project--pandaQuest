/**
 * MiniGameSummary - Shows chest mini-game outcome and animate the score.
 */
import greenfoot.*;

public class MiniGameSummary extends World {

    private int amount;

    /**
     * Constructor - Displays summary and updates the saved score.
     */
    public MiniGameSummary(int amount) {
        super(500, 500, 1);
        this.amount = amount;
        setBackground("500px Mini Game Summary.png");
        PandaWorld.savedScore += amount;
        animateResult();
    }

    /**
     * Animates score change and adds navigation button.
     */
    private void animateResult() {

        int centerX = getWidth() / 2;
        int centerY = 330; // plank center

        Color bambooLight = new Color(198, 255, 148);
        Color bambooDark  = new Color(66, 99, 40);

        GreenfootImage bg;

        int steps = 20;

        for (int i = 0; i <= steps; i++) {

            int currentValue = (int)((amount / (double)steps) * i);

            setBackground("500px Mini Game Summary.png");
            bg = getBackground();

            GreenfootImage txt = new GreenfootImage("" + currentValue, 60, bambooLight, null);
            GreenfootImage shadow = new GreenfootImage("" + currentValue, 60, bambooDark, null);

            int w = txt.getWidth();
            int h = txt.getHeight();

            double bounce = Math.sin((i / (double)steps) * Math.PI) * 15;

            // shadow
            bg.drawImage(shadow,
                centerX - w/2 + 3,
                (int)(centerY - h/2 + 3 - bounce));

            // main text
            bg.drawImage(txt,
                centerX - w/2,
                (int)(centerY - h/2 - bounce));

            Greenfoot.delay(2);
        }


        HomeButton homebutton = new HomeButton();
        addObject(homebutton, getWidth()/2, 400);
    }
}
