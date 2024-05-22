package com.fabless.clothlogix.DAO.impl;



import com.fabless.clothlogix.Entity.ProdottoEntity;
import com.fabless.clothlogix.DAO.ProdottoDAO;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;
@Repository
public class ProdottoDAOImpl implements ProdottoDAO {
    @Override
    public List<ProdottoEntity> getListProdotto(Map<String, Object> risposta) {
        return List.of();
    }

    @Override
    public void inserisciProdotto(ProdottoEntity prodottoEntity, Map<String, Object> risposta) {

    }

    @Override
    public void aggiornaProdotto(ProdottoEntity prodottoEntity, Map<String, Object> risposta) {

    }

    @Override
    public void eliminaProdotto(Long id, Map<String, Object> risposta) {

    }

    @Override
    public Optional<ProdottoEntity> prodottoFindById(Long id, Map<String, Object> risposta) {
        return null;
    }
}
