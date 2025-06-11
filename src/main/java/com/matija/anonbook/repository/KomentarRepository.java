package com.matija.anonbook.repository;

import com.matija.anonbook.model.Komentar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KomentarRepository extends JpaRepository<Komentar, Integer> {
}
