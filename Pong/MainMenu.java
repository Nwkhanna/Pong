import java.awt.*;
import java.io.Console;
import java.util.*;
import javax.swing.*;
import java.awt.event.KeyEvent; 

public class MainMenu extends JFrame implements Runnable{
    Graphics2D graphics2d;
    KeyList keyListener = new KeyList();
    public ML mouseListener = new ML();
    Text startGame, exitGame, pong;
    public boolean isRunning = true;

    public MainMenu(){
        this.setSize(Constants.ScrWidth, Constants.ScrHeight);
        this.setTitle("PONG");
        this.setResizable(false);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.addKeyListener(keyListener);
        this.addMouseListener(mouseListener);
        this.addMouseMotionListener(mouseListener);
        this.startGame = new Text("Start Game", new Font("Times New Roman", Font.BOLD, 40), Constants.ScrWidth/2.0 - 140.0, Constants.ScrHeight/2.0, Color.WHITE);
        this.exitGame = new Text("Exit", new Font("Times New Roman", Font.BOLD, 40), Constants.ScrWidth/2.0 - 80.0, Constants.ScrHeight/2.0 + 60, Color.WHITE);
        this.pong = new Text("PONG", new Font("Times New Roman", Font.BOLD, 100), Constants.ScrWidth/2.0 - 180.0, 200, Color.WHITE);
        graphics2d = (Graphics2D)getGraphics();
    }
    public void update(double deltaTime){
      Image dbImage = createImage(getWidth(), getHeight());
      Graphics dbg = dbImage.getGraphics();
      this.draw(dbg); 
      graphics2d.drawImage(dbImage, 0, 0, this);
      if(mouseListener.getMouseX() > startGame.x && mouseListener.getMouseX() < startGame.x + startGame.width &&
        mouseListener.getMouseY() > startGame.y - startGame.height/2 && mouseListener.getMouseY() < startGame.y + startGame.height/2){
            startGame.color = new Color(150,150,150);
            if (mouseListener.isMousePressed()){
                Pong.changeState(1);
            }
        }
        else {
            startGame.color = Color.WHITE;
        }
        if(mouseListener.getMouseX() > exitGame.x && mouseListener.getMouseX() < exitGame.x + exitGame.width &&
        mouseListener.getMouseY() > exitGame.y - exitGame.height/2 && mouseListener.getMouseY() < exitGame.y + exitGame.height/2){
            exitGame.color = new Color(150,150,150);
            if (mouseListener.isMousePressed()){
                Pong.changeState(2);
            }
        }
        else {
            exitGame.color = Color.WHITE;
        }
    }
    public void draw(Graphics g){
      Graphics2D graphics2d = (Graphics2D)g;
      graphics2d.setColor(Color.BLACK);
      graphics2d.fillRect(0, 0, Constants.ScrWidth, Constants.ScrHeight);

      startGame.draw(graphics2d);
      exitGame.draw(graphics2d);
      pong.draw(graphics2d);
    }
    public void stop(){
        isRunning = false;
    }
    public void run(){
      double lastFrameTime = 0.0;
      while(isRunning){    
        double time = Time.getTime();
        double deltaTime = time - lastFrameTime;
        lastFrameTime = time;
        update(deltaTime);
      }  
      this.dispose();
      return;
    }
}

