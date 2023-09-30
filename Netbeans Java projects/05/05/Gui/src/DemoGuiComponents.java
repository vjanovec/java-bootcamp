
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.ListSelectionModel;

public class DemoGuiComponents {

    public void demo() {
        JFrame frame = new JFrame("HelloWorldSwing"); // titulek

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel label = new JLabel("Hello World");
        frame.getContentPane().add(label, BorderLayout.NORTH);

        frame.pack();  //nastavi velikost okna pro zobrazeni komponent
        frame.setVisible(true); //zobrazi okno
    }

    public void demoButtons() {
        JFrame frame = new JFrame("PJV - GUI demo - Buttons");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setMinimumSize(new Dimension(320, 240));
        Container pane = frame.getContentPane();
        pane.setLayout(new GridLayout(4, 3));

        //row #1
        pane.add(new JPanel());
        pane.add(new JButton("JButton"));
        pane.add(new JPanel());

        //row #2
        pane.add(new JPanel());
        pane.add(new JToggleButton("JToggleButton"));
        pane.add(new JPanel());

        //row #3
        pane.add(new JPanel());
        pane.add(new JCheckBox("JCheckBox"));
        pane.add(new JPanel());

        //row #4
        JRadioButton[] radioButtons = new JRadioButton[]{
            new JRadioButton("Radio1"),
            new JRadioButton("Radio3"),
            new JRadioButton("Radio2")};
        ButtonGroup group = new ButtonGroup();
        for (JRadioButton btn : radioButtons) {
            group.add(btn);
            pane.add(btn);
        }
        frame.setVisible(true);
    }

    public void demoList() {
        JFrame frame = new JFrame("PJV - GUI demo - List");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setMinimumSize(new Dimension(320, 240));
        Container pane = frame.getContentPane();
        pane.setLayout(new GridLayout(4, 3));

        for (int i = 0; i < 4; ++i) {
            pane.add(new JPanel());
        }
        ArrayList<String> lst = new ArrayList();
        for (int i = 0; i < 10; ++i) {
            lst.add("Item - " + i);
        }

        JList list = new JList(lst.toArray());
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list.setLayoutOrientation(JList.VERTICAL);
        list.setSelectedIndex(5);
        JScrollPane listScroller = new JScrollPane(list);
        listScroller.setPreferredSize(new Dimension(250, 80));
        pane.add(listScroller);
        for (int i = 0; i < 4; ++i) {
            pane.add(new JPanel());
        }
        frame.setVisible(true);
    }

    public void demoComboBox() {
        JFrame frame = new JFrame("PJV - GUI demo - ComboBox");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setMinimumSize(new Dimension(320, 240));
        Container pane = frame.getContentPane();
        pane.setLayout(new GridLayout(4, 3));

        for (int i = 0; i < 4; ++i) {
            pane.add(new JPanel());
        }
        ArrayList<String> lst = new ArrayList();
        for (int i = 0; i < 10; ++i) {
            lst.add("Item - " + i);
        }
        JComboBox list = new JComboBox(lst.toArray());
        list.setSelectedIndex(5);
        pane.add(list);
        for (int i = 0; i < 4; ++i) {
            pane.add(new JPanel());
        }
        frame.setVisible(true);
    }

    public void demoTextField() {
        JFrame frame = new JFrame("PJV - GUI demo - TextField");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setMinimumSize(new Dimension(320, 240));
        Container pane = frame.getContentPane();
        pane.setLayout(new GridLayout(5, 3));

        for (int i = 0; i < 4; ++i) {
            pane.add(new JPanel());
        }
        JTextField txt1 = new JTextField("Text field #1");

        pane.add(txt1);
        pane.add(new JPanel());

        pane.add(new JPanel());
        JTextField txt2 = new JTextField("Text field #2");
        txt2.setEditable(false);
        pane.add(txt2);
        pane.add(new JPanel());

        pane.add(new JPanel());
        JTextArea txt3 = new JTextArea("Text area with long text");
        txt3.setLineWrap(true);
        pane.add(txt3);

        for (int i = 0; i < 4; ++i) {
            pane.add(new JPanel());
        }
        frame.setVisible(true);
    }

    public void demoMenu() {
        JFrame frame = new JFrame("PJV - GUI demo - Menu");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setMinimumSize(new Dimension(320, 240));
        Container pane = frame.getContentPane();
        pane.setLayout(new FlowLayout());

        JMenuItem menuItem;
        JRadioButtonMenuItem rbMenuItem;
        JCheckBoxMenuItem cbMenuItem;

        JMenuBar menuBar = new JMenuBar();
        JMenu menuFile = new JMenu("File");
        JMenu menuEdit = new JMenu("Edit");
        menuBar.add(menuFile);
        menuBar.add(menuEdit);

        menuFile.add(new JMenuItem("Load"));
        menuFile.add(new JMenuItem("Save"));
        menuEdit.add(new JMenuItem("Copy"));
        menuEdit.add(new JMenuItem("Paste"));

        ButtonGroup group = new ButtonGroup();
        JRadioButtonMenuItem rbMenuItem1 = new JRadioButtonMenuItem("Include comments");
        JRadioButtonMenuItem rbMenuItem2 = new JRadioButtonMenuItem("Without comments");
        rbMenuItem1.setSelected(true);
        group.add(rbMenuItem1);
        group.add(rbMenuItem2);
        menuFile.addSeparator();
        menuFile.add(rbMenuItem1);
        menuFile.add(rbMenuItem2);

        pane.add(menuBar);
        frame.setVisible(true);
    }

    public void demoSlider() {
        JFrame frame = new JFrame("PJV - GUI demo - Slider");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setMinimumSize(new Dimension(320, 240));
        Container pane = frame.getContentPane();
        pane.setLayout(new GridLayout(2, 3));

        for (int i = 0; i < 4; ++i) {
            pane.add(new JPanel());
        }
        JSlider slider = new JSlider(JSlider.HORIZONTAL, 1, 5, 1);

        slider.setMajorTickSpacing(10);
        slider.setMinorTickSpacing(2);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);

        Font font = new Font("Sans", Font.BOLD, 8);
        slider.setFont(font);

        pane.add(slider);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        DemoGuiComponents gui = new DemoGuiComponents();
        // gui.demo();
        // gui.demo(new JLabel("Label"));
        // gui.demoButtons();
        // gui.demoList();
        // gui.demoComboBox();
        // gui.demoMenu();

        //gui.demoSlider();
    }
}
