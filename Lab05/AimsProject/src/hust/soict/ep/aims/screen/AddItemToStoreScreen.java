package hust.soict.ep.aims.screen;

import javax.swing.*;
import java.awt.*;
import hust.soict.ep.aims.store.Store;
import hust.soict.ep.aims.cart.Cart;

public abstract class AddItemToStoreScreen extends JFrame {
    protected Store store;
    protected Cart cart;

    protected JTextField tfTitle;
    protected JTextField tfCategory;
    protected JTextField tfCost;
    protected JPanel formPanel;

    public AddItemToStoreScreen(Store store, Cart cart, String title) {
        this.store = store;
        this.cart = cart;

        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());

        // Menu bar va header chung
        cp.add(createNorth(), BorderLayout.NORTH);

        // Form nhap thong tin
        formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(0, 2, 10, 10));
        formPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        formPanel.add(new JLabel("Title:"));
        tfTitle = new JTextField(20);
        formPanel.add(tfTitle);

        formPanel.add(new JLabel("Category:"));
        tfCategory = new JTextField(20);
        formPanel.add(tfCategory);

        formPanel.add(new JLabel("Cost ($):"));
        tfCost = new JTextField(20);
        formPanel.add(tfCost);

        // Nut submit
        JButton btnAdd = new JButton("Add Item");
        btnAdd.addActionListener(e -> {
            try {
                addItem();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Loi: " + ex.getMessage(), "Loi", JOptionPane.ERROR_MESSAGE);
            }
        });

        JPanel btnPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        btnPanel.add(btnAdd);

        JPanel centerPanel = new JPanel(new BorderLayout());
        centerPanel.add(formPanel, BorderLayout.CENTER);
        centerPanel.add(btnPanel, BorderLayout.SOUTH);

        cp.add(centerPanel, BorderLayout.CENTER);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle(title);
        setSize(400, 450);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    JPanel createNorth() {
        JPanel north = new JPanel();
        north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
        north.add(createMenuBar());
        return north;
    }

    JMenuBar createMenuBar() {
        JMenu menu = new JMenu("Options");

        JMenuItem mViewStore = new JMenuItem("View store");
        mViewStore.addActionListener(e -> {
            new StoreScreen(store, cart);
            dispose();
        });
        menu.add(mViewStore);

        JMenuItem mViewCart = new JMenuItem("View cart");
        mViewCart.addActionListener(e -> {
            new CartScreen(cart, store);
            dispose();
        });
        menu.add(mViewCart);

        JMenuBar menuBar = new JMenuBar();
        menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        menuBar.add(menu);
        return menuBar;
    }

    // Phuong thuc de lop con tu trien khai logic add phu hop
    protected abstract void addItem();
}
