package Lab.AimsProject.src.hust.soict.hedspi.aims.screen;
import Lab.AimsProject.src.hust.soict.hedspi.aims.media.*;
import Lab.AimsProject.src.hust.soict.hedspi.cart.Cart;
import java.awt.*;
import javax.swing.*;

public class MediaStore extends JPanel {
    private Media media;
    private CartScreenController controller;

    public MediaStore(Media media, Cart myCart, CartScreenController controller) {
        this.media = media;
        this.controller = controller;
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel title = new JLabel(media.getTitle());
        title.setFont(new Font(title.getFont().getName(),Font.PLAIN,20));
        title.setAlignmentX(CENTER_ALIGNMENT);

        JLabel cost = new JLabel(media.getCost() + "$");
        cost.setAlignmentX(CENTER_ALIGNMENT);

        JPanel container = new JPanel();
        container.setLayout(new FlowLayout(FlowLayout.CENTER));
        JButton btnAdd = new JButton("Add to cart");
        container.add(btnAdd);
        btnAdd.addActionListener(e -> {
            myCart.addMedia(media);
            JOptionPane.showMessageDialog(this, "Added " + media.getTitle() + " to cart successfully", "Add to Cart", JOptionPane.INFORMATION_MESSAGE);
            try {
                controller.updateCart();
            } catch (Exception ignored) {
            }
        });
        if(media instanceof Playable) {
            JButton playBtn= new JButton("Play");
            playBtn.addActionListener(e -> {
                JDialog playDialog = createPlayDialog(media);
                if (playDialog != null) {
                    playDialog.setVisible(true);
                    playDialog.setSize(300,200);
                    playDialog.pack();
                }
            });
            container.add(playBtn);
        }
        this.add(Box.createVerticalGlue());
        this.add(title);
        this.add(cost);
        this.add(Box.createVerticalGlue());
        this.add(container);
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }

    static JDialog createPlayDialog(Media media) {
        try {
            if (media instanceof DigitalVideoDisc dvd) {
                dvd.play();
            }
            if (media instanceof CompactDisc cd) {
                cd.play();
            }

            JDialog playDialog = new JDialog();
            Container container = playDialog.getContentPane();
            playDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            container.setLayout(new BoxLayout(container,BoxLayout.Y_AXIS));
            container.add(Box.createRigidArea(new Dimension(10,10)));
            if(media instanceof DigitalVideoDisc dvd) {
                container.add(new JLabel("Ho Tuan Huy - 20225856: Playing DVD:" + dvd.getTitle()));
                container.add(new JLabel("Ho Tuan Huy - 20225856: DVD length:" + dvd.getLength() +" min"));
            } else if (media instanceof CompactDisc cd) {
                container.add(new JLabel("Ho Tuan Huy - 20225856: Title: " + cd.getTitle()));
                container.add(new JLabel("Ho Tuan Huy - 20225856: Artist: " + cd.getArtist()));
                for (Track track : cd.getTracks()) {
                    container.add(new JLabel("Ho Tuan Huy - 20225856: Play: " + track.getTitle() + ". Length: " + track.getLength() + " min"));
                }
            }
            playDialog.setTitle("Ho Tuan Huy - 20225856: Play " + media.getTitle());
            return playDialog;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        return null;
    }
}
