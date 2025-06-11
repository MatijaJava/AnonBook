package com.matija.anonbook.service;

import com.matija.anonbook.model.Post;
import com.matija.anonbook.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public List<Post> vratiPostove() {
        return postRepository.findAll();
    }

    public Post vratiJedanPost(Integer postId) {
        Optional<Post> optionalPost = postRepository.findById(postId);
        if (optionalPost.isPresent()){
            return optionalPost.get();
        } else {
            return null;
        }
    }
}
