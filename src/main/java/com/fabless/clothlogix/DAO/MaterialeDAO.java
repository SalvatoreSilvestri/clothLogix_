package com.fabless.clothlogix.DAO;







import com.fabless.clothlogix.Entity.MaterialeEntity;

import java.util.List;
import java.util.Map;
import java.util.Optional;


public interface MaterialeDAO  {

    List<MaterialeEntity> getListMateriale(Map<String, Object> risposta);

    void inserisciMateriale(MaterialeEntity materialeEntity, Map<String, Object> risposta );

    void aggiornaMateriale(MaterialeEntity materialeEntity, Map<String, Object> risposta );

    void eliminaMateriale(Long id, Map<String, Object> risposta );

    Optional<MaterialeEntity> materialeFindById(Long id, Map<String, Object> risposta);
}
