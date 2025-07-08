package online_store.media.book;

import online_store.review.Review;

import java.util.ArrayList;

public class AcademicBook extends Book{
    private String subject;


    public AcademicBook(String title, String auteur, String ISBN, double price, int stock, ArrayList<Review> review, String subject) {
        super(title, auteur, ISBN, price, stock, review);
        this.subject = subject;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Override
    public String getMediaType() {
        if (getAverageRating() > 4.5) {
            return "Bestselling AcademicBook";
        }else {
            return "AcademicBook";
        }
    }

    @Override
    public String toString() {
        return "AcademicBook{" +
                "title="+getTitle()+
                ", auteur="+getAuteur()+
                ", subject='" + subject + '\'' +
                ", review=" + getReview() +
                '}'+"\n";
    }
}
