package com.fabless.clothlogix.service.Impl;




import com.fabless.clothlogix.Entity.SezioneEntity;
import com.fabless.clothlogix.DAO.SezioneDAO;
import com.fabless.clothlogix.service.AbstractSezioneService;
import org.hibernate.exception.DataException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.Optional;


@Service
public class SezioneService implements AbstractSezioneService {

    private SezioneDAO repo;

    @Autowired
    public  SezioneService(SezioneDAO repo){
        this.repo = repo;
    }


    public List<SezioneEntity> findAll(Map<String, Object> risposta) throws DataException {
        return repo.getListSezione(risposta);
    }

    public Optional<SezioneEntity> findById(Long id, Map<String, Object> risposta) throws DataException{
        return repo.sezioneFindById(id, risposta);
    }
    @Transactional
    public void create(SezioneEntity sezioneEntity, Map<String, Object> risposta) throws DataException{
        repo.inserisciSezione(sezioneEntity,risposta);
    }

    @Transactional
    public void update(SezioneEntity sezioneEntity, Map<String, Object> risposta) throws DataException{
        repo.aggiornaSezione(sezioneEntity,risposta);
    }
    @Transactional
    public void deleteByid(Long id, Map<String, Object> risposta) throws  DataException{
        repo.eliminaSezione(id, risposta);
    }
}
