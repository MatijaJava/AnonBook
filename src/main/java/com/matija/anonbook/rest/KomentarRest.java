package com.matija.anonbook.rest;


import com.matija.anonbook.model.Komentar;
import com.matija.anonbook.service.KomentarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/kom")
public class KomentarRest {

    @Autowired
    private KomentarService komentarService;

    @PostMapping("/dodajKomentar/post/{postId}")
    public void napraviKomentar(@RequestBody Komentar komentar, @PathVariable Integer postId) {
        komentarService.napraviKomentar(komentar, postId);
    }

}
