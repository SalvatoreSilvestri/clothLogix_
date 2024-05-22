package com.fabless.clothlogix.DAO.impl;



import com.fabless.clothlogix.Entity.MagazzinoEntity;
import com.fabless.clothlogix.DAO.MagazzinoDAO;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;
@Repository
public class MagazzinoDAOImpl implements MagazzinoDAO {
    @Override
    public List<MagazzinoEntity> getListMagazzino(Map<String, Object> risposta) {
        return List.of();
    }

    @Override
    public void inserisciMagazzino(MagazzinoEntity magazzinoEntity, Map<String, Object> risposta) {

    }

    @Override
    public void aggiornaMagazzino(MagazzinoEntity magazzinoEntity, Map<String, Object> risposta) {

    }

    @Override
    public void eliminaMagazzino(Long id, Map<String, Object> risposta) {

    }

    @Override
    public Optional<MagazzinoEntity> magazzinoFindById(Long id, Map<String, Object> risposta) {
        return null;
    }
}
