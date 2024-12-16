import java.awt.*;
import javax.swing.*;
public class Main {
    public static void main(String[] args) {
        JFrame fr = new JFrame("Отрезок, вращающийся в плоскости фрейма вокруг точки, движущейся по отрезку");
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.setPreferredSize(new Dimension(400, 400));
        fr.add(new RotatingLine());
        fr.pack();
        fr.setVisible(true);
    }
}