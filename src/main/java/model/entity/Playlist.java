package model.entity;

import lombok.Getter;
import lombok.Setter;

import java.sql.Time;

@Getter
@Setter

public class Playlist {

    private Integer id;
    private String appointment;
    private String about;
    private Integer library_id;

    public Playlist(Integer id, String appointment, String about, Integer library_id) {
        this.id = id;
        this.appointment = appointment;
        this.about = about;
        this.library_id = library_id;
    }

    public Playlist(String appointment, String about, Integer library_id) {
        this.appointment = appointment;
        this.about = about;
        this.library_id = library_id;
    }

    public Playlist() {
    }

    @Override
    public String toString() {
        return "\n\nPlaylist: id: " + id + ", appointment: " + appointment + ", about: " + about +
                ", library id: " + library_id; }
}