package hust.soict.ep.aims;

import hust.soict.ep.aims.cart.Cart;
import hust.soict.ep.aims.disc.DigitalVideoDisc;

public class Aims {
    public static void main(String[] args) {
        Cart anOrder = new Cart();
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King",
                "Animation", "Roger Allers", 87, 19.95f);
        anOrder.addDigitalVideoDisc(dvd1);

        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars",
                "Science Fiction", "George Lucas", 87, 24.95f);
        anOrder.addDigitalVideoDisc(dvd2);

        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin",
                "Animation", 18.99f);
        anOrder.addDigitalVideoDisc(dvd3);

        System.out.println("hust.soict.ep.aims.cart.Cart before removing item:");
        anOrder.displayCart();

        anOrder.removeDigitalVideoDisc(dvd2);

        System.out.println("\nhust.soict.ep.aims.cart.Cart after removing item:");
        anOrder.displayCart();
    }
}
