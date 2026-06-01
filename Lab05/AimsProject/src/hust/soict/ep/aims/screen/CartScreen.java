package hust.soict.ep.aims.screen;

import javax.swing.*;
import javafx.embed.swing.JFXPanel;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import java.io.IOException;
import hust.soict.ep.aims.cart.Cart;
import hust.soict.ep.aims.store.Store;

public class CartScreen extends JFrame {
    private Cart cart;
    private Store store;

    public CartScreen(Cart cart, Store store) {
        super();
        this.cart = cart;
        this.store = store;

        JFXPanel fxPanel = new JFXPanel();
        this.add(fxPanel);

        this.setTitle("Cart");
        this.setSize(1024, 768);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                try {
                    // Giu cho JavaFX platform chay ngam de tranh loi trang man hinh
                    Platform.setImplicitExit(false);
                    
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/hust/soict/ep/aims/screen/cart.fxml"));
                    CartScreenController controller = new CartScreenController(cart, store);
                    controller.setParentFrame(CartScreen.this);
                    loader.setController(controller);
                    Parent root = loader.load();
                    fxPanel.setScene(new Scene(root));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
