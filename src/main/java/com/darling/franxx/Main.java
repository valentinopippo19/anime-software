package com.darling.franxx;

import com.darling.franxx.ui.FranxxFrame;
import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            FranxxFrame frame = new FranxxFrame();
            frame.setVisible(true);
        });
    }
}
