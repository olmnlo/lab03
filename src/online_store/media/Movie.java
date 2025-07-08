package online_store.media;

import online_store.user.User;

import java.util.ArrayList;
import java.util.List;

public class Movie extends Media{
    private int duration;

    public Movie(String title, String auteur, String ISBN, double price, int duration) {
        super(title, auteur, ISBN, price);
        this.duration = duration;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) throws RuntimeException {
        if (duration < 0){
            throw new RuntimeException("you cannot enter negative duration");
        }
        this.duration = duration;
    }

    public void watch(User user){
        user.addToPurchaseCart(new Movie(getTitle(),getAuteur(), getISBN(), getPrice(),getDuration()));
    }

    public ArrayList<Movie> recommendSimilarMovie(ArrayList<Movie> movieCatalog){
        ArrayList<Movie> recommendations = new ArrayList<>();
        for (Movie movie : movieCatalog) {
            if (!movie.getTitle().equals(this.getTitle()) && movie.getAuteur().equals(this.getAuteur())) {
                recommendations.add(movie);
            }
        }
        return recommendations;
    }

    public List<Movie> movieCatalog(){

        return null;
    }

    @Override
    public String getMediaType() {
        if (duration >= 120){
            return "long movie";
        }else {
            return "Movie";
        }
    }

    @Override
    public String toString() {
        return "Movie{" +
                "title="+getTitle()+
                ", auteur="+getAuteur()+
                ", duration=" + duration +
                '}'+"\n";
    }
}
