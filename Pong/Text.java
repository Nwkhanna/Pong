import java.awt.*;

public class Text {
 public String text;
 public Font font;
 public double x,y;   
 public double width, height;
 public Color color = Color.WHITE;

 public Text(String text, Font font, double x, double y, Color color){
     this.font = font;
     this.text = text;
     this.x = x;
     this.y = y;
     this.width = font.getSize() * text.length();
     this.height = font.getSize();
 }
 public Text(int text, Font font, double x, double y){
    this.font = font;
    this.text = "" + text;
    this.x = x;
    this.y = y;
}
 public void draw(Graphics2D graphics2d){
     graphics2d.setColor(color);
     graphics2d.setFont(font);
     graphics2d.drawString(text, (float)x, (float)y);
 }
}
