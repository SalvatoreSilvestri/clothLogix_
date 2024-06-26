package com.fabless.clothlogix.service;



import com.fabless.clothlogix.Entity.ColoreEntity;
import org.hibernate.exception.DataException;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface AbstractColoreService {

    List<ColoreEntity> findAll(Map<String, Object> risposta) throws DataException;

    Optional<ColoreEntity> findById(Long id, Map<String, Object> risposta) throws DataException;
    void create(ColoreEntity coloreEntity, Map<String, Object> risposta) throws DataException;

    void update(ColoreEntity coloreEntity, Map<String, Object> risposta) throws  DataException;

    void deleteByid(Long id, Map<String, Object> risposta) throws  DataException;

}
