package Lab.AimsProject.src.hust.soict.hedspi.aims.screen;

import Lab.AimsProject.src.hust.soict.hedspi.aims.media.*;
import Lab.AimsProject.src.hust.soict.hedspi.cart.Cart;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.paint.Color;
import javax.swing.JDialog;
import java.util.ArrayList;
import java.util.Collections;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.geometry.Pos;
import javafx.application.Platform;


public class CartScreenController {
    private Cart cart;

    @FXML
    private Button btnPlaceOrder;
    @FXML
    private TextField tfFilter;
    @FXML
    private ToggleGroup filterCategory;
    @FXML
    private RadioButton radioBtnFilterId;
    @FXML
    private RadioButton radioBtnFilterTitle;
    @FXML
    private Button btnPlay;
    @FXML
    private Button btnRemove;
    @FXML
    private TableView<Media> tblMedia;
    @FXML
    private TableColumn<Media, String> colMediaTitle;
    @FXML
    private TableColumn<Media, String> colMediaCategory;
    @FXML
    private TableColumn<Media, Float> colMediaCost;
    @FXML
    private Label totalPrice;

    public CartScreenController(Cart cart) {
        super();
        this.cart = cart;
    }

    @FXML
    private void initialize() {
        colMediaTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        colMediaCategory.setCellValueFactory(new PropertyValueFactory<>("category"));
        colMediaCost.setCellValueFactory(new PropertyValueFactory<>("cost"));
        tblMedia.setItems(FXCollections.observableList(this.cart.getItemsOrdered()));
        tblMedia.setPlaceholder(new Label("No item in cart"));
        btnPlay.setVisible(false);
        btnRemove.setVisible(false);

        btnRemove.setOnAction(event -> btnRemovePressed());
        tfFilter.textProperty().addListener((observableValue, oldValue, newValue) -> showFilterMedia(newValue));

        tblMedia.getSelectionModel().selectedItemProperty().addListener(
                (observableValue, oldMedia, newMedia) -> updateButtonBar(newMedia)
        );
        totalPrice.setText(cart.totalCost() + "$");

        btnPlay.setOnAction(event -> {
            JDialog playDialog = MediaStore.createPlayDialog(tblMedia.getSelectionModel().getSelectedItem());
            if (playDialog != null) {
                playDialog.setVisible(true);
                playDialog.setSize(300, 200);
                playDialog.pack();
            }
        });

        btnPlaceOrder.setOnAction(event -> {
            createPopUp();
            cart.getItemsOrdered().clear();
            updateCart();
        });
    }

    @FXML
    void updateButtonBar(Media media) {
        btnRemove.setVisible(media != null);
        btnPlay.setVisible(media instanceof Playable);
    }

    @FXML
    void showFilterMedia(String input) {
        if (input == null || input.trim().isEmpty()) {
            tblMedia.setItems(FXCollections.observableList(cart.getItemsOrdered()));
            return;
        }

        if (filterCategory.getSelectedToggle() == radioBtnFilterTitle) {
            Media result = cart.searchByTitle(input);
            if (result != null) {
                tblMedia.setItems(FXCollections.observableList(Collections.singletonList(result)));
            } else {
                tblMedia.setItems(FXCollections.observableList(new ArrayList<>()));
            }
        } else if (filterCategory.getSelectedToggle() == radioBtnFilterId) {
            try {
                int id = Integer.parseInt(input.trim());
                Media result = cart.searchByID(id); // Sử dụng đúng tên phương thức searchByID
                if (result != null) {
                    tblMedia.setItems(FXCollections.observableList(Collections.singletonList(result)));
                } else {
                    tblMedia.setItems(FXCollections.observableList(new ArrayList<>()));
                }
            } catch (NumberFormatException e) {
                tblMedia.setItems(FXCollections.observableList(new ArrayList<>()));
            }
        }
    }

    @FXML
    void createPopUp() {
        Stage popUpWindow = new Stage();
        popUpWindow.initModality(Modality.APPLICATION_MODAL);
        popUpWindow.setTitle("Place order");

        Label label1 = new Label("You have placed your order!");
        label1.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        Label label2 = new Label("Your bill total is " + cart.totalCost() + "$");
        Button button1 = new Button("OK!");
        label2.setTextFill(Color.RED);
        button1.setOnAction(e -> popUpWindow.close());
        VBox layout = new VBox(10);
        layout.getChildren().addAll(label1, label2, button1);
        layout.setAlignment(Pos.CENTER);
        Scene scene1 = new Scene(layout, 300, 200);
        popUpWindow.setScene(scene1);
        popUpWindow.show();
    }

    @FXML
    void btnRemovePressed() {
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        if (media != null) {
            cart.removeMedia(media);
            updateCart();
        }
    }

    public void updateCart() {
        Platform.runLater(() -> {
            tblMedia.setItems(FXCollections.observableList(cart.getItemsOrdered()));
            totalPrice.setText(cart.totalCost() + "$");
        });
    }
}
