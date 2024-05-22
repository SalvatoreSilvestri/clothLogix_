package com.fabless.clothlogix.DAO.impl;



import com.fabless.clothlogix.Entity.ColoreEntity;
import com.fabless.clothlogix.DAO.ColoreDAO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;
@Repository
public class ColoreDAOImpl implements ColoreDAO {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public List<ColoreEntity> getListColore(Map<String, Object> risposta) {
        return List.of();
    }

    @Override
    public void inserisciColore(ColoreEntity coloreEntity, Map<String, Object> risposta) {
        try {
            entityManager.persist(coloreEntity);
            risposta.put("successo", true);
            risposta.put("messaggio", "Colore inserito con successo.");
        } catch (Exception e) {
            risposta.put("successo", false);
            risposta.put("messaggio", "Errore durante l'inserimento del colore: " + e.getMessage());
        }

    }

    @Override
    public void aggiornaColore(ColoreEntity coloreEntity, Map<String, Object> risposta) {

    }

    @Override
    public void eliminaColore(Long id, Map<String, Object> risposta) {

    }

    @Override
    public Optional<ColoreEntity> coloreFindById(Long id, Map<String, Object> risposta) {
        return null;
    }
}
