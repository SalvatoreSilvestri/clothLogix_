package com.fabless.clothlogix.controller;



import com.fabless.clothlogix.DTO.ColoreDTO;
import com.fabless.clothlogix.Entity.ColoreEntity;
import com.fabless.clothlogix.mapper.SuperClassMapper;
import com.fabless.clothlogix.service.AbstractColoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/colore")
public class ColoreController {


    private final AbstractColoreService coloreService;
    private final SuperClassMapper superClassMapper;

    @Autowired
    public ColoreController(AbstractColoreService coloreService, SuperClassMapper superClassMapper) {
        this.coloreService = coloreService;
        this.superClassMapper = superClassMapper;
    }
/*
    // Ottieni tutti i colori disponibili
    @GetMapping("/colore/list")
    public ResponseEntity<?> getAllColori() {
        Map<String, Object> risposta = new HashMap<>();
        try {
            Iterable<ColoreEntity> colori = coloreService.findAll(risposta);
            return ResponseEntity.ok(coloreMapper.toColoreDTO(colori));
        } catch (Exception e) {
            risposta.put("errore", "Errore nel recuperare i colori: " + e.getMessage());
            return new ResponseEntity<>(risposta, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Ottieni un singolo colore per ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getColoreById(@PathVariable Long id) {
        Map<String, Object> risposta = new HashMap<>();
        try {
            Optional<ColoreEntity> colore = coloreService.findById(id, risposta);
            return colore.map(c -> ResponseEntity.ok(coloreMapper.toColoreDTO(c)))
                    .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
        } catch (Exception e) {
            risposta.put("errore", "Errore nella ricerca del colore con ID: " + id + ", " + e.getMessage());
            return new ResponseEntity<>(risposta, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }*/

    @PostMapping("/create")
    public ResponseEntity<?> createColore(@RequestBody ColoreDTO coloreDTO) {
        Map<String, Object> risposta = new HashMap<>();
        try {
            ColoreEntity coloreEntity = superClassMapper.toColoreEntity(coloreDTO);
            coloreService.create(coloreEntity, risposta);
            risposta.put("messaggio", "Colore creato con successo.");
            return ResponseEntity.ok(superClassMapper.toColoreDTO(coloreEntity));
        } catch (Exception e) {
            risposta.put("errore", "Errore nella creazione del colore: " + e.getMessage());
            return new ResponseEntity<>(risposta, HttpStatus.BAD_REQUEST);
        }
    }
/*

    // Aggiorna un colore esistente
    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateColore(@PathVariable Long id, @RequestBody ColoreDTO coloreDTO) {
        Map<String, Object> risposta = new HashMap<>();
        try {
            ColoreEntity coloreEntity = coloreMapper.toColoreEntity(coloreDTO);
            coloreEntity.setId(id); // Assicurati che l'ID sia impostato correttamente
            coloreService.upload(coloreEntity, risposta);
            risposta.put("messaggio", "Colore aggiornato con successo.");
            return ResponseEntity.ok(coloreMapper.toColoreDTO(coloreEntity));
        } catch (Exception e) {
            risposta.put("errore", "Errore nell'aggiornamento del colore: " + e.getMessage());
            return new ResponseEntity<>(risposta, HttpStatus.BAD_REQUEST);
        }
    }

    // Elimina un colore
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteColore(@PathVariable Long id) {
        Map<String, Object> risposta = new HashMap<>();
        try {
            coloreService.deleteByid(id, risposta);
            risposta.put("messaggio", "Colore eliminato con successo.");
            return ResponseEntity.ok(risposta);
        } catch (Exception e) {
            risposta.put("errore", "Errore nell'eliminazione del colore: " + e.getMessage());
            return new ResponseEntity<>(risposta, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

 */
}
