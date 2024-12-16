import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RotatingLine extends JPanel implements ActionListener {
    public RotatingLine() {
        Timer tm = new Timer(50, this);
        tm.start();
    }

    double angle, angle2 = 0;
    int lineLength = 100;
    int[] xcord = {50, 350};
    int[] ycord = {150, 150};
    int pointX = xcord[0];
    int pointY = ycord[0];
    int centerX = pointX;
    int centerY = pointY;
    boolean zn = true;

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawLine(xcord[0], ycord[0], xcord[1], ycord[1]);

        double progress = angle / (2 * Math.PI);
        pointX = xcord[0] + (int) ((xcord[1] - xcord[0]) * progress);
        pointY = ycord[0] + (int) ((ycord[1] - ycord[0]) * progress);

        centerX = pointX;
        centerY = pointY;

        int x2 = (int) (centerX + lineLength * Math.cos(angle2));
        int y2 = (int) (centerY + lineLength * Math.sin(angle2));
        g.drawLine(centerX, centerY, x2, y2);

        g.setColor(Color.RED);
        g.fillOval(centerX - 3, centerY - 3, 6, 6);
        g.setColor(Color.BLACK);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        angle2 += 0.1;
        if (zn) {
            if (angle < Math.PI * 2) {
                angle += 0.1;
            }
            else {
                zn = false;
            }
        }
        else {
            if (angle > 0) {
            angle -= 0.1;
            }
            else {
                zn = true;
            }
        }
        repaint();
    }
}
