package com.fabless.clothlogix.controller;



import com.fabless.clothlogix.DTO.ColoreDTO;
import com.fabless.clothlogix.Entity.ColoreEntity;
import com.fabless.clothlogix.mapper.SuperClassMapper;
import com.fabless.clothlogix.service.AbstractColoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;


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

    // Ottieni tutti i colori disponibili
    @GetMapping("/listcolor")
    public ResponseEntity<List<ColoreDTO>> getListColore() {
        Map<String, Object> risposta = new HashMap<>();
        List<ColoreEntity> colori = coloreService.findAll(risposta);
        return ResponseEntity.ok(superClassMapper.toColoreDTOs(colori));
    }

    // Ottieni un singolo colore per ID
    @GetMapping("/find/{id}")
    public ResponseEntity<ColoreDTO> getColoreById(@PathVariable Long id) {
        Map<String, Object> risposta = new HashMap<>();
       Optional<ColoreEntity> colore = coloreService.findById(id, risposta);
        return ResponseEntity.ok(superClassMapper.toColoreDTO(colore.get()));
    }

    @PostMapping("/create")
    public ResponseEntity<?> createColore(@RequestBody ColoreDTO coloreDTO) {
        Map<String, Object> risposta = new HashMap<>();
        try {
            ColoreEntity coloreEntity = superClassMapper.toColoreEntity(coloreDTO);
            coloreService.create(coloreEntity, risposta);
            return ResponseEntity.ok(superClassMapper.toColoreDTO(coloreEntity));
        } catch (Exception e) {
            return new ResponseEntity<>(risposta, HttpStatus.BAD_REQUEST);
        }
    }


    // Aggiorna un colore esistente
    @PutMapping("/update")
    public ResponseEntity<Map<String, Object>> updateColore(@RequestBody ColoreEntity coloreEntity) {
        Map<String, Object> risposta = new HashMap<>();
        coloreService.update(coloreEntity, risposta);
        return ResponseEntity.ok(risposta);
    }

    // Elimina un colore
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteColore(@PathVariable Long id) {
        Map<String, Object> risposta = new HashMap<>();
        try {
            coloreService.deleteByid(id, risposta);
            return ResponseEntity.ok(risposta);
        } catch (Exception e) {
            return new ResponseEntity<>(risposta, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
