import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
        frame.add(new JLabel("Первая метка"));
        frame.add(new JLabel("Вторая метка"));
        frame.add(new JLabel("Третья метка"));
        frame.add(new JButton("Кнопка"));
        frame.setSize(300, 200);
        frame.setLocation(500, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}