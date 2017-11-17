package pl.szymonchowaniec.giftProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.szymonchowaniec.giftProject.repository.GifRepository;

@Controller
public class GifController {



    @Autowired
    GifRepository gifRepository;


    @GetMapping("/")
    public String showGifs(@RequestParam(required = false)String q, ModelMap modelMap){

        if (q != null){

        }

        modelMap.addAttribute("gifs", gifRepository.getAllGifs());
        return "home";
    }


}
