package com.matija.anonbook.repository;

import com.matija.anonbook.model.Komentar;
import com.matija.anonbook.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KomentarRepository extends JpaRepository<Komentar, Integer> {
    List<Komentar> findAllByPost(Post post);
}
