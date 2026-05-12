package hust.soict.ep.aims.cart;

import hust.soict.ep.aims.media.Media;
import java.util.ArrayList;
import java.util.Collections; // Import thêm thư viện này để dùng chức năng Sort

public class Cart {
    private ArrayList<Media> itemsOrdered = new ArrayList<Media>();

    public void addMedia(Media media) {
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

    // Lấy số lượng sản phẩm trong giỏ
    public int getSize() {
        return itemsOrdered.size();
    }

    // In danh sách giỏ hàng
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

    // Tìm kiếm để in ra theo ID
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

    // Tìm kiếm để in ra theo Tên
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

    // Tìm kiếm và trả về Object cho Menu xử lý Play hoặc Remove
    public Media searchByTitleReturn(String title) {
        for (Media media : itemsOrdered) {
            if (media.getTitle().equalsIgnoreCase(title)) {
                return media;
            }
        }
        return null;
    }

    // Sắp xếp theo Tiêu đề rồi đến Giá
    public void sortByTitleCost() {
        Collections.sort(itemsOrdered, Media.COMPARE_BY_TITLE_COST);
        System.out.println("Da sap xep gio hang theo Tieu de -> Gia.");
    }

    // Sắp xếp theo Giá rồi đến Tiêu đề
    public void sortByCostTitle() {
        Collections.sort(itemsOrdered, Media.COMPARE_BY_COST_TITLE);
        System.out.println("Da sap xep gio hang theo Gia -> Tieu de.");
    }

    // Làm trống giỏ hàng sau khi Order
    public void emptyCart() {
        itemsOrdered.clear();
    }
}