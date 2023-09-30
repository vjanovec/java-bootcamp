
import javax.swing.JOptionPane;

public class DemoDialog {

    public void messageDialog() {
        JOptionPane.showMessageDialog(null, "PJV is great!");
    }

    public void confirmDialog() {
        int response = JOptionPane.showConfirmDialog(null, "PJV is great! Isn't it?");
        System.out.println("User response: " + response);
    }

    public void entryDialog() {
        String str = JOptionPane.showInputDialog(null, "Entry your opinion");
        System.out.println("User input: " + str);
    }

    public void userEntry() {
        int response = JOptionPane.showConfirmDialog(null, "PJV is great! Isn't it?");
        switch (response) {
            case 0:
                JOptionPane.showMessageDialog(null, "You are right!", "Confirm", JOptionPane.PLAIN_MESSAGE);
                break;
            case 1:
                JOptionPane.showMessageDialog(null, "You are wrong!", "Error", JOptionPane.ERROR_MESSAGE);
                break;
            case 2:
                JOptionPane.showMessageDialog(null, "You should know!", "Warn", JOptionPane.WARNING_MESSAGE);
                break;
        }
    }

    public static void main(String[] args) {
        DemoDialog demo = new DemoDialog();
        //demo.messageDialog();
        //demo.confirmDialog();
        //demo.entryDialog();
        demo.userEntry();
    }

}
