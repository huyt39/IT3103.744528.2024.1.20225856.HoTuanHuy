package Lab01;

import java.util.Scanner; //nhap lop Scanner tu thu vien java.util => nhan du lieu dau vao tu nguoi dung thong qua keyboard
public class DaysOfAMonth {
    public static void main(String[] args){
        Scanner keyboard = new Scanner(System.in); //tao doi tuong Scanner va gan bien keyboard, su dung System.in de nhan du lieu tu user
        System.out.println("Enter a year: ");
        int year = keyboard.nextInt(); //Nhap nam
        keyboard.nextLine(); //Bo qua dong trong sau khi nhap so nguyen
        System.out.println("Enter a month: ");
        String month = keyboard.nextLine(); //Nhap thang
        String Month = month.toLowerCase(); //Chuyen thang sang ky tu thuong

        int days = monthYear(Month, year); //Goi phuong thuc va truyen bien

        System.out.println("Days of month " + Month + " is " + days);

        }

    //Kiem tra ngay:
    public static int monthYear(String Month, int year){
        switch(Month){
            case "january":
            case "jan.":
            case "jan":
            case "1":
                return 31;
            case "february":
            case "feb.":
            case "feb":
            case "2":
                if((year % 4 == 0 && year % 100 != 0) || year % 400 == 0){
                    return 29;
                }
                else{
                    return 28;
                }
            case "march":
            case "mar.":
            case "mar":
            case "3":
                return 31;
            case "april":
            case "apr.":
            case "apr":
            case "4":
                return 30;
            case "may":
            case "5":
                return 31;
            case "june":
            case "jun":
            case "6":
                return 30;
            case "july":
            case "jul":
            case "7":
                return 31;
            case "august":
            case "aug.":
            case "aug":
            case "8":
                return 31;
            case "september":
            case "sept.":
            case "sep":
            case "9":
                return 30;
            case "october":
            case "oct.":
            case "oct":
            case "10":
                return 31;
            case "november":
            case "nov.":
            case "nov":
            case "11":
                return 30;
            case "december":
            case "dec.":
            case "dec":
            case "12":
                return 31;
            default:
                return -1;

        }
    }
    }


