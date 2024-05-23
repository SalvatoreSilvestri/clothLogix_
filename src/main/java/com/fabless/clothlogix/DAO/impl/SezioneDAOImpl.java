package com.fabless.clothlogix.DAO.impl;



import com.fabless.clothlogix.Entity.MaterialeEntity;
import com.fabless.clothlogix.Entity.SezioneEntity;
import com.fabless.clothlogix.DAO.SezioneDAO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;
@Repository
public class SezioneDAOImpl implements SezioneDAO {
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public List<SezioneEntity> getListSezione(Map<String, Object> risposta) {
        try {
            TypedQuery<SezioneEntity> sezione = entityManager.createQuery("SELECT c FROM SezioneEntity c", SezioneEntity.class);
            risposta.put("successo", true);
            return sezione.getResultList();
        } catch (Exception e) {
            risposta.put("successo", false);
            risposta.put("messaggio", "Errore durante il recupero della lista delle Sezioni: " + e.getMessage());
            return List.of();
        }
    }

    @Override
    public void inserisciSezione(SezioneEntity sezioneEntity, Map<String, Object> risposta) {
        try {
            entityManager.persist(sezioneEntity);
            risposta.put("Sezione inserito con successo.", true);
            risposta.put("dati:", sezioneEntity);
        } catch (Exception e) {
            risposta.put("successo", false);
            risposta.put("messaggio", "Errore durante l'inserimento della Sezione: " + e.getMessage());
        }
    }

    @Override
    public void aggiornaSezione(SezioneEntity sezioneEntity, Map<String, Object> risposta) {
        try {
            entityManager.merge(sezioneEntity);
            risposta.put("successo", true);
            risposta.put("messaggio", "Sezione aggiornato con successo.");
        } catch (Exception e) {
            risposta.put("successo", false);
            risposta.put("messaggio", "Errore durante l'aggiornamento della Sezione: " + e.getMessage());
        }
    }

    @Override
    public void eliminaSezione(Long id, Map<String, Object> risposta) {
        try {
            SezioneEntity sezioneEntity = entityManager.find(SezioneEntity.class, id);
            if (sezioneEntity != null) {
                entityManager.remove(sezioneEntity);
                risposta.put("successo", true);
                risposta.put("messaggio", "Sezione eliminata con successo.");
            }
        } catch (Exception e) {
            risposta.put("successo", false);
            risposta.put("messaggio", "Errore durante l'eliminazione della Sezione: " + e.getMessage());
        }
    }

    @Override
    public Optional<SezioneEntity> sezioneFindById(Long id, Map<String, Object> risposta) {
        try {
            SezioneEntity sezioneEntity = entityManager.find(SezioneEntity.class, id);
            risposta.put("successo", true);
            return Optional.ofNullable(sezioneEntity);
        } catch (Exception e) {
            risposta.put("successo", false);
            risposta.put("messaggio", "Errore durante il recupero della Sezione: " + e.getMessage());
            return Optional.empty();
        }
    }
}

