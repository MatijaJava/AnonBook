package com.matija.anonbook.repository;

import com.matija.anonbook.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {

    @Query("SELECT p FROM Post p LEFT JOIN FETCH p.komentari ORDER BY p.datum DESC")
    List<Post> findAllFetchKomentare();
}
