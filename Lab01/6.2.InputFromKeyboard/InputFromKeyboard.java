
import java.util.Scanner; //nhap lop Scanner tu thu vien java.util => nhan du lieu dau vao tu nguoi dung thong qua keyboard
public class InputFromKeyboard {
    public static void main(String[] args){
        Scanner keyboard = new Scanner(System.in); //tao doi tuong Scanner va gan bien keyboard, su dung System.in de nhan du lieu tu user

        System.out.println("What's your name?");
        String strName = keyboard.nextLine(); //nhap ten
        System.out.println("How old are you?");
        int iAge = keyboard.nextInt(); //nhap tuoi
        System.out.println("How tasll are you (cm)?");
        double dHeight = keyboard.nextDouble(); //nhap chieu cao

        //similar to other data types:
        //nextByte(), nextShort(), nextLong(), nextFloat(), nextBoolean()

        System.out.println("Mr. " + strName + ", " + iAge + " years old. " + "Your height is " + dHeight + ".");
        keyboard.close();

    }

}
