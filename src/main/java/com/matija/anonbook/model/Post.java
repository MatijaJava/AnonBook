package com.matija.anonbook.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 500, nullable = false)
    private String text;

    private String potpis;

    private LocalDateTime datum;

    @OneToMany(mappedBy = "post", cascade = CascadeType.DETACH)
    private List<Komentar> komentari;


}
