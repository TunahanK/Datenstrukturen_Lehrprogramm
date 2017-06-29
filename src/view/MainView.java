package view;

import control.ArrayController;
import control.ListController;
import control.QueueController;
import control.StackController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by tkasi on 29.06.2017.
 */
public class MainView extends JFrame{
    private JPanel mainPanel;
    private JTextArea welcomeSign;
    private JButton arrayButton;
    private JButton queueButton;
    private JButton stackButton;
    private JButton listButton;
    private JButton treeButton;
    private JButton graphButton;
    private JLabel chooseText;

    public MainView(){
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.pack();
        this.setVisible(true);
        createButtonListener();

    }

    private void createButtonListener(){
        arrayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayView arrayView = new ArrayView(new ArrayController());
            }
        });
        queueButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                QueueView queueView = new QueueView(new QueueController());
            }
        });
        stackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StackView stackview = new StackView(new StackController());
            }
        });
        listButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ListView listview = new ListView(new ListController());
            }
        });
        treeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        graphButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
}
