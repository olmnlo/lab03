package online_store.store;
import online_store.media.Media;
import online_store.user.User;

import java.util.ArrayList;


public class Store {
    private ArrayList<User> users;
    private ArrayList<Media> media;

    public Store(ArrayList<User> users, ArrayList<Media> media) {
        this.users = users;
        this.media = media;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }

    public ArrayList<Media> getMedia() {
        return media;
    }

    public void setMedia(ArrayList<Media> media) {
        this.media = media;
    }

    public void addUser(User user){
        if (users.contains(user)){
            System.out.println("user is available");
        }else {
            users.add(user);
            System.out.println("User add successfully");
        }
    }

    public ArrayList<User> displayUsers(){
        return users;
    }

    public void addMedia(Media media){
        if (this.media.contains(media)){
            System.out.println("media is available");
        }else {
            this.media.add(media);
            System.out.println("media add successfully");
        }
    }

    public ArrayList<Media> displayMedia(){
        return media;
    }


    public Media searchBook(String title){
        for (Media m : media){
            if(m.getTitle().equalsIgnoreCase(title)){
                System.out.println("your book search is found:");
                return m;
            }
        }
        System.out.println("your book search is not found");
        return null;
    }

    @Override
    public String toString() {
        return "Store{" +
                "users=" + users +
                ", media=" + media +
                '}'+"\n";
    }
}
