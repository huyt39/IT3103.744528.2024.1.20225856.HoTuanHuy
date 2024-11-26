package Lab.OtherProjects.hust.soict.hedspi.Lab01.TheVeryFirstJavaPrograms;
// Example 5: ShowTwoNumbers.java
import javax.swing.JOptionPane;
public class ShowTwoNumbers {
    public static void main(String[] args) {
        String strNum1, strNum2;
        String strNotification = "You've just entered: ";

        strNum1 = JOptionPane.showInputDialog(null,
                    "Please input the first number: ", "Input the first number", //Hien thi hop thoai de input so thu nhat
                                JOptionPane.INFORMATION_MESSAGE);
        strNotification += strNum1 + " and ";
        strNum2 = JOptionPane.showInputDialog(null,
                    "Please input the second number: ", "Input the second number", //Hien thi hop thoai de input so thu 2
                                JOptionPane.INFORMATION_MESSAGE);
        strNotification += strNum2;

        JOptionPane.showMessageDialog(null, strNotification,
                                        "Show two numbers", JOptionPane.INFORMATION_MESSAGE); //Hien thi hop thoai hien thi ra 2 so vua nhap
        
        System.exit(0);
    }
}
