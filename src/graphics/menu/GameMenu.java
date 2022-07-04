package graphics.menu;

import main.Game;

import java.awt.*;

public abstract class GameMenu {

    public GameMenu(String[] options) {
        this.options = options;
    }

    public String[] options;

    public int currentOption = 0;

    public int maxOption;
    public boolean up, down, enter;

    public int w = (Game.WIDTH * Game.SCALE);
    public int h = (Game.HEIGHT * Game.SCALE);
    int optionsHeight = h / 2 + 100;

    Font mainFont = new Font("Arial", Font.BOLD, 40);
    Font optionsFont = new Font("TimesRoman", Font.PLAIN, 30);

    public void tick() {
        if (up) {
            up = false;
            currentOption--;
            if (currentOption < 0) currentOption = maxOption;
        }

        if (down) {
            down = false;
            currentOption++;
            if (currentOption > maxOption) currentOption = 0;
        }
    }


    public abstract void render(Graphics graphics);


    public void drawCenteredString(String s, int w, int h, Graphics g) {
        FontMetrics fm = g.getFontMetrics();
        int x = (w - fm.stringWidth(s)) / 2;
        int y = (fm.getAscent() + (h - (fm.getAscent() + fm.getDescent())) / 2);
        g.drawString(s, x, y);
    }

    public void drawOptions(Graphics graphics) {
        graphics.setFont(optionsFont);
        graphics.setColor(Color.WHITE);

        int aux = optionsHeight;
        for (String option : options) {
            drawCenteredString(option, w, aux,
                    graphics);
            aux += 100;
        }

        graphics.setColor(Color.RED);
        drawCenteredString(options[currentOption], w,
                optionsHeight + (currentOption * 100),
                graphics);
    }
}
