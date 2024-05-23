package com.fabless.clothlogix.service.Impl;




import com.fabless.clothlogix.Entity.MagazzinoEntity;
import com.fabless.clothlogix.DAO.MagazzinoDAO;
import com.fabless.clothlogix.service.AbstractMagazzinoService;
import org.hibernate.exception.DataException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;
import java.util.Optional;

@Service
public class MagazzinoService implements AbstractMagazzinoService {

    private MagazzinoDAO repo;

    @Autowired
    public  MagazzinoService(MagazzinoDAO repo){
        this.repo = repo;
    }


    public Iterable<MagazzinoEntity> findAll(Map<String, Object> risposta) throws DataException {
        return repo.getListMagazzino(risposta);
    }

    public Optional<MagazzinoEntity> findById(Long id, Map<String, Object> risposta) throws DataException{
        return repo.magazzinoFindById(id, risposta);
    }
    @Transactional
    public void create(MagazzinoEntity magazzinoEntity, Map<String, Object> risposta) throws DataException{
        repo.inserisciMagazzino(magazzinoEntity,risposta);
    }

    @Transactional
    public void update(MagazzinoEntity magazzinoEntity, Map<String, Object> risposta) throws  DataException{
        repo.aggiornaMagazzino(magazzinoEntity,risposta);
    }
    @Transactional
    public void deleteByid(Long id, Map<String, Object> risposta) throws  DataException{
        repo.eliminaMagazzino(id, risposta);
    }
}
