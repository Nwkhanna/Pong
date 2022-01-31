import java.awt.Graphics2D;
import java.awt.Color;

public class Paddle2{
    public int x, y, width, height;
    public Color color;
    public Paddle2(int x, int y, int width, int height, Color color){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
    }
    public void draw(Graphics2D graphics){
        graphics.setColor(color);
        graphics.fillRect(x, y, width, height);
    }
}