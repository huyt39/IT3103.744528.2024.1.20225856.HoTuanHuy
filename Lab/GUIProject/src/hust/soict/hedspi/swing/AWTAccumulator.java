package Lab.GUIProject.src.hust.soict.hedspi.swing;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class AWTAccumulator extends Frame {
    private TextField tfInput;
    private TextField tfOutput;
    private int sum = 0; //Accumulated sum, init to 0

    //Constructor to setup the GUI components and event handlers
    public AWTAccumulator(){
        setLayout(new GridLayout(2, 2)); //2 rows and 2 cols
        
        add(new Label("Ho Tuan Huy 20225856 - Enter an integer: "));

        tfInput = new TextField(10); //10 cols
        add(tfInput);
        tfInput.addActionListener(new TFInputListener());

        add(new Label("Ho Tuan Huy 20225856 - The accumulated sum is: "));

        tfOutput = new TextField(10);
        tfOutput.setEditable(false);
        add(tfOutput);

        setTitle("Ho Tuan Huy 20225856 - AWT Accumulator");
        setSize(350, 120); //w and h
        setVisible(true);
    }

    public static void main(String[] args){
        new AWTAccumulator();
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
