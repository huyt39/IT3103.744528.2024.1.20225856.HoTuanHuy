package Lab01.TheVeryFirstJavaPrograms;
// Example 3: HelloNameDialog.java
import javax.swing.JOptionPane;
public class HelloNameDialog {
    public static void main(String[] args){
        String result;
        result = JOptionPane.showInputDialog("Please enter your name:"); //Hien thi hop thoai de nhap input voi thong diep "Please enter your name"
        JOptionPane.showMessageDialog(null, "Hi " + result + "!"); //Hien thi hop thoai chua: Hi + input vua nhap + !
        System.exit(0);
    }
}
