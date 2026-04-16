package hust.soict.ep.aims.store;
import hust.soict.ep.aims.disc.DigitalVideoDisc;

public class Store {
    private DigitalVideoDisc itemsInStore[] = new DigitalVideoDisc[100];
    private int qtyInStore = 0;

    // Phương thức thêm đĩa vào kho
    public void addDVD(DigitalVideoDisc dvd) {
        if (qtyInStore < itemsInStore.length) {
            itemsInStore[qtyInStore] = dvd;
            qtyInStore++;
            System.out.println("Đã thêm đĩa vào kho: " + dvd.getTitle());
        } else {
            System.out.println("Kho đã đầy, không thể thêm đĩa!");
        }
    }

    // Phương thức xóa đĩa khỏi kho
    public void removeDVD(DigitalVideoDisc dvd) {
        boolean found = false;
        for (int i = 0; i < qtyInStore; i++) {
            if (itemsInStore[i].equals(dvd)) {
                // Đẩy các đĩa phía sau lên trước
                for (int j = i; j < qtyInStore - 1; j++) {
                    itemsInStore[j] = itemsInStore[j + 1];
                }
                itemsInStore[qtyInStore - 1] = null;
                qtyInStore--;
                found = true;
                System.out.println("Đã xóa đĩa khỏi kho: " + dvd.getTitle());
                break;
            }
        }
        if (!found) {
            System.out.println("Không tìm thấy đĩa này trong kho!");
        }
    }
}