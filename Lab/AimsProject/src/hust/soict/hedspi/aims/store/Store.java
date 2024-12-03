package Lab.AimsProject.src.hust.soict.hedspi.aims.store;

import Lab.AimsProject.src.hust.soict.hedspi.disc.DigitalVideoDisc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Store {
    private final List<DigitalVideoDisc> itemsInStore;

    public Store(List<DigitalVideoDisc> itemsInStore) {
        this.itemsInStore = new ArrayList<>(itemsInStore);
    }

    // add item method
    public void addItem(DigitalVideoDisc item) {
        if (itemsInStore.contains(item)) {
            System.out.println("Ho Tuan Huy - 20225856: Already existed in store.");
            return;
        }
        itemsInStore.add(item);
        System.out.println("Ho Tuan Huy - 20225856: Added " + item.getTitle() + " to store.");
    }

    // remove item method
    public void removeItem(DigitalVideoDisc item) {
        if (!itemsInStore.contains(item)) {
            System.out.println("Ho Tuan Huy - 20225856: Not exist.");
            return;
        }
        itemsInStore.remove(item);
        System.out.println("Ho Tuan Huy - 20225856: Deleted " + item.getTitle() + " from store.");
    }

    // show items in store method
    public void showItems() {
        System.out.println("*******************STORE*******************");
        System.out.println("Ho Tuan Huy - 20225856: DVD List:");
        Arrays.stream(itemsInStore.toArray()).
                forEach(item -> System.out.println(item.toString()));
    }
}
