package Lab.GUIProject.src.hust.soict.hedspi.swing;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.Container;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;

public class SwingAccumulator extends JFrame {
    private JTextField tfInput;
    private JTextField tfOutput;
    private int sum = 0; //Accumulated sum, init to 0

    //Constructor to setup the GUI components and event handlers
    public SwingAccumulator(){
        Container cp = getContentPane();
        cp.setLayout(new GridLayout(2, 2)); //2r and 2c

        cp.add(new JLabel("Ho Tuan Huy 20225856 - Enter an integer: "));

        tfInput = new JTextField(10); //10 cols
        cp.add(tfInput);
        tfInput.addActionListener(new TFInputListener());

        cp.add(new JLabel("Ho Tuan Huy 20225856 - The accumulated sum is: "));

        tfOutput = new JTextField(10); //10 cols
        tfOutput.setEditable(false);
        cp.add(tfOutput);

        setTitle("Ho Tuan Huy 20225856 - Swing accumulator");
        setSize(350, 120); //w and h
        setVisible(true);
    }

    public static void main(String[] args){
        new SwingAccumulator();
    }

    private class TFInputListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent evt){
            int numberIn = Integer.parseInt(tfInput.getText());
            sum += numberIn;
            tfInput.setText("");
            tfOutput.setText(sum + "");
        }
    }
    
}
