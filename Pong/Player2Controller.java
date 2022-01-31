import java.awt.event.KeyEvent;

public class Player2Controller {
    public Rect rect;
    public KeyList keyListener;

    public Player2Controller(Rect rect, KeyList keyListener){
        this.rect = rect;
        this.keyListener = keyListener;
    }
    public Player2Controller(Rect rect){
        this.rect = rect;
        this.keyListener = null;
    }
    public void update(double deltaTime){
        if(keyListener != null){
            if(keyListener.iskeyPressed(KeyEvent.VK_DOWN)){
                moveDown(deltaTime);
            }
            else if(keyListener.iskeyPressed(KeyEvent.VK_UP)){
                moveUp(deltaTime);
            }
        }
       
    }
    public void moveUp(double deltaTime){
        if(rect.y - Constants.paddleSpeed * deltaTime > Constants.toolbarHeight)
            this.rect.y = (Double)(this.rect.y - Constants.paddleSpeed*deltaTime);
    }
    public void moveDown(double deltaTime){
        if((rect.y + Constants.paddleSpeed  * deltaTime) + Constants.PadHeight < Constants.ScrHeight - Constants.bottomInset)
            this.rect.y = (Double)(this.rect.y + Constants.paddleSpeed *deltaTime);
        
    }
}