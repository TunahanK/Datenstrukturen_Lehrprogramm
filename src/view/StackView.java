package view;

import control.StackController;
import model.Stack;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by tkasi on 29.06.2017.
 */
public class StackView extends JFrame{
    private JPanel mainPanel;
    private JTextPane everythingPane;
    private JTextArea stackArea;
    private JTextField intField;
    private JButton popButton;
    private JButton pushButton;
    private StackController controller;

    public StackView(StackController controller) {
        this.controller = controller;
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.setBounds(100,100,1000,500);
        this.setVisible(true);
        listener();
    }

    private void listener(){
        pushButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int newInt = Integer.parseInt(intField.getText());
                    Stack<Integer> stack = controller.getStack();
                    stack.push(newInt);
                    String old = stackArea.getText();
                    stackArea.setText(String.valueOf(newInt));
                    stackArea.append(old);
                    everythingPane.setText("Neue Zahlen die hinzugefügt werden landen vorne.");
                }catch(NumberFormatException exception){
                    intField.setText("Bitte eine Zahl eingeben");
                }
            }
        });
        popButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                stackArea.setText("");
                everythingPane.setText("\"Pop\" entfernt das vorderste Objekt auf dem Stapel");
                Stack<Integer> stack = controller.getStack();
                stack.pop();
                Stack<Integer> temp = new Stack<>();
                while(!stack.isEmpty()){
                    stackArea.append(String.valueOf(stack.top()));
                    temp.push(stack.top());
                    stack. pop();
                }
                while(!temp.isEmpty()){
                    stack.push(temp.top());
                    temp.pop();
                }
            }
        });
    }
}
