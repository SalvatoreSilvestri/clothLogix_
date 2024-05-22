package com.fabless.clothlogix.DAO.impl;



import com.fabless.clothlogix.Entity.MaterialeEntity;
import com.fabless.clothlogix.DAO.MaterialeDAO;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;
@Repository
public class MaterialeDAOImpl implements MaterialeDAO {
    @Override
    public List<MaterialeEntity> getListMateriale(Map<String, Object> risposta) {
        return List.of();
    }

    @Override
    public void inserisciMateriale(MaterialeEntity materialeEntity, Map<String, Object> risposta) {

    }

    @Override
    public void aggiornaMateriale(MaterialeEntity materialeEntity, Map<String, Object> risposta) {

    }

    @Override
    public void eliminaMateriale(Long id, Map<String, Object> risposta) {

    }

    @Override
    public Optional<MaterialeEntity> materialeFindById(Long id, Map<String, Object> risposta) {
        return null;
    }
}
