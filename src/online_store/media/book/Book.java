package online_store.media.book;

import online_store.media.Media;
import online_store.review.Review;
import online_store.user.User;

import java.util.ArrayList;

public class Book extends Media {
    private int stock;
    private ArrayList<Review> review;

    public Book(String title, String auteur, String ISBN, double price, int stock, ArrayList<Review> review) {
        super(title, auteur, ISBN, price);
        this.stock = stock;
        this.review = review;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public ArrayList<Review> getReview() {
        return review;
    }

    public void setReview(ArrayList<Review> review) {
        this.review = review;
    }

    public void addReview(Review r){
        review.add(r);
        System.out.println("thank you for your review");
    }

    public ArrayList<Review> getListOfReviews(){
        return review;
    }

    public double getAverageRating(){
        int total = 0;
        for (Review r : review){
            total+=r.getRating();
        }
        return (double) total/review.size();
    }

    public void purchase(User user, Media media){
        if (stock > 0) {
            user.addToPurchaseCart(media);
            stock--;
        }else {
            System.out.println("you cannot purchase this book");
        }

    }

    public boolean isBestSeller(){
        double total = 0.0;
        for (Review r : review ){
          total+=r.getRating();
        }
        return total/review.size() >= 4.5;
    }


    public void reStock(int quantity){
        stock+=quantity;
        System.out.println("book restocked successfully");
    }

    public int getQuantityInStock(){
        return stock;
    }

    @Override
    public String getMediaType(){
        if (isBestSeller()){
            return "Bestselling Book";
        }else {
            return "Book";
        }
    }

    @Override
    public String toString() {
        return "Book{" +
                "title="+getTitle()+
                ", auteur="+getAuteur()+
                ", stock=" + stock +
                ", review=" + review +
                '}'+"\n";
    }
}
