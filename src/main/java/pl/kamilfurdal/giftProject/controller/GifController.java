package pl.kamilfurdal.giftProject.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
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

        List<Gif> gifs = gifRepository.getAllFilteredGifs(q);
        LOG.info("Founds gifs={}", gifs);

        modelMap.addAttribute("gifs", gifs);
        return "home";
    }

/*
    @GetMapping("/gif/{chose}")
    public String showGifDetails( ModelMap  modelMap, @PathVariable String chose) {
        modelMap.addAttribute("gif.name", chose);
        modelMap.addAttribute("gif.favorite",gifRepository.getGifByName(chose).isFavorite());
        return "redirect:/gif-details";
    }
*/

/*    @GetMapping("/gif-details")
    public String showGifDetailed(ModelMap modelMap){

        modelMap.addAttribute("gifs", gifRepository.getAllGifs());
        return "gif-details";
    }*/

    @GetMapping("/gif-details")
    @ResponseBody
    public String showGifDetails() {

        return "TO DO later";
    }


}
