package ui;

import javax.swing.*;
import java.awt.*;

public class Renderer extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Gui.gui.repaint(g);
    }
}
