package online_store.review;

public class Review {
    private String username;
    private int rating;
    private String comment;

    public Review(String username, int rating, String comment) {
        this.username = username;
        setRating(rating);
        this.comment = comment;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) throws RuntimeException {
        if (rating > 10 || rating < 0){
            throw new RuntimeException("you cannot enter more than 10 or negative");
        }
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "Review{" +
                "username='" + username + '\'' +
                ", rating=" + rating +
                ", comment='" + comment + '\'' +
                '}'+"\n";
    }
}
