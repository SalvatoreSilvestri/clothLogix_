package com.fabless.clothlogix.controller;

import com.fabless.clothlogix.Entity.UtenteEntity;
import com.fabless.clothlogix.service.Impl.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/utente")
public class UtenteController {
    @Autowired
    private UtenteService utenteService;
    @GetMapping("/username/{username}")
    public UtenteEntity getUtenteByUsername(@PathVariable String username) {
        return utenteService.findByUsername(username);
    }

    }

