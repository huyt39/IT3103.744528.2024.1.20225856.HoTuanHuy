package Lab.AimsProject.src.hust.soict.hedspi.test;

import Lab.AimsProject.src.hust.soict.hedspi.cart.Cart;
import Lab.AimsProject.src.hust.soict.hedspi.disc.DigitalVideoDisc;

public class CartTest {
    public static void main(String[] args) {
        // Create a new cart
        Cart cart = new Cart();

        // Create new dvd objects and add them to the cart
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        cart.addDigitalVideoDisc(dvd1);

        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        cart.addDigitalVideoDisc(dvd2);

        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
        cart.addDigitalVideoDisc(dvd3);

        // Test the print method
        cart.print();

        // Test search by ID method
        DigitalVideoDisc dvd = cart.searchById(1);
        if (dvd != null) {
            System.out.println("Ho Tuan Huy - 20225856: Found DVD with ID 1: " + dvd.toString());
        } else {
            System.out.println("Ho Tuan Huy - 20225856: DVD with ID 1 not found.");
        }

        // Test search by title method
        dvd = cart.searchByTitle("Aladin");
        if (dvd != null) {
            System.out.println("Ho Tuan Huy - 20225856: Found DVD with title 'Aladin': " + dvd.toString());
        } else {
            System.out.println("Ho Tuan Huy - 20225856: DVD with title 'Aladin' not found.");
        }
    }
}
