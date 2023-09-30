
import java.awt.Dialog;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;

public class DemoModality {

    public void start() {
        final JFrame parent = new JFrame("Parent Frame");
        parent.setLayout(new FlowLayout());
        parent.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        parent.setBounds(100, 100, 300, 200);
        parent.add(new JButton("Button"));

        parent.setVisible(true);

        JDialog dialog1 = new JDialog(parent, "Modeless Dialog");
        dialog1.setBounds(200, 200, 300, 200);
        dialog1.setVisible(true);

        JDialog dialog2 = new JDialog(parent, "Document-Modal Dialog",
                Dialog.ModalityType.DOCUMENT_MODAL);
        dialog2.setBounds(300, 300, 300, 200);
        dialog2.setVisible(true);
    }

    public static void main(String[] args) {
        DemoModality demo = new DemoModality();
        demo.start();
    }
}
