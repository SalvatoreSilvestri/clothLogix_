package com.fabless.clothlogix.service;




import com.fabless.clothlogix.Entity.LoginEntity;
import org.hibernate.exception.DataException;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface AbstractLoginService {

    List<LoginEntity> findAll(Map<String, Object> risposta) throws DataException;

    Optional<LoginEntity> findById(Long id, Map<String, Object> risposta) throws DataException;

    void create(LoginEntity coloreEntity, Map<String, Object> risposta) throws DataException;

    void update(LoginEntity coloreEntity, Map<String, Object> risposta) throws  DataException;

    void deleteByid(Long id, Map<String, Object> risposta) throws  DataException;
}
