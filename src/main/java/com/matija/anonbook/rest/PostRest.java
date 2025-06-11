package com.matija.anonbook.rest;

import com.matija.anonbook.model.Post;
import com.matija.anonbook.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/post")
public class PostRest {

    @Autowired
    PostService postService;

    @GetMapping("/hello")
    public String hello() {
        return "Hello World";
    }

    @GetMapping("/sviPostovi")
    public List<Post> vratiPostove(){
        return postService.vratiPostove();
    }

    @GetMapping("/{postId}")
    public Post vratiJedanPost(@PathVariable Integer postId){
        return postService.vratiJedanPost(postId);
    }


}
