package com.matija.anonbook.rest;

import com.matija.anonbook.model.Post;
import com.matija.anonbook.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
@RequestMapping("/post")
public class PostRest {

    @Autowired
    PostService postService;

    @GetMapping
    public String hello() {
        return "redirect:/post/svi-postovi";
    }

    @GetMapping("/svi-postovi")
    public String vratiPostove(Model model){
        List<Post> postovi = postService.vratiPostove();
        model.addAttribute("postovi", postovi);

        return "post-feed";
    }

    @GetMapping("/{id}")
    public String prikaziKomentare(@PathVariable Integer id, Model model) {
        Post post = postService.vratiJedanPost(id);
        model.addAttribute("post", post);
        return "post-comments";
    }



}
