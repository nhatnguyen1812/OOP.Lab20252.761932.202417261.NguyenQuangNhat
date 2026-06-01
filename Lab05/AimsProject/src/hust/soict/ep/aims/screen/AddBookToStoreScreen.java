package hust.soict.ep.aims.screen;

import javax.swing.*;
import hust.soict.ep.aims.store.Store;
import hust.soict.ep.aims.cart.Cart;
import hust.soict.ep.aims.media.Book;

public class AddBookToStoreScreen extends AddItemToStoreScreen {
    private JTextField tfAuthors;

    public AddBookToStoreScreen(Store store, Cart cart) {
        super(store, cart, "Add Book to Store");

        // Ghi de cac gia tri mac dinh cho sach
        tfTitle.setText("Java Programming 101");
        tfCategory.setText("Education");
        tfCost.setText("45.50");

        formPanel.add(new JLabel("Authors (comma separated):"));
        tfAuthors = new JTextField("James Gosling, Joshua Bloch", 20);
        formPanel.add(tfAuthors);

        formPanel.revalidate();
        formPanel.repaint();
    }

    @Override
    protected void addItem() {
        String title = tfTitle.getText().trim();
        String category = tfCategory.getText().trim();
        String costStr = tfCost.getText().trim();
        String authorsText = tfAuthors.getText().trim();

        if (title.isEmpty() || category.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Tieu de va the loai khong duoc de trong!", "Loi nhap lieu", JOptionPane.ERROR_MESSAGE);
            return;
        }

        float cost = 0.0f;
        try {
            cost = Float.parseFloat(costStr);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Gia (Cost) phai la so thap phan hop le (VD: 45.50)!", "Loi nhap lieu", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Book book = new Book();
        book.setTitle(title);
        book.setCategory(category);
        book.setCost(cost);

        if (!authorsText.isEmpty()) {
            String[] authors = authorsText.split(",");
            for (String author : authors) {
                book.addAuthor(author.trim());
            }
        }

        store.addMedia(book);
        JOptionPane.showMessageDialog(null, "Da them sach vao cua hang thanh cong!");

        new StoreScreen(store, cart);
        dispose();
    }
}
