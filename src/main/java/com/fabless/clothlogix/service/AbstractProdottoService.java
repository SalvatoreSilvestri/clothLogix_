package com.fabless.clothlogix.service;




import com.fabless.clothlogix.Entity.ProdottoEntity;
import org.hibernate.exception.DataException;

import java.util.Map;
import java.util.Optional;

public interface AbstractProdottoService {

    Iterable<ProdottoEntity> findAll(Map<String, Object> risposta) throws DataException;

    Optional<ProdottoEntity> findById(Long id, Map<String, Object> risposta) throws DataException;

    void create(ProdottoEntity prodottoEntity, Map<String, Object> risposta) throws DataException;

    void upload(ProdottoEntity prodottoEntity, Map<String, Object> risposta) throws DataException;

    void deleteByid(Long id, Map<String, Object> risposta) throws  DataException;
}
