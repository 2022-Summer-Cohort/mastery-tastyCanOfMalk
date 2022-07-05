package com.survivingcodingbootcamp.blog.controller;

import com.survivingcodingbootcamp.blog.repository.HashtagRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.survivingcodingbootcamp.blog.model.Hashtag;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Controller
public class HashtagController {

    private HashtagRepository hashtagRepo;

    public HashtagController(HashtagRepository hashtagRepo) {
        this.hashtagRepo = hashtagRepo;
    }

    @GetMapping("/hashtags")
    public String displayAllHashtags(Model model){
        model.addAttribute("hashtags", hashtagRepo.findAll());
        return("all-hashtags-template");
    }

    @GetMapping("/hashtags/{id}")
    public String displaySingleHashtag(@PathVariable long id, Model model){
        model.addAttribute("hashtag", hashtagRepo.findById(id).get());
        return "single-hashtag-template";
    }

}
