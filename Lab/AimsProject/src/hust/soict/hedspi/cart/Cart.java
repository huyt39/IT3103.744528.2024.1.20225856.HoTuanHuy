package Lab.AimsProject.src.hust.soict.hedspi.cart;
import Lab.AimsProject.src.hust.soict.hedspi.aims.media.Media;
import java.util.ArrayList;
import java.util.List;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;

    private List<Media> itemsOrdered = new ArrayList<>();

    public Cart() {}

    public void addMedia(Media media) {
        itemsOrdered.add(media);
        System.out.println("Ho Tuan Huy 20225856 - Added successfully");
    }

    public void removeMedia(Media media) {
        if (!itemsOrdered.remove(media)) {
            System.out.println("Ho Tuan Huy 20225856 - Not found media!");
        } else {
            System.out.println("Ho Tuan Huy 20225856 - Removed successfully");
        }
    }

    public double totalCost() {
        return itemsOrdered.stream()
                .mapToDouble(Media::getCost)
                .sum();
    }

    public void printCart() {
        System.out.println("********************CART********************");
        System.out.println("Ho Tuan Huy 20225856 - Ordered Items:");
        itemsOrdered.forEach(Media::print);
        System.out.println("Ho Tuan Huy 20225856 - Total cost: " + totalCost());
        System.out.println("********************************************");
    }

    public Media searchByID(int id) {
        return itemsOrdered.stream()
                .filter(media -> media.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public Media searchByTitle(String title) {
        return itemsOrdered.stream()
                .filter(media -> media.getTitle().contains(title))
                .findFirst()
                .orElse(null);
    }

    public void searchAndPrintById(int inputId) {
        System.out.println("********************CART********************");
        itemsOrdered.stream()
                .filter(media -> media.getId() == inputId)
                .forEach(media -> System.out.println(media + " found!"));
        System.out.println("********************************************");
    }

    public void sortByTitleCost() {
        itemsOrdered.sort(Media.COMPARE_BY_TITLE_COST);
    }

    public void sortByCostTitle() {
        itemsOrdered.sort(Media.COMPARE_BY_COST_TITLE);
    }

    public List<Media> getItemsOrdered() {
        return itemsOrdered;
    }

    // Thêm phương thức findMedia
    public Media findMedia(String title) {
        return itemsOrdered.stream()
                .filter(media -> media.getTitle().equals(title))
                .findFirst()
                .orElse(null);
    }

    // Thêm phương thức emptyCart
    public void emptyCart() {
        itemsOrdered.clear();
        System.out.println("Ho Tuan Huy 20225856 - Cart is now empty.");
    }
}