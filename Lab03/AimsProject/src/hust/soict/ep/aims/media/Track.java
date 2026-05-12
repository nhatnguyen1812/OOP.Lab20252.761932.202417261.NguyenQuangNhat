package hust.soict.ep.aims.media;

public class Track implements Playable {
    private String title;
    private int length;

    public Track() {
    }

    public Track(String title, int length) {
        this.title = title;
        this.length = length;
    }

    public String getTitle() {
        return title;
    }

    public int getLength() {
        return length;
    }

    @Override
    public void play() {
        if (this.getLength() > 0) {
            System.out.println("Playing track: " + this.getTitle());
            System.out.println("Track length: " + this.getLength());
        } else {
            System.out.println("Cannot play track: " + this.getTitle() + " because its length is 0 or less.");
        }
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Track)) {
            return false;
        }
        Track other = (Track) obj;
        // So sanh title va length
        return this.title != null &&
                this.title.equals(other.getTitle()) &&
                this.length == other.getLength();
    }
}