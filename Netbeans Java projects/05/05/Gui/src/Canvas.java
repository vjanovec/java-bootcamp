
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import javax.swing.JFrame;

public class Canvas extends JFrame {

    public Canvas() {
        setTitle("PJV Demo Canvas");
        setSize(640, 480);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.RED);

        g2d.fillOval(110, 210, 30, 30);
        g2d.drawOval(360, 320, 30, 30);

        g2d.setColor(Color.BLUE);
        g2d.fillRect(150, 50, 30, 30);

        g2d.setColor(Color.BLACK);
        g2d.drawRect(450, 150, 30, 30);

        g2d.drawPolygon(
                new int[]{200, 250, 300, 290, 180},
                new int[]{150, 200, 180, 210, 240},
                5);

        g2d.draw(new Ellipse2D.Double(320, 240, 30, 30));
    }

}
