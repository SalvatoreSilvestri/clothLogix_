package com.fabless.clothlogix.controller;

import com.fabless.clothlogix.DTO.ColoreDTO;
import com.fabless.clothlogix.DTO.MaterialeDTO;
import com.fabless.clothlogix.Entity.ColoreEntity;
import com.fabless.clothlogix.Entity.MaterialeEntity;
import com.fabless.clothlogix.mapper.SuperClassMapper;
import com.fabless.clothlogix.service.AbstractColoreService;
import com.fabless.clothlogix.service.AbstractMaterialeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/materiale")
public class MaterialeController {
    private final AbstractMaterialeService materialeService;
    private final SuperClassMapper superClassMapper;

    @Autowired
    public MaterialeController(AbstractMaterialeService materialeService, SuperClassMapper superClassMapper) {
        this.materialeService = materialeService;
        this.superClassMapper = superClassMapper;
    }

    // Ottieni tutti i colori disponibili
    @GetMapping("/listmaterial")
    public ResponseEntity<List<MaterialeDTO>> getListMateriale() {
        Map<String, Object> risposta = new HashMap<>();
        List<MaterialeEntity> materiale = materialeService.findAll(risposta);
        return ResponseEntity.ok(superClassMapper.toMaterialeDTOs(materiale));
    }

    // Ottieni un singolo colore per ID
    @GetMapping("/find/{id}")
    public ResponseEntity<MaterialeDTO> getMaterialeById(@PathVariable Long id) {
        Map<String, Object> risposta = new HashMap<>();
        Optional<MaterialeEntity> materiale = materialeService.findById(id, risposta);
        return ResponseEntity.ok(superClassMapper.toMaterialeDTO(materiale.get()));
    }

    @PostMapping("/create")
    public ResponseEntity<?> createMateriale(@RequestBody MaterialeDTO materialeDTO) {
        Map<String, Object> risposta = new HashMap<>();
        try {
            MaterialeEntity materialeEntity = superClassMapper.toMaterialeEntity(materialeDTO);
            materialeService.create(materialeEntity, risposta);
            return ResponseEntity.ok(risposta);
        } catch (Exception e) {
            return new ResponseEntity<>(risposta, HttpStatus.BAD_REQUEST);
        }
    }


    // Aggiorna un colore esistente
    @PutMapping("/update")
    public ResponseEntity<Map<String, Object>> updateMateriale(@RequestBody MaterialeEntity materialeEntity) {
        Map<String, Object> risposta = new HashMap<>();
        materialeService.update(materialeEntity, risposta);
        return ResponseEntity.ok(risposta);
    }

    // Elimina un colore
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteMateriale(@PathVariable Long id) {
        Map<String, Object> risposta = new HashMap<>();
        try {
            materialeService.deleteByid(id, risposta);
            return ResponseEntity.ok(risposta);
        } catch (Exception e) {
            return new ResponseEntity<>(risposta, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
