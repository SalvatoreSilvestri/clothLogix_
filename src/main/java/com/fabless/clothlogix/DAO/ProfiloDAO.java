package com.fabless.clothlogix.DAO;
import com.fabless.clothlogix.Entity.ProfiloEntity;

import java.util.List;
import java.util.Map;
import java.util.Optional;
public interface ProfiloDAO  {
        ProfiloEntity findById(Long id);
        List<ProfiloEntity> findAll();
        void update(ProfiloEntity profilo);
}
