import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.geom.Rectangle2D;

public class Rect{
    public double x, y, width, height;
    public Color color;
    public Rect(double x, double y, double width, double height, Color color){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
    }
    public void draw(Graphics2D graphics2d){
        graphics2d.setColor(color);
        graphics2d.fill(new Rectangle2D.Double(x,y,width,height));
    }
}