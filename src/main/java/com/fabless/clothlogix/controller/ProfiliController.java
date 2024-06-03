package com.fabless.clothlogix.controller;

import com.fabless.clothlogix.Entity.ProfiloEntity;
import com.fabless.clothlogix.service.Impl.ProfiloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/profili")
public class ProfiliController {

    @Autowired
    private ProfiloService profiliService;

    @GetMapping("/{id}")
    public ProfiloEntity getProfiliById(@PathVariable Long id) {
        return profiliService.findById(id);
    }

    @GetMapping
    public List<ProfiloEntity> getAllProfili() {
        return profiliService.findAll();
    }

    @PutMapping
    public void updateProfilo(@RequestBody ProfiloEntity profilo) {
        profiliService.update(profilo);
    }

}
