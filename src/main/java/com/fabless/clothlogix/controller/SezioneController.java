package com.fabless.clothlogix.controller;

import com.fabless.clothlogix.DTO.MaterialeDTO;
import com.fabless.clothlogix.DTO.SezioneDTO;
import com.fabless.clothlogix.Entity.MaterialeEntity;
import com.fabless.clothlogix.Entity.SezioneEntity;
import com.fabless.clothlogix.mapper.SuperClassMapper;
import com.fabless.clothlogix.service.AbstractMaterialeService;
import com.fabless.clothlogix.service.AbstractSezioneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/sezione")
public class SezioneController {
        private final AbstractSezioneService sezioneService;
        private final SuperClassMapper superClassMapper;

        @Autowired
        public SezioneController(AbstractSezioneService sezioneService, SuperClassMapper superClassMapper) {
            this.sezioneService = sezioneService;
            this.superClassMapper = superClassMapper;
        }

        // Ottieni tutte le sezione
        @GetMapping("/listsezione")
        public ResponseEntity<List<SezioneDTO>> getListSezione() {
            Map<String, Object> risposta = new HashMap<>();
            List<SezioneEntity> sezione = sezioneService.findAll(risposta);
            return ResponseEntity.ok(superClassMapper.toSezioneDTOs(sezione));
        }

        // Ottieni un singolo per ID
        @GetMapping("/find/{id}")
        public ResponseEntity<SezioneDTO> getSezioneById(@PathVariable Long id) {
            Map<String, Object> risposta = new HashMap<>();
            Optional<SezioneEntity> sezione = sezioneService.findById(id, risposta);
            return ResponseEntity.ok(superClassMapper.toSezioneDTO(sezione.get()));
        }

        @PostMapping("/create")
        public ResponseEntity<?> createSezione(@RequestBody SezioneDTO sezioneDTO) {
            Map<String, Object> risposta = new HashMap<>();
            try {
                SezioneEntity sezioneEntity = superClassMapper.toSezioneEntity(sezioneDTO);
                sezioneService.create(sezioneEntity, risposta);
                return ResponseEntity.ok(risposta);
            } catch (Exception e) {
                return new ResponseEntity<>(risposta, HttpStatus.BAD_REQUEST);
            }
        }


        // Aggiorna una sezione esistente
        @PutMapping("/update")
        public ResponseEntity<Map<String, Object>> updateSezione(@RequestBody SezioneEntity sezioneEntity) {
            Map<String, Object> risposta = new HashMap<>();
            sezioneService.update(sezioneEntity, risposta);
            return ResponseEntity.ok(risposta);
        }

        // Elimina una sezione
        @DeleteMapping("/delete/{id}")
        public ResponseEntity<?> deleteSezione(@PathVariable Long id) {
            Map<String, Object> risposta = new HashMap<>();
            try {
                sezioneService.deleteByid(id, risposta);
                return ResponseEntity.ok(risposta);
            } catch (Exception e) {
                return new ResponseEntity<>(risposta, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
}
