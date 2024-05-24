package com.fabless.clothlogix.controller;


import com.fabless.clothlogix.DTO.ProdottoDTO;
import com.fabless.clothlogix.Entity.ProdottoEntity;
import com.fabless.clothlogix.mapper.SuperClassMapper;
import com.fabless.clothlogix.service.AbstractProdottoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/prodotto")
public class ProdottoController {


    private final AbstractProdottoService prodottoService;
    private final SuperClassMapper superClassMapper;

    @Autowired
    public ProdottoController(AbstractProdottoService prodottoService, SuperClassMapper superClassMapper) {
        this.prodottoService = prodottoService;
        this.superClassMapper = superClassMapper;
    }

    // Ottieni tutti i colori disponibili
    @GetMapping("/listprodotto")
    public ResponseEntity<List<ProdottoDTO>> getListProdotto() {
        Map<String, Object> risposta = new HashMap<>();
        List<ProdottoEntity> prodotto = prodottoService.findAll(risposta);
        return ResponseEntity.ok(superClassMapper.toProdottoDTOs(prodotto));
    }

    // Ottieni un singolo colore per ID
    @GetMapping("/find/{id}")
    public ResponseEntity<ProdottoDTO> getProdottoById(@PathVariable Long id) {
        Map<String, Object> risposta = new HashMap<>();
        Optional<ProdottoEntity> prodotto = prodottoService.findById(id, risposta);
        return ResponseEntity.ok(superClassMapper.toProdottoDTO(prodotto.get()));
    }

    @PostMapping("/create")
    public ResponseEntity<?> createProdotto(@RequestBody ProdottoDTO prodottoDTO) {
        Map<String, Object> risposta = new HashMap<>();
        try {
            ProdottoEntity prodottoEntity = superClassMapper.toProdottoEntity(prodottoDTO);
            prodottoService.create(prodottoEntity, risposta);
            return ResponseEntity.ok(superClassMapper.toProdottoDTO(prodottoEntity));
        } catch (Exception e) {
            return new ResponseEntity<>(risposta, HttpStatus.BAD_REQUEST);
        }
    }


    // Aggiorna un colore esistente
    @PutMapping("/update")
    public ResponseEntity<Map<String, Object>> updateProdotto(@RequestBody ProdottoEntity prodottoEntity) {
        Map<String, Object> risposta = new HashMap<>();
        prodottoService.update(prodottoEntity, risposta);
        return ResponseEntity.ok(risposta);
    }

    // Elimina un colore
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteProdotto(@PathVariable Long id) {
        Map<String, Object> risposta = new HashMap<>();
        try {
            prodottoService.deleteByid(id, risposta);
            return ResponseEntity.ok(risposta);
        } catch (Exception e) {
            return new ResponseEntity<>(risposta, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
