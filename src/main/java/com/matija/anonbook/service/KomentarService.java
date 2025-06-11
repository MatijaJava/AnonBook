package com.matija.anonbook.service;

import com.matija.anonbook.model.Komentar;
import com.matija.anonbook.model.Post;
import com.matija.anonbook.repository.KomentarRepository;
import com.matija.anonbook.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class KomentarService {

    @Autowired
    private KomentarRepository komentarRepository;
    @Autowired
    private PostRepository postRepository;

    public void napraviKomentar(Komentar komentar, Integer postId) {
        Optional<Post> optionalPost = postRepository.findById(postId);
        if (optionalPost.isEmpty()) throw new RuntimeException("Post ne postoji!");

        Post post = optionalPost.get();
        komentar.setPost(post);

        komentarRepository.save(komentar);
    }
}
