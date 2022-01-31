import java.awt.Graphics2D;
import java.awt.Color;

public class Ball{
  public Rect rect;
  public Rect player1, player2;
  private double vy = 10.0;
  private double vx = -200.0;
  Text player1Score;
  Text player2Score;
  public Ball(Rect rect, Rect player1, Rect player2, Text player1Score, Text player2Score){
      this.rect = rect;
      this.player1 = player1;
      this.player2 = player2;
      this.player1Score = player1Score;
      this.player2Score = player2Score;
  }

  public double calcVelocityAngle(Rect paddle){
      double relativeIntersectionY = (paddle.y + (paddle.height/2.0)) - (this.rect.y + (this.rect.height/2.0));
      double normalIntersectionY = relativeIntersectionY/(paddle.height/2.0);
      double theta = normalIntersectionY * Constants.maxAngle;

      return Math.toRadians(theta);
  }
  public void update(double dt){
      if (vx < 0){
        if(this.rect.x + (vx * dt) < player1.x + player1.width){
            if(this.rect.y + (vx * dt) > player1.y && 
                this.rect.y + (vx * dt) + this.rect.height < player1.y + player1.height   
            ){
                double theta = calcVelocityAngle(player1);
                double newVx = Math.abs((Math.cos(theta)) * Constants.ballSpeed);
                double newVy = (-Math.sin(theta)) * Constants.ballSpeed;
                double oldSign = Math.signum(vx);
                this.vx = newVx * (-1.0 * oldSign);
                this.vy = newVy;
            }
        }
      }
      else if(vx >= 0){
        if(this.rect.x + (vx *dt) + rect.width > player2.x){
          if(this.rect.y + (vy * dt) > player2.y &&
          this.rect.y  + (vy * dt) + this.rect.height < player2.y + player2.height){
            double theta = calcVelocityAngle(player2);
            double newVx = Math.abs((Math.cos(theta)) * Constants.ballSpeed);
            double newVy = (-Math.sin(theta)) * Constants.ballSpeed;
            double oldSign = Math.signum(vx);
            this.vx = newVx * (-1.0 * oldSign);
            this.vy = newVy;
          }
        }
      }
      if(vy >= 0){
          if(this.rect.y + (vy * dt) + this.rect.height > Constants.ScrHeight - Constants.bottomInset){
              this.vy *= -1;
          }
      }else if(vy < 0){
          if(this.rect.y + (vy * dt) < Constants.toolbarHeight){
              this.vy *= -1;
          }
      }
      //Below was created using physics formulae. 
      this.rect.x += vx*dt;
      this.rect.y += vy*dt;

      if(this.rect.x + this.rect.width < player1.x){
        int player2IntScore = Integer.parseInt(player2Score.text);
        player2IntScore++;
        player2Score.text = "" + player2IntScore; 
        this.rect.x = Constants.ScrWidth/2.0;
        this.rect.y = Constants.ScrHeight/2.0;
        this.vx = -150.0;
        this.vy = 50.0;
        if(player2IntScore > Constants.winScore){
            Pong.changeState(0);
        }
      }
      else if(this.rect.x > player2.x + player2.width){
        int player1IntScore = Integer.parseInt(player1Score.text);
        player1IntScore++;
        player1Score.text = "" + player1IntScore; 
        this.rect.x = Constants.ScrWidth/2.0;
        this.rect.y = Constants.ScrHeight/2.0;
        this.vx = 150.0;
        this.vy = -50.0;
        if(player1IntScore >= Constants.winScore){
            Pong.changeState(0);
        }
      }
  }
}