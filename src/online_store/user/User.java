package online_store.user;

import online_store.media.Media;

import java.util.ArrayList;

public class User {
    private String username;
    private String email;
    private ArrayList<Media> purchase_media_list;
    private ArrayList<Media> shopping_cart;


    public User(){

    }
    public User(String username, String email, ArrayList<Media> purchase_media_list, ArrayList<Media> shopping_cart) {
        this.username = username;
        this.email = email;
        this.purchase_media_list = purchase_media_list;
        this.shopping_cart = shopping_cart;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) throws RuntimeException{
        if (email.contains("@")) {
            this.email = email;
        }else {
            throw new RuntimeException("you must have @ in email");
        }
    }

    public ArrayList<Media> getPurchase_media_list() {
        return purchase_media_list;
    }

    public void setPurchaseMediaList(ArrayList<Media> purchase_media_list) {
        this.purchase_media_list = purchase_media_list;
    }

    public void addToPurchaseCart(Media media){
        purchase_media_list.add(media);

    }

    public ArrayList<Media> getShopping_cart() {
        return shopping_cart;
    }

    public void setShopping_cart(ArrayList<Media> shopping_cart) {
        this.shopping_cart = shopping_cart;
    }

    public void addToCart(Media media){
        if (shopping_cart.add(media)) {
            System.out.println("media added successfully");
        }else {
            System.out.println("theres problem media not added");
        }
    }

    public void removeFromCart(Media media) {
        if(shopping_cart.remove(media)){
            System.out.println("media removed successfully");
        }else {
            System.out.println("theres problem media cannot removed");
        }
    }

    public void checkout(){
        purchase_media_list = new ArrayList<Media>();
        shopping_cart = new ArrayList<Media>();
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", purchase_media_list=" + purchase_media_list +
                ", shopping_cart=" + shopping_cart +
                '}'+"\n";
    }
}
