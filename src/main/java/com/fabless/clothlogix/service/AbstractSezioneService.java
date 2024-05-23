package com.fabless.clothlogix.service;




import com.fabless.clothlogix.Entity.SezioneEntity;
import org.hibernate.exception.DataException;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface AbstractSezioneService {

    List<SezioneEntity> findAll(Map<String, Object> risposta) throws DataException;

    Optional<SezioneEntity> findById(Long id, Map<String, Object> risposta) throws DataException;

    void create(SezioneEntity sezioneEntity, Map<String, Object> risposta) throws DataException;

    void update(SezioneEntity sezioneEntity, Map<String, Object> risposta) throws  DataException;

    void deleteByid(Long id, Map<String, Object> risposta) throws  DataException;
}
