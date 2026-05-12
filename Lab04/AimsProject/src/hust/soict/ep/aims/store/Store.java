package hust.soict.ep.aims.store;

import hust.soict.ep.aims.media.Media;
import java.util.ArrayList;

public class Store {
    private ArrayList<Media> itemsInStore = new ArrayList<Media>();

    public void addMedia(Media media) {
        if (!itemsInStore.contains(media)) {
            itemsInStore.add(media);
            System.out.println("Da them " + media.getTitle() + " vao cua hang.");
        } else {
            System.out.println(media.getTitle() + " da ton tai trong cua hang!");
        }
    }

    public void removeMedia(Media media) {
        if (itemsInStore.contains(media)) {
            itemsInStore.remove(media);
            System.out.println("Da xoa " + media.getTitle() + " khoi cua hang.");
        } else {
            System.out.println("Khong tim thay " + media.getTitle() + " de xoa!");
        }
    }

    // Hàm in danh sách cửa hàng
    public void printStore() {
        System.out.println("********************STORE********************");
        if (itemsInStore.isEmpty()) {
            System.out.println("Cua hang dang trong!");
        } else {
            for (int i = 0; i < itemsInStore.size(); i++) {
                System.out.println((i + 1) + ". " + itemsInStore.get(i).toString());
            }
        }
        System.out.println("*********************************************");
    }

    // Hàm tìm kiếm Media theo tên và trả về Object để Menu xử lý
    public Media searchByTitle(String title) {
        for (Media media : itemsInStore) {
            if (media.getTitle().equalsIgnoreCase(title)) {
                return media;
            }
        }
        return null;
    }
}