package hust.soict.ep.aims.media;

import hust.soict.ep.aims.exception.PlayerException;

public interface Playable {
    public void play() throws PlayerException;
}