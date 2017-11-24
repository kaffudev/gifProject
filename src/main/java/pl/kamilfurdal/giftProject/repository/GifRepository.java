package pl.kamilfurdal.giftProject.repository;


import org.springframework.stereotype.Repository;
import pl.kamilfurdal.giftProject.model.Gif;

import java.util.ArrayList;
import java.util.List;

@Repository
public class GifRepository {
    private List<Gif> allGifs = new ArrayList<>();


    public GifRepository() {
        allGifs.add((new Gif("android-explosion", true)));
        allGifs.add(new Gif("compiler-bot", true));
        allGifs.add(new Gif("ben-and-mike", false));
        allGifs.add(new Gif("book-dominos", true));
        allGifs.add(new Gif("cowboy-coder", false));
        allGifs.add(new Gif("infinite-andrew", false));
    }

    public List<Gif> getAllGifs() {
        return allGifs;
    }

    public Gif getGifByName(String name, String q){
        Gif selectedGif = null;

        if (q == null) {

            for (Gif gif : allGifs) {
                if (gif.getName().equals(name)) {
                    selectedGif = gif;

                }
            }
            return selectedGif;
        }else return null;
    }

    public List<Gif> getAllFilteredGifs(String q){
        List<Gif> gifs;

        if (q != null){
            List<Gif> filteredGifs = new ArrayList<>();
            for (Gif gif : allGifs) {
                if (gif.getName().contains(q)) {
                    filteredGifs.add(gif);
                }

            }
            gifs = filteredGifs;
        }else {
            gifs = allGifs;
        }

        return gifs;
    }

    public List<Gif> getFavoriteGifs() {
        List<Gif> gifs = new ArrayList<>();

        for (Gif gif : allGifs) {
            if (gif.isFavorite()== true){
                gifs.add(gif);
            }

        }

        return gifs;
    }
}
