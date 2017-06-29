package view;

import control.ListController;
import model.List;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by tkasi on 29.06.2017.
 */
public class ListView extends JFrame {
    private JTextPane everythingPane;
    private JTextArea listArea;
    private JPanel mainPanel;
    private JButton nextButton;
    private JButton appendButton;
    private JButton removeButton;
    private JButton insertButton;
    private JTextField intField;
    private JTextArea currentArea;
    private ListController controller;

    public ListView(ListController controller) {
        this.controller = controller;
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.setBounds(100,100,1000,500);
        this.setVisible(true);
        listener();

    }

    private void listener(){
        List<Integer> list = controller.getList();
        appendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int newInt = Integer.parseInt(intField.getText());
                    List<Integer> list = controller.getList();
                    list.append(newInt);
                    listArea.append(String.valueOf(intField.getText()));
                    everythingPane.setText("Neue Zahlen die hinzugefügt werden, werden (in diesem Fall) hinten drangehängt.");
                }catch(NumberFormatException exception){
                    intField.setText("Bitte eine Zahl eingeben");
                }
            }
        });
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!list.hasAccess()){
                    list.toFirst();
                }else{
                    list.next();
                }
                currentArea.setText("Zeiger bei: " + String.valueOf(list.getContent()));
            }
        });
        insertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(list.hasAccess()){
                    try {
                        int newInt = Integer.parseInt(intField.getText());
                        list.insert(newInt);
                        listArea.insert(String.valueOf(intField.getText()), getPositionOfCurrent(list) - 1);
                        everythingPane.setText("Neue Zahlen die hinzugefügt werden, werden, in diesem Fall, vor dem markierten Objekt hinzugefügt.");
                    }catch(NumberFormatException exception){
                        intField.setText("Bitte eine Zahl eingeben");
                    }
                }
            }
        });
        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(list.hasAccess()){
                    list.remove();
                    intField.remove(getPositionOfCurrent(list));
                }
            }
        });
    }

    private int getPositionOfCurrent(List<Integer> list){
        int position = 0;
        int current = list.getContent();
        list.toFirst();
        while(list.hasAccess() && list.getContent() != current){
            list.next();
            position++;
        }
        return position;
    }
}
