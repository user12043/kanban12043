package ogr.user12043.kanbanBoard;

import javax.swing.*;

/**
 * Created by ME99735 on 04.07.2018 - 16:51
 * Part of project: kanbanboard
 */
public class MainPane {
    private JLabel jlabel_windowTitle;
    private JButton testButton;
    private JPanel jPanel_main;

    public void display(String[] args) {
        createUIComponents();
        JFrame frame = new JFrame("MainPane");
        frame.setContentPane(new MainPane().jPanel_main);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
