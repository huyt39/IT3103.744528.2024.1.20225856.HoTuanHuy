package Lab.AimsProject.src.hust.soict.hedspi.test;

import java.util.List;

import Lab.AimsProject.src.hust.soict.hedspi.aims.store.Store;
import Lab.AimsProject.src.hust.soict.hedspi.disc.DigitalVideoDisc;

public class StoreTest {
    public static void main(String[] args) {
        // Create a new store
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
        List<DigitalVideoDisc> itemsInStore = List.of(dvd1, dvd2, dvd3);
        Store aStore = new Store(itemsInStore);

        // Add a DVD to the store
        DigitalVideoDisc dvd4 = new DigitalVideoDisc("The Lion King 2", "Animation", "Roger Allers", 87, 19.95f);
        aStore.addItem(dvd4);
        // Remove a DVD from the store
        aStore.removeItem(dvd4);

        // Show items in store
        aStore.showItems();
    }
}
