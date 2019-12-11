package com.whatever.lookify.controllers;

import java.util.List;

import javax.validation.Valid;

import com.whatever.lookify.models.Song;
import com.whatever.lookify.services.SongService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;






/**
 * SongController
 */

 @Controller
public class SongController {

    private final SongService songService;

    public SongController(SongService songService) {
        this.songService = songService;
    }

    @GetMapping(value="/")
    public String index(){
        return "index.jsp";
    }
    
    @GetMapping(value="/dashboard")
    public String dashboard(Model model) {
        List<Song> songs = songService.allSongs();
        model.addAttribute("songs", songs);
        return "/dashboard.jsp";
    }
    
    @GetMapping(value="/songs/new")
    public String newSong(Model model, @ModelAttribute("song") Song song){
        return "new.jsp";
    }

    @PostMapping(value="/songs")
    public String createNewSong(@Valid @ModelAttribute("song") Song song, BindingResult result) {
        if (result.hasErrors()) {
            return "/new.jsp";
        } else {
            songService.createSong(song);
            return "redirect:/dashboard";
        }
    }

    @GetMapping(value="/songs/{id}")
    public String show(@PathVariable(value="id") Long id, Model model) {
        Song song = songService.findSong(id);
        model.addAttribute("song", song);
        return "songdisplay.jsp";
    }

    @PostMapping(value="/search")
    public String artistSongs(@RequestParam(value="search") String artist, Model model){
        System.out.println(artist);
        return "redirect:/search/"+artist;
    }
    
    @GetMapping(value="/search/{artist}")
    public String artistSongsDisplay(@PathVariable("artist") String artist, Model model){
        System.out.println("I made it here!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        List<Song> songs = songService.findSongByArtist(artist);
        model.addAttribute("songs", songs);
        return "artistsongs.jsp";
    }
    
    // @GetMapping(value="/songs/{id}/edit")
    // public String edit(@PathVariable(value = "id") Long id, Model model) {
    //     Song song = songService.findSong(id);
    //     model.addAttribute("song", song);
    //     return "edit.jsp";
    // }
    
    // @PostMapping(value="/songs/{id}")
    // public String update(@Valid @ModelAttribute("song") Song song, BindingResult result) {
    //     if (result.hasErrors()) {
    //         return "/edit.jsp";
    //     } else {
    //         songService.createSong(song);
    //         return "redirect:/songs";
    //     }
    // }

    @GetMapping(value = "/songs/{id}/delete")
    public String delete(@PathVariable(value = "id") Long id){
        songService.deleteSong(id);
        return "redirect:/dashboard";
    }
    
    
    
    
}