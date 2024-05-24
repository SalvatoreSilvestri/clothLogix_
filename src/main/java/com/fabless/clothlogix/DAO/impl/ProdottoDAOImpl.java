package com.fabless.clothlogix.DAO.impl;


import com.fabless.clothlogix.Entity.ColoreEntity;
import com.fabless.clothlogix.Entity.ProdottoEntity;
import com.fabless.clothlogix.DAO.ProdottoDAO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public class ProdottoDAOImpl implements ProdottoDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<ProdottoEntity> getListProdotto(Map<String, Object> risposta) {
        try {
            TypedQuery<ProdottoEntity> prodotto = entityManager.createQuery("SELECT c FROM ProdottoEntity c", ProdottoEntity.class);
            risposta.put("successo", true);
            return prodotto.getResultList();
        } catch (Exception e) {
            risposta.put("successo", false);
            risposta.put("messaggio", "Errore durante il recupero della lista dei prodotti: " + e.getMessage());
            return List.of();
        }
    }

    @Override
    public void inserisciProdotto(ProdottoEntity prodottoEntity, Map<String, Object> risposta) {
        try {
            entityManager.persist(prodottoEntity);
            risposta.put("successo", true);
            risposta.put("Dati", prodottoEntity);
        } catch (Exception e) {
            risposta.put("successo", false);
            risposta.put("messaggio", "Errore durante l'inserimento del Prodotto: " + e.getMessage());
        }

    }

    @Override
    public void aggiornaProdotto(ProdottoEntity prodottoEntity, Map<String, Object> risposta) {
        try {
            entityManager.merge(prodottoEntity);
            risposta.put("successo", true);
            risposta.put("messaggio", "Prodotto aggiornato con successo.");
        } catch (Exception e) {
            risposta.put("successo", false);
            risposta.put("messaggio", "Errore durante l'aggiornamento del Prodotto: " + e.getMessage());
        }

    }

    @Override
    public void eliminaProdotto(Long id, Map<String, Object> risposta) {
        try {
            ProdottoEntity ProdottoEntity = entityManager.find(ProdottoEntity.class, id);
            if (ProdottoEntity != null) {
                entityManager.remove(ProdottoEntity);
                risposta.put("successo", true);
                risposta.put("messaggio", "Prodotto eliminato con successo.");
            }
        } catch (Exception e) {
            risposta.put("successo", false);
            risposta.put("messaggio", "Errore durante l'eliminazione del prodotto: " + e.getMessage());
        }

    }

    @Override
    public Optional<ProdottoEntity> prodottoFindById(Long id, Map<String, Object> risposta) {
        try {
            ProdottoEntity prodottoEntity = entityManager.find(ProdottoEntity.class, id);
            risposta.put("successo", true);
            return Optional.ofNullable(prodottoEntity);
        } catch (Exception e) {
            risposta.put("successo", false);
            risposta.put("messaggio", "Errore durante il recupero del prodotto: " + e.getMessage());
            return Optional.empty();
        }
    }

}
