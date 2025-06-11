package com.matija.anonbook.service;

import com.matija.anonbook.model.Post;
import com.matija.anonbook.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public List<Post> vratiPostove() {
        return postRepository.findAll();
    }
}
