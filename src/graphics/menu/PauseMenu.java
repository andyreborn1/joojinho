package graphics.menu;

import java.awt.*;

public class PauseMenu extends GameMenu {
    public PauseMenu() {
        super(new String[]{"Continuar", "Salvar", "Sair"});
        maxOption = options.length - 1;
    }

    @Override
    public void render(Graphics graphics) {
        graphics.setFont(mainFont);
        graphics.setColor(Color.LIGHT_GRAY);

        drawCenteredString("Jogo Pausado", w,
                h / 2 - 50,
                graphics);

        drawOptions(graphics);
    }
}
