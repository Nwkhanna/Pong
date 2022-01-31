import java.awt.*;
import java.io.Console;
import java.util.*;
import javax.swing.*;
import java.awt.event.KeyEvent; 

public class GPanel extends JFrame implements Runnable{
    Graphics2D graphics2d;
    KeyList keyListener = new KeyList();
    Rect player1;
    Rect player2;
    Rect ballObj;
    PlayerController playerController;
    Player2Controller player2Controller;
    Ball ball;
    Text player1Score;
    Text player2Score;
    public boolean isRunning = true;
    public GPanel(){
        this.setSize(Constants.ScrWidth, Constants.ScrHeight);
        this.setTitle("PONG");
        this.setResizable(false);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.addKeyListener(keyListener);
        graphics2d = (Graphics2D)this.getGraphics();
        player1Score = new Text(0, new Font("Times New Roman", Font.BOLD, Constants.textSize),Constants.textXPos, Constants.textYPos);
        player2Score = new Text(0, new Font("Times New Roman", Font.BOLD, Constants.textSize),Constants.ScrWidth - Constants.textXPos - Constants.textSize, Constants.textYPos);
        player1 = new Rect(Constants.horPadWidth, 40, Constants.PadWidth, Constants.PadHeight, Color.WHITE);
        playerController = new PlayerController(player1, keyListener);
        player2 = new Rect(Constants.ScrWidth - Constants.horPadWidth - Constants.PadWidth, 40, Constants.PadWidth, Constants.PadHeight, Color.WHITE);
        ballObj = new Rect(Constants.ScrWidth/2,Constants.ScrHeight/2, Constants.ballWidth, Constants.ballWidth, Color.WHITE);
        ball = new Ball(ballObj, player1, player2, player1Score, player2Score);
        player2Controller = new Player2Controller(player2, keyListener);
        Constants.toolbarHeight = this.getInsets().top;
        Constants.bottomInset = this.getInsets().bottom;

    }
    public void update(double deltaTime){
      Image dbImage = createImage(getWidth(), getHeight());
      Graphics dbg = dbImage.getGraphics();
      this.draw(dbg); 
      graphics2d.drawImage(dbImage, 0, 0, this);
      playerController.update(deltaTime);
     
      player2Controller.update(deltaTime);
      ball.update(deltaTime);
      player1Score.draw(graphics2d);
      player2Score.draw(graphics2d);
      
    }
    public void draw(Graphics g){
      Graphics2D graphics2d = (Graphics2D)g;
      graphics2d.setColor(Color.BLACK);
      graphics2d.fillRect(0, 0, Constants.ScrWidth, Constants.ScrHeight);
      player1Score.draw(graphics2d);
      player2Score.draw(graphics2d);
      player1.draw(graphics2d);
      player2.draw(graphics2d);
      ballObj.draw(graphics2d);

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
