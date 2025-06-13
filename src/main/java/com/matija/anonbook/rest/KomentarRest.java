package com.matija.anonbook.rest;


import com.matija.anonbook.model.Komentar;
import com.matija.anonbook.service.KomentarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/kom")
public class KomentarRest {

    @Autowired
    private KomentarService komentarService;

    @PostMapping("/dodajKomentar/post/{postId}")
    public void napraviKomentar(@RequestBody Komentar komentar, @PathVariable Integer postId) {
        komentarService.napraviKomentar(komentar, postId);
    }

    @GetMapping("/edit-comment/{id}")
    public String prikaziFormuZaKomentar(@PathVariable Integer id, Model model) {
        Komentar komentar = komentarService.findById(id);
        model.addAttribute("komentar", komentar);
        return "comment";
    }

    @PostMapping("/edit-comment")
    public String izmeniKomentar(@RequestParam Integer id, @RequestParam String text) {
        Komentar komentar = komentarService.edit(id, text);
        Integer postId = komentar.getPost().getId();
        return "redirect:/post/" + postId;
    }

    @PostMapping("/delete-comment/{id}")
    public String obrisiKomentar(@PathVariable Integer id) {
        Integer postId = komentarService.delete(id);
        return "redirect:/post/" + postId;
    }

}
