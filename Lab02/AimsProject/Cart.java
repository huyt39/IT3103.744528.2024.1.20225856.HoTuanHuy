package Lab02.AimsProject;
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
    public void display(){
        System.out.println("Items in cart:");
        for(DigitalVideoDisc disc:items){
            System.out.println(disc.getTitle() + " | " + disc.getCategory() +" | " + disc.getDirector() + " | " + disc.getLength() + " | $" + disc.getCost());
        }
    }
}

