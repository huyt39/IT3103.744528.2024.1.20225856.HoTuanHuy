package Lab.AimsProject.src.hust.soict.hedspi.aims.screen;

import Lab.AimsProject.src.hust.soict.hedspi.aims.media.*;
import Lab.AimsProject.src.hust.soict.hedspi.aims.store.Store;
import Lab.AimsProject.src.hust.soict.hedspi.cart.Cart;
import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

public class StoreScreen extends JFrame {
    private Store store;
    private Container cp;
    private Cart cart;

    JPanel createNorth() {
        JPanel north = new JPanel();
        north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
        north.add(createMenuBar());
        north.add(createHeader());
        return north;
    }

    JMenuBar createMenuBar() {
        JMenu menu = new JMenu("Ho Tuan Huy - 20225856: Options");
        JMenu smUpdateStore = new JMenu("Ho Tuan Huy - 20225856: Update Store");

        JMenuItem addBook = new JMenuItem("Ho Tuan Huy - 20225856: Add Book");
        smUpdateStore.add(addBook);
        addBook.addActionListener(e -> new AddBookStoreScreen(store));

        JMenuItem addCD = new JMenuItem("Ho Tuan Huy - 20225856: Add CD");
        smUpdateStore.add(addCD);
        addCD.addActionListener(e -> new AddCDStoreScreen(store));

        JMenuItem addDVD = new JMenuItem("Ho Tuan Huy - 20225856: Add DVD");
        smUpdateStore.add(addDVD);
        addDVD.addActionListener(e -> new AddDVDStoreScreen(store));

        menu.add(smUpdateStore);

        JMenuItem viewStore = new JMenuItem("Ho Tuan Huy - 20225856: View store");
        menu.add(viewStore);

        JMenuItem viewCart = new JMenuItem("Ho Tuan Huy - 20225856: View cart");
        viewCart.addActionListener(e -> new CartScreen(cart));
        menu.add(viewCart);

        JMenuBar menuBar = new JMenuBar();
        menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        menuBar.add(menu);
        return menuBar;
    }

    JPanel createHeader() {
        JPanel header = new JPanel();
        header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));

        JLabel title = new JLabel("Ho Tuan Huy - 20225856: AIMS");
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
        title.setForeground(Color.CYAN);

        JButton cartButton = new JButton("Ho Tuan Huy - 20225856: View cart");
        cartButton.setPreferredSize(new Dimension(100, 50));
        cartButton.addActionListener(e -> new CartScreen(cart));

        header.add(Box.createRigidArea(new Dimension(10, 10)));
        header.add(title);
        header.add(Box.createHorizontalGlue());
        header.add(cartButton);
        header.add(Box.createRigidArea(new Dimension(10, 10)));
        return header;
    }

    JPanel createCenter() {
        JPanel center = new JPanel();
        center.setLayout(new GridLayout(3, 3, 2, 2));
        ArrayList<Media> mediaStore = store.getItemsInStore();
        for (Media media : mediaStore) {
            MediaStore cell = new MediaStore(media, cart);
            center.add(cell);
        }
        return center;
    }

    public StoreScreen(Store store, Cart cart) {
        this.store = store;
        this.cart = cart;
        cp = getContentPane();
        cp.setLayout(new BorderLayout());
        cp.add(createNorth(), BorderLayout.NORTH);
        cp.add(createCenter(), BorderLayout.CENTER);
        setVisible(true);
        setTitle("Store");
        setSize(1024, 768);
    }

    public static void main(String[] args) {
        Store store = new Store();
        Cart myCart = new Cart();

        DigitalVideoDisc dvd = new DigitalVideoDisc("Cinderella", "Fantasy", "Jack", 10);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Doraemon", "Hoat hinh", "Fuji", 20);

        ArrayList<Track> tracks = new ArrayList<>();
        tracks.add(new Track("Happy new year", 3));
        tracks.add(new Track("I want it that way", 4));
        CompactDisc cd = new CompactDisc("What do you mean", "USUK", "Justin Bieber", 20.5f);

        ArrayList<String> authors = new ArrayList<>();
        authors.add("Agatha Christie");
        Book book1 = new Book("God Father", "Novel", 25.5f);

        store.addMedia(cd);
        store.addMedia(dvd);
        store.addMedia(book1);

        new StoreScreen(store, myCart);
    }

    // Add Book Store Screen
    private class AddBookStoreScreen extends JFrame {
        public AddBookStoreScreen(Store store) {
            setLayout(new GridLayout(4, 2, 5, 5));
            add(new JLabel("Enter title: "));
            TextField title = new TextField(10);
            add(title);
            add(new JLabel("Enter category: "));
            TextField category = new TextField(10);
            add(category);
            add(new JLabel("Enter cost: "));
            TextField cost = new TextField(10);
            add(cost);

            JButton addBtn = new JButton("Add Book");
            add(addBtn);
            addBtn.addActionListener(e -> {
                Book book = new Book(title.getText(), category.getText(), Float.parseFloat(cost.getText()));
                store.addMedia(book);
                cp.add(createCenter(), BorderLayout.CENTER);
                cp.revalidate();
            });
            setTitle("Add Book");
            setSize(300, 200);
            setVisible(true);
        }
    }

    // Add DVD Store Screen
    private class AddDVDStoreScreen extends JFrame {
        public AddDVDStoreScreen(Store store) {
            setLayout(new GridLayout(4, 2, 5, 5));
            add(new JLabel("Enter title: "));
            TextField title = new TextField(10);
            add(title);
            add(new JLabel("Enter category: "));
            TextField category = new TextField(10);
            add(category);
            add(new JLabel("Enter director: "));
            TextField director = new TextField(10);
            add(director);
            add(new JLabel("Enter cost: "));
            TextField cost = new TextField(10);
            add(cost);

            JButton addBtn = new JButton("Add DVD");
            add(addBtn);
            addBtn.addActionListener(e -> {
                DigitalVideoDisc dvd = new DigitalVideoDisc(title.getText(), category.getText(), director.getText(), Float.parseFloat(cost.getText()));
                store.addMedia(dvd);
                cp.add(createCenter(), BorderLayout.CENTER);
                cp.revalidate();
            });
            setTitle("Add DVD");
            setSize(300, 200);
            setVisible(true);
        }
    }

    // Add CD Store Screen
    private class AddCDStoreScreen extends JFrame {
        public AddCDStoreScreen(Store store) {
            setLayout(new GridLayout(5, 2, 5, 5));
            add(new JLabel("Enter title: "));
            TextField title = new TextField(10);
            add(title);
            add(new JLabel("Enter category: "));
            TextField category = new TextField(10);
            add(category);
            add(new JLabel("Enter cost: "));
            TextField cost = new TextField(10);
            add(cost);
            add(new JLabel("Enter artist: "));
            TextField artist = new TextField(10);
            add(artist);

            JButton addBtn = new JButton("Add CD");
            add(addBtn);
            addBtn.addActionListener(e -> {
                CompactDisc cd = new CompactDisc(title.getText(), category.getText(), artist.getText(), Float.parseFloat(cost.getText()));
                store.addMedia(cd);
                cp.add(createCenter(), BorderLayout.CENTER);
                cp.revalidate();
            });
            setTitle("Add CD");
            setSize(300, 200);
            setVisible(true);
        }
    }
}
