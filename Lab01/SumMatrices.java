package Lab01;

import java.util.Scanner; //nhap lop Scanner tu thu vien java.util => nhan du lieu dau vao tu nguoi dung thong qua keyboard

public class SumMatrices {
    public static void main(String[] args){
        Scanner keyboard = new Scanner(System.in); //tao doi tuong Scanner va gan bien keyboard, su dung System.in de nhan du lieu tu user

        int rows = keyboard.nextInt(); //nhap so luong hang
        int cols = keyboard.nextInt(); //nhap so luong cot

        int matrix1[][] = new int[rows][cols]; //khai bao ma tran thu 1
        int matrix2[][] = new int[rows][cols]; //khai bao ma tran thu 2
        int matrixSum[][] = new int[rows][cols]; //khai bao ma tran tong

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                matrix1[i][j] = keyboard.nextInt(); //nhap phan tu cho ma tran thu 1
            }
        }

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                matrix2[i][j] = keyboard.nextInt(); //nhap phan tu cho ma tran thu 2
            }
        }

        //tinh ma tran tong:
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                matrixSum[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }

        //in ra ma tran tong:
        System.out.println("Sum: ");
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                System.out.print(matrixSum[i][j] + " ");
            }
            System.out.println();
        }
    }
}
