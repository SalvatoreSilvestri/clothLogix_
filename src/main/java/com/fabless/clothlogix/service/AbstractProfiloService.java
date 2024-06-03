package com.fabless.clothlogix.service;




import com.fabless.clothlogix.Entity.ProfiloEntity;
import org.hibernate.exception.DataException;

import java.util.List;
import java.util.Map;
import java.util.Optional;


public interface AbstractProfiloService {
    ProfiloEntity findById(Long id);
    List<ProfiloEntity> findAll();
    void update(ProfiloEntity profilo);

}
