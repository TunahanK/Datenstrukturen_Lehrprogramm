package view;

import control.QueueController;
import model.Queue;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by tkasi on 29.06.2017.
 */
public class QueueView extends JFrame {
    private JPanel mainPanel;
    private JButton enqueueButton;
    private JButton dequeueButton;
    private JTextField intField;
    private JTextArea queueArea;
    private JTextPane everythingPane;
    private QueueController controller;

    public QueueView(QueueController controller){
        this.controller = controller;
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.setBounds(100,100,1000,500);
        this.setVisible(true);
        listener();
    }

    private void listener(){
        enqueueButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int newInt = Integer.parseInt(intField.getText());
                    Queue<Integer> queue = controller.getQueue();
                    queue.enqueue(newInt);
                    queueArea.append(String.valueOf(intField.getText()));
                    everythingPane.setText("Neue Zahlen die hinzugefügt werden, werden hinten drangehängt");
                }catch(NumberFormatException exception){
                    intField.setText("Bitte eine Zahl eingeben");
                }
            }
        });
        dequeueButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                queueArea.setText("");
                everythingPane.setText("Beim dequeuen wird das vorderste Objekt entfernt");
                Queue<Integer> queue = controller.getQueue();
                queue.dequeue();
                Queue<Integer> temp = new Queue<>();
                while(!queue.isEmpty()){
                    queueArea.append(String.valueOf(queue.front()));
                    temp.enqueue(queue.front());
                    queue.dequeue();
                }
                queue = temp;
            }
        });
    }
}
