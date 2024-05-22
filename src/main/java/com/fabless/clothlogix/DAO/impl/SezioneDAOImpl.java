package com.fabless.clothlogix.DAO.impl;



import com.fabless.clothlogix.Entity.SezioneEntity;
import com.fabless.clothlogix.DAO.SezioneDAO;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;
@Repository
public class SezioneDAOImpl implements SezioneDAO {
    @Override
    public List<SezioneEntity> getListSezione(Map<String, Object> risposta) {
        return List.of();
    }

    @Override
    public void inserisciSezione(SezioneEntity sezioneEntity, Map<String, Object> risposta) {

    }

    @Override
    public void aggiornaSezione(SezioneEntity sezioneEntity, Map<String, Object> risposta) {

    }

    @Override
    public void eliminaSezione(Long id, Map<String, Object> risposta) {

    }

    @Override
    public Optional<SezioneEntity> sezioneFindById(Long id, Map<String, Object> risposta) {
        return null;
    }
}
