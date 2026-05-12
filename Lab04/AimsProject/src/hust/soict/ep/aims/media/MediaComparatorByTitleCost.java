package hust.soict.ep.aims.media;

import java.util.Comparator;

public class MediaComparatorByTitleCost implements Comparator<Media> {
    @Override
    public int compare(Media m1, Media m2) {
        // So sanh theo tieu de
        int titleComparison = m1.getTitle().compareTo(m2.getTitle());
        if (titleComparison != 0) {
            return titleComparison;
        } else {
            // Tieu de giong thi so gia
            return Float.compare(m2.getCost(), m1.getCost());
        }
    }
}