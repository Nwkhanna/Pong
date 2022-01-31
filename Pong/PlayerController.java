import java.awt.event.KeyEvent;

public class PlayerController {
    public Rect rect;
    public KeyList keyListener;

    public PlayerController(Rect rect, KeyList keyListener){
        this.rect = rect;
        this.keyListener = keyListener;
    }
    public PlayerController(Rect rect){
        this.rect = rect;
        this.keyListener = null;
    }
    public void update(double deltaTime){
        if(keyListener != null){
            if(keyListener.iskeyPressed(KeyEvent.VK_S)){
                moveDown(deltaTime);
            }
            else if(keyListener.iskeyPressed(KeyEvent.VK_W)){
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
