package view;

import controller.implementation.*;
import model.entity.*;

import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class View {
    private static final Scanner SCANNER = new Scanner(System.in);
    private final Map<String, Printable> menu = new LinkedHashMap<>();

    private final CountryController countryController = new CountryController();
    private final LibraryController libraryController = new LibraryController();
    private final PlaylistController playlistController = new PlaylistController();
    private final ArtistController artistController = new ArtistController();
    private final SongController songController = new SongController();
    private final UserController userController = new UserController();

    public View() {
        menu.put("11", this::getAllArtists);
        menu.put("12", this::getArtistById);
        menu.put("13", this::createArtist);
        menu.put("14", this::updateArtist);
        menu.put("15", this::deleteArtist);

        menu.put("21", this::getAllCountries);
        menu.put("22", this::getCountryById);
        menu.put("23", this::createCountry);
        menu.put("24", this::updateCountry);
        menu.put("25", this::deleteCountry);

        menu.put("31", this::getAllLibraries);
        menu.put("32", this::getLibraryById);
        menu.put("33", this::createLibrary);
        menu.put("34", this::updateLibrary);
        menu.put("35", this::deleteLibrary);

        menu.put("41", this::getAllPlaylists);
        menu.put("42", this::getPlaylistById);
        menu.put("43", this::createPlaylist);
        menu.put("44", this::updatePlaylist);
        menu.put("45", this::deletePlaylist);

        menu.put("51", this::getAllSongs);
        menu.put("52", this::getSongById);
        menu.put("53", this::createSong);
        menu.put("54", this::updateSong);
        menu.put("55", this::deleteSong);

        menu.put("61", this::getAllUsers);
        menu.put("62", this::getUserById);
        menu.put("63", this::createUser);
        menu.put("64", this::updateUser);
        menu.put("65", this::deleteUser);

    }
    public final void show() {
        String input;
        Menu showMenu = new Menu();
        showMenu.displayMenu();
        System.out.println("\nEnter numbers:\n");
        do {
            try {
                input = SCANNER.next();
                menu.get(input).print();
            } catch (Exception ignored) {
            }
        } while (SCANNER.hasNext());
    }


    private void getAllCountries() throws SQLException {
        System.out.println("\n");
        System.out.println(countryController.findAll() + "\n");
    }

    private void getCountryById() throws SQLException {
        System.out.println("\nEnter id: ");
        Integer id = SCANNER.nextInt();
        System.out.println(countryController.findById(id) + "\n");
    }

    private Country getCountryInputs() {
        System.out.println("\nEnter name: ");
        String name = SCANNER.next();
        System.out.println("\nEnter population: ");
        Integer population = SCANNER.nextInt();
        return new Country(name, population);

    }

    private void createCountry() throws SQLException {
        System.out.println("\n");
        Country country = getCountryInputs();
        countryController.create(country);
        System.out.println("Country was successfully created!\n");
    }

    private void updateCountry() throws SQLException {
        System.out.println("\nEnter Name for updating: ");
        String name = SCANNER.next();
        Country country = getCountryInputs();
        country.setName(name);
        countryController.update(country.getName(), country);
        System.out.println("Updated country with Name = " + name + "\n");
    }

    private void deleteCountry() throws SQLException {
        System.out.println("\nEnter name to delete country: ");
        String name = SCANNER.next();
        countryController.delete(name);
        System.out.println("Deleted country with name = " + name + "\n");
    }


    private void getAllLibraries() throws SQLException {
        System.out.println("\n");
        System.out.println(libraryController.findAll() + "\n");
    }

    private void getLibraryById() throws SQLException {
        System.out.println("\nEnter ID: ");
        Integer id = SCANNER.nextInt();
        System.out.println(libraryController.findById(id) + "\n");
    }

    private Library getLibraryInputs() {
        System.out.println("\nEnter amount of songs: ");
        Integer amount_of_songs = SCANNER.nextInt();
        System.out.println("Enter amount of downloaded songs id: ");
        Integer amount_of_downloaded_songs = SCANNER.nextInt();
        return new Library(amount_of_songs, amount_of_downloaded_songs);
    }

    private void createLibrary() throws SQLException {
        System.out.println("\n");
        Library hotel = getLibraryInputs();
        libraryController.create(hotel);
        System.out.println("Library was successfully created!\n");
    }

    private void updateLibrary() throws SQLException {
        System.out.println("\nEnter ID for updating: ");
        Integer id = SCANNER.nextInt();
        Library library = getLibraryInputs();
        library.setId(id);
        libraryController.update(library.getId(), library);
        System.out.println("Updated library with ID = " + id + "\n");
    }

    private void deleteLibrary() throws SQLException {
        System.out.println("\nEnter ID to delete library: ");
        int id = SCANNER.nextInt();
        libraryController.delete(id);
        System.out.println("Deleted library with ID = " + id + "\n");
    }


    private void getAllPlaylists() throws SQLException {
        System.out.println("\n");
        System.out.println(playlistController.findAll() + "\n");
    }

    private void getPlaylistById() throws SQLException {
        System.out.println("\nEnter ID: ");
        Integer id = SCANNER.nextInt();
        System.out.println(playlistController.findById(id) + "\n");
    }

    private Playlist getPlaylistInputs() {
        System.out.println("\nEnter appointment: ");
        String appointment = SCANNER.next();
        System.out.println("Enter some text: ");
        String about = SCANNER.next();
        System.out.println("Enter amount of songs: ");
        Integer library_id = SCANNER.nextInt();
        return new Playlist(appointment, about, library_id);
    }

    private void createPlaylist() throws SQLException {
        System.out.println("\n");
        Playlist room = getPlaylistInputs();
        playlistController.create(room);
        System.out.println("Playlist was successfully created!\n");
    }

    private void updatePlaylist() throws SQLException {
        System.out.println("\nEnter ID for updating: ");
        Integer id = SCANNER.nextInt();
        Playlist playlist = getPlaylistInputs();
        playlist.setId(id);
        playlistController.update(playlist.getId(), playlist);
        System.out.println("Updated playlist with ID = " + id + "\n");
    }

    private void deletePlaylist() throws SQLException {
        System.out.println("\nEnter ID to delete playlist: ");
        int id = SCANNER.nextInt();
        playlistController.delete(id);
        System.out.println("Deleted playlist with ID = " + id + "\n");
    }


    private void getAllArtists() throws SQLException {
        System.out.println("\n");
        System.out.println(artistController.findAll() + "\n");
    }

    private void getArtistById() throws SQLException {
        System.out.println("\nEnter ID: ");
        Integer id = SCANNER.nextInt();
        System.out.println(artistController.findById(id) + "\n");
    }

    private Artist getArtistInputs() {
        System.out.println("\nEnter name: ");
        String name = SCANNER.next();
        System.out.println("Enter last name: ");
        String  last_name = SCANNER.next();
        System.out.println("Enter age: ");
        Integer age = SCANNER.nextInt();
        System.out.println("Enter amount of albums: ");
        Integer amount_of_albums = SCANNER.nextInt();
        return new Artist(name, last_name, age, amount_of_albums);
    }


    private void createArtist() throws SQLException {
        System.out.println("\n");
        Artist review = getArtistInputs();
        artistController.create(review);
        System.out.println("Artist was successfully created!\n");
    }

    private void updateArtist() throws SQLException {
        System.out.println("\nEnter ID for updating: ");
        Integer id = SCANNER.nextInt();
        Artist artist = getArtistInputs();
        artist.setId(id);
        artistController.update(artist.getId(), artist);
        System.out.println("Updated Artist with ID = " + id + "\n");
    }

    private void deleteArtist() throws SQLException {
        System.out.println("\nEnter ID to delete singer: ");
        int id = SCANNER.nextInt();
        artistController.delete(id);
        System.out.println("Deleted artist with ID = " + id + "\n");
    }


    private void getAllSongs() throws SQLException {
        System.out.println("\n");
        System.out.println(songController.findAll() + "\n");
    }

    private void getSongById() throws SQLException {
        System.out.println("\nEnter ID: ");
        Integer id = SCANNER.nextInt();
        System.out.println(songController.findById(id) + "\n");
    }

    private Song getSongInputs() {
        System.out.println("\nEnter name: ");
        String name = SCANNER.next();
        System.out.println("Enter amount of likes: ");
        Integer amount_of_likes = SCANNER.nextInt();
        System.out.println("Enter downloaded amount: ");
        Integer downloaded_amount = SCANNER.nextInt();
        System.out.println("Enter streaming amount: ");
        Integer streaming = SCANNER.nextInt();
        System.out.println("Enter playlist_id: ");
        Integer playlist_id = SCANNER.nextInt();
        System.out.println("Enter artist id: ");
        Integer artist_id = SCANNER.nextInt();
        return new Song(name, amount_of_likes, downloaded_amount, streaming, playlist_id, artist_id);
    }

    private void createSong() throws SQLException {
        System.out.println("\n");
        Song song = getSongInputs();
        songController.create(song);
        System.out.println("Song was successfully created!\n");
    }

    private void updateSong() throws SQLException {
        System.out.println("\nEnter ID for updating: ");
        Integer id = SCANNER.nextInt();
        Song song = getSongInputs();
        song.setId(id);
        songController.update(song.getId(), song);
        System.out.println("Updated song with ID = " + id + "\n");
    }

    private void deleteSong() throws SQLException {
        System.out.println("\nEnter ID to delete song: ");
        int id = SCANNER.nextInt();
        songController.delete(id);
        System.out.println("Deleted song with ID = " + id + "\n");
    }


    private void getAllUsers() throws SQLException {
        System.out.println("\n");
        System.out.println(userController.findAll() + "\n");
    }

    private void getUserById() throws SQLException {
        System.out.println("\nEnter ID: ");
        Integer id = SCANNER.nextInt();
        System.out.println(userController.findById(id) + "\n");
    }

    private User getUserInputs() {
        System.out.println("\nEnter name: ");
        String name = SCANNER.next();
        System.out.println("Enter last name: ");
        String last_name = SCANNER.next();
        System.out.println("Enter email: ");
        String email = SCANNER.next();
        System.out.println("Enter age: ");
        Integer age = SCANNER.nextInt();
        System.out.println("Enter country id: ");
        Integer country_id = SCANNER.nextInt();
        System.out.println("Enter library id: ");
        Integer library_id = SCANNER.nextInt();
        return new User(name, last_name, email, age, country_id, library_id);
    }


    private void createUser() throws SQLException {
        System.out.println("\n");
        User user = getUserInputs();
        userController.create(user);
        System.out.println("User was successfully created!\n");
    }

    private void updateUser() throws SQLException {
        System.out.println("\nEnter ID for updating: ");
        Integer id = SCANNER.nextInt();
        User user = getUserInputs();
        user.setId(id);
        userController.update(user.getId(), user);
        System.out.println("Updated user with ID = " + id + "\n");
    }

    private void deleteUser() throws SQLException {
        System.out.println("\nEnter ID to delete user: ");
        int id = SCANNER.nextInt();
        userController.delete(id);
        System.out.println("Deleted user with ID = " + id + "\n");
    }
}
