package Lab01;
import java.util.Scanner; //nhap lop Scanner tu thu vien java.util => nhan du lieu dau vao tu nguoi dung thong qua keyboard
public class Star {
    public static void main(String[] args){
        Scanner keyboard = new Scanner(System.in); //tao doi tuong Scanner va gan bien keyboard, su dung System.in de nhan du lieu tu user

        System.out.println("Input n: ");
        int n = keyboard.nextInt(); //nhap n
        for(int i = 0; i < n; i++){ //rows
            for(int j = 0; j < 2*n -1; j++){ //cols
                if (j >= n - 1 - i && j <= n - 1 + i){
                    System.out.print("*");
                }
                else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
