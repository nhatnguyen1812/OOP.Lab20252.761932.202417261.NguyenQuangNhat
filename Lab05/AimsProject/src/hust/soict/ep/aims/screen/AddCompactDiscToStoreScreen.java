package hust.soict.ep.aims.screen;

import javax.swing.*;
import hust.soict.ep.aims.store.Store;
import hust.soict.ep.aims.cart.Cart;
import hust.soict.ep.aims.media.CompactDisc;
import hust.soict.ep.aims.media.Track;

public class AddCompactDiscToStoreScreen extends AddItemToStoreScreen {
    private JTextField tfArtist;
    private JTextField tfTracks;

    public AddCompactDiscToStoreScreen(Store store, Cart cart) {
        super(store, cart, "Add CD to Store");

        // Ghi de cac gia tri mac dinh cho CD
        tfTitle.setText("Star Wars Soundtrack");
        tfCategory.setText("Soundtrack");
        tfCost.setText("18.99");

        formPanel.add(new JLabel("Artist:"));
        tfArtist = new JTextField("John Williams", 20);
        formPanel.add(tfArtist);

        formPanel.add(new JLabel("Tracks (Title-Len, Title-Len):"));
        tfTracks = new JTextField("Main Theme-320, Imperial March-180", 20);
        formPanel.add(tfTracks);

        formPanel.revalidate();
        formPanel.repaint();
    }

    @Override
    protected void addItem() {
        String title = tfTitle.getText().trim();
        String category = tfCategory.getText().trim();
        String costStr = tfCost.getText().trim();
        String artist = tfArtist.getText().trim();
        String tracksText = tfTracks.getText().trim();

        if (title.isEmpty() || category.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Tieu de va the loai khong duoc de trong!", "Loi nhap lieu", JOptionPane.ERROR_MESSAGE);
            return;
        }

        float cost = 0.0f;
        try {
            cost = Float.parseFloat(costStr);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Gia (Cost) phai la so thap phan hop le (VD: 18.99)!", "Loi nhap lieu", JOptionPane.ERROR_MESSAGE);
            return;
        }

        CompactDisc cd = new CompactDisc();
        cd.setTitle(title);
        cd.setCategory(category);
        cd.setCost(cost);
        cd.setArtist(artist);

        if (!tracksText.isEmpty()) {
            String[] trackParts = tracksText.split(",");
            for (String part : trackParts) {
                String[] subParts = part.split("-");
                if (subParts.length == 2) {
                    String trackTitle = subParts[0].trim();
                    try {
                        int trackLength = Integer.parseInt(subParts[1].trim());
                        cd.addTrack(new Track(trackTitle, trackLength));
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Do dai cua track phai la so nguyen hop le!", "Loi dinh dang track", JOptionPane.WARNING_MESSAGE);
                    }
                }
            }
        }

        store.addMedia(cd);
        JOptionPane.showMessageDialog(null, "Da them CD vao cua hang thanh cong!");

        new StoreScreen(store, cart);
        dispose();
    }
}
