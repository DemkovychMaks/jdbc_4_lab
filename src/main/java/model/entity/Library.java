package model.entity;

import lombok.*;

@Getter
@Setter


public class Library {

    private Integer id;
    private Integer amount_of_songs;
    private Integer amount_of_downloaded_songs;

    public Library(Integer id, Integer amount_of_songs, Integer amount_of_downloaded_songs) {
        this.id = id;
        this.amount_of_songs = amount_of_songs;
        this.amount_of_downloaded_songs = amount_of_downloaded_songs;
    }

    public Library(Integer amount_of_songs, Integer amount_of_downloaded_songs) {
        this.amount_of_songs = amount_of_songs;
        this.amount_of_downloaded_songs = amount_of_downloaded_songs;
    }

    public Library(){}
    @Override
    public String toString() {
        return "\n\nAlbum: id: " + id + ", amount_of_liked_songs: " + amount_of_songs + ", amount_of_downloaded_songs: " + amount_of_downloaded_songs;
    }
}