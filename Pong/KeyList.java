import java.awt.event.KeyEvent; 
import java.awt.event.KeyListener; 
public class KeyList implements KeyListener{
    private boolean keyPressed[] = new boolean[128];
    public void keyTyped(KeyEvent keyEvent){

    }
    public void keyPressed(KeyEvent keyEvent){
        keyPressed[keyEvent.getKeyCode()] = true;
    }
    public void keyReleased(KeyEvent keyEvent){
        keyPressed[keyEvent.getKeyCode()] = false;
    }
    public boolean iskeyPressed(int keyCode){
        return keyPressed[keyCode]; 
    }
}
