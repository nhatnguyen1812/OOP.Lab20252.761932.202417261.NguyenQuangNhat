package hust.soict.ep.aims.screen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import hust.soict.ep.aims.media.Media;
import hust.soict.ep.aims.media.Playable;
import hust.soict.ep.aims.cart.Cart;
import hust.soict.ep.aims.exception.PlayerException;
import hust.soict.ep.aims.exception.LimitExceededException;

public class MediaStore extends JPanel {
    private Media media;
    private Cart cart;

    public MediaStore(Media media, Cart cart) {
        this.media = media;
        this.cart = cart;
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel title = new JLabel(media.getTitle());
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 20));
        title.setAlignmentX(CENTER_ALIGNMENT);

        JLabel cost = new JLabel("" + media.getCost() + " $");
        cost.setAlignmentX(CENTER_ALIGNMENT);

        JPanel container = new JPanel();
        container.setLayout(new FlowLayout(FlowLayout.CENTER));

        JButton btnAddToCart = new JButton("Add to cart");
        btnAddToCart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    cart.addMedia(MediaStore.this.media);
                    JOptionPane.showMessageDialog(null, 
                        "Da them " + MediaStore.this.media.getTitle() + " vao gio hang!", 
                        "Thanh cong", JOptionPane.INFORMATION_MESSAGE);
                } catch (LimitExceededException ex) {
                    // Bat ngoai le vuot qua so luong cho phep trong gio hang
                    JOptionPane.showMessageDialog(null, 
                        ex.getMessage(), 
                        "Loi gio hang", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        container.add(btnAddToCart);
 
        if (media instanceof Playable) {
            JButton btnPlay = new JButton("Play");
            btnPlay.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        ((Playable) MediaStore.this.media).play();
                        
                        // Tao hop thoai phat media bang JDialog
                        JDialog dialog = new JDialog();
                        dialog.setTitle("Phat Media");
                        dialog.setSize(300, 150);
                        dialog.setLocationRelativeTo(null);
                        
                        JLabel label = new JLabel("Dang phat: " + MediaStore.this.media.getTitle(), SwingConstants.CENTER);
                        dialog.add(label);
                        dialog.setVisible(true);
                    } catch (PlayerException ex) {
                        // Bat ngoai le khi phat media co do dai khong hop le
                        JOptionPane.showMessageDialog(null, 
                            ex.getMessage(), 
                            "Loi phat Media", JOptionPane.ERROR_MESSAGE);
                    }
                }
            });
            container.add(btnPlay);
        }

        this.add(Box.createVerticalGlue());
        this.add(title);
        this.add(cost);
        this.add(Box.createVerticalGlue());
        this.add(container);

        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }
}
