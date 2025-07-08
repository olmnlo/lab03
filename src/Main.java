import online_store.media.Media;
import online_store.media.Movie;
import online_store.media.Music;
import online_store.media.book.AcademicBook;
import online_store.media.book.Book;
import online_store.media.book.Novel;
import online_store.review.Review;
import online_store.store.Store;
import online_store.user.User;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // Create users
        User user1 = new User("Hussam", "hussam@gmail.com", new ArrayList<>(), new ArrayList<>());
        User user2 = new User("Sara", "sara@gmail.com", new ArrayList<>(), new ArrayList<>());

        // Create reviews
        Review r1 = new Review("Hussam", 5, "Excellent read!");
        Review r2 = new Review("Sara", 4, "Very informative.");

        // Create books and add reviews
        Book b1 = new Book("Effective Java", "Joshua Bloch", "123ABC", 39.99, 5, new ArrayList<>());
        b1.addReview(r1);
        b1.addReview(r2);

        // Create novel
        Novel n1 = new Novel("The Alchemist", "Paulo Coelho", "456DEF", 29.99, 3, new ArrayList<>(), "Adventure");
        n1.addReview(new Review("Sara", 5, "Beautiful story!"));

        // Create academic book
        AcademicBook ab1 = new AcademicBook("Algorithms", "CLRS", "789GHI", 49.99, 6, new ArrayList<>(), "Computer Science");

        // Create movies
        Movie m1 = new Movie("Inception", "Christopher Nolan", "MOV123", 14.99, 148);
        Movie m2 = new Movie("Interstellar", "Christopher Nolan", "MOV789", 13.99, 169);
        Movie m3 = new Movie("Pulp Fiction", "Quentin Tarantino", "MOV456", 12.50, 154);

        // Create music
        Music music1 = new Music("Thriller", "Michael Jackson", "MUS456", 11.99, "Michael Jackson");
        Music music2 = new Music("Beat It", "Michael Jackson", "MUS999", 9.99, "Michael Jackson");

        // Create store and add users and media
        Store store = new Store(new ArrayList<>(), new ArrayList<>());
        store.addUser(user1);
        store.addUser(user2);
        store.addMedia(b1);
        store.addMedia(n1);
        store.addMedia(ab1);
        store.addMedia(m1);
        store.addMedia(m2);
        store.addMedia(m3);
        store.addMedia(music1);
        store.addMedia(music2);

        // Display media
        System.out.println(store.displayMedia());

        // User1 adds items to cart and checkout
        user1.addToCart(b1);
        user1.addToCart(m1);
        user1.addToCart(music1);
        user1.checkout();

        // Check media type and average rating
        System.out.println(b1.getMediaType() + " | Avg Rating: " + b1.getAverageRating());
        System.out.println(n1.getMediaType() + " | Avg Rating: " + n1.getAverageRating());
        System.out.println(ab1.getMediaType());

        // Movie recommendations
        ArrayList<Movie> catalogMovie = new ArrayList<>();
        catalogMovie.add(m1);
        catalogMovie.add(m2);
        catalogMovie.add(m3);
        ArrayList<Movie> recommended = m1.recommendSimilarMovie(catalogMovie);
        System.out.println("Recommended movies:");
        for (Movie m : recommended) {
            System.out.println(m);
        }

        // Generate playlist
        ArrayList<Music> musicCatalog = new ArrayList<>();
        musicCatalog.add(music1);
        musicCatalog.add(music2);
        System.out.println("Generated playlist:");
        System.out.println(music1.generatePlayList(musicCatalog));

        // More Review testing
        try {
            Review badReview = new Review("Ali", 11, "Should fail");  // will throw
        } catch (RuntimeException e) {
            System.out.println("Caught expected exception: " + e.getMessage());
        }

        Review r = new Review("Omar", 8, "Nice!");
        System.out.println(r);  // test toString()
        r.setRating(10);        // test setter
        r.setComment("Perfect");
        System.out.println("Updated: " + r.getRating() + " - " + r.getComment());

        // More Store testing
        store.addUser(user1); // Duplicate user
        store.addMedia(b1);   // Duplicate media

        System.out.println("Users:");
        for (User u : store.displayUsers()) {
            System.out.println(u.getUsername());
        }

        store.searchBook("Nonexistent Book");
        System.out.println(store);

        // More Media testing
        try {
            Media test = new Media("Broken Media", "Someone", "ISBN999", -50.0);
        } catch (RuntimeException e) {
            System.out.println("Caught expected price error: " + e.getMessage());
        }

        Media media = new Media("Generic Title", "Anon", "GEN123", 19.99);
        System.out.println("Type: " + media.getMediaType());
        System.out.println(media);

        media.setPrice(25.00);
        media.setTitle("Updated Title");
        System.out.println("Updated Media: " + media.getTitle() + " - $" + media.getPrice());

        // More Music testing
        Music premium = new Music("Premium Track", "Artist A", "PRE123", 15.0, "Artist A");
        Music normal = new Music("Basic Track", "Artist B", "BAS123", 8.0, "Artist B");

        System.out.println(premium.getMediaType()); // Premium music
        System.out.println(normal.getMediaType());  // Music

        ArrayList<Music> emptyPlaylist = new ArrayList<>();
        emptyPlaylist.add(normal);
        ArrayList<Music> result = premium.generatePlayList(emptyPlaylist);
        System.out.println("Generated Playlist Size: " + result.size()); // Should be 0

        // More Book testing
        b1.reStock(5);
        System.out.println("Stock after restock: " + b1.getStock());

        b1.purchase(user1, b1);
        System.out.println("User purchases: " + user1.getPurchase_media_list().size());
        System.out.println("Stock after purchase: " + b1.getStock());

        b1.setStock(0);
        b1.purchase(user1, b1); // Should print: "you cannot purchase this book"

        for (Review rev : b1.getListOfReviews()) {
            System.out.println(rev);
        }

        // More AcademicBook testing
        AcademicBook ab = new AcademicBook("Math Logic", "Dr. Turing", "LOG123", 39.99, 3, new ArrayList<>(), "Mathematics");
        System.out.println("Subject: " + ab.getSubject());
        ab.setSubject("Discrete Math");
        System.out.println("Updated subject: " + ab.getSubject());

        ab.addReview(new Review("Alice", 5, "Great"));
        ab.addReview(new Review("Bob", 5, "Fantastic"));

        System.out.println("Media Type: " + ab.getMediaType());
        System.out.println(ab);

        // More Movie testing
        System.out.println(m1.getMediaType());  // "long movie"

        System.out.println("Recommended movies:");
        for (Movie m : recommended) {
            System.out.println(m);
        }

        User testUser = new User("TestUser", "test@test.com", new ArrayList<>(), new ArrayList<>());
        m1.watch(testUser);
        System.out.println("User purchased media size: " + testUser.getPurchase_media_list().size());

        try {
            m1.setDuration(-10);
        } catch (RuntimeException e) {
            System.out.println("Caught expected error: " + e.getMessage());
        }

        //more Novel testing
        Novel novel = new Novel("Dune", "Frank Herbert", "ISBN1234", 35.99, 4, new ArrayList<>(), "Science Fiction");
        System.out.println("Genre: " + novel.getGenre());
        novel.setGenre("Sci-Fi");
        System.out.println("Updated Genre: " + novel.getGenre());

        novel.addReview(new Review("Reader1", 5, "Amazing story!"));
        novel.addReview(new Review("Reader2", 4, "Great read."));

        System.out.println(novel.getMediaType());  // Should print "Bestselling Novel" because avg rating >= 4.5
        System.out.println(novel);


    }
}
