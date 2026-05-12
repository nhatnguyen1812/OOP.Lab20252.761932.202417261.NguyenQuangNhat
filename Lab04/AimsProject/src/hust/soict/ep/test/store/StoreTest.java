package hust.soict.ep.test.store;

import hust.soict.ep.aims.media.DigitalVideoDisc;
import hust.soict.ep.aims.store.Store;

public class StoreTest {
    public static void main(String[] args) {
        Store store = new Store();
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King");
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars");

        store.addMedia(dvd1);
        store.addMedia(dvd2);

        store.removeMedia(dvd1);
    }
}