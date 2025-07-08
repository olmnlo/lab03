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
        // ===== Users =====
        User user1 = new User("Hussam", "hussam@gmail.com", new ArrayList<>(), new ArrayList<>());
        User user2 = new User("Sara", "sara@gmail.com", new ArrayList<>(), new ArrayList<>());
        User user3 = new User("Ali", "ali@gmail.com", new ArrayList<>(), new ArrayList<>());
        User user4 = new User("Omar", "omar@gmail.com", new ArrayList<>(), new ArrayList<>());
        User user5 = new User("Lina", "lina@gmail.com", new ArrayList<>(), new ArrayList<>());

        // ===== Reviews =====
        Review r1 = new Review(user1.getUsername(), 5, "Excellent read!");
        Review r2 = new Review(user2.getUsername(), 4, "Very informative.");
        Review r3 = new Review(user3.getUsername(), 3, "Okay book.");
        Review r4 = new Review(user4.getUsername(), 5, "Loved it!");
        Review r5 = new Review(user5.getUsername(), 4, "Good but a bit long.");

        // ===== Books =====
        Book b1 = new Book("Effective Java", "Joshua Bloch", "123ABC", 39.99, 5, new ArrayList<>());
        b1.addReview(r1);
        b1.addReview(r2);
        b1.addReview(r3);
        b1.addReview(r4);
        b1.addReview(r5);

        b1.reStock(5);
        System.out.println("Stock after restock: " + b1.getStock());

        b1.purchase(user1, b1);
        System.out.println("User purchases: " + user1.getPurchase_media_list().size());
        System.out.println("Stock after purchase: " + b1.getStock());

        b1.setStock(0);
        b1.purchase(user1, b1); // Should print: cannot purchase

        for (Review rev : b1.getListOfReviews()){
            System.out.println(rev);
        }

        System.out.println(b1.getMediaType() + " | Avg Rating: " + b1.getAverageRating());

        // ===== Novel =====
        Novel novel = new Novel("Dune", "Frank Herbert", "ISBN1234", 35.99, 4, new ArrayList<>(), "Science Fiction");
        novel.setGenre("Sci-Fi");
        novel.addReview(new Review("Reader1", 5, "Amazing story!"));
        novel.addReview(new Review("Reader2", 4, "Great read."));
        novel.addReview(new Review("Reader3", 5, "Epic!"));
        novel.addReview(new Review("Reader4", 5, "Masterpiece."));
        novel.addReview(new Review("Reader5", 5, "Best ever."));

        System.out.println(novel.getMediaType());
        System.out.println(novel);

        // ===== AcademicBook =====
        AcademicBook ab1 = new AcademicBook("Algorithms", "CLRS", "789GHI", 49.99, 6, new ArrayList<>(), "CS");
        ab1.addReview(new Review("Alice", 5, "Great"));
        ab1.addReview(new Review("Bob", 5, "Fantastic"));
        ab1.addReview(new Review("Carol", 5, "Very useful"));
        ab1.addReview(new Review("Dave", 4, "Dense"));
        ab1.addReview(new Review("Eve", 4, "Challenging"));

        System.out.println(ab1.getMediaType());
        System.out.println(ab1);

        // ===== Movies =====
        Movie m1 = new Movie("Inception", "Christopher Nolan", "MOV123", 14.99, 148);
        Movie m2 = new Movie("Interstellar", "Christopher Nolan", "MOV789", 13.99, 169);
        Movie m3 = new Movie("Pulp Fiction", "Quentin Tarantino", "MOV456", 12.50, 154);
        Movie m4 = new Movie("Tenet", "Christopher Nolan", "MOV321", 15.99, 150);
        Movie m5 = new Movie("The Hateful Eight", "Quentin Tarantino", "MOV654", 10.99, 167);

        ArrayList<Movie> movieCatalog = new ArrayList<>();
        movieCatalog.add(m1); movieCatalog.add(m2); movieCatalog.add(m3); movieCatalog.add(m4); movieCatalog.add(m5);

        ArrayList<Movie> recommended = m1.recommendSimilarMovie(movieCatalog);
        for (Movie m : recommended) System.out.println(m);

        m1.watch(user2);
        System.out.println("User purchased media size: " + user2.getPurchase_media_list().size());

        // ===== Music =====
        Music music1 = new Music("Thriller", "Michael Jackson", "MUS456", 11.99, "Michael Jackson");
        Music music2 = new Music("Beat It", "Michael Jackson", "MUS999", 9.99, "Michael Jackson");
        Music music3 = new Music("Billie Jean", "Michael Jackson", "MUS100", 12.99, "Michael Jackson");
        Music music4 = new Music("Smooth Criminal", "Michael Jackson", "MUS101", 7.99, "Michael Jackson");
        Music music5 = new Music("Black or White", "Michael Jackson", "MUS102", 10.01, "Michael Jackson");

        ArrayList<Music> musicCatalog = new ArrayList<>();
        musicCatalog.add(music1); musicCatalog.add(music2); musicCatalog.add(music3); musicCatalog.add(music4); musicCatalog.add(music5);

        System.out.println(music1.generatePlayList(musicCatalog));
        System.out.println(music5.getMediaType());

        // ===== Store =====
        Store store = new Store(new ArrayList<>(), new ArrayList<>());
        store.addUser(user1);
        store.addUser(user2);
        store.addUser(user3);
        store.addUser(user4);
        store.addUser(user5);

        store.addMedia(b1);
        store.addMedia(novel);
        store.addMedia(ab1);
        store.addMedia(m1);
        store.addMedia(m2);
        store.addMedia(m3);
        store.addMedia(m4);
        store.addMedia(m5);
        store.addMedia(music1);
        store.addMedia(music2);
        store.addMedia(music3);
        store.addMedia(music4);
        store.addMedia(music5);

        for (User u : store.displayUsers()) {
            System.out.println(u.getUsername());
        }

        System.out.println(store.searchBook("Some Unknown Book"));

        // ===== Error Tests =====
        try {
            new Review("Bad", 11, "Out of range");
        } catch (RuntimeException e) {
            System.out.println("Caught expected rating error: " + e.getMessage());
        }

        try {
            new Media("Bad Media", "Author", "BAD123", -20);
        } catch (RuntimeException e) {
            System.out.println("Caught expected price error: " + e.getMessage());
        }

        try {
            m1.setDuration(-5);
        } catch (RuntimeException e) {
            System.out.println("Caught expected duration error: " + e.getMessage());
        }
    }
}
