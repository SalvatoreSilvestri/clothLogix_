package com.fabless.clothlogix.DAO;






import com.fabless.clothlogix.Entity.ColoreEntity;

import java.util.List;
import java.util.Map;
import java.util.Optional;


public interface ColoreDAO {

    List<ColoreEntity> getListColore(Map<String, Object> risposta);

    void inserisciColore(ColoreEntity coloreEntity, Map<String, Object> risposta );

    void aggiornaColore(ColoreEntity coloreEntity, Map<String, Object> risposta );

    void eliminaColore(Long id, Map<String, Object> risposta );

    Optional<ColoreEntity> coloreFindById(Long id, Map<String, Object> risposta);
}
