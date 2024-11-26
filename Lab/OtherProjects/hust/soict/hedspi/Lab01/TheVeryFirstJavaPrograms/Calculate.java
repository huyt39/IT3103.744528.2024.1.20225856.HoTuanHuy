package Lab.OtherProjects.hust.soict.hedspi.Lab01.TheVeryFirstJavaPrograms;

import javax.swing.JOptionPane;
public class Calculate {
    public static void main(String[] args){
        String strNum1, strNum2;
        
        strNum1 = JOptionPane.showInputDialog(null,
                    "Please input the first number: ", "Input the first number", //Hien thi hop thoai de input so thu nhat
                                JOptionPane.INFORMATION_MESSAGE);
        strNum2 = JOptionPane.showInputDialog(null,
                    "Please input the second number: ", "Input the first number", //Hien thi hop thoai de input so 2
                                JOptionPane.INFORMATION_MESSAGE);
        double num1 = Double.parseDouble(strNum1); //chuyen so thu nhat tu dang string sang double
        double num2 = Double.parseDouble(strNum2); //chuyen so thu 2 tu dang string sang double

        System.out.println("Sum: " + (num1 + num2)); //in ra tong 2 so
        System.out.println("Difference: " + (num1 - num2)); //in ra hieu 2 so
        System.out.println("Product: " + (num1 * num2)); //in ra tich 2 so
        System.out.println("Quotient: " + (num1/num2)); //in ra thuong 2 so

    }

}
