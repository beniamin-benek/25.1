package com.example.music;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
public class MusicBandController {

    private MusicBandRepository musicBandRepository;
    //private static final String BAND_HAS_BEEN_ADDED = "Band has been added";

    public MusicBandController(MusicBandRepository musicBandRepository) {
        this.musicBandRepository = musicBandRepository;
    }

    @GetMapping("/")
    public String showHomePage(Model model) {
        List<MusicBand> musicBands = musicBandRepository.findAll();
        model.addAttribute("bands", musicBands);
        return "home-page";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("newBand", new MusicBand());
        model.addAttribute("generes", Genere.values());
        return "add-form";
    }

    @PostMapping("/post")
    public String createNewBand(Model model, MusicBand newMusicBand) {
        musicBandRepository.save(newMusicBand);
        //model.addAttribute(ModelConstants.ERROR_MESSAGE, BAND_HAS_BEEN_ADDED);
        return "redirect:/";
    }

    @GetMapping("/band/{id}")
    public String showDetails(Model model, @PathVariable Long id) {
        Optional<MusicBand> bandOptional = musicBandRepository.findById(id);
        if (bandOptional.isPresent()) {
            MusicBand musicBand = bandOptional.get();
            model.addAttribute("band", musicBand);
            return "details";
        }
        return "redirect:/";

    }

    @PostMapping("/edit")
    public String showEditForm(@RequestParam Long id) {

        Optional<MusicBand> bandOptional = musicBandRepository.findById(id);
        if (bandOptional.isPresent()) {
            return "edit-form";
        }

        return "redirect:/";
    }

    @GetMapping("/edit")
    public String showEditFor2m(Model model, @RequestParam Long id) {
        return "edit-form";
    }
}
