import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel label1 = new JLabel("Первая метка");
        JLabel label2 = new JLabel("Вторая метка");
        JLabel label3 = new JLabel("Третья метка");
        JButton button = new JButton("Кнопка");

        label1.setAlignmentX(Component.CENTER_ALIGNMENT);
        label2.setAlignmentX(Component.CENTER_ALIGNMENT);
        label3.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.setAlignmentX(Component.CENTER_ALIGNMENT);

        panel.add(label1);
        panel.add(label2);
        panel.add(label3);
        panel.add(button);

        frame.add(panel);
        frame.pack();
        frame.setLocation(500, 200);
        frame.setVisible(true);
    }
}