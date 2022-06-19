package model.entity;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter

public class Song {

    private Integer id;
    private String name;
    private Integer amount_of_likes;
    private Integer downloaded_amount;
    private Integer streaming;
    private Integer playlist_id;
    private Integer artist_id;

    public Song(Integer id, String name, Integer amount_of_likes, Integer downloaded_amount, Integer streaming, Integer playlist_id, Integer artist_id) {
        this.id = id;
        this.name = name;
        this.amount_of_likes = amount_of_likes;
        this.downloaded_amount = downloaded_amount;
        this.streaming = streaming;
        this.playlist_id = playlist_id;
        this.artist_id = artist_id;
    }

    public Song(String name, Integer amount_of_likes, Integer downloaded_amount, Integer streaming, Integer playlist_id, Integer artist_id) {
        this.name = name;
        this.amount_of_likes = amount_of_likes;
        this.downloaded_amount = downloaded_amount;
        this.streaming = streaming;
        this.playlist_id = playlist_id;
        this.artist_id = artist_id;
    }

    public Song(){}

    @Override
    public String toString() {
        return "\n\nSong: id: " + id + ", name: " + name + ", amount_of_likes: " + amount_of_likes +
                ", downloaded: " + downloaded_amount + ", streaming: " + streaming +
                "playlist_id" + playlist_id + ", artist_id" + artist_id;
    }
}
