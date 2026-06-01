package hust.soict.ep.aims.media;

import java.util.ArrayList;
import java.util.List;

// Book nhan Media lam cha
public class Book extends Media {
    private List<String> authors = new ArrayList<String>();

    public Book() {
    }
    // Them tac gia
    public void addAuthor(String authorName) {
        if (!authors.contains(authorName)) {
            authors.add(authorName);
            System.out.println("Da them tac gia: " + authorName);
        } else {
            System.out.println("Tac gia " + authorName + " da ton tai!");
        }
    }
    // Xoa tac gia
    public void removeAuthor(String authorName) {
        if (authors.contains(authorName)) {
            authors.remove(authorName);
            System.out.println("Da xoa tac gia: " + authorName);
        } else {
            System.out.println("Khong tim thay tac gia " + authorName + " de xoa!");
        }
    }
    @Override
    public String toString() {
        return "Book - " + this.getTitle() + " - " + this.getCategory() + " - " + this.getCost() + " $";
    }
}