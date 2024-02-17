import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import static com.sun.java.accessibility.util.AWTEventMonitor.addKeyListener;

class JKeyPressExample implements KeyListener {

    public void keyTyped(KeyEvent e) {
// Обработка события нажатия клавиши
        if (e.getKeyChar()==KeyEvent.VK_F2)
        System.out.println("Key typed");
    }
    public void keyPressed(KeyEvent e) {
// Обработка события удерживания клавиши
        System.out.println("Key pressed");
    }
    public void keyReleased(KeyEvent e) {
// Обработка события отпускания клавиши
        System.out.println("Key released");
    }

}

public static void main(String[] args) {

}