package com.fabless.clothlogix.service;




import com.fabless.clothlogix.Entity.MagazzinoEntity;
import org.hibernate.exception.DataException;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface AbstractMagazzinoService {

    List<MagazzinoEntity> findAll(Map<String, Object> risposta) throws DataException;

    Optional<MagazzinoEntity> findById(Long id, Map<String, Object> risposta) throws DataException;

    void create(MagazzinoEntity magazzinoEntity, Map<String, Object> risposta) throws DataException;

    void update(MagazzinoEntity magazzinoEntity, Map<String, Object> risposta) throws  DataException;

    void deleteByid(Long id, Map<String, Object> risposta) throws  DataException;
}
