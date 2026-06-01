package hust.soict.ep.aims.cart;

import hust.soict.ep.aims.media.Media;
import hust.soict.ep.aims.exception.LimitExceededException;
import java.util.Collections; // Import them thu vien nay de dung chuc nang Sort
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private ObservableList<Media> itemsOrdered = FXCollections.observableArrayList();

    public void addMedia(Media media) throws LimitExceededException {
        if (itemsOrdered.size() >= MAX_NUMBERS_ORDERED) {
            throw new LimitExceededException("ERROR: The number of media has reached its limit");
        }
        if (!itemsOrdered.contains(media)) {
            itemsOrdered.add(media);
            System.out.println("Da them " + media.getTitle() + " vao gio hang.");
        } else {
            System.out.println(media.getTitle() + " da co trong gio hang!");
        }
    }

    public void removeMedia(Media media) {
        if (itemsOrdered.contains(media)) {
            itemsOrdered.remove(media);
            System.out.println("Da xoa " + media.getTitle() + " khoi gio hang.");
        } else {
            System.out.println("Khong tim thay " + media.getTitle() + " de xoa!");
        }
    }

    public float totalCost() {
        float total = 0;
        for (Media media : itemsOrdered) {
            total += media.getCost();
        }
        return total;
    }

    // Lay so luong san pham trong gio
    public int getSize() {
        return itemsOrdered.size();
    }

    // In danh sach gio hang
    public void printCart() {
        System.out.println("***********************CART***********************");
        System.out.println("Ordered Items:");
        if (itemsOrdered.isEmpty()) {
            System.out.println("Gio hang dang trong!");
        } else {
            for (int i = 0; i < itemsOrdered.size(); i++) {
                System.out.println((i + 1) + ". " + itemsOrdered.get(i).toString());
            }
        }
        System.out.println("Total cost: " + totalCost() + " $");
        System.out.println("**************************************************");
    }

    // Tim kiem de in ra theo ID
    public void searchById(int id) {
        boolean found = false;
        for (Media media : itemsOrdered) {
            if (media.getId() == id) {
                System.out.println("Tim thay: " + media.toString());
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Khong tim thay san pham voi ID: " + id);
        }
    }

    // Tim kiem de in ra theo Ten
    public void searchByTitle(String title) {
        boolean found = false;
        for (Media media : itemsOrdered) {
            if (media.getTitle().equalsIgnoreCase(title)) {
                System.out.println("Tim thay: " + media.toString());
                found = true;
            }
        }
        if (!found) {
            System.out.println("Khong tim thay san pham voi ten: " + title);
        }
    }

    // Tim kiem va tra ve Object de xu ly
    public Media searchByTitleReturn(String title) {
        for (Media media : itemsOrdered) {
            if (media.getTitle().equalsIgnoreCase(title)) {
                return media;
            }
        }
        return null;
    }

    // Sap xep theo Tieu de roi den Gia
    public void sortByTitleCost() {
        Collections.sort(itemsOrdered, Media.COMPARE_BY_TITLE_COST);
        System.out.println("Da sap xep gio hang theo Tieu de -> Gia.");
    }

    // Sap xep theo Gia roi den Tieu de
    public void sortByCostTitle() {
        Collections.sort(itemsOrdered, Media.COMPARE_BY_COST_TITLE);
        System.out.println("Da sap xep gio hang theo Gia -> Tieu de.");
    }

    // Lam trong gio hang sau khi Order
    public void emptyCart() {
        itemsOrdered.clear();
    }

    public ObservableList<Media> getItemsOrdered() {
        return itemsOrdered;
    }
}