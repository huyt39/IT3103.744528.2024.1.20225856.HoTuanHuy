package HuyHT_DeXX_20241_20225856;

import java.util.Scanner;

public class Main {
   public static void main(String[] args) {
        DistrictManagement city = new DistrictManagement();
        Scanner scanner = new Scanner(System.in);

        city.addPerson_20225856(new Citizen_20225856("Nguyễn Bùi Tuấn Linh", 20, "Hai Ba Trung, Hanoi", "Fullstack Developer"));
        city.addPerson_20225856(new Officer_20225856("Phạm Quốc Cường", 20, "Hoang Mai, Hanoi", "IT Engineer"));
        city.addPerson_20225856(new Citizen_20225856("Nguyễn Khánh Toàn", 20, "Hoang Mai, Hanoi", "Data Scientist"));
        city.addPerson_20225856(new Officer_20225856("Hà Trung Chiến", 20, "Hai Ba Trung, Hanoi", "Backend Developer"));
        city.addPerson_20225856(new Citizen_20225856("Hồ Tuấn Huy", 20, "Hai Ba Trung, Hanoi", "AI Engineer"));
        while (true) {
            System.out.println("\nQuản lý Nhân khẩu - 20225856 - Hồ Tuấn Huy - kỳ 2024.1 - Ngày 11:");
            System.out.println("1. Thêm nhân khẩu (ít nhất 5 nhân khẩu (gồm công chức và dân thường))");
            System.out.println("2. Hiển thị danh sách tất cả các nhân khẩu");
            System.out.println("3. Tìm kiếm và hiển thị thông tin nhân khẩu theo tên được nhập từ bàn phím");
            System.out.println("4. Thoát - Hồ Tuấn Huy - 744528");
            System.out.print("Nhập lựa chọn của bạn: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 :
                    System.out.println("Nhập dữ liệu - Hồ Tuấn Huy - 20225856");
                    System.out.println("a) Thêm Nhân khẩu_Citizen_20225856");
                    System.out.println("b) Thêm Nhân khẩu_Officer_20225856");
                    System.out.printf("Lựa chọn của bạn: ");
                    String inputChoice = scanner.nextLine();
                    if(inputChoice.compareTo("a") == 0){
                        System.out.println("Hồ Tuấn Huy - 20225856");
                        System.out.print("Họ và tên_20225856: ");
                        String name = scanner.nextLine();
                        System.out.print("Tuổi_20225856: ");
                        int age = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Địa chỉ_20225856: ");
                        String address = scanner.nextLine();
                        System.out.print("Nghề nghiệp_20225856: ");
                        String job = scanner.nextLine();
                        city.addPerson_20225856(new Citizen_20225856(name, age, address, job));
                    } else if (inputChoice.compareTo("b") == 0) {
                        System.out.println("Hồ Tuấn Huy - 20225856");
                        System.out.print("Họ tên_20225856: ");
                        String name = scanner.nextLine();
                        System.out.print("Tuổi_20225856: ");
                        int age = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Địa chỉ_20225856: ");
                        String address = scanner.nextLine();
                        System.out.print("Phòng ban công tác_20225856: ");
                        String department = scanner.nextLine();
                        city.addPerson_20225856(new Officer_20225856(name, age, address, department));
                    }
                    break;
                case 2:
                    System.out.println("Hien thi thong tin - Hồ Tuấn Huy - 20225856");
                    city.displayAll_20225856();
                    break;
                case 3:
                    System.out.println("Tìm kiếm - Hồ Tuấn Huy - 20225856");
                    System.out.print("Nhập tên nhân khẩu_20225856 cần tìm: ");
                    String name = scanner.nextLine();
                    city.searchByName_20225856(name);
                    break;
                case 4:
                    System.out.println("Thoát khỏi chương trình - Hồ Tuấn Huy - 744528");
                    scanner.close();
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }
}
