package hust.soict.ep.test.cart;
import hust.soict.ep.aims.cart.Cart;
import hust.soict.ep.aims.disc.DigitalVideoDisc;

public class CartTest {
    public static void main(String[] args) {
        Cart cart = new Cart();

        // Tạo các đĩa DVD
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladdin", "Animation", 18.99f);

        // Thêm đĩa vào giỏ
        cart.addDigitalVideoDisc(dvd1, dvd2, dvd3);
        cart.print();

        // Hàm search
        System.out.println("\n--- Thử nghiệm tìm kiếm ---");
        cart.search(1);      // Tìm theo ID 1
        cart.search(10);     // Tìm ID không tồn tại
        cart.search("Star Wars"); // Tìm theo tên
    }
}