package hust.soict.ep.aims;

import hust.soict.ep.aims.cart.Cart;
import hust.soict.ep.aims.media.Book;
import hust.soict.ep.aims.media.CompactDisc;
import hust.soict.ep.aims.media.DigitalVideoDisc;
import hust.soict.ep.aims.media.Media;
import hust.soict.ep.aims.media.Playable;
import hust.soict.ep.aims.store.Store;

import java.util.Scanner;
import java.util.Collections;

public class Aims {
    private static Store store = new Store();
    private static Cart cart = new Cart();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        initSetup();
        boolean exit = false;

        while (!exit) {
            showMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    viewStore();
                    break;
                case 2:
                    updateStore();
                    break;
                case 3:
                    seeCurrentCart();
                    break;
                case 0:
                    exit = true;
                    System.out.println("Tam biet! Hen gap lai.");
                    break;
                default:
                    System.out.println("Lua chon khong hop le. Vui long chon lai!");
            }
        }
        scanner.close();
    }

    private static void initSetup() {
        DigitalVideoDisc dvd = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        CompactDisc cd = new CompactDisc();
        cd.setTitle("Album Nhac Tre");
        cd.setCost(15.5f);
        Book book = new Book();
        book.setTitle("Dac Nhan Tam");
        book.setCost(10.0f);

        store.addMedia(dvd);
        store.addMedia(cd);
        store.addMedia(book);
    }

    public static void showMenu() {
        System.out.println("\nAIMS: ");
        System.out.println("--------------------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3");
    }

    public static void storeMenu() {
        System.out.println("\nOptions: ");
        System.out.println("--------------------------------");
        System.out.println("1. See a media's details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current cart");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4");
    }

    public static void mediaDetailsMenu() {
        System.out.println("\nOptions: ");
        System.out.println("--------------------------------");
        System.out.println("1. Add to cart");
        System.out.println("2. Play");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2");
    }

    public static void cartMenu() {
        System.out.println("\nOptions: ");
        System.out.println("--------------------------------");
        System.out.println("1. Filter medias in cart");
        System.out.println("2. Sort medias in cart");
        System.out.println("3. Remove media from cart");
        System.out.println("4. Play a media");
        System.out.println("5. Place order");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4-5");
    }

    private static void viewStore() {
        boolean back = false;
        while (!back) {
            System.out.println("\n--- CUA HANG ---");
            // Hiển thị danh sách cửa hàng
            store.printStore();
            storeMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Nhap ten Media ban muon xem chi tiet: ");
                    String titleDetails = scanner.nextLine();
                    Media mediaDetails = store.searchByTitle(titleDetails);
                    if (mediaDetails != null) {
                        System.out.println(mediaDetails.toString());
                        boolean backDetails = false;
                        while (!backDetails) {
                            mediaDetailsMenu();
                            int detailsChoice = scanner.nextInt();
                            scanner.nextLine();
                            switch (detailsChoice) {
                                case 1:
                                    cart.addMedia(mediaDetails);
                                    break;
                                case 2:
                                    if (mediaDetails instanceof Playable) {
                                        ((Playable) mediaDetails).play();
                                    } else {
                                        System.out.println("San pham nay khong the phat (Play)!");
                                    }
                                    break;
                                case 0:
                                    backDetails = true;
                                    break;
                                default:
                                    System.out.println("Khong hop le!");
                            }
                        }
                    } else {
                        System.out.println("Khong tim thay san pham!");
                    }
                    break;
                case 2:
                    System.out.println("Nhap ten Media muon them vao gio:");
                    String titleAdd = scanner.nextLine();
                    Media mediaAdd = store.searchByTitle(titleAdd);
                    if (mediaAdd != null) {
                        cart.addMedia(mediaAdd);
                        System.out.println("So luong san pham trong gio: " + cart.getSize());
                    } else {
                        System.out.println("Khong tim thay san pham!");
                    }
                    break;
                case 3:
                    System.out.println("Nhap ten Media muon Play:");
                    String titlePlay = scanner.nextLine();
                    Media mediaPlay = store.searchByTitle(titlePlay);
                    if (mediaPlay != null) {
                        if (mediaPlay instanceof Playable) {
                            ((Playable) mediaPlay).play();
                        } else {
                            System.out.println("San pham nay khong the phat (Play)!");
                        }
                    } else {
                        System.out.println("Khong tim thay san pham!");
                    }
                    break;
                case 4:
                    seeCurrentCart();
                    break;
                case 0:
                    back = true;
                    break;
                default:
                    System.out.println("Lua chon khong hop le!");
            }
        }
    }

    private static void updateStore() {
        System.out.println("\n1. Them Media vao cua hang");
        System.out.println("2. Xoa Media khoi cua hang");
        System.out.println("0. Quay lai");
        int choice = scanner.nextInt();
        scanner.nextLine();

        if (choice == 1) {
            System.out.println("Tinh nang nhap lieu moi dang duoc phat trien (De nhanh, co the test voi bien khoi tao san).");
        } else if (choice == 2) {
            System.out.println("Nhap ten Media muon xoa:");
            String titleRemove = scanner.nextLine();
            Media mediaRemove = store.searchByTitle(titleRemove);
            if (mediaRemove != null) {
                store.removeMedia(mediaRemove);
            } else {
                System.out.println("Khong tim thay san pham de xoa!");
            }
        }
    }

    private static void seeCurrentCart() {
        boolean back = false;
        while (!back) {
            System.out.println("\n--- GIO HANG CUA BAN ---");
            cart.printCart();
            System.out.println("Tong tien: " + cart.totalCost() + " $");
            cartMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("1. Loc theo ID | 2. Loc theo Tieu de");
                    int filterChoice = scanner.nextInt();
                    scanner.nextLine();
                    if (filterChoice == 1) {
                        System.out.println("Nhap ID:");
                        int id = scanner.nextInt();
                        cart.searchById(id);
                    } else {
                        System.out.println("Nhap Tieu de:");
                        String title = scanner.nextLine();
                        cart.searchByTitle(title);
                    }
                    break;
                case 2:
                    System.out.println("1. Sap xep theo Tieu de | 2. Sap xep theo Gia");
                    int sortChoice = scanner.nextInt();
                    if (sortChoice == 1) {
                        cart.sortByTitleCost();
                    } else {
                        cart.sortByCostTitle();
                    }
                    break;
                case 3:
                    System.out.println("Nhap ten Media muon xoa khoi gio:");
                    String titleRemove = scanner.nextLine();
                    Media mediaRemove = cart.searchByTitleReturn(titleRemove);
                    if (mediaRemove != null) {
                        cart.removeMedia(mediaRemove);
                    } else {
                        System.out.println("Khong tim thay san pham!");
                    }
                    break;
                case 4:
                    System.out.println("Nhap ten Media trong gio muon Play:");
                    String titlePlay = scanner.nextLine();
                    Media mediaPlay = cart.searchByTitleReturn(titlePlay);
                    if (mediaPlay != null) {
                        if (mediaPlay instanceof Playable) {
                            ((Playable) mediaPlay).play();
                        } else {
                            System.out.println("San pham nay khong the phat (Play)!");
                        }
                    } else {
                        System.out.println("Khong tim thay san pham!");
                    }
                    break;
                case 5:
                    System.out.println("Don hang cua ban da duoc tao thanh cong! Gio hang da duoc lam trong.");
                    cart.emptyCart();
                    back = true;
                    break;
                case 0:
                    back = true;
                    break;
                default:
                    System.out.println("Lua chon khong hop le!");
            }
        }
    }
}