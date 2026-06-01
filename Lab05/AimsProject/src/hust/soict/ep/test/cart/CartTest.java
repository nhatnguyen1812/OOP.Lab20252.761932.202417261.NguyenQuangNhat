package hust.soict.ep.test.cart;

import hust.soict.ep.aims.cart.Cart;
import hust.soict.ep.aims.media.DigitalVideoDisc;

public class CartTest {
    public static void main(String[] args) throws Exception {
        Cart cart = new Cart();

        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladdin", "Animation", 18.99f);
        cart.addMedia(dvd1);
        cart.addMedia(dvd2);
        cart.addMedia(dvd3);

        // Code Lab cu:
        // cart.print();

        // System.out.println("\n--- Thu nghiem tim kiem ---");
        // cart.search(1);      // Tim theo ID 1
        // cart.search(10);     // Tim ID khong ton tai
        // cart.search("Star Wars"); // Tim theo ten
    }
}