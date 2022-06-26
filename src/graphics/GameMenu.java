package graphics;

import entities.states.InGameState;
import main.Game;

import java.awt.*;

public class GameMenu {

    public String[] options = new String[]{"Novo Jogo", "Carregar Jogo",
            "Sair"};

    public int currentOption = 0;
    public int maxOption = options.length - 1;
    public boolean up, down, enter;

    public int w = (Game.WIDTH * Game.SCALE);
    public int h = (Game.HEIGHT * Game.SCALE);

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


    public void render(Graphics graphics) {
        Font font = new Font("Arial", Font.BOLD, 40);
        Font font1 = new Font("TimesRoman", Font.PLAIN, 30);
        Font font2 = new Font("TimesRoman", Font.BOLD, 30);

        graphics.setFont(font);
        graphics.setColor(Color.LIGHT_GRAY);

        drawCenteredString("JOGO DE NAVINHA", w,
                h / 2 - 50,
                graphics);

        graphics.setFont(font1);
        graphics.setColor(Color.WHITE);

        int aux = h / 2 + 100;
        for (String option : options) {
            drawCenteredString(option, w, aux,
                    graphics);
            aux += 100;
        }

        if (currentOption == 0) {
            graphics.setColor(Color.RED);
            drawCenteredString(options[0], w, h / 2 + 100,
                    graphics);
        } else if (currentOption == 1) {
            graphics.setColor(Color.RED);
            drawCenteredString(options[1], w, h / 2 + 200,
                    graphics);
        } else if (currentOption == 2) {
            graphics.setColor(Color.RED);
            drawCenteredString(options[2], w, h / 2 + 300,
                    graphics);
        }
    }

    public void drawCenteredString(String s, int w, int h, Graphics g) {
        FontMetrics fm = g.getFontMetrics();
        int x = (w - fm.stringWidth(s)) / 2;
        int y = (fm.getAscent() + (h - (fm.getAscent() + fm.getDescent())) / 2);
        g.drawString(s, x, y);
    }
}
