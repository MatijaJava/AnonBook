package com.matija.anonbook;

import com.matija.anonbook.model.Post;
import com.matija.anonbook.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class AnonBookApplication {

    @Autowired
    private PostRepository postRepository;

    public static void main(String[] args) {
        SpringApplication.run(AnonBookApplication.class, args);
    }

//    @EventListener(ApplicationReadyEvent.class)
    void start(){
        System.out.println("CUVAM POST");
        Post post = new Post();
        post.setText("Text ASDF");
        post.setPotpis("Komentar neki tamo budjavi");

        postRepository.save(post);
        System.out.print("Uspesno sacuvan post");
    }

}
