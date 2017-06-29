package view;

import control.ArrayController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by tkasi on 29.06.2017.
 */
public class ArrayView extends JFrame{
    private ArrayController controller;
    private JPanel mainPanel;
    private JTextPane everythingPane;
    private JComboBox arrayLength;
    private JLabel lengthLabel;
    private JButton createArrayButton;
    private JTextArea arrayArea;

    public ArrayView(ArrayController controller){
        this.controller = controller;
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.setBounds(100,100,1000,500);
        this.setVisible(true);
        listener();
    }

    private void listener() {
        createArrayButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                arrayArea.setText("");
                everythingPane.setText("Ein Array mit der länge " + String.valueOf(arrayLength.getSelectedItem()) + " wurde erstellt und mit zufälligen Zahlen gefüllt. \nJede Stelle ist mit einem Index definiert, welche von 0 aufsteigt und problemlos mit dieser aufgegriffen werden kann. \n" +
                        "Die länge eines Arrays kann nicht geändert werden. Man füllt ein Array indem man mit dem Arrayname den jeweiligen Index aufruft und mit dem auf ein Objekt zeigt, welches dann im Array an dieser Stelle ist." +
                        " \nSinvoll sind Arrays (abstrahiert), wenn man zum Beispiel Regale simulieren möchte bzw. ansich nur eine gewisse Menge Speicher braucht");
                controller.setArrayLength(Integer.parseInt(String.valueOf(arrayLength.getSelectedItem())));
                controller.fillRandom();
                int[] array = controller.getArray();
                for (int i = 0; i < array.length; i++) {
                    arrayArea.append(String.valueOf(i) + "   ");
                    arrayArea.append(String.valueOf(array[i]) + "         ");
                }
            }
        });
    }
}
