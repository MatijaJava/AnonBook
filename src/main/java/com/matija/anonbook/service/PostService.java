package com.matija.anonbook.service;

import com.matija.anonbook.model.Komentar;
import com.matija.anonbook.model.Post;
import com.matija.anonbook.repository.KomentarRepository;
import com.matija.anonbook.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;
    @Autowired
    private KomentarRepository komentarRepository;

    public List<Post> vratiPostove() {
        return postRepository.findAllFetchKomentare();
    }

    public Post vratiJedanPost(Integer postId) {
        Optional<Post> optionalPost = postRepository.findById(postId);
        if (optionalPost.isPresent()){
            Post post = optionalPost.get();
            List<Komentar> komentari = komentarRepository.findAllByPost(post);

            post.setKomentari(komentari);

            return post;
        } else {
            return null;
        }
    }

    public void sacuvajPost(Post noviPost) {
        noviPost.setDatum(LocalDateTime.now());

        if (noviPost.getText() == null || noviPost.getText().isEmpty()) throw new RuntimeException("Text ne sme biti prazan!");

        postRepository.save(noviPost);
    }
}
