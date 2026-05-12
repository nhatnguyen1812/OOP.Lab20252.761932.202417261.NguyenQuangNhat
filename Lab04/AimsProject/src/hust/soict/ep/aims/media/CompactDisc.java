package hust.soict.ep.aims.media;

import java.util.ArrayList;

public class CompactDisc extends Disc implements Playable {
    private String artist;
    private ArrayList<Track> tracks = new ArrayList<Track>();

    public CompactDisc() {
        super();
    }

    public String getArtist() {
        return artist;
    }

    public void addTrack(Track track) {
        if (!tracks.contains(track)) {
            tracks.add(track);
            System.out.println("Da them track: " + track.getTitle());
        } else {
            System.out.println("Track " + track.getTitle() + " da ton tai trong CD!");
        }
    }

    public void removeTrack(Track track) {
        if (tracks.contains(track)) {
            tracks.remove(track);
            System.out.println("Da xoa track: " + track.getTitle());
        } else {
            System.out.println("Khong tim thay track " + track.getTitle() + " de xoa!");
        }
    }

    @Override
    public int getLength() {
        int totalLength = 0;
        for (Track track : tracks) {
            totalLength += track.getLength();
        }
        return totalLength;
    }

    // Ham play() cho dia CD
    @Override
    public void play() {
        if (this.getLength() > 0) {
            System.out.println("Playing CD: " + this.getTitle());
            System.out.println("CD length: " + this.getLength());
            for (Track track : tracks) {
                track.play();
            }
        } else {
            System.out.println("Cannot play CD: " + this.getTitle() + " because its length is 0 or less.");
        }
    }
    @Override
    public String toString() {
        return "CD - " + this.getTitle() + " - " + this.getArtist() + " - " + this.getLength() + ": " + this.getCost() + " $";
    }
}