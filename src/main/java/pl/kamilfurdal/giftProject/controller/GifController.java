package pl.kamilfurdal.giftProject.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.kamilfurdal.giftProject.model.Gif;
import pl.kamilfurdal.giftProject.repository.GifRepository;

import java.util.ArrayList;
import java.util.List;

@Controller
public class GifController {

    private static final Logger LOG = LoggerFactory.getLogger(GifController.class);

    @Autowired
    GifRepository gifRepository;



    @GetMapping("/")
    public String showGifs(@RequestParam(required = false)String q, ModelMap modelMap){

        LOG.info("User is showing gifs with q={}, q");

        List<Gif> gifs = getAllFilteredGifs(q);
        LOG.info("Founds gifs={}", gifs);

        modelMap.addAttribute("gifs", gifs);
        return "home";
    }


    private List<Gif> getAllFilteredGifs(String q){
        List<Gif> gifs;

        if (q != null){
            List<Gif> filteredGifs = new ArrayList<>();
            for (Gif gif : gifRepository.getAllGifs()) {
                if (gif.getName().contains(q)) {
                    filteredGifs.add(gif);
                }

            }
            gifs = filteredGifs;
        }else {
            gifs = gifRepository.getAllGifs();
        }

        return gifs;
    }

}
