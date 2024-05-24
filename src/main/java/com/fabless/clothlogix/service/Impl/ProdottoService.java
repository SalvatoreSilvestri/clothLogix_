package com.fabless.clothlogix.service.Impl;




import com.fabless.clothlogix.Entity.ProdottoEntity;
import com.fabless.clothlogix.DAO.ProdottoDAO;
import com.fabless.clothlogix.service.AbstractProdottoService;
import org.hibernate.exception.DataException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class ProdottoService implements AbstractProdottoService {

    private ProdottoDAO repo;

    @Autowired
    public  ProdottoService(ProdottoDAO repo){
        this.repo = repo;
    }


    public List<ProdottoEntity> findAll(Map<String, Object> risposta) throws DataException {
        return repo.getListProdotto(risposta);
    }

    public Optional<ProdottoEntity> findById(Long id,Map<String, Object> risposta) throws DataException{
        return repo.prodottoFindById(id, risposta);
    }
    @Transactional
    public void create(ProdottoEntity prodottoEntity, Map<String, Object> risposta) throws DataException{
        repo.inserisciProdotto(prodottoEntity,risposta);
    }

    @Transactional
    public void update(ProdottoEntity prodottoEntity, Map<String, Object> risposta) throws  DataException{
        repo.aggiornaProdotto(prodottoEntity,risposta);
    }
    @Transactional
    public void deleteByid(Long id, Map<String, Object> risposta) throws  DataException{
        repo.eliminaProdotto(id, risposta);
    }
}
