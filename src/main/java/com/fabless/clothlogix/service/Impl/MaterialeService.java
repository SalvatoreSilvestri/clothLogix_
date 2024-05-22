package com.fabless.clothlogix.service.Impl;



import com.fabless.clothlogix.Entity.MaterialeEntity;
import com.fabless.clothlogix.DAO.MaterialeDAO;
import com.fabless.clothlogix.service.AbstractMaterialeService;
import org.hibernate.exception.DataException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class MaterialeService implements AbstractMaterialeService {

    private MaterialeDAO repo;

    @Autowired
    public  MaterialeService(MaterialeDAO repo){
        this.repo = repo;
    }


    public List<MaterialeEntity> findAll(Map<String, Object> risposta) throws DataException {
        return repo.getListMateriale(risposta);
    }

    public Optional<MaterialeEntity> findById(Long id,Map<String, Object> risposta) throws DataException{
        return repo.materialeFindById(id, risposta);
    }
    @Transactional
    public void create(MaterialeEntity materialeEntity, Map<String, Object> risposta) throws DataException{
        repo.inserisciMateriale(materialeEntity,risposta);
    }

    @Transactional
    public void update(MaterialeEntity materialeEntity, Map<String, Object> risposta) throws  DataException{
        repo.aggiornaMateriale(materialeEntity,risposta);
    }
    @Transactional
    public void deleteByid(Long id, Map<String, Object> risposta) throws  DataException{
        repo.eliminaMateriale(id, risposta);
    }
}
