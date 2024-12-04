package Lab.AimsProject.src.hust.soict.hedspi.aims;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.Iterator;


import Lab.AimsProject.src.hust.soict.hedspi.aims.media.*;
import Lab.AimsProject.src.hust.soict.hedspi.aims.store.Store;
import Lab.AimsProject.src.hust.soict.hedspi.cart.Cart;

public class Aims {
    public static void main(String[] args) {
        DigitalVideoDisc dvd = new DigitalVideoDisc(1, "Cinderella","Fantasy","Jack",18, 10.55f);

        ArrayList<Track> tracks = new ArrayList<Track>();
        tracks.add(new Track("Hong nhan",2));
        tracks.add(new Track("Bac phan",3));
        CompactDisc cd = new CompactDisc(2, "One Call Away","USUK",10.55f,"Charlie", 3, "Puth");

        ArrayList<String> authors = new ArrayList<String>();
        authors.add("MeoMeo");
        authors.add("Tai Smile");
        Book book   = new Book(3, "Harry Potter","novel",25.2f);

        Store store = new Store();
        store.addMedia(cd);
        store.addMedia(dvd);
        store.addMedia(book);

        Cart cart = new Cart();
        Scanner sc = new Scanner(System.in);

        showMenu(sc, store, cart);
    }

    public static void showMenu(Scanner scanner, Store store, Cart cart) {
        while (true) {
            System.out.println(
                    """
                                           
                            AIMS:
                            --------------------------------
                            1. View store
                            2. Update store
                            3. See current cart
                            0. Exit
                            --------------------------------
                            Please choose a number: 0-1-2-3
                                     """);
            int option = getOption(scanner);
            switch (option) {
                case 0 -> {
                    scanner.close();
                    System.exit(0);
                }
                case 1 -> storeMenu(scanner, store, cart);
                case 2 -> updateStoreMenu(scanner, store);
                case 3 -> {
                    cart.printCart();
                    cartMenu(scanner,cart);
                }
            }
        }
    }

    public static void updateStoreMenu(Scanner scanner, Store store) {
        System.out.println("""
                ==========================
                1. Add Media
                2. Delete Media
                3. Update Media in Store
                0. Back
                ==========================
                Option:
                """);
        int option = inputInt(scanner);
        switch (option) {
            case 1 -> {
                System.out.println("""
                        1.DigitalVideoDisc
                        2.CompactDisc
                        3.Book
                        -------
                        -> Your type:""");
                int option2 = getOption(scanner);
                scanner.nextLine();
                System.out.print("Ho Tuan Huy 20225856 - Enter title: ");
                String title = scanner.nextLine();
                System.out.print("Ho Tuan Huy 20225856 - Enter category: ");
                String category = scanner.nextLine();
                System.out.print("Ho Tuan Huy 20225856 - Enter cost: ");
                float cost = inputFloat(scanner);
                scanner.nextLine();
                switch (option2) {
                    case 1 ->
                    {
                        System.out.print("Ho Tuan Huy 20225856 - Enter director's name: ");
                        String director = scanner.nextLine();
                        System.out.print("Ho Tuan Huy 20225856 - Enter dvd's length: ");
                        int length = inputInt(scanner);
                        scanner.nextLine();
                        store.addMedia(new DigitalVideoDisc(title, category, director, cost));
                    }
                    case 3 -> {
                        System.out.print("Enter author's name (Enter nothing to skip): ");
                        String authorInput = scanner.nextLine();
                        ArrayList<String> authors = new ArrayList<String>();

                        while (!authorInput.isEmpty()) {
                            authors.add(authorInput);
                            System.out.print("Enter author's name (Enter nothing to skip): ");
                            authorInput = scanner.nextLine();
                        }

                        store.addMedia(new Book(title, category, cost));

                    }
                    case 2 -> {
                        System.out.print("Enter artist's name: ");
                        String artist = scanner.nextLine();
                        System.out.print("Enter number of track: ");
                        int nbTrack = inputInt(scanner);
                        scanner.nextLine();
                        ArrayList<Track> tracks = new ArrayList<>();
                        StringBuilder name = new StringBuilder();
                        for(int i = 0;i< nbTrack;i++) {
                            System.out.print("Enter Track[" + i + "]'s name: ");
                            name.replace(0,name.length(),scanner.nextLine());
                            System.out.print("Enter Track[" + i + "]'s length: ");
                            int trackLength = inputInt(scanner);
                            tracks.add(new Track(name.toString(), trackLength));
                            scanner.nextLine();
                        }
                        store.addMedia(new CompactDisc(title,category, artist, cost));
                    }
                }
            }
            case 2 -> {
                System.out.println("Ho Tuan Huy 20225856 - Enter item's title: ");
                scanner.nextLine();
                String title = scanner.nextLine();
                Iterator<Media> iter = store.getItemsInStore().iterator();
                while (iter.hasNext()) {
                    Media item = iter.next();
                    if(item.getTitle().equals(title)) {
                        iter.remove();
                        System.out.println(item.getClass().getSimpleName() + " " + item.getTitle() + "'ve been deleted from the store !");
                    }
                }

            }
            case 3 -> {
                System.out.println("Ho Tuan Huy 20225856 - Enter item's id: ");
                int id = inputInt(scanner);
                scanner.nextLine();

                Media media = store.getItemsInStore().get(id);
                if (media == null) {
                    System.out.println("Media with id " + id + " not found!");
                    return;
                }

                System.out.println("Now you are updating: " + media);

                System.out.print("Enter title: ");
                String title = scanner.nextLine();
                System.out.print("Enter category: ");
                String category = scanner.nextLine();
                System.out.print("Enter cost: ");
                float cost = inputFloat(scanner);
                media.setTitle(title);
                media.setCategory(category);
                media.setCost(cost);

                switch (media) {
                    case DigitalVideoDisc digitalVideoDisc -> {
                        System.out.print("Enter new director's name: ");
                        scanner.nextLine();
                        String director = scanner.nextLine();
                        System.out.print("Enter new dvd's length: ");
                        int length = inputInt(scanner);
                        digitalVideoDisc.setDirector(director);
                        digitalVideoDisc.setLength(length);
                    }
                    case Book book -> {
                        System.out.print("Enter new author's name (Enter nothing to skip): ");
                        String authorInput = scanner.nextLine();

                        while (!authorInput.isEmpty()) {
                            ((Book) media).addAuthor(authorInput);
                            System.out.print("Enter new author's name (Enter nothing to skip): ");
                            authorInput = scanner.nextLine();
                        }
                    }
                    case CompactDisc compactDisc -> {
                        System.out.print("Enter new artist's name: ");
                        String artist = scanner.nextLine();
                        System.out.print("Enter new number of tracks: ");
                        int nbTrack = inputInt(scanner);
                        scanner.nextLine();
                        ArrayList<Track> tracks = new ArrayList<>();
                        StringBuilder name = new StringBuilder();
                        for (int i = 0; i < nbTrack; i++) {
                            System.out.print("Enter Track[" + i + "]'s name: ");
                            name.replace(0, name.length(), scanner.nextLine());
                            System.out.print("Enter Track[" + i + "]'s length: ");
                            int trackLength = inputInt(scanner);
                            tracks.add(new Track(name.toString(), trackLength));
                            scanner.nextLine();
                        }
                        compactDisc.setArtist(artist);
                        compactDisc.setTracks(tracks);
                    }
                    default -> {
                    }
                }
                System.out.println("Ho Tuan Huy 20225856 - Media have been updated !");
            }
            case 0 -> {
            }
        }
    }

    public static void mediaDetailsMenu(Scanner scanner, Store store, Cart cart) {
        System.out.print("Ho Tuan Huy 20225856 - Enter media's title: ");
        String title = scanner.nextLine();
        Media item = store.findMediaByTitle(title);
        if(item == null) {
            System.out.println("Ho Tuan Huy 20225856 - There is no such media !");
            return;
        }
        System.out.println(item);
        while (true) {
            System.out.println("""
                            Options:
                            --------------------------------
                            1. Add to cart
                            2. Play
                            0. Back
                            --------------------------------
                            Please choose a number: 0-1-2""");
            int option = getOption(scanner);
            scanner.nextLine();
            switch (option) {
                case 1 -> cart.addMedia(item);
                case 2 -> {
                    if (item.getClass().getSimpleName().equals("Book")) {
                        System.out.println("Ho Tuan Huy 20225856 - This media is unplayable");
                    } else {
                        if (item instanceof DigitalVideoDisc dvd) {
                            dvd.play();
                        }
                        if (item instanceof CompactDisc cd) {
                            if (((CompactDisc) item).getTracks().isEmpty()) {
                                System.out.println("Ho Tuan Huy 20225856 - This CD has no track, can't play !");
                            } else cd.play();
                        }
                    }
                }
                case 0 -> {
                    return;
                }
            }
        }
    }

    public static void storeMenu(Scanner scanner, Store store, Cart cart) {
        //show all items in store
        store.print();

        while (true) {
            System.out.println("""
                                Options:\s
                                --------------------------------
                                1. See a media’s details
                                2. Add a media to cart
                                3. Play a media
                                4. See current cart
                                0. Back
                                --------------------------------
                                Please choose a number: 0-1-2-3-4
                                """);
            int option = getOption(scanner);
            scanner.nextLine();
            switch (option) {
                case 1 -> mediaDetailsMenu(scanner, store, cart);
                case 0 -> {
                    return;
                }
                case 2 -> {
                    System.out.print("Ho Tuan Huy 20225856 - Enter media's title: ");
                    String title = scanner.nextLine();
                    Media item = store.findMediaByTitle(title);
                    if (item == null) {
                        System.out.println("Ho Tuan Huy 20225856 - There is no such media !");
                    } else {
                        cart.addMedia(item);
                    }
                }
                case 3 -> {
                    System.out.print("Ho Tuan Huy 20225856 - Enter media's title: ");
                    String title = scanner.nextLine();
                    Media item = store.findMediaByTitle(title);
                    if (item == null) {
                        System.out.println("Ho Tuan Huy 20225856 - There is no such media !");
                    } else {
                        if (item.getClass().getSimpleName().equals("Book")) {
                            System.out.println("Ho Tuan Huy 20225856 - This media is unplayable");
                        } else {
                            if (item instanceof DigitalVideoDisc dvd) {
                                dvd.play();
                            }
                            if (item instanceof CompactDisc cd) {
                                cd.play();
                            }
                        }
                    }
                }
                case 4 -> {
                    cart.printCart();
                    cartMenu(scanner,cart);
                }
            }
        }
    }

    public static void cartMenu(Scanner scanner,Cart cart) {
        while (true) {
            System.out.println("""
                    Options:
                    --------------------------------
                    1. Filter medias in cart
                    2. Sort medias in cart
                    3. Remove media from cart
                    4. Play a media
                    5. Place order
                    0. Back
                    -------------------------------- \s
                    "Please choose a number: 0-1-2-3-4-5""");
            int option = getOption(scanner);
            scanner.nextLine();
            switch (option) {
                case 0 -> {
                    return;
                }
                case 1 -> {
                    System.out.println("""
                            1. Filter by title
                            2. Filter by id
                            ------------------
                            Your option:
                            """);
                    int option2 = getOption(scanner);
                    scanner.nextLine();
                    Media item;
                    if (option2 == 1) {
                        System.out.println("Ho Tuan Huy 20225856 - Enter title: ");
                        String title = scanner.nextLine();
                        item = cart.searchByTitle(title);
                    } else {
                        System.out.println("Ho Tuan Huy 20225856 - Enter id: ");
                        int id = inputInt(scanner);
                        item = cart.searchByID(id);
                    }
                    if (item == null) {
                        System.out.println("Ho Tuan Huy 20225856 - Can't found this item inside cart!");
                    } else {
                        System.out.println(item);
                    }
                }
                case  2 -> {
                    System.out.println("""
                            1. Sort by title cost
                            2. Sort by cost title
                            ----------------
                            your option:
                            """);
                    int option2 = getOption(scanner);
                    scanner.nextLine();
                    if (option2 == 1) {
                        cart.sortByTitleCost();
                        cart.printCart();
                    } else {
                        cart.sortByCostTitle();
                        cart.printCart();
                    }
                }
                case 3 -> {
                    System.out.print("Ho Tuan Huy 20225856 - Enter media's title: ");
                    String title = scanner.nextLine();
                    Media item = cart.findMedia(title);
                    if (item == null) {
                        System.out.println("Ho Tuan Huy 20225856 - There is no such media !");
                    } else {
                        cart.removeMedia(item);
                    }
                }
                case 4 -> {
                    System.out.print("Ho Tuan Huy 20225856 - Enter media's title: ");
                    String title = scanner.nextLine();
                    Media item = cart.findMedia(title);
                    if (item == null) {
                        System.out.println("Ho Tuan Huy 20225856 - There is no such media !");
                    } else {
                        if (item.getClass().getSimpleName().equals("Book")) {
                            System.out.println("Ho Tuan Huy 20225856 - This media is unplayable");
                        } else {
                            if (item instanceof DigitalVideoDisc dvd) {
                                dvd.play();
                            }
                            if (item instanceof CompactDisc cd) {
                                cd.play();
                            }
                        }
                    }
                }
                case  5 -> {
                    System.out.println("Ho Tuan Huy 20225856 - Your cart have been paid\nThanks for using our service");
                    cart.emptyCart();
                }
            }
        }
    }

    public static int getOption(Scanner scanner) {
        try {
            return inputInt(scanner);
        } catch (InputMismatchException e) {
            System.out.println("Ho Tuan Huy 20225856 - Invalid input, please enter a number");
            scanner.nextLine();
            return getOption(scanner);
        }
    }

    public static int inputInt(Scanner scanner) {
        try {
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Ho Tuan Huy 20225856 - Invalid input, please enter a number");
            scanner.nextLine();
            return inputInt(scanner);
        }
    }

    public static float inputFloat(Scanner scanner) {
        try {
            return scanner.nextFloat();
        } catch (InputMismatchException e) {
            System.out.println("Ho Tuan Huy 20225856 - Invalid input, please enter a number");
            scanner.nextLine();
            return inputFloat(scanner);
        }
    }
}