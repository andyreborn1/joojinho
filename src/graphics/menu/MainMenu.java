package graphics.menu;

import java.awt.*;

public class MainMenu extends GameMenu {
    public MainMenu() {
        super(new String[]{"Novo Jogo", "Continuar", "Créditos", "Sair"});
        maxOption = options.length - 1;
    }

    @Override
    public void render(Graphics graphics) {
        graphics.setFont(mainFont);
        graphics.setColor(Color.LIGHT_GRAY);

        drawCenteredString("JOGO DE NAVINHA", w,
                h / 2 - 50,
                graphics);

        drawOptions(graphics);
    }
}
