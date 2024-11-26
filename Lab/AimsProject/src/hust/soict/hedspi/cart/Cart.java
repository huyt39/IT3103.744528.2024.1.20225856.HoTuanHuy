package Lab.AimsProject.src.hust.soict.hedspi.cart;
import java.util.ArrayList;
public class Cart {
    // Hằng số cho số lượng DVD tối đa có thể đặt trong giỏ hàng
    public static final int MAX_NUMBERS_ORDERED = 20;
    // Mảng lưu trữ các đối tượng DVD
    private ArrayList<DigitalVideoDisc> items = new ArrayList<>();
    // Biến đếm số lượng DVD đã được đặt trong giỏ hàng
    private int qtyOrdered = 0;

    // Phương thức thêm DVD vào giỏ hàng
    public void addDigitalVideoDisc(DigitalVideoDisc disc) {
        if (qtyOrdered < MAX_NUMBERS_ORDERED) {
            items.add(disc);
            qtyOrdered++;
            System.out.println("The disc has been added.");
        } else {
            System.out.println("The cart is full.");
        }
    }

    //Cho phep them danh sach cac doi tuong DigitalVideoDisc vao gio hang
    public void addDigitalVideoDisc(DigitalVideoDisc[] dvdList){
        for(DigitalVideoDisc dvd: dvdList){
            this.addDigitalVideoDisc(dvd);
        }
    }

    public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
        if (qtyOrdered + 2 > MAX_NUMBERS_ORDERED) {
            System.out.println("The cart is full.");
            return;
        }
    
        items.add(dvd1);
        qtyOrdered++;
        System.out.println("The disc has been added to the cart.");
    
        items.add(dvd2);
        qtyOrdered++;
        System.out.println("The disc has been added to the cart.");
    }
    

    // Phương thức xóa DVD khỏi giỏ hàng
    public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
            if (items.remove(disc)) {
                qtyOrdered--;
                System.out.println("The disc has been removed.");
            }
            else{
                System.out.println("The disc is not found.");
            }
        }
    

    // Phương thức tính tổng chi phí của tất cả các DVD trong giỏ hàng
    public float totalCost() {
        float total = 0;
        for(DigitalVideoDisc disc : items){
            total+=disc.getCost();
        }    
        return total;
    }
    public void print(){
        System.out.println("***********************CART***********************");
        System.out.println("Ho Tuan Huy - 20225856: Ordered Items:");

        for (int i = 0; i < qtyOrdered; i++){
            System.out.println(items.get(i).toString());
        }

        System.out.println("Ho Tuan Huy - 20225856: Total cost: " + totalCost());
        System.out.println("**************************************************");
    }
    

    //search by Id
    public DigitalVideoDisc searchById(int id) {
        return items.stream()
                .filter(disc -> disc.getId() == id)
                .findFirst()
                .orElse(null);
    }
    
    // search by title
    public DigitalVideoDisc searchByTitle(String title) {
        return items.stream()
                .filter(disc -> disc.isMatch(title))
                .findFirst()
                .orElse(null);
    }

}
