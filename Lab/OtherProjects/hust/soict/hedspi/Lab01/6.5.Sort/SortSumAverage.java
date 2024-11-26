package Lab01;
import java.util.Arrays;
import java.util.Scanner;
public class SortSumAverage {
    public static void main(String[] args){
        Scanner keyboard = new Scanner(System.in); //tao doi tuong Scanner va gan bien keyboard, su dung System.in de nhan du lieu tu user

        int sum = 0;
        double average = 0;

        int n = keyboard.nextInt(); //nhap so luong phan tu cua mang
        int[] num = new int[n]; //khoi tao mang voi so luong phan tu da nhap vao
        //nhap tung phan tu cua mang:
        for(int i = 0; i < n; i++){
            num[i] = keyboard.nextInt();
            sum += num[i]; //sum
        }
        Arrays.sort(num); //sap xep mang
        System.out.println("Sorted array: " + Arrays.toString(num)); //in mang sap xep
        double reSum = sum; //chuyen sum sang double 
        average = reSum/n;

        System.out.println("Tong: " + sum + ", " + "Gia tri trung binh: " + average);

    }
}
