package hust.soict.ep.aims.screen;

import javax.swing.*;
import hust.soict.ep.aims.store.Store;
import hust.soict.ep.aims.cart.Cart;
import hust.soict.ep.aims.media.DigitalVideoDisc;

public class AddDigitalVideoDiscToStoreScreen extends AddItemToStoreScreen {
    private JTextField tfDirector;
    private JTextField tfLength;

    public AddDigitalVideoDiscToStoreScreen(Store store, Cart cart) {
        super(store, cart, "Add DVD to Store");

        // Ghi de cac gia tri mac dinh cho DVD
        tfTitle.setText("The Matrix");
        tfCategory.setText("Action");
        tfCost.setText("19.99");

        formPanel.add(new JLabel("Director:"));
        tfDirector = new JTextField("Lana Wachowski", 20);
        formPanel.add(tfDirector);

        formPanel.add(new JLabel("Length:"));
        tfLength = new JTextField("136", 20);
        formPanel.add(tfLength);

        formPanel.revalidate();
        formPanel.repaint();
    }

    @Override
    protected void addItem() {
        String title = tfTitle.getText().trim();
        String category = tfCategory.getText().trim();
        String costStr = tfCost.getText().trim();
        String director = tfDirector.getText().trim();
        String lengthStr = tfLength.getText().trim();

        if (title.isEmpty() || category.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Tieu de va the loai khong duoc de trong!", "Loi nhap lieu", JOptionPane.ERROR_MESSAGE);
            return;
        }

        float cost = 0.0f;
        try {
            cost = Float.parseFloat(costStr);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Gia (Cost) phai la so thap phan hop le (VD: 19.99)!", "Loi nhap lieu", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int length = 0;
        try {
            length = Integer.parseInt(lengthStr);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Do dai (Length) phai la so nguyen hop le (VD: 136)!", "Loi nhap lieu", JOptionPane.ERROR_MESSAGE);
            return;
        }

        DigitalVideoDisc dvd = new DigitalVideoDisc(title, category, director, length, cost);
        store.addMedia(dvd);
        JOptionPane.showMessageDialog(null, "Da them DVD vao cua hang thanh cong!");

        new StoreScreen(store, cart);
        dispose();
    }
}
