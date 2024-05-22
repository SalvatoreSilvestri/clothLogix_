package com.fabless.clothlogix.DAO.impl;



import com.fabless.clothlogix.Entity.ColoreEntity;
import com.fabless.clothlogix.Entity.MaterialeEntity;
import com.fabless.clothlogix.DAO.MaterialeDAO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;
@Repository
public class MaterialeDAOImpl implements MaterialeDAO {
    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public List<MaterialeEntity> getListMateriale(Map<String, Object> risposta) {
        try {
            TypedQuery<MaterialeEntity> materiale = entityManager.createQuery("SELECT c FROM MaterialeEntity c", MaterialeEntity.class);
            risposta.put("successo", true);
            return materiale.getResultList();
        } catch (Exception e) {
            risposta.put("successo", false);
            risposta.put("messaggio", "Errore durante il recupero della lista dei materiali: " + e.getMessage());
            return List.of();
        }
    }
    @Override
    public void inserisciMateriale(MaterialeEntity materialeEntity, Map<String, Object> risposta) {
        try {
            entityManager.persist(materialeEntity);
            risposta.put("Materiale inserito con successo.", true);
            risposta.put("dati:", materialeEntity);
        } catch (Exception e) {
            risposta.put("successo", false);
            risposta.put("messaggio", "Errore durante l'inserimento del materiale: " + e.getMessage());
        }

    }

    @Override
    public void aggiornaMateriale(MaterialeEntity materialeEntity, Map<String, Object> risposta) {
        try {
            entityManager.merge(materialeEntity);
            risposta.put("successo", true);
            risposta.put("messaggio", "Colore aggiornato con successo.");
        } catch (Exception e) {
            risposta.put("successo", false);
            risposta.put("messaggio", "Errore durante l'aggiornamento del colore: " + e.getMessage());
        }
    }


    @Override
    public void eliminaMateriale(Long id, Map<String, Object> risposta) {
        try {
            MaterialeEntity materialeEntity = entityManager.find(MaterialeEntity.class, id);
            if (materialeEntity != null) {
                entityManager.remove(materialeEntity);
                risposta.put("successo", true);
                risposta.put("messaggio", "Materiale eliminato con successo.");
            }
        } catch (Exception e) {
            risposta.put("successo", false);
            risposta.put("messaggio", "Errore durante l'eliminazione del materiale: " + e.getMessage());
        }
    }

    @Override
    public Optional<MaterialeEntity> materialeFindById(Long id, Map<String, Object> risposta) {
        try {
            MaterialeEntity materialeEntity = entityManager.find(MaterialeEntity.class, id);
            risposta.put("successo", true);
            return Optional.ofNullable(materialeEntity);
        } catch (Exception e) {
            risposta.put("successo", false);
            risposta.put("messaggio", "Errore durante il recupero del materiale: " + e.getMessage());
            return Optional.empty();
        }
    }
}
