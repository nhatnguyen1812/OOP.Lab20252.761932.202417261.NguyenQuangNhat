package hust.soict.ep.test.cart;

import hust.soict.ep.aims.cart.Cart;
import hust.soict.ep.aims.media.DigitalVideoDisc;

public class CartTest {
    public static void main(String[] args) {
        Cart cart = new Cart();

        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladdin", "Animation", 18.99f);
        cart.addMedia(dvd1);
        cart.addMedia(dvd2);
        cart.addMedia(dvd3);

        // Code Lab cũ:
        // cart.print();

        // System.out.println("\n--- Thử nghiệm tìm kiếm ---");
        // cart.search(1);      // Tìm theo ID 1
        // cart.search(10);     // Tìm ID không tồn tại
        // cart.search("Star Wars"); // Tìm theo tên
    }
}