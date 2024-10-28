package com.example.candidat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("candidat")
public class CandidatRestApi {
    @Autowired
    private CandidatService candidatService ;

    @PostMapping(consumes = MediaType.APPLICATION_XML_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Candidat> createCandidat(@RequestBody Candidat candidat) {
        return new ResponseEntity<>(candidatService.addCandidat(candidat), HttpStatus.OK);}


    @GetMapping
    public ResponseEntity<List<Candidat>> getCandidat() {
        return new ResponseEntity<>(candidatService.getAll(), HttpStatus.OK);}


    @PutMapping(value="/{id}")
    public ResponseEntity<Candidat> updateCandidat(@PathVariable (value = "id" ) int id , @RequestBody Candidat candidat) {
        return new ResponseEntity<>(candidatService.updateCandidat(id,candidat), HttpStatus.OK);}

    @DeleteMapping(value="/delete/{id}")
    public ResponseEntity<String > deleteCandidat(@PathVariable (value = "id" ) int id ) {
        return new ResponseEntity<>(candidatService.deleteCandidat(id), HttpStatus.OK);}


}