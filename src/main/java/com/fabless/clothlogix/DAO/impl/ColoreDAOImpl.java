package com.fabless.clothlogix.DAO.impl;



import com.fabless.clothlogix.Entity.ColoreEntity;
import com.fabless.clothlogix.DAO.ColoreDAO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
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
        try {
            TypedQuery<ColoreEntity> colori = entityManager.createQuery("SELECT c FROM ColoreEntity c", ColoreEntity.class);
            risposta.put("successo", true);
            return colori.getResultList();
        } catch (Exception e) {
            risposta.put("successo", false);
            risposta.put("messaggio", "Errore durante il recupero della lista dei colori: " + e.getMessage());
            return List.of();
        }
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
        try {
                entityManager.merge(coloreEntity);
                risposta.put("successo", true);
                risposta.put("messaggio", "Colore aggiornato con successo.");
            } catch (Exception e) {
                risposta.put("successo", false);
                risposta.put("messaggio", "Errore durante l'aggiornamento del colore: " + e.getMessage());
            }
        }


    @Override
    public void eliminaColore(Long id, Map<String, Object> risposta) {
        try {
            ColoreEntity coloreEntity = entityManager.find(ColoreEntity.class, id);
            if (coloreEntity != null) {
                entityManager.remove(coloreEntity);
                risposta.put("successo", true);
                risposta.put("messaggio", "Colore eliminato con successo.");
            }
        } catch (Exception e) {
            risposta.put("successo", false);
            risposta.put("messaggio", "Errore durante l'eliminazione del colore: " + e.getMessage());
        }
    }

    @Override
    public Optional<ColoreEntity> coloreFindById(Long id, Map<String, Object> risposta) {
        try {
            ColoreEntity coloreEntity = entityManager.find(ColoreEntity.class, id);
            risposta.put("successo", true);
            return Optional.ofNullable(coloreEntity);
        } catch (Exception e) {
            risposta.put("successo", false);
            risposta.put("messaggio", "Errore durante il recupero del colore: " + e.getMessage());
            return Optional.empty();
        }
    }

}

