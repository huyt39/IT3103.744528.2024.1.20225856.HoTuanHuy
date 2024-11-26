package Lab.OtherProjects.hust.soict.hedspi.Lab01.TheVeryFirstJavaPrograms;

import javax.swing.JOptionPane;
public class Equation {
    public static void main(String[] args){
        //Giai phuong trinh bac nhat:
        String strA, strB;
        strA = JOptionPane.showInputDialog(null,
                    "Please input a: ", "Input a", //Hien thi hop thoai de input a
                                JOptionPane.INFORMATION_MESSAGE);
        strB = JOptionPane.showInputDialog(null,
                    "Please input b: ", "Input b", //Hien thi hop thoai de input b
                                JOptionPane.INFORMATION_MESSAGE);
        double x; //nghiem phuong trinh
        double a = Double.parseDouble(strA); //chuyen a tu string sang double
        double b = Double.parseDouble(strB); //chuyen b tu string sang double
        if (a == 0 && b!= 0){
            System.out.println("Phuong trinh vo nghiem");
        }
        else if(a == 0 && b == 0){
            System.out.println("Phuong trinh vo so nghiem");
        }
        else{
            x = -b/a;
            System.out.println("Phuong trinh co nghiem duy nhat: " + (x));
        }
        ptbac2();
        hePt();
    }

    public static void ptbac2(){
        String strA1, strB1, strC1;
    strA1 = JOptionPane.showInputDialog(null,
                    "Please input a1: ", "Input a1", //Hien thi hop thoai de input a1
                                JOptionPane.INFORMATION_MESSAGE);
    strB1 = JOptionPane.showInputDialog(null,
                    "Please input b1: ", "Input b1", //Hien thi hop thoai de input b1
                                JOptionPane.INFORMATION_MESSAGE);
    strC1 = JOptionPane.showInputDialog(null,
                    "Please input c1: ", "Input c1", //Hien thi hop thoai de input b1
                                JOptionPane.INFORMATION_MESSAGE);
    double a1 = Double.parseDouble(strA1); //chuyen a1 tu string thanh double
    double b1 = Double.parseDouble(strB1); //chuyen b1 tu string thanh double
    double c1 = Double.parseDouble(strC1); //chuyen c1 tu string thanh double
    double X, x1, x2, delta;
    delta = b1*b1 - 4*a1*c1;

    if (a1 == 0){
        if (b1 == 0 && c1 == 0){
            System.out.println("Phuong trinh vo so nghiem");
        }
        else if (b1 == 0 && c1 != 0){
            System.out.println("Phuong trinh vo nghiem");
        }
        else{
            X = -c1/b1;
            System.out.println("Phuong trinh la phuong trinh bac nhat co nghiem: " + (X));
        }
    }
    else{
        if(delta < 0){
            System.out.println("Phuong trinh bac 2 vo nghiem");
        }
        else if(delta == 0){
            X = -b1/(2*a1);
            System.out.println("Phuong trinh bac 2 co nghiem kep: " + (X));
        }
        else{
            x1 = (-b1 + Math.sqrt(delta))/(2*a1);
            x2 = (-b1 - Math.sqrt(delta))/(2*a1);
            System.out.println("Phuong trinh bac 2 co 2 nghiem: " + x1 + " and " + x2);
        }
    }
}
public static void hePt(){
    String strA11, strA12, strA21, strA22, str1, str2;
    strA11 = JOptionPane.showInputDialog(null,
                    "Please input a11: ", "Input a11", //Hien thi hop thoai de input a11
                                JOptionPane.INFORMATION_MESSAGE);
    strA12 = JOptionPane.showInputDialog(null,
                    "Please input a12: ", "Input a12", //Hien thi hop thoai de input a12
                                JOptionPane.INFORMATION_MESSAGE);
    strA21 = JOptionPane.showInputDialog(null,
                    "Please input a21: ", "Input a21", //Hien thi hop thoai de input a21
                                JOptionPane.INFORMATION_MESSAGE);
    strA22 = JOptionPane.showInputDialog(null,
                    "Please input a22: ", "Input a22", //Hien thi hop thoai de input a22
                                JOptionPane.INFORMATION_MESSAGE);
    str1 = JOptionPane.showInputDialog(null,
                    "Please input result 1: ", "Input result 1", //Hien thi hop thoai de input result 1
                                JOptionPane.INFORMATION_MESSAGE);
    str2 = JOptionPane.showInputDialog(null,
                    "Please input result 2: ", "Input result 2", //Hien thi hop thoai de input result 2
                                JOptionPane.INFORMATION_MESSAGE);
    double a11 = Double.parseDouble(strA11);
    double a12 = Double.parseDouble(strA12);
    double a21 = Double.parseDouble(strA21);
    double a22 = Double.parseDouble(strA22);
    double s1 = Double.parseDouble(str1);
    double s2 = Double.parseDouble(str2);
    double D = a11*a22 - a12*a21;
    double x, y;
    if (D == 0 && s1*a22 - s2*a12 != 0){
        System.out.println("He phuong trinh vo nghiem");
    }
    else if (D == 0 && s1*a22 - s2*a12 == 0){
        System.out.println("He phuong trinh vo so nghiem");
    }
    else if (D != 0){
        x = (s1*a22 - s2*a12)/D;
        y = (a11*s2 - a21*s1)/D;
        System.out.println("He co nghiem duy nhat: " + x + " and " + y);
    }
}
}

