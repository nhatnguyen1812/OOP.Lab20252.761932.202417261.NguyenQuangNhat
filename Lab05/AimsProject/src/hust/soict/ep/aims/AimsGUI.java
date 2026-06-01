package hust.soict.ep.aims;

import hust.soict.ep.aims.cart.Cart;
import hust.soict.ep.aims.media.Book;
import hust.soict.ep.aims.media.CompactDisc;
import hust.soict.ep.aims.media.DigitalVideoDisc;
import hust.soict.ep.aims.media.Track;
import hust.soict.ep.aims.store.Store;

import hust.soict.ep.aims.screen.StoreScreen;

public class AimsGUI {
    public static void main(String[] args) {
        Store store = new Store();
        Cart cart = new Cart();

        // Nap san du lieu cua hang (co ca san pham loi de kiem thu)
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        dvd1.setId(1);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Sci-Fi", "George Lucas", 124, 24.95f);
        dvd2.setId(2);
        
        // DVD loi (length = 0) de kiem thu PlayerException
        DigitalVideoDisc dvdError = new DigitalVideoDisc("Aladdin (Error Length)", "Animation", "John Musker", 0, 15.95f);
        dvdError.setId(3);

        CompactDisc cd = new CompactDisc();
        cd.setId(4);
        cd.setTitle("Album Nhac Tre");
        cd.setArtist("MTP");
        cd.setCost(15.5f);
        cd.addTrack(new Track("Track 1", 120));
        cd.addTrack(new Track("Track 2", 150));

        // CD loi de kiem thu CD PlayerException
        CompactDisc cdError = new CompactDisc();
        cdError.setId(5);
        cdError.setTitle("Album Loi (Zero Tracks)");
        cdError.setArtist("Unknow");
        cdError.setCost(5.0f);

        Book book1 = new Book();
        book1.setId(6);
        book1.setTitle("Dac Nhan Tam");
        book1.setCategory("Self-help");
        book1.setCost(10.0f);
        book1.addAuthor("Dale Carnegie");

        Book book2 = new Book();
        book2.setId(7);
        book2.setTitle("OOP Java Lab 05");
        book2.setCategory("Education");
        book2.setCost(5.5f);
        book2.addAuthor("SOICT Professor");

        store.addMedia(dvd1);
        store.addMedia(dvd2);
        store.addMedia(dvdError);
        store.addMedia(cd);
        store.addMedia(cdError);
        store.addMedia(book1);
        store.addMedia(book2);

        // Khoi chay man hinh StoreScreen
        new StoreScreen(store, cart);
    }
}
