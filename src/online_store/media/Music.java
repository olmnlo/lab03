package online_store.media;

import online_store.user.User;

import java.util.ArrayList;

public class Music extends Media{
    private String artist;

    public Music(String title, String auteur, String ISBN, double price, String artist) {
        super(title, auteur, ISBN, price);
        this.artist = artist;
    }

    public void listen(User user){
        System.out.println(user.getUsername()+" is listening to "+ getTitle());
    }


    public ArrayList<Music> generatePlayList(ArrayList<Music> musicCatalog){
        ArrayList<Music> generated_list = new ArrayList<>();
        for (Music m : musicCatalog){
            if (m.getAuteur().equalsIgnoreCase(artist)){
                generated_list.add(m);
            }
        }
        return generated_list;
    }

    @Override
    public String getMediaType() {
        if(getPrice() > 10) {
            return "Premium music";
        }else {
            return "Music";
        }
    }

    @Override
    public String toString() {
        return "Music{" +
                "artist='" + artist + '\'' +
                ", title="+getTitle()+
                '}'+"\n";
    }
}
