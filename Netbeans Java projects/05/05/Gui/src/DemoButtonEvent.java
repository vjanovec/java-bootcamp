
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class DemoButtonEvent {

    public void demo(JComponent component) {
        JFrame frame = new JFrame("PJV - GUI button click demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setMinimumSize(new Dimension(320, 240));
        Container pane = frame.getContentPane();
        pane.setLayout(new BoxLayout(pane, BoxLayout.PAGE_AXIS));

        JButton printButton = new JButton("Print");
        printButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("User click to print");
            }
        });

        JButton exitButton = new JButton("Quit");
        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("User click to exit");
                System.exit(0);
            }
        });

        printButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        exitButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        pane.add(component);
        pane.add(printButton);
        pane.add(exitButton);

        component.setAlignmentX(Component.CENTER_ALIGNMENT);

        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        DemoButtonEvent gui = new DemoButtonEvent();
        gui.demo(new JLabel("Demo button click"));
    }
}
