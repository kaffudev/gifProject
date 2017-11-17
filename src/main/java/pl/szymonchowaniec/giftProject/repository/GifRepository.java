package pl.szymonchowaniec.giftProject.repository;


import org.springframework.stereotype.Repository;
import pl.szymonchowaniec.giftProject.model.Gif;

import java.util.ArrayList;
import java.util.List;

@Repository
public class GifRepository {
    private List<Gif> allGifs = new ArrayList<>();


    public GifRepository() {
        allGifs.add((new Gif("android-explosion", true)));
        allGifs.add((new Gif("ben-and-mike", true)));
    }

    public GifRepository(List<Gif> allGifs) {
        this.allGifs = allGifs;
    }

    public List<Gif> getAllGifs(){
        return null;
    }


}
