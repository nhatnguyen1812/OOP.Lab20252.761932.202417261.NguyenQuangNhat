package hust.soict.ep.aims.screen;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javax.swing.JOptionPane;
import javax.swing.JFrame;
import hust.soict.ep.aims.cart.Cart;
import hust.soict.ep.aims.store.Store;
import hust.soict.ep.aims.media.Media;
import hust.soict.ep.aims.media.Playable;
import hust.soict.ep.aims.exception.PlayerException;

public class CartScreenController {
    private Cart cart;
    private Store store;
    private JFrame parentFrame;
    private FilteredList<Media> filteredList;

    @FXML
    private TableView<Media> tblMedia;

    @FXML
    private TableColumn<Media, String> colMediaTitle;

    @FXML
    private TableColumn<Media, String> colMediaCategory;

    @FXML
    private TableColumn<Media, Float> colMediaCost;

    @FXML
    private Button btnPlay;

    @FXML
    private Button btnRemove;

    @FXML
    private Label lblTotal;

    @FXML
    private TextField tfFilter;

    @FXML
    private RadioButton radioBtnFilterId;

    @FXML
    private RadioButton radioBtnFilterTitle;

    public CartScreenController(Cart cart, Store store) {
        this.cart = cart;
        this.store = store;
    }

    public void setParentFrame(JFrame parentFrame) {
        this.parentFrame = parentFrame;
    }

    @FXML
    private void initialize() {
        colMediaTitle.setCellValueFactory(new PropertyValueFactory<Media, String>("title"));
        colMediaCategory.setCellValueFactory(new PropertyValueFactory<Media, String>("category"));
        colMediaCost.setCellValueFactory(new PropertyValueFactory<Media, Float>("cost"));

        // Dung FilteredList de ho tro tinh nang tim kiem
        filteredList = new FilteredList<>(this.cart.getItemsOrdered(), p -> true);
        tblMedia.setItems(filteredList);

        btnPlay.setDisable(true);
        btnRemove.setDisable(true);

        // Lang nghe thay doi lua chon tren bang
        tblMedia.getSelectionModel().selectedItemProperty().addListener(
            new ChangeListener<Media>() {
                @Override
                public void changed(ObservableValue<? extends Media> observable, Media oldValue, Media newValue) {
                    if (newValue != null) {
                        updateButtonBar(newValue);
                    } else {
                        btnPlay.setDisable(true);
                        btnRemove.setDisable(true);
                    }
                }
            }
        );

        // Lang nghe thay doi tren o tim kiem
        tfFilter.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                showFilteredMedia(newValue);
            }
        });

        // Lang nghe thay doi tren radio button de cap nhat filter tuc thi
        ChangeListener<Boolean> radioListener = new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                showFilteredMedia(tfFilter.getText());
            }
        };
        radioBtnFilterId.selectedProperty().addListener(radioListener);
        radioBtnFilterTitle.selectedProperty().addListener(radioListener);

        tfFilter.setPromptText("Nhap tu khoa...");

        updateTotalCost();
    }

    private void updateButtonBar(Media media) {
        btnRemove.setDisable(false);
        if (media instanceof Playable) {
            btnPlay.setDisable(false);
        } else {
            btnPlay.setDisable(true);
        }
    }

    private void updateTotalCost() {
        lblTotal.setText(String.format("%.2f $", cart.totalCost()));
    }

    private void showFilteredMedia(String newValue) {
        filteredList.setPredicate(media -> {
            if (newValue == null || newValue.isEmpty()) {
                return true;
            }
            String lowerCaseFilter = newValue.toLowerCase();
            if (radioBtnFilterId.isSelected()) {
                return String.valueOf(media.getId()).contains(lowerCaseFilter);
            } else if (radioBtnFilterTitle.isSelected()) {
                return media.getTitle().toLowerCase().contains(lowerCaseFilter);
            }
            return false;
        });
    }

    @FXML
    void btnRemovePressed(ActionEvent event) {
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        if (media != null) {
            cart.removeMedia(media);
            updateTotalCost();
        }
        tblMedia.getSelectionModel().clearSelection();
    }

    @FXML
    void btnPlayPressed(ActionEvent event) {
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        if (media instanceof Playable) {
            try {
                ((Playable) media).play();
                javax.swing.SwingUtilities.invokeLater(() -> {
                    JOptionPane.showMessageDialog(null, 
                        "Dang phat: " + media.getTitle(), 
                        "Phat Media", JOptionPane.INFORMATION_MESSAGE);
                });
            } catch (PlayerException e) {
                javax.swing.SwingUtilities.invokeLater(() -> {
                    JOptionPane.showMessageDialog(null, 
                        e.getMessage(), 
                        "Loi phat Media", JOptionPane.ERROR_MESSAGE);
                });
            }
        }
    }

    @FXML
    void btnPlaceOrderPressed(ActionEvent event) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            JOptionPane.showMessageDialog(null, 
                "Don hang cua ban da duoc tao thanh cong! Gio hang da duoc lam trong.", 
                "Dat hang thanh cong", JOptionPane.INFORMATION_MESSAGE);
        });
        cart.emptyCart();
        updateTotalCost();
        tblMedia.getSelectionModel().clearSelection();
    }

    // Dieu huong menu
    @FXML
    void addBookMenuSelected(ActionEvent event) {
        new AddBookToStoreScreen(store, cart);
        closeParentFrame();
    }

    @FXML
    void addCDMenuSelected(ActionEvent event) {
        new AddCompactDiscToStoreScreen(store, cart);
        closeParentFrame();
    }

    @FXML
    void addDVDMenuSelected(ActionEvent event) {
        new AddDigitalVideoDiscToStoreScreen(store, cart);
        closeParentFrame();
    }

    @FXML
    void viewStoreMenuSelected(ActionEvent event) {
        new StoreScreen(store, cart);
        closeParentFrame();
    }

    private void closeParentFrame() {
        if (parentFrame != null) {
            parentFrame.dispose();
        }
    }
}
