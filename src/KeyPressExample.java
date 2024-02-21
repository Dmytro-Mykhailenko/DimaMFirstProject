import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

class JKeyPressExample implements KeyListener {

    int h;

    void JKeyPressExample(){

    }

    public void keyTyped(KeyEvent e) {
// Обработка события нажатия клавиши
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



public static void main() throws IOException {

    JKeyPressExample j=new JKeyPressExample();
    j.h=System.in.read();

    }
}