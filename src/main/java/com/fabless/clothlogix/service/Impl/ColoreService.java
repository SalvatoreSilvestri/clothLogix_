package com.fabless.clothlogix.service.Impl;



import com.fabless.clothlogix.Entity.ColoreEntity;
import com.fabless.clothlogix.DAO.ColoreDAO;
import com.fabless.clothlogix.service.AbstractColoreService;
import org.hibernate.exception.DataException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class ColoreService implements AbstractColoreService {

    private ColoreDAO repo;

    @Autowired
    public  ColoreService(ColoreDAO repo){
        this.repo = repo;
    }

    public List<ColoreEntity> findAll(Map<String, Object> risposta) throws DataException {
        return repo.getListColore(risposta);
    }

    public Optional<ColoreEntity> findById(Long id, Map<String, Object> risposta) throws DataException{
        return repo.coloreFindById(id, risposta);
    }
    @Transactional
    public void create(ColoreEntity coloreEntity, Map<String, Object> risposta) throws DataException{
        repo.inserisciColore(coloreEntity,risposta);
    }

    @Transactional
    public void update(ColoreEntity coloreEntity, Map<String, Object> risposta) throws  DataException{
          repo.aggiornaColore(coloreEntity,risposta);
    }
    @Transactional
    public void deleteByid(Long id, Map<String, Object> risposta) throws  DataException{
        repo.eliminaColore(id, risposta);
    }

}
