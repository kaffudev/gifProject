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

import java.util.List;

@Controller
public class FavoriteController {


    private static final Logger LOG = LoggerFactory.getLogger(FavoriteController.class);

    @Autowired
    GifRepository gifRepository;


    @GetMapping("/favorites")
    public String showFavorite(ModelMap modelMap){

        LOG.info("User is showing favorite gifs  ");

        List<Gif> gifs = gifRepository.getFavoriteGifs();
        LOG.info("Founds gifs={}", gifs);

        modelMap.addAttribute("gifs", gifs);
        return "favorites";
    }
}
